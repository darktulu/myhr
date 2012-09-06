package com.wadia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wadia.beans.ESalaryData;

public interface ESalaryDataRepos extends JpaRepository<ESalaryData, Integer> {

    @Query("FROM ESalaryData where resurceId=:username")
    public List<ESalaryData> findByUsername(@Param("username") String username);

    @Query("SELECT MAX(ans) FROM ESalaryData WHERE resurceId=:username")
    public Integer findByAnsMax(@Param("username") String username);

    @Query("SELECT MAX(mois) FROM ESalaryData e WHERE e.resurceId=:username AND e.ans=(SELECT MAX(ans) FROM e) ")
    public Integer findByMoisMax(@Param("username") String username);
}
