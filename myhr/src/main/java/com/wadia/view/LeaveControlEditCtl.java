/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import com.wadia.beans.EGeneralData;
import com.wadia.beans.ELData;
import com.wadia.local.Recipients;
import com.wadia.metier.AffectationMetier;
import com.wadia.metier.MailForm;
import com.wadia.repos.EGeneralDataRepos;
import com.wadia.repos.ELDataRepos;

/**
 *
 * @author toshiba
 */
@ManagedBean (name="LeaveControlEditCtl")
@ViewScoped
public class LeaveControlEditCtl implements Serializable {

    private int leveToApprove;
    private ELData data = new ELData("no one");
    private userController user = new userController();
    
    private ELDataRepos eLDataRepos() {
        return SpringJSFUtil.getBean("eLDataRepos");
    }
    
    private AffectationMetier affectationMetier() {
        return SpringJSFUtil.getBean("affectationMetier");
    }
    
    private EGeneralDataRepos eGeneralDataRepos() {
        return SpringJSFUtil.getBean("eGeneralDataRepos");
    }
    
    private MailForm mailForm() {
        return SpringJSFUtil.getBean("mailForm");
    }
    
    private static String description;

    public String approuve() {
       // List<String> mailList = new ArrayList<String>();
        List<Recipients> mailList = new ArrayList<Recipients>();
        data.setStatus("Approved By HR");
        data.setSatatusDescription(" ");
        eLDataRepos().save(data);
       
        /* Sending Mail */
	    
	    Recipients manager = new Recipients();
	    manager.setMail(affectationMetier().findMyManager(user.getUsername()).getInfo());
	    manager.setType("Cc");
		mailList.add(manager); // ADD MANAGER
		
		Recipients HrManager = new Recipients();
		HrManager.setMail(affectationMetier().findMyHrManager(user.getUsername()).getInfo());
		HrManager.setType("Cc");
		mailList.add(HrManager);//ADD HR
		
		Recipients Me = new Recipients();
		Me.setMail(affectationMetier().findMe(user.getUsername()).getInfo());
		Me.setType("To");
		mailList.add(Me);// ADD ME
	    
		EGeneralData generalData = new EGeneralData();
		generalData = eGeneralDataRepos().findOne(user.getUsername()); 
		mailForm().leaveApprouved(mailList,generalData.getName()+" "+generalData.getSurname(), data.getDate(), data.getLeaveStartDate(), data.getLeaveEndDate(), data.getTotalDays(), data.getSatatusDescription(),"HR Manager");
		    
		 	
		    
       
        
        return "LeaveSummaryList?faces-redirect=true";
    }

    public String approuvePM() {
        List<Recipients> mailList = new ArrayList<Recipients>();
        data.setStatus("Approved By PM");
        data.setSatatusDescription(" ");
        eLDataRepos().save(data);
        /* Sending Mail */
	    
	    Recipients manager = new Recipients();
	    manager.setMail(affectationMetier().findMyManager(user.getUsername()).getInfo());
	    manager.setType("Cc");
		mailList.add(manager); // ADD MANAGER
		
		Recipients HrManager = new Recipients();
		HrManager.setMail(affectationMetier().findMyHrManager(user.getUsername()).getInfo());
		HrManager.setType("Cc");
		mailList.add(HrManager);//ADD HR
		
		Recipients Me = new Recipients();
		Me.setMail(affectationMetier().findMe(user.getUsername()).getInfo());
		Me.setType("To");
		mailList.add(Me);// ADD ME
	    
		EGeneralData generalData = new EGeneralData();
		generalData = eGeneralDataRepos().findOne(user.getUsername()); 
		mailForm().leaveApprouved(mailList,generalData.getName()+" "+generalData.getSurname(), data.getDate(), data.getLeaveStartDate(), data.getLeaveEndDate(), data.getTotalDays(), data.getSatatusDescription(),"Project Manager");
        return "myTeam?faces-redirect=true";
    }
    
