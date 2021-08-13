package com.dtu.social_it.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "chatroom")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoom {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_userone")
    private int idUserOne;

    @Column(name = "id_usertwo")
    private int idUserTwo;
}
