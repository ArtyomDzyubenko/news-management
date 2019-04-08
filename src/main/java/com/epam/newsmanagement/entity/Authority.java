package com.epam.newsmanagement.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AUTHORITY")
public class Authority implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "AUTHORITY")
    private String authority;

    @Id
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    public String getAuthority() {
        return authority;
    }

    public User getUser() {
        return user;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
