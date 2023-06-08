package com.jobsBoard.api.entity;

import jakarta.persistence.*;
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

    //add a url for uploading cv






}
