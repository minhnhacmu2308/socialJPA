package com.dtu.social_it.respositorys;


import com.dtu.social_it.domains.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRespository extends JpaRepository<Post,Integer> {
}
