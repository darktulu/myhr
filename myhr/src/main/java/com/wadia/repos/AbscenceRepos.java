package com.wadia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wadia.beans.Abscence;
import com.wadia.beans.Affectation;

public interface AbscenceRepos extends JpaRepository<Abscence, Integer> {

    public Abscence findById(Integer id);
    
    @Query("from Abscence where ressourceId=:username")
    public List<Abscence> findByUsername(@Param("username") String username);
    
    @Query("from Abscence where ressourceId=:username AND justified=:justified")
    public List<Abscence> findByUsernameAndJustified(@Param("username") String username, @Param("justified") String justified );
}
