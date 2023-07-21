package com.jobsBoard.api.service.JobService;

import com.jobsBoard.api.entity.Job;

import java.util.List;

public interface JobService {


    Job createJob(Job job);

    List<Job> getAllJobs();

    Job getJobById(String id);

    void deleteJobById(String id);


    List<Job> findJobByJobTitle(String jobTitle);

    List<Job> getJobByJobLocation(String jobLocation);

    List<Job> findJobByJobSalary(String jobSalary);

    List<Job> findJobByJobCategory(String jobCategory);

    List<Job> findJobByJobQualification(String jobQualification);

    List<Job> findJobByEmployerAuthor(String employerAuthor);

    Job updateJob(String id, Job job);
}
