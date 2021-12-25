package com.hobbycircle.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="users")
public class User {
    private String name;
    @Id
    private String email;
    private String city;
    private String country;
    private String password;

    public User() {
    }

    public User(String name, String email, String city, String country, String pwd) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.country = country;
        this.password = pwd;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPassword() {
        return password;
    }

}
