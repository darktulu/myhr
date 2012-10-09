package com.wadia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wadia.beans.EPrime;
import com.wadia.beans.Echarge;

@Repository
public interface EchargeRepos extends JpaRepository<Echarge, Integer> {

    @Query("SELECT MAX(ans) FROM Echarge WHERE resourceId=:username")
    public Integer findByAnsMax(@Param("username") String username);

    @Query("SELECT MAX(mois) FROM Echarge e WHERE e.resourceId=:username AND e.ans=(SELECT MAX(ans) FROM e WHERE resourceId=:username) ")
    public Integer findByMoisMax(@Param("username") String username);

    @Query("SELECT e FROM Echarge e WHERE e.resourceId=:username "
	    + "AND e.mois = (SELECT MAX(mois) FROM e WHERE e.resourceId=:username AND e.ans=(SELECT MAX(ans) FROM e WHERE resourceId=:username)) "
	    + "AND e.ans=(SELECT MAX(ans) FROM e WHERE e.resourceId=:username)")
    public List<Echarge> findLastEcharge(@Param("username") String username);
    
    @Query("FROM Echarge  WHERE " + "resourceId=:username "
    	    + "AND mois <=:mois AND ans=:year")
    public List<Echarge> findSameYearCharge(@Param("username") String username, @Param("mois") Integer mois, @Param("year") Integer year );

    @Query("FROM Echarge  WHERE " + "resourceId=:username "
    	    + "AND ans < :year")
    public List<Echarge> findMargeYearCharge(@Param("username") String username, @Param("year") Integer year );

    @Query("FROM Echarge  WHERE " + "resourceId=:username "
    	    + "AND ans =:year")
    public List<Echarge> findByYear(@Param("username") String username, @Param("year") Integer year );
 
    @Query("FROM Echarge  WHERE " + "resourceId=:username "
    	    + "AND ans =:year AND mois=:mois")
   public List<Echarge> findByYearAndMonth(@Param("username") String username, @Param("mois") Integer mois, @Param("year") Integer year);
    
}
