package com.example.blogbackend.service;

import com.example.blogbackend.entity.Blog;
import com.example.blogbackend.entity.Category;
import com.example.blogbackend.exception.NotFoundException;
import com.example.blogbackend.repository.BlogRepository;
import com.example.blogbackend.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WebService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Blog> getBlogs(String search, String category) {
        log.info("search {}", search);
        log.info("category {}", category);
        return blogRepository.findByTitleContainsIgnoreCaseAndStatusTrueAndCategories_NameIgnoreCaseOrderByPublishedAtDesc(search, category);
    }

    public Blog getBlogById(Integer id) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found blog with id = " + id);
        });

        if(!blog.getStatus()) {
            throw new NotFoundException("Not found blog with id = " + id);
        }
        // Trả về thông tin bài viết đã public
        // Nếu bài viết có tồn tại mà status = false => báo lỗi
        return blog;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
