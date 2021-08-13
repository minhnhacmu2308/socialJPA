package com.dtu.social_it.respositorys;

import com.dtu.social_it.domains.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRespository extends JpaRepository<Comment,Integer> {
}
