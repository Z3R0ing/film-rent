package com.company.filmrent.entity.actor;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "FILMRENT_ACTOR")
@Entity(name = "filmrent_Actor")
@NamePattern("%s %s|firstName,lastname")
public class Actor extends StandardEntity {
    private static final long serialVersionUID = -3045069187838355030L;

    @Column(name = "Actor_firstname")
    private String firstName;

    @Column(name = "Actor_lastname")
    private String lastname;

    @Column(name = "Actor_gender")
    private String gender;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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