package com.wadia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wadia.beans.EIndemnite;
import com.wadia.beans.ESalaryData;

public interface EIndemniteRepos extends JpaRepository<EIndemnite, Integer> {

	@Query("SELECT MAX(ans) FROM EIndemnite WHERE resureceId=:username")
	public Integer findByAnsMax(@Param("username") String username);

	@Query("SELECT MAX(mois) FROM EIndemnite e WHERE e.resureceId=:username AND e.ans=(SELECT MAX(ans) FROM e WHERE e.resureceId=:username) ")
	public Integer findByMoisMax(@Param("username") String username);

	@Query("SELECT e FROM EIndemnite e WHERE e.resureceId=:username " +
			"AND e.mois = (SELECT MAX(mois) FROM e WHERE e.resureceId=:username AND e.ans=(SELECT MAX(ans) FROM e WHERE e.resureceId=:username)) " +
			"AND e.ans=(SELECT MAX(ans) FROM EIndemnite WHERE resureceId=:username)")
	public List<EIndemnite> findLastEIndemnite(@Param("username") String username);
	
	 @Query("FROM EIndemnite  WHERE " + "resureceId=:username "
	    	    + "AND mois <=:mois AND ans=:year")
	 public List<EIndemnite> findSameYearIndem(@Param("username") String username, @Param("mois") Integer mois, @Param("year") Integer year );

	 @Query("FROM EIndemnite  WHERE " + "resureceId=:username "
	    	    + "AND ans < :year")
	 public List<EIndemnite> findMargeYearIndem(@Param("username") String username, @Param("year") Integer year );

	 @Query("FROM EIndemnite  WHERE " + "resureceId=:username "
	    	    + "AND ans =:year")
	 public List<EIndemnite> findByYear(@Param("username") String username, @Param("year") Integer year );
	 
	 @Query("FROM EIndemnite  WHERE " + "resureceId=:username "
	    	    + "AND ans =:year AND mois=:mois")
	 public List<EIndemnite> findByYearAndMonth(@Param("username") String username, @Param("mois") Integer mois, @Param("year") Integer year);
}
