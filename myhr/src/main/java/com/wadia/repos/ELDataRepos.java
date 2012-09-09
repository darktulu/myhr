package com.wadia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wadia.beans.ELData;

@Repository
public interface ELDataRepos extends JpaRepository<ELData, Integer>{
	
    @Query("From ELData d where d.resurceId=:username")
    public List<ELData> findByUsername(@Param("username")String username);

}
