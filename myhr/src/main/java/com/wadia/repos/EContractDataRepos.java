package com.wadia.repos;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wadia.beans.EContractData;

public interface EContractDataRepos extends JpaRepository<EContractData, Integer> {
    @Query("SELECT MIN(contractStartDate) FROM EContractData WHERE resurceId=:username ")
    public Date getFirstContract(@Param("username") String username);

   // @Query("UPDATE EContractData SET contractStatus=:status WHERE contractId=:id ")
    //public void setStatus(@Param("status") String status, @Param("id") Integer id);
}
