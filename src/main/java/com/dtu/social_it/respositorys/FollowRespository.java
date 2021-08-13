package com.dtu.social_it.respositorys;

import com.dtu.social_it.domains.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRespository extends JpaRepository<Follow,Integer> {
}
