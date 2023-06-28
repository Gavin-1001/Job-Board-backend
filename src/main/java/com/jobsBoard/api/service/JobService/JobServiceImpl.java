package com.jobsBoard.api.service.JobService;

import com.jobsBoard.api.entity.AuthUser;
import com.jobsBoard.api.entity.Job;
import com.jobsBoard.api.repository.JobRepository;
import com.jobsBoard.api.repository.UserAuthRepository;
import com.jobsBoard.api.service.AuthenticationService.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserAuthRepository userAuthRepository;


    @Override
    public Job createJob(Job job) {
        job.setJobDateCreated(LocalDateTime.now());
        //AuthUser user = authenticationService.findById(userId).orElse(null);

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
    public Job updateJob(String id, Job job) {
        Job updateJob = jobRepository.findById(job.getId()).get();
        if(job.getJobTitle() != null && !job.getJobTitle().isEmpty()){
            updateJob.setJobTitle(job.getJobTitle());
        }
        if(job.getJobDescription() != null && !job.getJobDescription().isEmpty()){
            updateJob.setJobDescription(job.getJobDescription());
        }
        if(job.getJobSalary() != null && !job.getJobSalary().isEmpty()){
            updateJob.setJobSalary(job.getJobSalary());
        }
        if(job.getJobLocation() != null && !job.getJobLocation().isEmpty()){
            updateJob.setJobLocation(job.getJobLocation());
        }
        if(job.getJobStartDate() != null && !job.getJobStartDate().isEmpty()){
            updateJob.setJobStartDate(job.getJobStartDate());
        }
        if(job.getJobQualifications() != null && !job.getJobQualifications().isEmpty()){
            updateJob.setJobQualifications(job.getJobQualifications());
        }
        if(job.getJobCategory() != null && !job.getJobCategory().isEmpty()){
            updateJob.setJobCategory(job.getJobCategory());
        }
        updateJob = jobRepository.save(updateJob);
        return updateJob;

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

    @Override
    public List<Job> findJobByEmployerAuthor(String employerAuthor){
        return jobRepository.findJobByEmployerAuthor(employerAuthor);
    }


    public List<Job> getJobsCreatedBy(Long userId){
        AuthUser user = userAuthRepository.findById(userId).orElseThrow(null);
        if(user != null){
            return jobRepository.findByEmployerAuthor(user);
        }
        return Collections.emptyList();
    }


}

