package com.company.filmrent.entity.actor;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Table(name = "Actors")
@Entity(name = "filmrent_Actor")
@NamePattern("%s %s|firstname,lastname")
public class Actor extends StandardEntity {
    private static final long serialVersionUID = -3045069187838355030L;

    @Column(name = "Actor_firstname", nullable = false)
    @NotEmpty(message = "{filmrent_Actor.firstname.validation.NotEmpty}")
    private String firstname;

    @Column(name = "Actor_lastname", nullable = false)
    @NotEmpty(message = "{filmrent_Actor.lastname.validation.NotEmpty}")
    private String lastname;

    @Column(name = "Actor_gender", nullable = false)
    @NotEmpty(message = "{filmrent_Actor.gender.validation.NotEmpty}")
    private String gender;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}