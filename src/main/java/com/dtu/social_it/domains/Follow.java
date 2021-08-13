package com.dtu.social_it.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "follow")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Follow {
    @Id
    @Column(name = "id_user")
    private int idUser;

    @Column(name = "user_follow")
    private int userFollow;

    @Column(name = "created_at")
    private String createdTime;
}
