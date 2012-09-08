package com.wadia.beans;
// Generated 30 ao�t 2012 18:58:08 by Hibernate Tools 3.2.1.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TypeAbsence generated by hbm2java
 */
@Entity
@Table(name = "type_absence")
public class TypeAbsence implements java.io.Serializable {

    private Integer id;
    private String name;
    private String payed;
    private Integer nombreDays;
    private String commantaire;

    public TypeAbsence() {
    }

    public TypeAbsence(String name, String payed, Integer nombreDays, String commantaire) {
        this.name = name;
        this.payed = payed;
        this.nombreDays = nombreDays;
        this.commantaire = commantaire;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", length = 500)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "payed", length = 50)
    public String getPayed() {
        return this.payed;
    }

    public void setPayed(String payed) {
        this.payed = payed;
    }

    @Column(name = "nombre_days")
    public Integer getNombreDays() {
        return this.nombreDays;
    }

    public void setNombreDays(Integer nombreDays) {
        this.nombreDays = nombreDays;
    }

    @Column(name = "commantaire", length = 500)
    public String getCommantaire() {
        return this.commantaire;
    }

    public void setCommantaire(String commantaire) {
        this.commantaire = commantaire;
    }
}