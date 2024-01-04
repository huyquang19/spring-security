package com.example.shopee_security.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "member")
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;


    @Column(nullable = false)
    private String password;
}
