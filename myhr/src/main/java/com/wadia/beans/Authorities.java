package com.wadia.beans;
// Generated 30 ao�t 2012 18:58:08 by Hibernate Tools 3.2.1.GA

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Authorities generated by hbm2java
 */
@Entity
@Table(name = "authorities")
public class Authorities implements java.io.Serializable {

    private AuthoritiesId id;
    private Users users;

    public Authorities() {
    }

    public Authorities(AuthoritiesId id, Users users) {
        this.id = id;
        this.users = users;
    }

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "authority", column =
        @Column(name = "authority", nullable = false, length = 40)),
        @AttributeOverride(name = "username", column =
        @Column(name = "username", nullable = false, length = 45))})
    public AuthoritiesId getId() {
        return this.id;
    }

    public void setId(AuthoritiesId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", nullable = false, insertable = false, updatable = false)
    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}