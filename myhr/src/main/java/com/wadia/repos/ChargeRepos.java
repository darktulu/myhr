package com.wadia.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wadia.beans.SalaryCharge;

public interface ChargeRepos extends JpaRepository<SalaryCharge, Integer> {

    public SalaryCharge findByIdCharge(Integer id);
    
}
