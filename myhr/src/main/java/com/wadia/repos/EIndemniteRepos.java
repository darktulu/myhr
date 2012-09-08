package com.wadia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wadia.beans.EIndemnite;

public interface EIndemniteRepos extends JpaRepository<EIndemnite, Integer>{

    @Query("SELECT MAX(ans) FROM EIndemnite WHERE resureceId=:username")
    public Integer findByAnsMax(@Param("username") String username);

    @Query("SELECT MAX(mois) FROM EIndemnite e WHERE e.resureceId=:username AND e.ans=(SELECT MAX(ans) FROM e) ")
    public Integer findByMoisMax(@Param("username") String username);
    
    @Query("SELECT e FROM EIndemnite e WHERE e.resureceId=:username AND e.mois = (SELECT MAX(mois) FROM e WHERE e.resureceId=:username AND e.ans=(SELECT MAX(ans) FROM e)) ")
    public List<EIndemnite> findLastEIndemnite(@Param("username")String username);
}
