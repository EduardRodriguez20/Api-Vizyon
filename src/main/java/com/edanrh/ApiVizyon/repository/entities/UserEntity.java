package com.edanrh.ApiVizyon.repository.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @Column(name = "pwd")
    private String password;
    private String role;
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_user")
//    private List<RoleEntity> roles;
}
