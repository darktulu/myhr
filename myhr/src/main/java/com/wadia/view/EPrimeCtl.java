/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.EPrime;
import com.wadia.repos.EPrimeRepos;

/**
 *
 * @author toshiba
 */
@ManagedBean
@RequestScoped
public class EPrimeCtl {
    @ManagedProperty(value="#{ePrimeRepos}")
    private EPrimeRepos ePrimeRepos;
    
    public EPrimeRepos getePrimeRepos() {
        return ePrimeRepos;
    }

    public void setePrimeRepos(EPrimeRepos ePrimeRepos) {
        this.ePrimeRepos = ePrimeRepos;
    }

    private Integer idPrime;
    private String resourceId;
    private String nom;
    private float montant;
    private int mois;
    private int ans;
    private String type;
    private String commentaire;
    private userController user = new userController();

    public String save() {

        EPrime eprime = new EPrime(user.getUsername(), nom, montant, type, commentaire, mois, ans);
        
        if(eprime!=null)
          {
            ePrimeRepos.save(eprime);
          }
     
     return "ok";
    }

    public Integer getIdPrime() {
        return idPrime;
    }

    public void setIdPrime(Integer idPrime) {
        this.idPrime = idPrime;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
