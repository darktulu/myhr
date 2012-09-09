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

import com.wadia.beans.ELData;
import com.wadia.metier.AffectationMetier;
import com.wadia.metier.MailForm;
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
    
    private ELDataRepos eLDataRepos() {
        return SpringJSFUtil.getBean("eLDataRepos");
    }
    
    private AffectationMetier affectationMetier() {
        return SpringJSFUtil.getBean("affectationMetier");
    }
    
    private static String description;

    public String approuve() {
        List<String> mailList = new ArrayList<String>();
        data.setStatus("Approved By HR");
        data.setSatatusDescription(" ");
        eLDataRepos().save(data);
        mailList.add(affectationMetier().findMyManager(data.getResurceId()).getInfo());
        mailList.add(affectationMetier().findMyHrManager(data.getResurceId()).getInfo());
        mailList.add(affectationMetier().findMe(data.getResurceId()).getInfo());
        MailForm mailForm = new MailForm();
        mailForm.leaveApprouved(mailList, affectationMetier().findMe(data.getResurceId()).getFullName(), data.getDate(), data.getLeaveStartDate(), data.getLeaveEndDate(), data.getTotalDays(), data.getSatatusDescription(), "HR Manager");
        return "ok";
    }

    public String approuvePM() {
        List<String> mailList = new ArrayList<String>();
        data.setStatus("Approved By PM");
        data.setSatatusDescription(" ");
        eLDataRepos().save(data);
//        mailList.add(affectationMetier().findMyManager(data.getResurceId()).getInfo());
//        mailList.add(affectationMetier().findMyHrManager(data.getResurceId()).getInfo());
//        mailList.add(affectationMetier().findMe(data.getResurceId()).getInfo());
//        MailForm mailForm = new MailForm();
//        mailForm.leaveApprouved(mailList, affectationMetier().findMe(data.getResurceId()).getFullName(), data.getDate(), data.getLeaveStartDate(), data.getLeaveEndDate(), data.getTotalDays(), data.getSatatusDescription(), "line Manager");
        return "myTeam?faces-redirect=true";
    }

    public String disapprouve() {
        List<String> mailList = new ArrayList<String>();
        data.setStatus("Disapproved By HR");
        data.setSatatusDescription("" + description);
        eLDataRepos().save(data);
        System.out.println("Approved object is : " + data.getResurceId());
        mailList.add(affectationMetier().findMyManager(data.getResurceId()).getInfo());
        mailList.add(affectationMetier().findMyHrManager(data.getResurceId()).getInfo());
        mailList.add(affectationMetier().findMe(data.getResurceId()).getInfo());
        MailForm mailForm = new MailForm();
        mailForm.leaveDesapprouved(mailList, affectationMetier().findMe(data.getResurceId()).getFullName(), data.getDate(), data.getLeaveStartDate(), data.getLeaveEndDate(), data.getTotalDays(), data.getSatatusDescription(), "HR Manager");
        return "ok";
    }

    public String disapprouvePM() {

        data.setStatus("Disapproved By PM");
        data.setSatatusDescription("" + description);
        eLDataRepos().save(data);

        System.out.println("Approved object is : " + data.getResurceId());
        List<String> mailList = new ArrayList<String>();
//        mailList.add(affectationMetier().findMyManager(data.getResurceId()).getInfo());
//        mailList.add(affectationMetier().findMyHrManager(data.getResurceId()).getInfo());
//        mailList.add(affectationMetier().findMe(data.getResurceId()).getInfo());
//        MailForm mailForm = new MailForm();
//        mailForm.leaveDesapprouved(mailList, affectationMetier().findMe(data.getResurceId()).getFullName(), data.getDate(), data.getLeaveStartDate(), data.getLeaveEndDate(), data.getTotalDays(), data.getSatatusDescription(), "line Manager");

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

}
