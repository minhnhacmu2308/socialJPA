package com.dtu.social_it.respositorys;

import com.dtu.social_it.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRespository extends JpaRepository<User,Integer> {

    User findUserByEmail(String email);

    @Transactional
    @Modifying
    @Query("update User u set u.status = :number WHERE u.email = :email")
    void activeAccount(@Param("email") String email,@Param("number") int number);
}
