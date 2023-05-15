package com.R2S.R2Sshop.data.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username", unique=true)
    private String username;

    @Column(name = "password")
    private String password;

    @OneToOne
    @MapsId
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToOne(mappedBy = "user")
    @MapsId
    @JoinColumn(name = "user_id")
    private Cart cart;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @Column(name = "status")
    private boolean status;

}
