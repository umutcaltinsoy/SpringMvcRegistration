package com.innova.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
// This class represents our objects on the database
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_surname")
    private String userSurname;

    @Column(name = "email_address")
    private String emailAddress;

}
