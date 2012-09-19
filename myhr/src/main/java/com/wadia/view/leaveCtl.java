/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.wadia.beans.EGeneralData;
import com.wadia.beans.ELData;
import com.wadia.beans.Soldleave;
import com.wadia.local.Recipients;
import com.wadia.metier.AffectationMetier;
import com.wadia.metier.MailForm;
import com.wadia.metier.SoldleaveMetier;
import com.wadia.repos.EGeneralDataRepos;
import com.wadia.repos.ELDataRepos;
import com.wadia.repos.SoldleaveRepos;

/**
 * 
 * @author wadi3
 */

@ManagedBean (name="leaveCtl")
@RequestScoped
public class leaveCtl {

    private String id;
    private String year;
    private Date start;
    private Date end;
    private int days;
    private String motif;
    private Integer idToEdit;
    private static ELData leaveToEdit = new ELData();
    
    
    @ManagedProperty(value = "#{soldleaveMetier}")
    private SoldleaveMetier soldleaveMetier;
   
    @ManagedProperty(value = "#{soldleaveRepos}")
    private SoldleaveRepos soldleaveRepos;
   
    private List<Soldleave> soldlist = new ArrayList<Soldleave>();
    private userController user = new userController();
    private ELData leave;
    
    @ManagedProperty(value = "#{eLDataRepos}")
    private ELDataRepos eLDataRepos;
   
    @ManagedProperty(value = "#{affectationMetier}")
    private AffectationMetier affectationMetier;
   
    
    @ManagedProperty(value = "#{eGeneralDataRepos}")
    private EGeneralDataRepos eGeneralDataRepos;



    public String save() {

	Soldleave sold = new Soldleave();
	int yearC;
	String returValue=null;
	List<Recipients> mailList = new ArrayList<Recipients>();
	
	/* Here we create leave to save */
	yearC = extractInt(year);
	
	/* vérification du sold */ 
	
	if(soldleaveMetier.soldKO(user.getUsername(), yearC, days)){
	
		leave = new ELData(user.getUsername(), year, "conge", start, end, days, "waiting", motif);
	    eLDataRepos.save(leave);
	
	/* Here we create sold to save */
	
	    sold = soldleaveRepos.findByUsernameAndYear(user.getUsername(), yearC);
	sold.setPlanned(sold.getPlanned() + days);
	soldleaveRepos.save(sold);
	returValue = "leaves?faces-redirect=true";
	}else {
		
		FacesContext.getCurrentInstance().addMessage(
			    null,
			    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Number of days not allowed",
				    null));
		//returValue = "leave?faces-redirect=true";
	}
   
