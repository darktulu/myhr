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
@ManagedBean(name = "EEducationEditCtl")
@RequestScoped
public class EEducationEditCtl {
    private int idToEdit;
    private static Integer idEducation;
    private static String resurceId;
    private static String type;
    private static String nameInstitut;
    private static String addressInstitut;
    private static String courseStudy;
    private static Date dateFrom;
    private static Date dateTo;
    private boolean certification;
    private Integer idToDelete;
    private EEducationData eEducationData = new EEducationData();

    @ManagedProperty(value = "#{eEducationDataRepos}")
    private EEducationDataRepos eEducationDataRepos;

    /**
     * @return the idToEdit
     */
    public int getIdToEdit() {
	return idToEdit;
    }

    /**
     * @param idToEdit
     *            the idToEdit to set
     */
    public void setIdToEdit(int idToEdit) {
	this.idToEdit = idToEdit;

	if (idToEdit != 0) {
	    EEducationData eEducationData = new EEducationData();
	    eEducationData = eEducationDataRepos.findOne(idToEdit);
	    idEducation = eEducationData.getIdEducation();
	    resurceId = eEducationData.getResurceId();
	    type = eEducationData.getType();
	    nameInstitut = eEducationData.getNameInstitut();
	    addressInstitut = eEducationData.getAddressInstitut();
	    courseStudy = eEducationData.getCourseStudy();
	    dateFrom = eEducationData.getDateFrom();
	    dateTo = eEducationData.getDateTo();

	}
    }

    public String saveEdit() {
	EEducationData educationData = new EEducationData();
	educationData.setAddressInstitut(addressInstitut);
	educationData.setCertification(certification);
	educationData.setCourseStudy(courseStudy);
	educationData.setDateFrom(dateFrom);
	educationData.setDateTo(dateTo);
	educationData.setIdEducation(idEducation);
	educationData.setNameInstitut(nameInstitut);
	educationData.setType(type);
	educationData.setResurceId(resurceId);
	eEducationDataRepos.save(educationData);

	return "ok";
    }

    public String deleteEducation() {

	if (eEducationData != null) {

	    eEducationDataRepos.delete(eEducationData);
	}

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
     * @return the idToDelete
     */
    public Integer getIdToDelete() {
	return idToDelete;
    }

    public void setIdToDelete(Integer idToDelete) {
	this.idToDelete = idToDelete;

	if (idToDelete != null) {

	    eEducationData = eEducationDataRepos.findOne(idToDelete);

	}

    }

    public EEducationData geteEducationData() {
        return eEducationData;
    }

    public void seteEducationData(EEducationData eEducationData) {
        this.eEducationData = eEducationData;
    }

    public EEducationDataRepos geteEducationDataRepos() {
        return eEducationDataRepos;
    }

    public void seteEducationDataRepos(EEducationDataRepos eEducationDataRepos) {
        this.eEducationDataRepos = eEducationDataRepos;
    }

}
