package com.dtu.social_it.respositorys;

import com.dtu.social_it.domains.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRespository extends JpaRepository<Role,Integer> {
}
