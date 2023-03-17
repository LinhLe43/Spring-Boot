package com.example.blogbackend.controller;

import com.example.blogbackend.entity.Category;
import com.example.blogbackend.request.UpsertCategoryRequest;
import com.example.blogbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // 1. Lấy danh sách category
    @GetMapping("categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    // 2. Lấy chi tiết category theo id
    @GetMapping("categories/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    // 3. Tạo mới category
    @PostMapping("categories")
    public Category createCategory(@RequestBody UpsertCategoryRequest request) {
        return categoryService.createCategory(request);
    }

    // 4. Cập nhật category
    @PutMapping("categories/{id}")
    public Category updateCategory(@RequestBody UpsertCategoryRequest request, @PathVariable Integer id) {
        return categoryService.updateCategory(id, request);
    }

    // 5. Xóa category
    @DeleteMapping("categories/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }
}
