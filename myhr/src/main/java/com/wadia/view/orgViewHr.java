/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.local.organizational;
import com.wadia.metier.orgHrMetier;
import com.wadia.repos.EGeneralDataRepos;

/**
 *
 * @author toshiba
 */
@ManagedBean
@RequestScoped
public class orgViewHr {
    @ManagedProperty("#{orgHrMetier}")
    private orgHrMetier orgHrMetier;
    
    @ManagedProperty("#{eGeneralDataRepos}")
    private EGeneralDataRepos eGeneralDataRepos;
    private static String idphoto;
    private static organizational org = new organizational();
    private String idToEdit;

    public String getIdToEdit() {
        return idToEdit;
    }

    public void setIdToEdit(String idToEdit) {
        this.idToEdit = idToEdit;
        if (idToEdit != null) {

            org = orgHrMetier.getbyusername(idToEdit);
            idphoto = eGeneralDataRepos.findOne(idToEdit).getIdPhoto();
        }
    }

    public organizational getOrg() {
        return org;
    }

    public void setOrg(organizational org) {
        this.org = org;
    }

    public orgHrMetier getOrgHrMetier() {
        return orgHrMetier;
    }

    public void setOrgHrMetier(orgHrMetier orgHrMetier) {
        this.orgHrMetier = orgHrMetier;
    }

	public EGeneralDataRepos geteGeneralDataRepos() {
		return eGeneralDataRepos;
	}

	public void seteGeneralDataRepos(EGeneralDataRepos eGeneralDataRepos) {
		this.eGeneralDataRepos = eGeneralDataRepos;
	}

	public String getIdphoto() {
		return idphoto;
	}

	public void setIdphoto(String idphoto) {
		this.idphoto = idphoto;
	}
}
