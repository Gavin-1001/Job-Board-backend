package com.jobsBoard.api.service.JobService;

import com.jobsBoard.api.entity.Job;
import com.jobsBoard.api.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Job createJob(Job job) {
        job.setJobDateCreated(LocalDateTime.now());
        return jobRepository.save(job);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(String id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteJobById(String id) {
        jobRepository.deleteJobById(id);
    }

    @Override
    public List<Job> findJobByJobTitle(String jobTitle) {
        return jobRepository.findJobByJobTitle(jobTitle);
    }

    @Override
    public List<Job> getJobByJobLocation(String jobLocation){
        return jobRepository.findJobByJobLocation(jobLocation);
    }

    @Override
    public List<Job> findJobByJobSalary(String jobSalary) {
        return jobRepository.findJobByJobSalary(jobSalary);
    }

    @Override
    public List<Job> findJobByJobCategory(String jobCategory) {
        return jobRepository.findJobByJobCategory(jobCategory);
    }

    @Override
    public List<Job> findJobByJobQualification(String jobQualification){
        return jobRepository.findJobByJobQualifications(jobQualification);
    }

}
