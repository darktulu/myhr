package com.wadia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wadia.beans.EEducationData;

public interface EEducationDataRepos extends JpaRepository<EEducationData, Integer>{
    
    @Query("from EEducationData where resurceId =:username")
    public List<EEducationData> findByResurceId(@Param("username") String username);
    @Query("from EEducationData where resurceId =:username AND type =:type")
    public List<EEducationData> findByResurceIdAndType(@Param("username") String username , @Param("type") String type );

}
