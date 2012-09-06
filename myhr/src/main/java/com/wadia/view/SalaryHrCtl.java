/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import com.wadia.metier.SalaryHrMetier;
import com.wadia.metier.SalaryHrfillMeteir;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author massin
 */
@ManagedBean(name="SalaryHrCtl")
@RequestScoped
public class SalaryHrCtl {
    private List<SalaryHrMetier> salaryHrMetiers = new ArrayList<SalaryHrMetier>();
    @ManagedProperty(value="#{salaryHrfillMeteir}")
    private SalaryHrfillMeteir salaryHrfillMeteir ;
    
    @PostConstruct
    public void init()
    {
        salaryHrMetiers = salaryHrfillMeteir.listSalary();
    }

    /**
     * @return the salaryHrMetiers
     */
    public List<SalaryHrMetier> getSalaryHrMetiers() {
        return salaryHrMetiers;
    }

    /**
     * @param salaryHrMetiers the salaryHrMetiers to set
     */
    public void setSalaryHrMetiers(List<SalaryHrMetier> salaryHrMetiers) {
        this.salaryHrMetiers = salaryHrMetiers;
    }

    public SalaryHrfillMeteir getSalaryHrfillMeteir() {
        return salaryHrfillMeteir;
    }

    public void setSalaryHrfillMeteir(SalaryHrfillMeteir salaryHrfillMeteir) {
        this.salaryHrfillMeteir = salaryHrfillMeteir;
    }

    
}
