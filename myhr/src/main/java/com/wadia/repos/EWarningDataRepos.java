package com.wadia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wadia.beans.EWarningData;

public interface EWarningDataRepos extends JpaRepository<EWarningData, Integer>{
	
	public List<EWarningData> findByResurceId(String username);

}
