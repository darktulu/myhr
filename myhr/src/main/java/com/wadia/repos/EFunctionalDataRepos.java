package com.wadia.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wadia.beans.EFunctionalData;

public interface EFunctionalDataRepos extends JpaRepository<EFunctionalData, String>{

}
