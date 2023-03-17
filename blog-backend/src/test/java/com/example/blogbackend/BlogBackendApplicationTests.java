package com.example.blogbackend;

import com.github.slugify.Slugify;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BlogBackendApplicationTests {

    @Autowired
    private Slugify slugify;

    @Test
    void test_slug() {
        List<String> list = new ArrayList<>(List.of(
                "Địa chỉ",
                "Địa điểm làm hành chính",
                "Không có đỉnh nào hết",
                "Nước chảy Đá mòn"
        ));

        list.forEach(item -> System.out.println(slugify.slugify(item)));
    }

}
