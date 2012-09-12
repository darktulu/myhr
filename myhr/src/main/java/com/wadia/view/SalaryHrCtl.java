/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.util.StopWatch;

import com.wadia.metier.SalaryHrMetier;
import com.wadia.metier.SalaryHrfillMeteir;
import com.wadia.service.SalaryService;

/**
 * 
 * @author massin
 */
@ManagedBean(name = "SalaryHrCtl")
@RequestScoped
public class SalaryHrCtl {
    private List<SalaryHrMetier> salaryHrMetiers = new ArrayList<SalaryHrMetier>();
    
    @ManagedProperty(value = "#{salaryService}")
    private SalaryService salaryService;

    @PostConstruct
    public void init() {
	StopWatch stopWatch = new StopWatch();
	stopWatch.start();
	salaryHrMetiers = salaryService.listSalary();
	System.out.println(salaryHrMetiers.size());
	stopWatch.stop();
	System.out.println("method time : " + stopWatch.getTotalTimeMillis() + " ms");
    }

    /**
     * @return the salaryHrMetiers
     */
    public List<SalaryHrMetier> getSalaryHrMetiers() {
	return salaryHrMetiers;
    }

    /**
     * @param salaryHrMetiers
     *            the salaryHrMetiers to set
     */
    public void setSalaryHrMetiers(List<SalaryHrMetier> salaryHrMetiers) {
	this.salaryHrMetiers = salaryHrMetiers;
    }

    public SalaryService getSalaryService() {
	return salaryService;
    }

    public void setSalaryService(SalaryService salaryService) {
	this.salaryService = salaryService;
    }

}
