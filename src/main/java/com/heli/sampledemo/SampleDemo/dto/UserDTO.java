package com.heli.sampledemo.SampleDemo.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable {

    private String username;
    private String password;
    private String gender;
    private String email;
    private String firstName;
    private String lastName;
    private Date birthDate;

    public UserDTO(String username, String password, String gender, String email, String firstName, String lastName, Date birthDate) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}