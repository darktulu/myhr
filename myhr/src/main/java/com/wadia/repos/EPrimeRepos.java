package com.wadia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wadia.beans.EPrime;

public interface EPrimeRepos extends JpaRepository<EPrime, Integer>{

    @Query("SELECT MAX(ans) FROM EPrime WHERE resourceId=:username")
    public Integer findByAnsMax(@Param("username") String username);

    @Query("SELECT MAX(mois) FROM EPrime e WHERE e.resourceId=:username AND e.ans=(SELECT MAX(ans) FROM e) ")
    public Integer findByMoisMax(@Param("username") String username);
    
    @Query("SELECT e FROM EPrime e WHERE e.resourceId=:username AND e.mois = (SELECT MAX(mois) FROM e WHERE e.resourceId=:username AND e.ans=(SELECT MAX(ans) FROM e)) ")
    public List<EPrime> findLastEPrime(@Param("username")String username);
}
