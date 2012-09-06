/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.ESalaryData;
import com.wadia.repos.ESalaryDataRepos;

/**
 *
 * @author wadi3
 */
@Service
@Transactional
public class SalaryListMetier {
    
    @Inject
    private ESalaryDataRepos eSalaryDataRepos;
    @Inject
    private ChargeMetier chargeMetier;
    @Inject
    private SalaryMetier salaryMetier;
    
    public Double clacluleIr(String Username, Double salaireBase) {
        Double iR = 0.0;


        if (salaireBase <= 2500) {
            iR = 0.0;
        }
        if ((salaireBase >= 2500) && (salaireBase <= 4166.66)) {
            iR = 250.00;
        }
        if ((salaireBase >= 4166.67) && (salaireBase <= 5000.00)) {
            iR = 666.66;
        }
        if ((salaireBase >= 5000.08) && (salaireBase <= 6666.66)) {
            iR = 1166.66;
        }
        if ((salaireBase >= 6666.75) && (salaireBase <= 15000.00)) {
            iR = 1433.33;
        }
        if (salaireBase >= 15000.00) {
            iR = 2033.33;
        }
        return iR;
    }

    public Double calculeSalireNet(String Username) {
        Double salaireNet = 0.0;
        Double SalaireBase = 0.0;

        
        ESalaryData eSalaryData = new ESalaryData(); 
        List<ESalaryData> salaryDataList = new ArrayList();
        
        salaryDataList = eSalaryDataRepos.findByUsername(Username);
        eSalaryData = salaryMetier.getSalaireMoisCourant(salaryDataList, Username);
        SalaireBase = calculeSalaireImposable(Username);
        if (salaryMetier.getTotalAllowance(Username) != 0) {
            salaireNet = salaryMetier.getTotalAllowance(Username) + SalaireBase - chargeMetier.calculeCharge(Username) - calculeIrNet(Username);
        } else {

            salaireNet = SalaireBase - chargeMetier.calculeCharge(Username) - calculeIrNet(Username);
        }

        return salaireNet;
    }

    public Double calculeSalaireImposable(String Username) {
        Double sailreImposable = 0.0;
        Double SalaireBase = 0.0;
        float anciente = 0;
        ESalaryData eSalaryData = new ESalaryData();
        
        List<ESalaryData> salaryDataList = new ArrayList();

        salaryDataList = eSalaryDataRepos.findByUsername(Username);
        
        eSalaryData = salaryMetier.getSalaireMoisCourant(salaryDataList, Username);
        if (eSalaryData.getBaseSalary() != null) {
            SalaireBase = eSalaryData.getBaseSalary();
        } else {
            SalaireBase = 0.0;
        }

        anciente = salaryMetier.anciente(Username);

        if (anciente != 0) {
            sailreImposable = SalaireBase + (anciente * SalaireBase / 100);
        } else {
            sailreImposable = SalaireBase;
        }
        return sailreImposable;
    }

    public Double CalculeBaseIR(String Username) {
        Double baseIr = 0.0;
        Double sailreImposable = 0.0;
        sailreImposable = calculeSalaireImposable(Username);
        baseIr = sailreImposable - (chargeMetier.calculeCharge(Username)) - Math.min(0.2 * sailreImposable, 2500);


        return baseIr;
    }

    public Double calculeIr(String Username) {
        Double retenuIr = 0.0;
        Double baseIr;
        Double iR;
        baseIr = CalculeBaseIR(Username);
        if (baseIr <= 2500) {
            iR = 0.0;
            retenuIr = 0.0;
        }
        if ((baseIr >= 2500) && (baseIr <= 4166.66)) {
            iR = 250.00;
            retenuIr = (baseIr * 10 / 100) - iR;
        }
        if ((baseIr >= 4166.67) && (baseIr <= 5000.00)) {
            iR = 666.66;
            retenuIr = (baseIr * 20 / 100) - iR;
        }
        if ((baseIr >= 5000.08) && (baseIr <= 6666.66)) {
            iR = 1166.66;
            retenuIr = (baseIr * 30 / 100) - iR;
        }
        if ((baseIr >= 6666.75) && (baseIr <= 15000.00)) {
            iR = 1433.33;
            retenuIr = (baseIr * 34 / 100) - iR;
        }
        if (baseIr >= 15000.00) {
            iR = 2033.33;
            retenuIr = (baseIr * 38 / 100) - iR;
        }


        return (retenuIr);
    }

    public Double calculeIrNet(String Username) {
        Double retenuIr = 0.0;
        Double retenuIrNet = 0.0;
        int nbPersonnes;
       
        retenuIr = calculeIr(Username);
        nbPersonnes = salaryMetier.personnesPrisEnCharge(Username);
        if (nbPersonnes != 0) {
            retenuIrNet = retenuIr - nbPersonnes * 30;
            if (retenuIrNet < 0) {
                retenuIrNet = 0.0;
            }

        } else {
            retenuIrNet = retenuIr;
        }

        return retenuIrNet;
    }
}
