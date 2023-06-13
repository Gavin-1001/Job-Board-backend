package com.jobsBoard.api.repository;

import com.jobsBoard.api.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<AuthUser, String> {

    Optional<AuthUser> findByUsername(String username);
}
