package com.wadia.beans;
// Generated 30 ao�t 2012 18:58:08 by Hibernate Tools 3.2.1.GA

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Budgetdetail generated by hbm2java
 */
@Entity
@Table(name = "budgetdetail")
public class Budgetdetail implements java.io.Serializable {

    private Integer idbudgetdetail;
    private Budget budget;
    private String description;
    private String category;
    private Double quantity;
    private String unit;
    private Double unitCost;
    private Double totalCost;
    private Set<Expensepayment> expensepayments = new HashSet<Expensepayment>(0);

    public Budgetdetail() {
    }

    public Budgetdetail(Budget budget) {
        this.budget = budget;
    }

    public Budgetdetail(Budget budget, String description, String category, Double quantity, String unit, Double unitCost, Double totalCost, Set<Expensepayment> expensepayments) {
        this.budget = budget;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
        this.unit = unit;
        this.unitCost = unitCost;
        this.totalCost = totalCost;
        this.expensepayments = expensepayments;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idbudgetdetail", unique = true, nullable = false)
    public Integer getIdbudgetdetail() {
        return this.idbudgetdetail;
    }

    public void setIdbudgetdetail(Integer idbudgetdetail) {
        this.idbudgetdetail = idbudgetdetail;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "budget_idbudget", nullable = false)
    public Budget getBudget() {
        return this.budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    @Column(name = "description", length = 5000)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "category", length = 100)
    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Column(name = "quantity", precision = 22, scale = 0)
    public Double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Column(name = "unit", length = 45)
    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Column(name = "unitCost", precision = 22, scale = 0)
    public Double getUnitCost() {
        return this.unitCost;
    }

    public void setUnitCost(Double unitCost) {
        this.unitCost = unitCost;
    }

    @Column(name = "totalCost", precision = 22, scale = 0)
    public Double getTotalCost() {
        return this.totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "budgetdetail")
    public Set<Expensepayment> getExpensepayments() {
        return this.expensepayments;
    }

    public void setExpensepayments(Set<Expensepayment> expensepayments) {
        this.expensepayments = expensepayments;
    }
}
