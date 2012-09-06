package com.wadia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wadia.beans.Affectation;

@Repository("affectationRepos")
public interface AffectationRepos extends JpaRepository<Affectation, Integer> {

    @Query("from Affectation where usersByUsersUsername.username =:username")
    public Affectation findMyManager(@Param("username") String username);
    
    @Query("select usersByUsersUsername.username from Affectation where usersByUsersLm.username = :username")
    public List<String> MyReportsList(@Param("username") String username);
}
