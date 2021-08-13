package com.dtu.social_it.services;

import com.dtu.social_it.domains.Comment;

public interface CommentService {

    Comment save(Comment comment);

    void deleteById(int id);


}
