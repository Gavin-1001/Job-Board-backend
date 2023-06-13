package com.jobsBoard.api.repository;

import com.jobsBoard.api.entity.JwtRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtRefreshTokenRepository extends JpaRepository<JwtRefreshToken, String> {
}
