package com.hobbycircle.common;

public class User {
    private String name;
    private String email;
    private String city;
    private String country;
    private String pwd;

    public User(String name, String email, String city, String country, String pwd) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.country = country;
        this.pwd = pwd;
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

    public String getPwd() {
        return pwd;
    }

}
