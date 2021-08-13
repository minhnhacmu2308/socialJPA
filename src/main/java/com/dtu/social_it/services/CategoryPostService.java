package com.dtu.social_it.services;

import com.dtu.social_it.domains.CategoryPost;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CategoryPostService {

    CategoryPost findById(int id);

    void deleteById(int id);

    List<CategoryPost> findAll(Sort sort);

    CategoryPost save(CategoryPost categoryPost);
}
