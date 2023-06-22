package com.jobsBoard.api.controller;

import com.jobsBoard.api.entity.Job;
import com.jobsBoard.api.service.JobService.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {


    @Autowired
    private JobService jobService;

    @PostMapping("/create")
    private ResponseEntity<Job> createAJob(@RequestBody Job job){
        return ResponseEntity.ok(jobService.createJob(job));
    }

    @GetMapping("/getAllJobs")
    public ResponseEntity<?> getAllJobs(){
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @GetMapping("/getJobById/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable String id){
        return ResponseEntity.ok(jobService.getJobById(id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteJob(@PathVariable("id") String id){
        jobService.deleteJobById(id);
    }


    @GetMapping("findJobByTitle/{jobTitle}")
    public List<Job> findJobByJobTitle(@PathVariable String jobTitle){
        return jobService.findJobByJobTitle(jobTitle);
    }

    @GetMapping("findJobByLocation/{jobLocation}")
    public List<Job> getJobByJobLocation(@PathVariable String jobLocation){
        return jobService.getJobByJobLocation(jobLocation);
    }

    @GetMapping("findJobBySalary/{jobSalary}")
    public List<Job> findJobByJobSalary(@PathVariable String jobSalary){
        return jobService.findJobByJobSalary(jobSalary);
    }

    @GetMapping("findJobByCategory/{jobCategory}")
    public List<Job> findJobByJobCategory(@PathVariable String jobCategory) {
        return jobService.findJobByJobCategory(jobCategory);
    }

    @GetMapping("findJobByQualification/{jobQualification}")
    public List<Job> findJobByJobQualification(@PathVariable String jobQualification){
        return jobService.findJobByJobQualification(jobQualification);
    }

    //findJobByUser -> show the jobseeker the list of jobs they have applied for

//do sort by dateCreated / When job was posted
}

// see the stackoverflow for issue with the /findJob same url different request params
