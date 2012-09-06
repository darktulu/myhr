/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.Child;
import com.wadia.beans.ESpouse;
import com.wadia.metier.ChildMetier;
import com.wadia.metier.SpouseListMetier;
import com.wadia.repos.ChildRepos;
import com.wadia.repos.ESpouseRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean(name="ESpouseCtl")
@RequestScoped
public class ESpouseCtl implements Serializable {

    @ManagedProperty(value = "#{childRepos}")
    private ChildRepos childRepos;
    @ManagedProperty(value = "#{eSpouseRepos}")
    private ESpouseRepos eSpouseRepos;
    @ManagedProperty(value = "#{spouseListMetier}")
    private SpouseListMetier spouseListMetier;
    @ManagedProperty(value = "#{childMetier}")
    private ChildMetier childMetier;
    
    private String spouseId;
    private String resurceId;
    private String spouseName;
    private String spouseSurname;
    private Date spouseBirthday;
    private String spouseStatus;
    private int nbSpouse;
    private int nbChildren;
    private String idSToEdit;
    private static ESpouse dataSp = new ESpouse();
    
    private userController usercontroller = new userController();
    private ESpouse eSpouseToEdit = new ESpouse();
    private List<ESpouse> eSpouseList = new ArrayList<ESpouse>();
    
    @PostConstruct
    public void init(){
	if (usercontroller.getUsername() != null) {
	    eSpouseList = spouseListMetier.findSpouseByUsername(usercontroller.getUsername());
	    nbSpouse = eSpouseList.size();
	    nbChildren = childMetier.countChilds(usercontroller.getUsername()).size();
	}

    }

    public boolean SpouseKO(ESpouse spouse) {

	List<ESpouse> list = new ArrayList<ESpouse>();
	boolean var = true;
	list = spouseListMetier.findSpouseByUsername(usercontroller.getUsername());
	for (ESpouse sp : list) {

	    if (sp.getSpouseId().equals(spouse.getSpouseId())) {
		var = false;
	    }

	}
	return var;
    }

    public void update() {

	if (usercontroller.getUsername() != null) {
	    eSpouseList = spouseListMetier.findSpouseByUsername(usercontroller.getUsername());
	    nbSpouse = eSpouseList.size();
	    nbChildren = childMetier.countChilds(usercontroller.getUsername()).size();
	}

    }

    public String save() {
	String ID;
	char firstLetter = spouseName.charAt(0);
	ID = firstLetter + "." + spouseSurname;
	ESpouse eSpouse = new ESpouse(ID, usercontroller.getUsername(), spouseName + " " + spouseSurname,
		spouseBirthday, spouseStatus, "waiting");
	int i = 1;

	while (!SpouseKO(eSpouse)) {
	    System.out.println("here in while");
	    firstLetter = spouseName.charAt(i);
	    ID = firstLetter + "." + spouseSurname;
	    System.out.println("ID " + ID);
	    eSpouse.setSpouseId(ID);
	    i++;
	}

	eSpouseRepos.save(eSpouse);
	return "acceuil?faces-redirect=true";

    }

    public String delete() {
	if (dataSp != null) {

	    List<Child> listChild = new ArrayList<Child>();

	    listChild = childRepos.findAll();
	    for (Child child : listChild) {

		if (child.getSpouseId().equals(dataSp.getSpouseId())) {
		    childRepos.delete(child);
		}
	    }
	    eSpouseRepos.delete(dataSp);
	}

	return "acceuil?faces-redirect=true";
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
     * @return the eSpouseToEdit
     */
    public ESpouse geteSpouseToEdit() {
	eSpouseToEdit = eSpouseRepos.findOne(spouseId);
	return eSpouseToEdit;
    }

    /**
     * @param eSpouseToEdit
     *            the eSpouseToEdit to set
     */
    public void seteSpouseToEdit(ESpouse eSpouseToEdit) {
	this.eSpouseToEdit = eSpouseToEdit;
    }

    /**
     * @return the eSpouseList
     */
    public List<ESpouse> geteSpouseList() {
	return eSpouseList;
    }

    /**
     * @param eSpouseList
     *            the eSpouseList to set
     */
    public void seteSpouseList(List<ESpouse> eSpouseList) {
	this.eSpouseList = eSpouseList;
    }

    public List<Child> findChildBySpouseID(String SpouseID) {

	List<Child> children, childrenToReturn = new ArrayList<Child>();
	children = childRepos.findAll();

	for (int i = 0; i < children.size(); i++) {

	    if (children.get(i).getSpouseId().equals(SpouseID)) {
		childrenToReturn.add(children.get(i));
	    }
	}

	return childrenToReturn;

    }

    public int getNbSpouse() {
	return nbSpouse;
    }

    public void setNbSpouse(int nbSpouse) {
	this.nbSpouse = nbSpouse;
    }

    public int getNbChildren() {
	return nbChildren;
    }

    public void setNbChildren(int nbChildren) {
	this.nbChildren = nbChildren;
    }

    public String getIdSToEdit() {
	return idSToEdit;
    }

    public void setIdSToEdit(String idSToEdit) {
	this.idSToEdit = idSToEdit;
	if (idSToEdit != null) {
	    dataSp = eSpouseRepos.findOne(idSToEdit);

	}
    }

    public ESpouse getDataSp() {
	return dataSp;
    }

    public void setDataSp(ESpouse dataSp) {
	this.dataSp = dataSp;
    }
    
    public ChildRepos getChildRepos() {
        return childRepos;
    }

    public void setChildRepos(ChildRepos childRepos) {
        this.childRepos = childRepos;
    }


    public ESpouseRepos geteSpouseRepos() {
        return eSpouseRepos;
    }

    public void seteSpouseRepos(ESpouseRepos eSpouseRepos) {
        this.eSpouseRepos = eSpouseRepos;
    }

    public SpouseListMetier getSpouseListMetier() {
        return spouseListMetier;
    }

    public void setSpouseListMetier(SpouseListMetier spouseListMetier) {
        this.spouseListMetier = spouseListMetier;
    }

    public ChildMetier getChildMetier() {
        return childMetier;
    }

    public void setChildMetier(ChildMetier childMetier) {
        this.childMetier = childMetier;
    }

    public userController getUsercontroller() {
        return usercontroller;
    }

    public void setUsercontroller(userController usercontroller) {
        this.usercontroller = usercontroller;
    }
}
