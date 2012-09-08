package com.wadia.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wadia.beans.EContractData;

public interface EContractDataRepos extends JpaRepository<EContractData, Integer> {
    @Query("SELECT MIN(contractStartDate) FROM EContractData WHERE resurceId=:username ")
    public Date getFirstContract(@Param("username") String username);

    public List<EContractData> findByResurceId(String username);
    
    @Query("SELECT e FROM EContractData AS e WHERE resurceId=:username AND contractStatus='Ongoing' AND contractType='CDI' ")
    public EContractData findLastOngoingCDI(@Param("username")String username);
    
    @Query("SELECT e FROM EContractData AS e WHERE resurceId=:username " +
    		"AND contractStartDate=(SELECT MAX(contractStartDate) FROM e WHERE resurceId=:username)" +
    		"")
    public EContractData findLastContract(@Param("username")String username);
    
   // @Query("UPDATE EContractData SET contractStatus=:status WHERE contractId=:id ")
    //public void setStatus(@Param("status") String status, @Param("id") Integer id);
}
