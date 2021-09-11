package com.company.filmrent.entity.user;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;

@Table(name = "LocalUser")
@Entity(name = "filmrent_Critic")
@NamePattern("%s|user")
public class Critic extends StandardEntity {
    private static final long serialVersionUID = -2731781279276514108L;

    @Column(name = "User_rang")
    private Integer userRang;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_id")
    private User user;

    public Integer getUserRang() {
        return userRang;
    }

    public void setUserRang(Integer userRang) {
        this.userRang = userRang;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}