package com.jobsBoard.api.entity;

import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;


    @Column(name = "username", unique = true, nullable = false, length = 100)
    private String username;

    private String password;

    @Transient
    private String accessToken;

    @Transient
    private String refreshToken;

    @Enumerated(EnumType.STRING)
    //@Column(name = "role")
    @Column(name = "role", nullable = false)
    private Role role;

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public User(){}

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

     */
    //add a url for uploading cv






}
