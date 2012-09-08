package com.wadia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wadia.beans.EInsurranceData;

public interface EInsurranceDataRepos extends JpaRepository<EInsurranceData, Integer>{
    
    @Query("from EInsurranceData where resurceId =:username")
    public List<EInsurranceData> findByResurceId(@Param("username") String username);

}
