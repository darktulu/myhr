package com.wadia.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wadia.beans.Child;

@Repository
public interface ChildRepos extends JpaRepository<Child, String>{

    @Query("UPDATE Child SET approved = :status WHERE childId = :childID")
    public void setStatus(@Param("status")String status,@Param("childID")String id);
}
