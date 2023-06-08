package com.jobsBoard.api.controller;

import com.jobsBoard.api.entity.Job;
import com.jobsBoard.api.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
