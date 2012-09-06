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
import com.wadia.repos.ChildRepos;
import com.wadia.repos.ESpouseRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean(name = "ChildCtl")
@RequestScoped
public class ChildCtl implements Serializable{
   
    private static Child transcientChild;
    private String childId;
    private String spouseId;
    private Date childBirthday;
    private String childName;
    private String childSurname;
    private String status;
    private String childToEdit;
    private Child child;
    
    @ManagedProperty(value = "#{childRepos}")
    private ChildRepos childRepos;
    
    @ManagedProperty(value = "#{eSpouseRepos}")
    private ESpouseRepos eSpouseRepos;
    
    @ManagedProperty(value = "#{childMetier}")
    private ChildMetier childMetier;
    
    private userController user = new userController();
    private List<ESpouse> listSpouse = new ArrayList<ESpouse>();
    
    @PostConstruct
    public void init(){
	listSpouse = eSpouseRepos.findByResurceId(user.getUsername());
	
    }


    public List<ESpouse> getListSpouse() {
        return listSpouse;
    }

    public void setListSpouse(List<ESpouse> listSpouse) {
        this.listSpouse = listSpouse;
    }

    public boolean ChildKO(Child child) {

	List<Child> list = new ArrayList<Child>();
	boolean var = true;
	list = childMetier.countChilds(user.getUsername());
	for (Child ch : list) {

	    if (ch.getChildId().equals(child.getChildId())) {
		var = false;
	    }

	}
	return var;
    }

    public String save() {

	if (spouseId == null) {
	    return null;
	} else {

	    String ID;
	    char firstLetter = childName.charAt(0);
	    ID = firstLetter + "." + childSurname;
	    child = new Child(ID, spouseId, childBirthday, childName + " " + childSurname, status, "waiting");
	    int i = 1;

	    while (!ChildKO(child)) {
		System.out.println("here in while");
		firstLetter = childName.charAt(i);
		ID = firstLetter + "." + childSurname;
		System.out.println("ID " + ID);
		child.setChildId(ID);
		i++;
	    }

	    childRepos.save(child);

	}

	return "familyData?faces-redirect=true";
    }

    public String getChildId() {
	return childId;
    }

    public void setChildId(String childId) {
	this.childId = childId;
    }

    public String getSpouseId() {
	return spouseId;
    }

    public void setSpouseId(String spouseId) {
	this.spouseId = spouseId;
    }

    public Date getChildBirthday() {
	return childBirthday;
    }

    public void setChildBirthday(Date childBirthday) {
	this.childBirthday = childBirthday;
    }

    public String getChildName() {
	return childName;
    }

    public void setChildName(String childName) {
	this.childName = childName;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public Child getChild() {
	return child;
    }

    public void setChild(Child child) {
	this.child = child;
    }

    public String getChildSurname() {
	return childSurname;
    }

    public void setChildSurname(String childSurname) {
	this.childSurname = childSurname;
    }

    public String getChildToEdit() {
	return childToEdit;
    }

    public void setChildToEdit(String aChildToEdit) {
	childToEdit = aChildToEdit;
	if (childToEdit != null) {
	    transcientChild = childRepos.findOne(childToEdit);
	    childId = transcientChild.getChildId();
	    spouseId = transcientChild.getSpouseId();
	    childBirthday = transcientChild.getChildBirthday();
	    childName = transcientChild.getChildName();

	}
    }

    public String delete() {
	if (transcientChild.getChildId() != null) {
	    childRepos.delete(transcientChild);
	    System.out.println("i delete it !! ");

	}

	return "acceuil?faces-redirect=true";
    }

    public static Child getTranscientChild() {
	return transcientChild;
    }

    public static void setTranscientChild(Child aTranscientChild) {
	transcientChild = aTranscientChild;
    }

    public String toEdit() {

	return "editChild";
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


    public ChildMetier getChildMetier() {
        return childMetier;
    }

    public void setChildMetier(ChildMetier childMetier) {
        this.childMetier = childMetier;
    }

    public userController getUser() {
        return user;
    }

    public void setUser(userController user) {
        this.user = user;
    }
}
