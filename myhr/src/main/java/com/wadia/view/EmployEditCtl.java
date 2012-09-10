/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.EGeneralData;
import com.wadia.repos.EGeneralDataRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean (name="EmployEditCtl")
@RequestScoped
public class EmployEditCtl {

    private String name;
    private String surname;
    private Date birthday;
    private String martialStatus;
    private String gender;
    private String homeAdress;
    private String businessPhoneNumber;
    private String businessFax;
    private String contactInformation;
    private String emergencyContact;
    private String skypeId;
    private String imId;
    private String bankName;
    private String bankAccount;
    private String Status;
    private String email;
    private String passportid;
    private Date passportEpireDate;
    private String driveLiecenceId;
    private String driveLicencetype;
    private String pecName;
    private String pecNumber;
    private String secName;
    private String secNumber;
    private String PMobile;
    private String SMobile;
    private String hmePhoneNumber;
    private String username;
    private String CIN;
    private String CIMR;
    private String CNSS;
    private String idphoto;
    private String matricule;
    private String matricule_inssurance;
    private String secondaryMailAdress;
    private String toEdit;
    private static EGeneralData eGeneralData;
    @ManagedProperty(value = "#{eGeneralDataRepos}")
    private EGeneralDataRepos eGeneralDataRepos;

    public EGeneralDataRepos geteGeneralDataRepos() {
	return eGeneralDataRepos;
    }

    public void seteGeneralDataRepos(EGeneralDataRepos eGeneralDataRepos) {
	this.eGeneralDataRepos = eGeneralDataRepos;
    }

    /**
     * @return the firstename
     */
    public EmployEditCtl() {
    }

    /**
     * @return the eGeneralData
     */
    public EGeneralData geteGeneralData() {
	return eGeneralData;
    }

    /**
     * @param eGeneralData
     *            the eGeneralData to set
     */
    public void seteGeneralData(EGeneralData eGeneralData) {
	this.eGeneralData = eGeneralData;
    }

    public String save() {

	eGeneralData.setName(name);
	eGeneralData.setSurname(surname);
	eGeneralData.setHomeAdress(homeAdress);
	eGeneralData.setSkypeId(skypeId);
	eGeneralData.setBirthday(birthday);
	eGeneralData.setMartialStatus(martialStatus);
	eGeneralData.setGender(gender);
	eGeneralData.setBusinessPhoneNumber(businessPhoneNumber);
	eGeneralData.setBusinessFax(businessFax);
	eGeneralData.setContactInformation(contactInformation);
	eGeneralData.setEmergencyContact(emergencyContact);
	eGeneralData.setImId(imId);
	eGeneralData.setEmail(email);
	eGeneralData.setPassportid(passportid);
	eGeneralData.setPassportEpireDate(passportEpireDate);
	eGeneralData.setDriveLiecenceId(driveLiecenceId);
	eGeneralData.setDriveLicencetype(driveLicencetype);
	eGeneralData.setPecName(pecName);
	eGeneralData.setPecNumber(pecNumber);
	eGeneralData.setSecName(secName);
	eGeneralData.setSecNumber(secNumber);
	eGeneralData.setPMobile(PMobile);
	eGeneralData.setSMobile(SMobile);
	eGeneralData.setHmePhoneNumber(hmePhoneNumber);
	eGeneralData.setStatus(Status);
	eGeneralData.setCin(CIN);
	eGeneralData.setCimr(CIMR);
	eGeneralData.setCnss(CNSS);
	eGeneralData.setBankName(bankName);
	eGeneralData.setBankAccount(bankAccount);
	eGeneralData.setMatricule(matricule);
	eGeneralData.setMatriculeInssurance(matricule_inssurance);
	eGeneralData.setSecondaryMailAdresse(secondaryMailAdress);

	eGeneralDataRepos.save(eGeneralData);
	return "ok";
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
	return surname;
    }

    /**
     * @param surname
     *            the surname to set
     */
    public void setSurname(String surname) {
	this.surname = surname;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
	return birthday;
    }

    /**
     * @param birthday
     *            the birthday to set
     */
    public void setBirthday(Date birthday) {
	this.birthday = birthday;
    }

