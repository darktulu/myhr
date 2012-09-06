/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.wadia.metier.OrgFillMetier;
import com.wadia.metier.OrganizationaMetier;

/**
 *
 * @author toshiba
 */
@ManagedBean
@RequestScoped
public class OrgDetailsCtl {

    private OrgFillMetier orgfill = new OrgFillMetier();
    private static OrganizationaMetier orgToview = new OrganizationaMetier();
    private String OrgToEdit;

    public OrgDetailsCtl() {

        System.out.println("Edit Ctl :" + orgToview.toString());


    }

    public String back() {

        return "back";

    }

    public String getOrgToEdit() {

        System.out.println("getter");
        return OrgToEdit;


    }

    public void setOrgToEdit(String OrgToEdit) {
        this.OrgToEdit = OrgToEdit;

        System.out.println("setter");
        if (OrgToEdit != null) {

            System.out.println("to edit : " + OrgToEdit);
            setOrgToview(orgfill.getByUsername(OrgToEdit));
            System.out.println("howa hada : " + getOrgToview().toString());

        }

    }

    public OrganizationaMetier getOrgToview() {
        return orgToview;
    }

    public void setOrgToview(OrganizationaMetier orgToview) {
        this.orgToview = orgToview;
    }
}
