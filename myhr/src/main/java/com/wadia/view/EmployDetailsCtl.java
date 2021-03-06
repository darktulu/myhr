/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.io.File;
import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.EGeneralData;
import com.wadia.metier.PathProvider;
import com.wadia.repos.EGeneralDataRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean (name="EmployDetailsCtl")
@RequestScoped
public class EmployDetailsCtl {

    private String IdToView;
    private static EGeneralData eGeneralData = new EGeneralData();
    private PathProvider pathProvider = new PathProvider();
   
    @ManagedProperty(value = "#{eGeneralDataRepos}")
    private EGeneralDataRepos eGeneralDataRepos;


    public void resetImage() throws IOException {

	if (eGeneralData.getResurceId() != null) {

	    EGeneralData egd = new EGeneralData();
	    egd = eGeneralDataRepos.findOne(eGeneralData.getResurceId());
	    egd.setIdPhoto("photos/anonime.gif");
	    eGeneralDataRepos.save(egd);

	    String lien = pathProvider.path() + "photos/" + eGeneralData.getResurceId() + ".jpg";
	    File MyPhoto = new File(lien);
	    MyPhoto.delete();

	}

    }

    public String getIdToView() {
	return IdToView;
    }

    public void setIdToView(String IdToView) {
	this.IdToView = IdToView;

	if (IdToView != null) {
	    eGeneralData = eGeneralDataRepos.findOne(IdToView);
	    System.out.println("non : " + eGeneralData.getResurceId() + " " + eGeneralData.getName() + " "
		    + eGeneralData.getSurname());
	}

    }

    
    

    public EGeneralDataRepos geteGeneralDataRepos() {
	return eGeneralDataRepos;
    }

    public void seteGeneralDataRepos(EGeneralDataRepos eGeneralDataRepos) {
	this.eGeneralDataRepos = eGeneralDataRepos;
    }

	public EGeneralData geteGeneralData() {
		return eGeneralData;
	}

	public void seteGeneralData(EGeneralData eGeneralData) {
		this.eGeneralData = eGeneralData;
	}

	public PathProvider getPathProvider() {
		return pathProvider;
	}

	public void setPathProvider(PathProvider pathProvider) {
		this.pathProvider = pathProvider;
	}

}
