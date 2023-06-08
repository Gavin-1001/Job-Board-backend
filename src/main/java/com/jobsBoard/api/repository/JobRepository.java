package com.jobsBoard.api.repository;

import com.jobsBoard.api.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {

    @Modifying
    @Transactional
    void deleteJobById(String id);
}
