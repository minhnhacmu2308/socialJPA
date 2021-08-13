package com.dtu.social_it.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "detail")
    private  String detail;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryPost categoryPost;

    @ManyToOne()
    @JoinColumn(name = "id_user",referencedColumnName = "id")
    private User user;

    @Column(name = "created_at")
    private String createdTime;

    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy = "post")
    private List<Comment> listComment;

    public List<Comment> getListComment() {
        return listComment;
    }

    public void setListComment(List<Comment> listComment) {
        this.listComment = listComment;
    }

    public CategoryPost getCategoryPost() {
        return categoryPost;
    }

    public void setCategoryPost(CategoryPost categoryPost) {
        this.categoryPost = categoryPost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
