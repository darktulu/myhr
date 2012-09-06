/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.EEducationData;
import com.wadia.repos.EEducationDataRepos;

/**
 * 
 * @author wadi3
 */
@ManagedBean (name="EEducationNewCtl")
@RequestScoped
public class EEducationNewCtl {
    private Integer idEducation;
    private String resurceId;
    private String type;
    private String nameInstitut;
    private String addressInstitut;
    private String courseStudy;
    private Date dateFrom;
    private Date dateTo;
    private boolean certification;
    private EEducationData eEducationData;

    @ManagedProperty(value = "#{eEducationDataRepos}")
    private EEducationDataRepos eEducationDataRepos;

    private userController user = new userController();


    public String Save() {

	eEducationData = new EEducationData(user.getUsername(), type, nameInstitut, addressInstitut, courseStudy,
		dateFrom, dateTo, certification);
	eEducationDataRepos.save(eEducationData);
	return "ok";
    }

    /**
     * @return the idEducation
     */
    public Integer getIdEducation() {
	return idEducation;
    }

    /**
     * @param idEducation
     *            the idEducation to set
     */
    public void setIdEducation(Integer idEducation) {
	this.idEducation = idEducation;
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
     * @return the type
     */
    public String getType() {
	return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
	this.type = type;
    }

    /**
     * @return the nameInstitut
     */
    public String getNameInstitut() {
	return nameInstitut;
    }

    /**
     * @param nameInstitut
     *            the nameInstitut to set
     */
    public void setNameInstitut(String nameInstitut) {
	this.nameInstitut = nameInstitut;
    }

    /**
     * @return the addressInstitut
     */
    public String getAddressInstitut() {
	return addressInstitut;
    }

    /**
     * @param addressInstitut
     *            the addressInstitut to set
     */
    public void setAddressInstitut(String addressInstitut) {
	this.addressInstitut = addressInstitut;
    }

    /**
     * @return the courseStudy
     */
    public String getCourseStudy() {
	return courseStudy;
    }

    /**
     * @param courseStudy
     *            the courseStudy to set
     */
    public void setCourseStudy(String courseStudy) {
	this.courseStudy = courseStudy;
    }

    /**
     * @return the dateFrom
     */
    public Date getDateFrom() {
	return dateFrom;
    }

    /**
     * @param dateFrom
     *            the dateFrom to set
     */
    public void setDateFrom(Date dateFrom) {
	this.dateFrom = dateFrom;
    }

    /**
     * @return the dateTo
     */
    public Date getDateTo() {
	return dateTo;
    }

    /**
     * @param dateTo
     *            the dateTo to set
     */
    public void setDateTo(Date dateTo) {
	this.dateTo = dateTo;
    }

    /**
     * @return the certification
     */
    public boolean isCertification() {
	return certification;
    }

    /**
     * @param certification
     *            the certification to set
     */
    public void setCertification(boolean certification) {
	this.certification = certification;
    }

    /**
     * @return the eEducationData
     */
    public EEducationData geteEducationData() {
	return eEducationData;
    }

    /**
     * @param eEducationData
     *            the eEducationData to set
     */
    public void seteEducationData(EEducationData eEducationData) {
	this.eEducationData = eEducationData;
    }

    public EEducationDataRepos geteEducationDataRepos() {
	return eEducationDataRepos;
    }

    public void seteEducationDataRepos(EEducationDataRepos eEducationDataRepos) {
	this.eEducationDataRepos = eEducationDataRepos;
    }

    public userController getUser() {
	return user;
    }

    public void setUser(userController user) {
	this.user = user;
    }

}
