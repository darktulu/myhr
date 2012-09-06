package com.wadia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wadia.beans.Soldleave;

public interface SoldleaveRepos extends JpaRepository<Soldleave, Integer> {

    @Query("from Soldleave where resourceId = :username")
    public List<Soldleave> findByUsername(@Param("username") String username);

    @Query("from Soldleave where resourceId=:username and year = :year")
    public Soldleave findByUsernameAndYear(@Param("username") String username, @Param("year") Integer year);
}
