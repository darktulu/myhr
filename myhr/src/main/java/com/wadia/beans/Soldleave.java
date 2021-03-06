package com.wadia.beans;
// Generated 30 ao�t 2012 18:58:08 by Hibernate Tools 3.2.1.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Soldleave generated by hbm2java
 */
@Entity
@Table(name = "soldleave")
public class Soldleave implements java.io.Serializable {

    private Integer id;
    private String resourceId;
    private Integer year;
    private Integer sold;
    private Integer consumed;
    private Integer planned;

    public Soldleave() {
    }

    public Soldleave(String resourceId) {
        this.resourceId = resourceId;
    }

    public Soldleave(String resourceId, Integer year, Integer sold, Integer consumed, Integer planned) {
        this.resourceId = resourceId;
        this.year = year;
        this.sold = sold;
        this.consumed = consumed;
        this.planned = planned;
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

    @Column(name = "resourceID", nullable = false, length = 500)
    public String getResourceId() {
        return this.resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @Column(name = "year")
    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Column(name = "sold")
    public Integer getSold() {
        return this.sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    @Column(name = "consumed")
    public Integer getConsumed() {
        return this.consumed;
    }

    public void setConsumed(Integer consumed) {
        this.consumed = consumed;
    }

    @Column(name = "planned")
    public Integer getPlanned() {
        return this.planned;
    }

    public void setPlanned(Integer planned) {
        this.planned = planned;
    }
}
