package com.dtu.social_it.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "likepost")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikePost {
    @Id
    @Column(name = "id_user")
    private int idUser;

    @Column(name = "id_post")
    private int idPost;

    @Column(name = "created_at")
    private String createdTime;
}
