/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.EIndemnite;
import com.wadia.repos.EIndemniteRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean
@RequestScoped
public class EIndemCtl {
    @ManagedProperty(value = "#{eIndemniteRepos}")
    private EIndemniteRepos eIndemniteRepos;

    public EIndemniteRepos geteIndemniteRepos() {
	return eIndemniteRepos;
    }

    public void seteIndemniteRepos(EIndemniteRepos eIndemniteRepos) {
	this.eIndemniteRepos = eIndemniteRepos;
    }

    private Integer idIndem;
    private String resureceId;
    private String nom;
    private String type;
    private float montant;
    private String commentaire;
    private int mois;
    private int ans;
    private userController user = new userController();

    public String save() {

	EIndemnite eindem = new EIndemnite(user.getUsername(), nom, type, montant, commentaire, mois, ans);

	if (eindem != null) {
	    eIndemniteRepos.save(eindem);
	}

	return "ok";
    }

    public Integer getIdIndem() {
	return idIndem;
    }

    public void setIdIndem(Integer idIndem) {
	this.idIndem = idIndem;
    }

    public String getResureceId() {
	return resureceId;
    }

    public void setResureceId(String resureceId) {
	this.resureceId = resureceId;
    }

    public String getNom() {
	return nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public float getMontant() {
	return montant;
    }

    public void setMontant(float montant) {
	this.montant = montant;
    }

    public String getCommentaire() {
	return commentaire;
    }

    public void setCommentaire(String commentaire) {
	this.commentaire = commentaire;
    }

    public int getMois() {
	return mois;
    }

    public void setMois(int mois) {
	this.mois = mois;
    }

    public int getAns() {
	return ans;
    }

    public void setAns(int ans) {
	this.ans = ans;
    }

}
