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

/**
 *
 * @author toshiba
 */
@ManagedBean
@RequestScoped
public class orgViewHr {
    @ManagedProperty("#{orgHrMetier}")
    private orgHrMetier orgHrMetier;
    private static organizational org = new organizational();
    private String idToEdit;

    public String getIdToEdit() {
        return idToEdit;
    }

    public void setIdToEdit(String idToEdit) {
        this.idToEdit = idToEdit;
        if (idToEdit != null) {

            org = orgHrMetier.getbyusername(idToEdit);
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
}
