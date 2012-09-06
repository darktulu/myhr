package com.wadia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wadia.beans.ESpouse;

@Repository
public interface ESpouseRepos extends JpaRepository<ESpouse, String>{

    @Query("UPDATE ESpouse e SET e.approved = :status WHERE e.spouseId = :childID")
    public void setStatus(@Param("status")String status,@Param("childID")String id);
    
    @Query("from ESpouse where resurceId =:username")
    public List<ESpouse> findByResurceId(@Param("username") String username);
    
}
