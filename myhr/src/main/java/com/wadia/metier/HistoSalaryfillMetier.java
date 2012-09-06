/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import com.wadia.beans.EIndemnite;
import com.wadia.beans.EPrime;
import com.wadia.beans.Echarge;
import com.wadia.beans.SalaryCharge;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Wadi3
 */
@Service
@Transactional
public class HistoSalaryfillMetier {
    @Inject
    private ChargeMetier chargeMetier;
    @Inject
    private SalaryListMetier listMetier;
    @Inject
    private EindemMetier eindemMetier;
    @Inject
    private EPrimeMetier ePrimeMetier;
    
    public List<HistoSalaryMetier> listHistoCharge(String Username) {
        List<HistoSalaryMetier> histoSalaryMetierList = new ArrayList<HistoSalaryMetier>();
        List<Echarge> listCharge = new ArrayList<Echarge>();
        Double totalAmount =0.0;
        Double retenuCharge = 0.0;
       
        SalaryCharge charges = new SalaryCharge();
        
        
        totalAmount = listMetier.calculeSalaireImposable(Username);
        listCharge = chargeMetier.getChargeByUsername(Username);
        for (Echarge charge : listCharge) {
            
            HistoSalaryMetier histoSalaryMetier = new HistoSalaryMetier();
            histoSalaryMetier.setAns(charge.getAns());
            histoSalaryMetier.setMois(charge.getMois());
            histoSalaryMetier.setDescription(charge.getNom());
            histoSalaryMetier.setId(charge.getId());
            charges =chargeMetier.findByName(charge.getNom());
           if ("CNSS".equals(charges.getNomCharge())){
            if( totalAmount >= 6000){
           retenuCharge =257.40;
          
            }
            else retenuCharge =(charges.getTax()*totalAmount)/100;}
           
           else   retenuCharge =(charges.getTax()*totalAmount)/100;
            histoSalaryMetier.setTotalCharge(retenuCharge);
            histoSalaryMetierList.add(histoSalaryMetier);
            
        }



        return histoSalaryMetierList;
    }

    public List<HistoSalaryMetier> listHistoIndemnite(String Username) {
        List<HistoSalaryMetier> histoSalaryMetierList = new ArrayList<HistoSalaryMetier>();
         List<EIndemnite> listIndemenite = new ArrayList<EIndemnite>();
        
         listIndemenite = eindemMetier.getByusername(Username);
         for(EIndemnite indem :listIndemenite){
          HistoSalaryMetier histoSalaryMetier = new HistoSalaryMetier();   
         histoSalaryMetier.setAns(indem.getAns());
         histoSalaryMetier.setMois(indem.getMois());
         histoSalaryMetier.setTotalAmount(indem.getMontant());
         histoSalaryMetier.setDescription(indem.getCommentaire());
         histoSalaryMetier.setTypeIndemPrem(indem.getNom());
         histoSalaryMetier.setId(indem.getIdIndem());
         histoSalaryMetierList.add(histoSalaryMetier);
         }

        return histoSalaryMetierList;
    }

    public List<HistoSalaryMetier> listHistoPrime(String Username) {
        List<HistoSalaryMetier> histoSalaryMetierList = new ArrayList<HistoSalaryMetier>();

        List<EPrime> listPrime = new ArrayList<EPrime>();

        

        listPrime = ePrimeMetier.getByusername(Username);
        for(EPrime prime :listPrime){
        HistoSalaryMetier histoSalaryMetier = new HistoSalaryMetier();  
        histoSalaryMetier.setTypeIndemPrem(prime.getNom());
        histoSalaryMetier.setAns(prime.getAns());
        histoSalaryMetier.setMois(prime.getMois());
        histoSalaryMetier.setDescription(prime.getCommentaire());
        histoSalaryMetier.setTotalAmount(prime.getMontant());
        histoSalaryMetier.setId(prime.getIdPrime());
        
        histoSalaryMetierList.add(histoSalaryMetier);
        }

        return histoSalaryMetierList;
    }
    
}
