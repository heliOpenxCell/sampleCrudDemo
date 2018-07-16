package com.heli.sampledemo.SampleDemo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table (name =  "user_tbl")
public class User {

    @Id
    @Column(name = "user_nm")
    private String userName;

    @Column(name="first_nm",nullable = false)
    private String firstName;

    @Column(name="last_nm",nullable = false)
    private String lastName;

    @Column(name="gender",nullable = false)
    private String gender;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "passwd",nullable = false)
    @Length(min = 5)
    private String encrytedPassword;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birth_dt")
    private Date  birthDate;

    public User(){

    }

    public User(String userName, String firstName, String lastName, String gender, String email, @Length(min = 5) String encrytedPassword, Date birthDate) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.encrytedPassword = encrytedPassword;
        this.birthDate = birthDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}