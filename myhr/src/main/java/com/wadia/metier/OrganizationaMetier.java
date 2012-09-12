/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.io.Serializable;

/**
 *
 * @author toshiba
 */
public class OrganizationaMetier implements Serializable{
    
     
     private String name;
     private String surname;
     private String Status;
     private String ressoureceID;
     private String Country;
     private String Region;
     private String IEsourcing;
     private String jobe_title;
     private String Grade;
     private String Ladder;    
     private String LineM;
     private String HR;
     private String lob;
     
     public OrganizationaMetier(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getRessoureceID() {
        return ressoureceID;
    }

    public void setRessoureceID(String ressoureceID) {
        this.ressoureceID = ressoureceID;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getIEsourcing() {
        return IEsourcing;
    }

    public void setIEsourcing(String IEsourcing) {
        this.IEsourcing = IEsourcing;
    }

    public String getJobe_title() {
        return jobe_title;
    }

    public void setJobe_title(String jobe_title) {
        this.jobe_title = jobe_title;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }

    public String getLadder() {
        return Ladder;
    }

    public void setLadder(String Ladder) {
        this.Ladder = Ladder;
    }

    public String getLineM() {
        return LineM;
    }

    public void setLineM(String LineM) {
        this.LineM = LineM;
    }

    public String getHR() {
        return HR;
    }

    public void setHR(String HR) {
        this.HR = HR;
    }

    public String getLob() {
        return lob;
    }

    public void setLob(String lob) {
        this.lob = lob;
    }
    
    @Override
    public String toString(){
    
        return "nom "+name+" prn "+surname+" job "+jobe_title;
    }
    
}
