package com.wadia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wadia.beans.Echarge;

@Repository
public interface EchargeRepos extends JpaRepository<Echarge, Integer> {

    @Query("SELECT MAX(ans) FROM Echarge WHERE resourceId=:username")
    public Integer findByAnsMax(@Param("username") String username);

    @Query("SELECT MAX(mois) FROM Echarge e WHERE e.resourceId=:username AND e.ans=(SELECT MAX(ans) FROM e) ")
    public Integer findByMoisMax(@Param("username") String username);

    @Query("SELECT e FROM Echarge e WHERE e.resourceId=:username "
	    + "AND e.mois = (SELECT MAX(mois) FROM e WHERE e.resourceId=:username AND e.ans=(SELECT MAX(ans) FROM e)) "
	    + "AND e.ans=(SELECT MAX(ans) FROM e WHERE e.resourceId=:username)")
    public List<Echarge> findLastEcharge(@Param("username") String username);
}