    /**
     * @return the martialStatus
     */
    public String getMartialStatus() {
	return martialStatus;
    }

    /**
     * @param martialStatus
     *            the martialStatus to set
     */
    public void setMartialStatus(String martialStatus) {
	this.martialStatus = martialStatus;
    }

    /**
     * @return the gender
     */
    public String getGender() {
	return gender;
    }

    /**
     * @param gender
     *            the gender to set
     */
    public void setGender(String gender) {
	this.gender = gender;
    }

    /**
     * @return the homeAdress
     */
    public String getHomeAdress() {
	return homeAdress;
    }

    /**
     * @param homeAdress
     *            the homeAdress to set
     */
    public void setHomeAdress(String homeAdress) {
	this.homeAdress = homeAdress;
    }

    /**
     * @return the businessPhoneNumber
     */
    public String getBusinessPhoneNumber() {
	return businessPhoneNumber;
    }

    /**
     * @param businessPhoneNumber
     *            the businessPhoneNumber to set
     */
    public void setBusinessPhoneNumber(String businessPhoneNumber) {
	this.businessPhoneNumber = businessPhoneNumber;
    }

    /**
     * @return the businessFax
     */
    public String getBusinessFax() {
	return businessFax;
    }

    /**
     * @param businessFax
     *            the businessFax to set
     */
    public void setBusinessFax(String businessFax) {
	this.businessFax = businessFax;
    }

    /**
     * @return the contactInformation
     */
    public String getContactInformation() {
	return contactInformation;
    }

    /**
     * @param contactInformation
     *            the contactInformation to set
     */
    public void setContactInformation(String contactInformation) {
	this.contactInformation = contactInformation;
    }

    /**
     * @return the emergencyContact
     */
    public String getEmergencyContact() {
	return emergencyContact;
    }

    /**
     * @param emergencyContact
     *            the emergencyContact to set
     */
    public void setEmergencyContact(String emergencyContact) {
	this.emergencyContact = emergencyContact;
    }

    /**
     * @return the skypeId
     */
    public String getSkypeId() {
	return skypeId;
    }

    /**
     * @param skypeId
     *            the skypeId to set
     */
    public void setSkypeId(String skypeId) {
	this.skypeId = skypeId;
    }

    /**
     * @return the imId
     */
    public String getImId() {
	return imId;
    }

    /**
     * @param imId
     *            the imId to set
     */
    public void setImId(String imId) {
	this.imId = imId;
    }

    /**
     * @return the bankName
     */
    public String getBankName() {
	return bankName;
    }

    /**
     * @param bankName
     *            the bankName to set
     */
    public void setBankName(String bankName) {
	this.bankName = bankName;
    }

    /**
     * @return the bankAccount
     */
    public String getBankAccount() {
	return bankAccount;
    }

