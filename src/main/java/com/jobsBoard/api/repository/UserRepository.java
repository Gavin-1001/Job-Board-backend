package com.jobsBoard.api.repository;

import com.jobsBoard.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface UserRepository extends JpaRepository<User, String> {


}
