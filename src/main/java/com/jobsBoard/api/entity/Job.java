package com.jobsBoard.api.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;


    @Column()
    private String jobTitle;

    @Column()
    private LocalDateTime jobDateCreated;

    @Column()
    private String jobDescription;

    @Column()
    private String companyName;

    @Column()
    private String jobLocation;

    @Column()
    private String jobQualifications;

    @Column()
    private String jobStartDate;

    @Column()
    private String jobSalary;

    @Column()
    private String jobCategory;

    @Column()
    private String employerAuthor;

    //@Column()
    //private Boolean appliedForJob;

//    @ManyToOne
//    @JoinColumn(name="authUserId")
//    private AuthUser authUser;

}
