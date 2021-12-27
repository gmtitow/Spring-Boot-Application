package com.example.demo.maven.model;
import java.io.Serializable;

import com.example.demo.maven.USER_ROLES;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.yaml.snakeyaml.serializer.Serializer;

import javax.persistence.*;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User extends AbstractEntity{
    @Id
    @Column(name = "user_id")
    @SequenceGenerator(name = "users_user_id_seq", sequenceName = "users_user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_user_id_seq")
    private Long userId;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private USER_ROLES role;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public USER_ROLES getRole() {
        return role;
    }

    public void setRole(USER_ROLES role) {
        this.role = role;
    }

    @Override
    public void setId(Long id) {
        setUserId(id);
    }
}
