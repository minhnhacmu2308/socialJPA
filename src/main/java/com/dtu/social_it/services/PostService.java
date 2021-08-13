package com.dtu.social_it.services;

import org.springframework.data.domain.Sort;

import java.util.List;

public interface PostService {

     PostService save(PostService post);

     List<PostService> findAll(Sort sort);

     PostService findById(int id);

     void deleteById(int id);
}
