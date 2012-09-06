package com.wadia.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wadia.beans.EIndemnite;

public interface EIndemniteRepos extends JpaRepository<EIndemnite, Integer>{

    @Query("SELECT MAX(ans) FROM EIndemnite WHERE resureceId=:username")
    public Integer findByAnsMax(@Param("username") String username);

    @Query("SELECT MAX(mois) FROM EIndemnite e WHERE e.resureceId=:username AND e.ans=(SELECT MAX(ans) FROM e) ")
    public Integer findByMoisMax(@Param("username") String username);
}
