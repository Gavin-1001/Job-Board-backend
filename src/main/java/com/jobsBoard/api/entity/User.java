package com.jobsBoard.api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String firstName;

    @Column()
    private String lastName;

    @Column()
    private String emailAddress;

    @Column()
    private String dateOfBirth;

    @Column()
    private String phoneNumber;

    @Column()
    private String homeAddress;

    /*
    @Column()
    private String cvUrl;

//     */
//    add a url for uploading cv


    public User(Long id, String firstName, String lastName, String emailAddress, String dateOfBirth, String phoneNumber, String homeAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
    }

    public User(){}
}
