package com.jobsBoard.api.service.JobService;

import com.jobsBoard.api.entity.Job;

import java.util.List;

public interface JobService {


    Job createJob(Job job);

    List<Job> getAllJobs();

    Job getJobById(String id);

    void deleteJobById(String id);
}