    /**
     * @param bankAccount
     *            the bankAccount to set
     */
    public void setBankAccount(String bankAccount) {
	this.bankAccount = bankAccount;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPassportid() {
	return passportid;
    }

    public void setPassportid(String passportid) {
	this.passportid = passportid;
    }

    public Date getPassportEpireDate() {
	return passportEpireDate;
    }

    public void setPassportEpireDate(Date passportEpireDate) {
	this.passportEpireDate = passportEpireDate;
    }

    public String getDriveLiecenceId() {
	return driveLiecenceId;
    }

    public void setDriveLiecenceId(String driveLiecenceId) {
	this.driveLiecenceId = driveLiecenceId;
    }

    public String getDriveLicencetype() {
	return driveLicencetype;
    }

    public void setDriveLicencetype(String driveLicencetype) {
	this.driveLicencetype = driveLicencetype;
    }

    public String getPecName() {
	return pecName;
    }

    public void setPecName(String pecName) {
	this.pecName = pecName;
    }

    public String getPecNumber() {
	return pecNumber;
    }

    public void setPecNumber(String pecNumber) {
	this.pecNumber = pecNumber;
    }

    public String getSecName() {
	return secName;
    }

    public void setSecName(String secName) {
	this.secName = secName;
    }

    public String getSecNumber() {
	return secNumber;
    }

    public void setSecNumber(String secNumber) {
	this.secNumber = secNumber;
    }

    public String getPMobile() {
	return PMobile;
    }

    public void setPMobile(String PMobile) {
	this.PMobile = PMobile;
    }

    public String getSMobile() {
	return SMobile;
    }

    public void setSMobile(String SMobile) {
	this.SMobile = SMobile;
    }

    public String getHmePhoneNumber() {
	return hmePhoneNumber;
    }

    public void setHmePhoneNumber(String hmePhoneNumber) {
	this.hmePhoneNumber = hmePhoneNumber;
    }

    public String getToEdit() {
	return toEdit;
    }

    public void setToEdit(String toEdit) {
	this.toEdit = toEdit;

	if (toEdit != null) {

	    eGeneralData = eGeneralDataRepos.findOne(toEdit);
	    name = eGeneralData.getName();
	    surname = eGeneralData.getSurname();
	    homeAdress = eGeneralData.getHomeAdress();
	    skypeId = eGeneralData.getSkypeId();
	    birthday = eGeneralData.getBirthday();
	    martialStatus = eGeneralData.getMartialStatus();
	    gender = eGeneralData.getGender();
	    businessPhoneNumber = eGeneralData.getBusinessPhoneNumber();
	    businessFax = eGeneralData.getBusinessFax();
	    contactInformation = eGeneralData.getContactInformation();
	    emergencyContact = eGeneralData.getEmergencyContact();
	    imId = eGeneralData.getImId();
	    bankName = eGeneralData.getBankName();
	    bankAccount = eGeneralData.getBankAccount();
	    email = eGeneralData.getEmail();
	    passportid = eGeneralData.getPassportid();
	    passportEpireDate = eGeneralData.getPassportEpireDate();
	    driveLiecenceId = eGeneralData.getDriveLiecenceId();
	    driveLicencetype = eGeneralData.getDriveLicencetype();
	    pecName = eGeneralData.getPecName();
	    pecNumber = eGeneralData.getPecNumber();
	    secName = eGeneralData.getSecName();
	    secNumber = eGeneralData.getSecNumber();
	    PMobile = eGeneralData.getPMobile();
	    SMobile = eGeneralData.getSMobile();
	    hmePhoneNumber = eGeneralData.getHmePhoneNumber();
	    Status = eGeneralData.getStatus();
	    username = eGeneralData.getResurceId();
	    CIMR = eGeneralData.getCimr();
	    CIN = eGeneralData.getCin();
	    CNSS = eGeneralData.getCnss();
	    idphoto = eGeneralData.getIdPhoto();
	    matricule = eGeneralData.getMatricule();
	    matricule_inssurance = eGeneralData.getMatriculeInssurance();
	    secondaryMailAdress = eGeneralData.getSecondaryMailAdresse();

	}

    }

    public String getStatus() {
	return Status;
    }

    public void setStatus(String Status) {
	this.Status = Status;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getCIN() {
	return CIN;
    }

    public void setCIN(String CIN) {
	this.CIN = CIN;
    }

    public String getCIMR() {
	return CIMR;
    }

    public void setCIMR(String CIMR) {
	this.CIMR = CIMR;
    }

    public String getCNSS() {
	return CNSS;
    }

    public void setCNSS(String CNSS) {
	this.CNSS = CNSS;
    }

    public String getIdphoto() {
	return idphoto;
    }

    public void setIdphoto(String idphoto) {
	this.idphoto = idphoto;
    }

    public String getMatricule() {
	return matricule;
    }

    public void setMatricule(String matricule) {
	this.matricule = matricule;
    }

    public String getMatricule_inssurance() {
	return matricule_inssurance;
    }

    public void setMatricule_inssurance(String matricule_inssurance) {
	this.matricule_inssurance = matricule_inssurance;
    }

    public String getSecondaryMailAdress() {
	return secondaryMailAdress;
    }

    public void setSecondaryMailAdress(String secondaryMailAdress) {
	this.secondaryMailAdress = secondaryMailAdress;
    }
}
