package com.example.serveripwcr.models;

//@Entity
//@Table('user')
public class User {
    private Long id;
    private String name;
    private String passcode;

    public User(Long id, String name, String passcode) {
        this.id = id;
        this.name = name;
        this.passcode = passcode;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }
}
