package com.example.blogbackend.security;

import com.example.blogbackend.entity.Account;
import com.example.blogbackend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Account> userOptional = accountRepository.findByEmail(email);
        if(userOptional.isEmpty()) {
            throw new UsernameNotFoundException("Not found account with email = " + email);
        }

        return new CustomUserDetails(userOptional.get());
    }
}
