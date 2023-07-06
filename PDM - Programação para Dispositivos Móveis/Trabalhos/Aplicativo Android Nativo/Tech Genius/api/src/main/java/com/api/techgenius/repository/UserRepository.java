package com.api.techgenius.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.techgenius.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("select u from User u order by u.score desc limit 10")
    public List<User> getTopRanking();
}
