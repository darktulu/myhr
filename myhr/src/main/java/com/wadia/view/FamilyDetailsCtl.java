/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.Child;
import com.wadia.beans.ESpouse;
import com.wadia.local.family;
import com.wadia.metier.ChildMetier;
import com.wadia.metier.SpouseListMetier;
import com.wadia.metier.famillyMetier;
import com.wadia.repos.ChildRepos;
import com.wadia.repos.ESpouseRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean (name="FamilyDetailsCtl")
@RequestScoped
public class FamilyDetailsCtl {

    @ManagedProperty(value = "#{childRepos}")
    private ChildRepos childRepos;
    @ManagedProperty(value = "#{eSpouseRepos}")
    private ESpouseRepos eSpouseRepos;
    @ManagedProperty(value = "#{famillyMetier}")
    private famillyMetier famillyMetier;
    @ManagedProperty(value = "#{childMetier}")
    private ChildMetier childMetier;
    @ManagedProperty(value = "#{spouseListMetier}")
    private SpouseListMetier spouseListMetier;

    private static family EmpFamily = new family();
    private static String toEdit;
    private static List<Child> listChildren = new ArrayList<Child>();
    private static List<ESpouse> spouseList = new ArrayList<ESpouse>();
   
 

    public void appSpouse(String id) {
	eSpouseRepos.setStatus("Approved", id);
    }

    public void DappSpouse(String id) {
	eSpouseRepos.setStatus("Disapproved", id);
    }

    public void appChild(String id) {

	childRepos.setStatus("Approved", id);
    }

    public void DappChild(String id) {
	childRepos.setStatus("Disapproved", id);
    }

    public void update() {

	EmpFamily = famillyMetier.getByUsername(toEdit);
	listChildren = childMetier.countChilds(toEdit);
	spouseList = spouseListMetier.findSpouseByUsername(toEdit);

    }

    public family getEmpFamily() {
	return EmpFamily;
    }

    public void setEmpFamily(family EmpFamily) {
	this.EmpFamily = EmpFamily;
    }

    public String getToEdit() {
	return toEdit;
    }

    public void setToEdit(String toEdit) {
	this.toEdit = toEdit;
	if (toEdit != null) {

	    EmpFamily = famillyMetier.getByUsername(toEdit);
	    listChildren = childMetier.countChilds(toEdit);
	    spouseList = spouseListMetier.findSpouseByUsername(toEdit);
	}
    }

    public List<Child> getListChildren() {
	return listChildren;
    }

    public void setListChildren(List<Child> listChildren) {
	this.listChildren = listChildren;
    }

    public List<ESpouse> getSpouseList() {
	return spouseList;
    }

    public void setSpouseList(List<ESpouse> spouseList) {
	this.spouseList = spouseList;
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

    public famillyMetier getFamillyMetier() {
        return famillyMetier;
    }

    public void setFamillyMetier(famillyMetier famillyMetier) {
        this.famillyMetier = famillyMetier;
    }

    public ChildMetier getChildMetier() {
        return childMetier;
    }

    public void setChildMetier(ChildMetier childMetier) {
        this.childMetier = childMetier;
    }

    public SpouseListMetier getSpouseListMetier() {
        return spouseListMetier;
    }

    public void setSpouseListMetier(SpouseListMetier spouseListMetier) {
        this.spouseListMetier = spouseListMetier;
    }
}
