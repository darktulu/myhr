package com.wadia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wadia.beans.ESalaryData;

public interface ESalaryDataRepos extends JpaRepository<ESalaryData, Integer> {

    @Query("FROM ESalaryData where resurceId=:username")
    public List<ESalaryData> findByUsername(@Param("username") String username);
    
    @Query("FROM ESalaryData where resurceId=:username AND ans=:year")
    public List<ESalaryData> findByYear(@Param("username") String username, @Param("year") Integer year);
    
    @Query("FROM ESalaryData where resurceId=:username AND ans=:year AND mois=:mois")
    public ESalaryData findByYearAndMonth(@Param("username") String username, @Param("mois") Integer mois, @Param("year") Integer year );

    @Query("SELECT MAX(ans) FROM ESalaryData WHERE resurceId=:username")
    public Integer findByAnsMax(@Param("username") String username);

    @Query("SELECT MAX(mois) FROM ESalaryData e WHERE e.resurceId=:username AND e.ans=(SELECT MAX(ans) FROM e WHERE resurceId=:username) ")
    public Integer findByMoisMax(@Param("username") String username);

    @Query("SELECT e FROM ESalaryData e WHERE " + "e.resurceId=:username "
	    + "AND e.mois = (SELECT MAX(mois) FROM e WHERE e.resurceId=:username AND e.ans=(SELECT MAX(ans) FROM e WHERE resurceId=:username))"
	    + "AND e.ans = (SELECT MAX(ans) FROM e WHERE resurceId=:username)")
    public ESalaryData findLastSalary(@Param("username") String username);
    
    @Query("FROM ESalaryData  WHERE " + "resurceId=:username "
    	    + "AND mois <=:mois AND ans=:year")
        public List<ESalaryData> findSameYearSalary(@Param("username") String username, @Param("mois") Integer mois, @Param("year") Integer year );

    @Query("FROM ESalaryData  WHERE " + "resurceId=:username "
    	    + "AND ans < :year")
        public List<ESalaryData> findMargeYearSalary(@Param("username") String username, @Param("year") Integer year );

}
