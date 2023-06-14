package com.jobsBoard.api.repository;

import com.jobsBoard.api.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {

    @Modifying
    @Transactional
    void deleteJobById(String id);

    List<Job> findJobByJobTitle(String jobTitle);

    List<Job> findJobByJobLocation(String jobLocation);

    List<Job> findJobByJobSalary(String jobSalary);

    List<Job> findJobByJobCategory(String jobCategory);

    List<Job> findJobByJobQualifications(String jobQualification);
}
