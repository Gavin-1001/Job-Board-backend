package com.jobsBoard.api.entity;

import javax.persistence.*;

@Entity
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


}
