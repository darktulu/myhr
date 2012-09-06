/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;
import com.wadia.beans.*;
import java.util.List;

/**
 *
 * @author massin
 */
public class SalarieNetMetier {
    
    
    
    public Double CalculeSalaireNet(Double anciente,Double BaseSalary,List<EPrime> listPrime,List<EIndemnite> listIndemn,List<Echarge> listCharge,int nbPersonnes)
    {
   ChargeMetier eChargeMetier = new ChargeMetier();
    SalaryCharge charges = new SalaryCharge();
   Double totalCharge=0.0;
   Double baseIr = 0.0;
   Double salaireNet =0.0;
   Double salaireImposable;
   float totalPrime =0;
   float totalIndemnite =0;
   float totalAllowance = 0;
   Double retrnuCNSS =0.0;
   Double retenuIr = 0.0;
   Double retenuIrNet = 0.0;
   Double iR;
   Double retenuNotCNSS =0.0;
   salaireImposable =BaseSalary*anciente/100;
   
   for(EPrime prim :listPrime)
   {
     totalPrime =totalPrime + prim.getMontant();  
   }
   for(EIndemnite indem :listIndemn)
   {
   totalIndemnite = totalIndemnite +indem.getMontant();
   }
   totalAllowance =totalIndemnite +totalPrime;
    for(Echarge charge :listCharge)
      {
          charges = eChargeMetier.findByName(charge.getNom());
          if(BaseSalary <=charges.getPlafond()){
          totalCharge =totalCharge+(charges.getTax()*BaseSalary)/100;}
          if(BaseSalary >=charges.getPlafond()){
              if("CNSS".equals(charge.getNom())){
             retrnuCNSS = ((charges.getPlafond())*charges.getTax())/100;}
             else
              { retenuNotCNSS =(charges.getTax()*BaseSalary)/100 ; }
           
          
          totalCharge =retrnuCNSS +retenuNotCNSS;
          }
      }
     
        baseIr =salaireImposable- totalCharge - Math.min(0.2 * salaireImposable, 2500);
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

      if (nbPersonnes != 0) {
            retenuIrNet = retenuIr - nbPersonnes * 30;
            if(retenuIrNet <0)
                retenuIrNet =0.0;
                
        } else {
            retenuIrNet = retenuIr;
        }
      
       if (totalAllowance != 0) {
            salaireNet = totalAllowance + BaseSalary - totalCharge - retenuIrNet;
        } else {
           
            salaireNet = BaseSalary - totalCharge - retenuIrNet;
        }

   
   return salaireNet;}
    
}
