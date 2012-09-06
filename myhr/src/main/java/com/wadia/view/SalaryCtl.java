/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.wadia.metier.EPrimeMetier;
import com.wadia.metier.EindemMetier;

/**
 *
 * @author toshiba
 */
@ManagedBean
@RequestScoped
public class SalaryCtl {
    
    private static String userToPay;
    private static int mounth;
    private static int year;
    private EPrimeMetier eprimeMetier= new EPrimeMetier();
    private EindemMetier eindemMetier= new EindemMetier();
    
    public SalaryCtl(){
    
    
    }
    
    
    
    
}
