/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.local.Directory;
import com.wadia.metier.DirectoryMetier;

/**
 *
 * @author toshiba
 */
@ManagedBean(name="DirectoryListCtl")
@RequestScoped
public class DirectoryListCtl {

    private List<Directory> listDirect = new ArrayList<Directory>();
    @ManagedProperty(value="#{directoryMetier}")
    private DirectoryMetier directoryMetier;
    private Directory selectedEmploy;
    private String search;

    @PostConstruct
    public void init(){

        listDirect = directoryMetier.findAll();

    }

    public List<Directory> getListDirect() {
        return listDirect;
    }

    public void setListDirect(List<Directory> listDirect) {
        this.listDirect = listDirect;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
        if (search != null) {

            listDirect = directoryMetier.findAll();
            List<Directory> toreturn = new ArrayList<Directory>();

            for (Directory direct : listDirect) {

                if (direct.getLastname().toLowerCase().equals(search.toLowerCase())
                        || direct.getFirstname().toLowerCase().equals(search.toLowerCase())
                        || direct.getDeparment().toLowerCase().equals(search.toLowerCase())
                        || direct.getEmail().toLowerCase().equals(search.toLowerCase())
                        || direct.getJobTitle().toLowerCase().equals(search.toLowerCase())
                        || direct.getRessourceId().toLowerCase().equals(search.toLowerCase())) {

                    toreturn.add(direct);
                }
            }

            listDirect = toreturn;


        }
    }

    public Directory getSelectedEmploy() {
        return selectedEmploy;
    }

    public void setSelectedEmploy(Directory selectedEmploy) {
        this.selectedEmploy = selectedEmploy;
    }

    public DirectoryMetier getDirectoryMetier() {
        return directoryMetier;
    }

    public void setDirectoryMetier(DirectoryMetier directoryMetier) {
        this.directoryMetier = directoryMetier;
    }

}