	return returValue;
    }
    
    public String Skip(){
    
    	return "leaves?faces-redirect=true";
    	
    }
    
    public String cancel() {

	if (leaveToEdit != null) {
	    System.out.println("leave to cancel : " + leaveToEdit.getLeaveId());
	    ELData eld = new ELData();
	    eld = eLDataRepos.findOne(leaveToEdit.getLeaveId());
	    eld.setStatus("canceled");
	    eLDataRepos.save(eld);
	    Soldleave soldc = new Soldleave();
	    int yearC;
	    yearC = extractInt(eld.getDate());

	    soldc = soldleaveRepos.findByUsernameAndYear(user.getUsername(), yearC);
	    soldc.setPlanned(soldc.getPlanned() - eld.getTotalDays());
	    soldleaveRepos.save(soldc);

	    // MailForm mailForm = new MailForm();
	    // mailForm.canceledLeaveMail(affectationMetier.findMyManagerMail(user.getUsername()),
	    // user.getUser().getFirstname(), user.getUser().getLastname());
	    // mailForm.canceledLeaveMail(affectationMetier.findMyRHMail(user.getUsername()),
	    // user.getUser().getFirstname(), user.getUser().getLastname());
	}
	 return "leaves?faces-redirect=true";
    }

    public boolean cancel(String status) {

	boolean var = true;

	if (status.equals("taken") || status.equals("canceled")) {

	    var = false;

	}

	return var;
    }

    public String take() {

	if (leaveToEdit != null) {
	    System.out.println("leave to cancel : " + leaveToEdit.getLeaveId());
	    ELData eld = new ELData();
	    eld = eLDataRepos.findOne(leaveToEdit.getLeaveId());
	    eld.setStatus("taken");
	    eLDataRepos.save(eld);
	    Soldleave soldc = new Soldleave();
	    int yearC;
	    yearC = extractInt(eld.getDate());
	    soldc = soldleaveRepos.findByUsernameAndYear(user.getUsername(), yearC);

	    soldc.setConsumed(soldc.getConsumed() + eld.getTotalDays());
	    soldc.setPlanned(soldc.getPlanned() - eld.getTotalDays());
	    soldleaveRepos.save(soldc);

	    MailForm mailForm = new MailForm();
	    // mailForm.takeLeaveMail(affectationMetier.findMyManagerMail(user.getUsername()),
	    // user.getUser().getFirstname(), user.getUser().getLastname());
	     //mailForm.takeLeaveMail(affectationMetier.findMyRHMail(user.getUsername()),
	    // user.getUser().getFirstname(), user.getUser().getLastname());
       
	}
	 return "leaves?faces-redirect=true";

    }

    public void changeStt() {

	List<EGeneralData> eGeneralDatas = new ArrayList<EGeneralData>();
	eGeneralDatas = eGeneralDataRepos.findAll();

	for (EGeneralData egen : eGeneralDatas) {

	    if (egen.getIesourcing() != null) {

		if (egen.getIesourcing().equals("insource")) {
		    egen.setIesourcing("Internal");
		    eGeneralDataRepos.save(egen);
		}

		if (egen.getIesourcing().equals("outsource")) {
		    egen.setIesourcing("External");
		    eGeneralDataRepos.save(egen);
		}

	    }
	}

    }

    public String delete() {

	if (leaveToEdit != null) {
	    System.out.println("leave to delete : " + leaveToEdit.getLeaveId());
	    eLDataRepos.delete(leaveToEdit);
	}
	
	 return "leaves?faces-redirect=true";

    }


    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public Date getStart() {
	return start;
    }

    public void setStart(Date start) {
	this.start = start;
    }

    public Date getEnd() {
	return end;
    }

    public void setEnd(Date end) {
	this.end = end;
    }

    public int getDays() {
	return days;
    }

    public void setDays(int days) {
	this.days = days;
    }

    public String getMotif() {
	return motif;
    }

    public void setMotif(String motif) {
	this.motif = motif;
    }

    public Integer getIdToEdit() {
	return idToEdit;
    }

    public void setIdToEdit(Integer idToEdit) {
	this.idToEdit = idToEdit;

	if (idToEdit != null) {

	    leaveToEdit = eLDataRepos.findOne(idToEdit);
	    System.out.println("leave : " + leaveToEdit.getLeaveId());
	}

    }

    public static ELData getLeaveToEdit() {
	return leaveToEdit;
    }

    public static void setLeaveToEdit(ELData aLeaveToEdit) {
	leaveToEdit = aLeaveToEdit;
    }

    public String getYear() {
	return year;
    }

    public void setYear(String year) {
	this.year = year;
    }

    public static int extractInt(String str) {
	Matcher matcher = Pattern.compile("\\d+").matcher(str);

	if (!matcher.find()) {
	    throw new NumberFormatException("For input string [" + str + "]");
	}

	return Integer.parseInt(matcher.group());
    }


    public SoldleaveRepos getSoldleaveRepos() {
	return soldleaveRepos;
    }

    public void setSoldleaveRepos(SoldleaveRepos soldleaveRepos) {
	this.soldleaveRepos = soldleaveRepos;
    }

    public List<Soldleave> getSoldlist() {
	return soldlist;
    }

    public void setSoldlist(List<Soldleave> soldlist) {
	this.soldlist = soldlist;
    }

    public userController getUser() {
	return user;
    }

    public void setUser(userController user) {
	this.user = user;
    }

    public ELData getLeave() {
	return leave;
    }

    public void setLeave(ELData leave) {
	this.leave = leave;
    }

    public AffectationMetier getAffectationMetier() {
	return affectationMetier;
    }

    public void setAffectationMetier(AffectationMetier affectationMetier) {
	this.affectationMetier = affectationMetier;
    }
    

    public EGeneralDataRepos geteGeneralDataRepos() {
	return eGeneralDataRepos;
    }

    public void seteGeneralDataRepos(EGeneralDataRepos eGeneralDataRepos) {
	this.eGeneralDataRepos = eGeneralDataRepos;
    }

    public SoldleaveMetier getSoldleaveMetier() {
        return soldleaveMetier;
    }

    public void setSoldleaveMetier(SoldleaveMetier soldleaveMetier) {
        this.soldleaveMetier = soldleaveMetier;
    }

    public ELDataRepos geteLDataRepos() {
        return eLDataRepos;
    }

    public void seteLDataRepos(ELDataRepos eLDataRepos) {
        this.eLDataRepos = eLDataRepos;
    }


}
