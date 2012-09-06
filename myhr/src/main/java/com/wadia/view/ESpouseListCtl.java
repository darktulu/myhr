/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.ESpouse;
import com.wadia.repos.ESpouseRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean
@RequestScoped
public class ESpouseListCtl {

    private String spouseId;
    private String resurceId;
    private String spouseName;
    private String spouseSurname;
    private Date spouseBirthday;
    private String spouseStatus;

    @ManagedProperty(value = "#{espouseRepos}")
    private ESpouseRepos espouseRepos;

    private ESpouse espouse;

    public ESpouseListCtl() {
	espouse = new ESpouse();
	espouse = espouseRepos.findOne(spouseId);
	spouseName = espouse.getSpouseName();

    }

    /**
     * @return the spouseId
     */
    public String getSpouseId() {
	return spouseId;
    }

    /**
     * @param spouseId
     *            the spouseId to set
     */
    public void setSpouseId(String spouseId) {
	this.spouseId = spouseId;
    }

    /**
     * @return the resurceId
     */
    public String getResurceId() {
	return resurceId;
    }

    /**
     * @param resurceId
     *            the resurceId to set
     */
    public void setResurceId(String resurceId) {
	this.resurceId = resurceId;
    }

    /**
     * @return the spouseName
     */
    public String getSpouseName() {
	return spouseName;
    }

    /**
     * @param spouseName
     *            the spouseName to set
     */
    public void setSpouseName(String spouseName) {
	this.spouseName = spouseName;
    }

    /**
     * @return the spouseSurname
     */
    public String getSpouseSurname() {
	return spouseSurname;
    }

    /**
     * @param spouseSurname
     *            the spouseSurname to set
     */
    public void setSpouseSurname(String spouseSurname) {
	this.spouseSurname = spouseSurname;
    }

    /**
     * @return the spouseBirthday
     */
    public Date getSpouseBirthday() {
	return spouseBirthday;
    }

    /**
     * @param spouseBirthday
     *            the spouseBirthday to set
     */
    public void setSpouseBirthday(Date spouseBirthday) {
	this.spouseBirthday = spouseBirthday;
    }

    /**
     * @return the spouseStatus
     */
    public String getSpouseStatus() {
	return spouseStatus;
    }

    /**
     * @param spouseStatus
     *            the spouseStatus to set
     */
    public void setSpouseStatus(String spouseStatus) {
	this.spouseStatus = spouseStatus;
    }
}