    public String taken() {
        List<String> mailList = new ArrayList<String>();
        data.setStatus("taken");
        data.setSatatusDescription(" ");
        eLDataRepos().save(data);
//       mailList.add(affectationMetier().findMyManager(data.getResurceId()).getInfo());
//        mailList.add(affectationMetier().findMyHrManager(data.getResurceId()).getInfo());
     // mailList.add(affectationMetier().findMe(data.getResurceId()).getInfo());
     //  MailForm mailForm = new MailForm();
     //  mailForm.leaveApprouved(mailList, affectationMetier().findMe(data.getResurceId()).getFullName(), data.getDate(), data.getLeaveStartDate(), data.getLeaveEndDate(), data.getTotalDays(), data.getSatatusDescription(), "line Manager");
        return "LeaveSummaryList?faces-redirect=true";
    }

    public String disapprouve() {
        List<Recipients> mailList = new ArrayList<Recipients>();
        data.setStatus("Disapproved By HR");
        data.setSatatusDescription("" + description);
        eLDataRepos().save(data);
        System.out.println("Approved object is : " + data.getResurceId());
       
        /* Sending Mail */
	    
	    Recipients manager = new Recipients();
	    manager.setMail(affectationMetier().findMyManager(user.getUsername()).getInfo());
	    manager.setType("Cc");
		mailList.add(manager); // ADD MANAGER
		
		Recipients HrManager = new Recipients();
		HrManager.setMail(affectationMetier().findMyHrManager(user.getUsername()).getInfo());
		HrManager.setType("Cc");
		mailList.add(HrManager);//ADD HR
		
		Recipients Me = new Recipients();
		Me.setMail(affectationMetier().findMe(user.getUsername()).getInfo());
		Me.setType("To");
		mailList.add(Me);// ADD ME
	    
		EGeneralData generalData = new EGeneralData();
		generalData = eGeneralDataRepos().findOne(user.getUsername()); 
		mailForm().leaveDesapprouved(mailList,generalData.getName()+" "+generalData.getSurname(), data.getDate(), data.getLeaveStartDate(), data.getLeaveEndDate(), data.getTotalDays(), data.getSatatusDescription(),"HR Manager");
       
		return "LeaveSummaryList?faces-redirect=true";
    }

    public String disapprouvePM() {

        data.setStatus("Disapproved By PM");
        data.setSatatusDescription("" + description);
        eLDataRepos().save(data);

        System.out.println("Approved object is : " + data.getResurceId());
        List<Recipients> mailList = new ArrayList<Recipients>();
        
        /* Sending Mail */
	    
	    Recipients manager = new Recipients();
	    manager.setMail(affectationMetier().findMyManager(user.getUsername()).getInfo());
	    manager.setType("Cc");
		mailList.add(manager); // ADD MANAGER
		
		Recipients HrManager = new Recipients();
		HrManager.setMail(affectationMetier().findMyHrManager(user.getUsername()).getInfo());
		HrManager.setType("Cc");
		mailList.add(HrManager);//ADD HR
		
		Recipients Me = new Recipients();
		Me.setMail(affectationMetier().findMe(user.getUsername()).getInfo());
		Me.setType("To");
		mailList.add(Me);// ADD ME
	    
		EGeneralData generalData = new EGeneralData();
		generalData = eGeneralDataRepos().findOne(user.getUsername()); 
		mailForm().leaveDesapprouved(mailList,generalData.getName()+" "+generalData.getSurname(), data.getDate(), data.getLeaveStartDate(), data.getLeaveEndDate(), data.getTotalDays(), data.getSatatusDescription(),"Line Manager");

        return "myTeam?faces-redirect=true";
    }

    public ELData getData() {
        return data;
    }

    public void setData(ELData data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public userController getUser() {
		return user;
	}

	public void setUser(userController user) {
		this.user = user;
	}



}
