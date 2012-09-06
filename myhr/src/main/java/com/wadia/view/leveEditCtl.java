/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.ELData;
import com.wadia.repos.ELDataRepos;

/**
 * 
 * @author wadi3
 */
@ManagedBean
@RequestScoped
public class leveEditCtl {

    private static Integer leaveId;
    private static String resurceId;
    private static String date;
    private static String leaveType;
    private static Date leaveStartDate;
    private static Date leaveEndDate;
    private static Integer totalDays;
    private static String status;
    private static String satatusDescription;
    private int toEdit;

    @ManagedProperty(value = "#{eLDataRepos}")
    private ELDataRepos eLDataRepos;





    public String save() {
	ELData el = new ELData(resurceId, date, leaveType, leaveStartDate, leaveEndDate, totalDays, status,
		satatusDescription);
	el.setLeaveId(leaveId);

	eLDataRepos.save(el);
	return "ok";
    }

    public Integer getLeaveId() {
	return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
	this.leaveId = leaveId;
    }

    public String getResurceId() {
	return resurceId;
    }

    public void setResurceId(String resurceId) {
	this.resurceId = resurceId;
    }

    public String getDate() {
	return date;
    }

    public void setDate(String date) {
	this.date = date;
    }

    public String getLeaveType() {
	return leaveType;
    }

    public void setLeaveType(String leaveType) {
	this.leaveType = leaveType;
    }

    public Date getLeaveStartDate() {
	return leaveStartDate;
    }

    public void setLeaveStartDate(Date leaveStartDate) {
	this.leaveStartDate = leaveStartDate;
    }

    public Date getLeaveEndDate() {
	return leaveEndDate;
    }

    public void setLeaveEndDate(Date leaveEndDate) {
	this.leaveEndDate = leaveEndDate;
    }

    public Integer getTotalDays() {
	return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
	this.totalDays = totalDays;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getSatatusDescription() {
	return satatusDescription;
    }

    public void setSatatusDescription(String satatusDescription) {
	this.satatusDescription = satatusDescription;
    }

    public int getToEdit() {
	return toEdit;
    }

    public void update() {
	totalDays = 100;
    }

    public void setToEdit(int toEdit) {
	this.toEdit = toEdit;
	if (toEdit != 0) {

	    ELData eld = new ELData();
	    eld = eLDataRepos.findOne(toEdit);

	    leaveId = eld.getLeaveId();
	    resurceId = eld.getResurceId();
	    date = eld.getDate();
	    leaveType = eld.getLeaveType();
	    leaveStartDate = eld.getLeaveStartDate();
	    leaveEndDate = eld.getLeaveEndDate();
	    totalDays = eld.getTotalDays();
	    status = eld.getStatus();
	    satatusDescription = eld.getSatatusDescription();
	    // soldLeave = soldleaveDao.findByUsernameAndYear(resurceId,
	    // extractInt(date));

	    // System.out.println("here in the corner");
	}
    }

    public static int extractInt(String str) {
	Matcher matcher = Pattern.compile("\\d+").matcher(str);

	if (!matcher.find()) {
	    throw new NumberFormatException("For input string [" + str + "]");
	}

	return Integer.parseInt(matcher.group());
    }
    
    public ELDataRepos geteLDataRepos() {
        return eLDataRepos;
    }

    public void seteLDataRepos(ELDataRepos eLDataRepos) {
        this.eLDataRepos = eLDataRepos;
    }
}
