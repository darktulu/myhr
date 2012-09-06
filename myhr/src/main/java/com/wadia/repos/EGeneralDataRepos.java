package com.wadia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wadia.beans.EGeneralData;

@Repository("eGeneralDataRepos")
public interface EGeneralDataRepos extends JpaRepository<EGeneralData, String>{

    public List<EGeneralData> findByStatus(String status);
}
