package com.example.blogbackend.repository;

import com.example.blogbackend.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query("""
            select b from Blog b inner join b.categories categories
            where (:term is null or upper(b.title) like upper(concat('%', :term, '%')))
            and b.status = true and (:categoryName is null or upper(categories.name) = upper(:categoryName))
            group by b.id
            order by b.publishedAt DESC""")
    List<Blog> findByTitleContainsIgnoreCaseAndStatusTrueAndCategories_NameIgnoreCaseOrderByPublishedAtDesc(@Param("term") String term, @Param("categoryName") String categoryName);
}