/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.util.StopWatch;

import com.wadia.local.Directory;
import com.wadia.metier.DirectoryMetier;

/**
 *
 * @author toshiba
 */
@ManagedBean(name="DirectoryListCtl")
@ViewScoped
public class DirectoryListCtl implements Serializable {

    private List<Directory> listDirect = new ArrayList<Directory>();
    private Directory selectedEmploy = new Directory();
    private String search;
    
    
    private DirectoryMetier directoryMetier() {
        return SpringJSFUtil.getBean("directoryMetier");
    }
    

    @PostConstruct
    public void init(){
        StopWatch stopWatch= new StopWatch();
        stopWatch.start();
        listDirect = directoryMetier().findAll();
        stopWatch.stop();
        System.out.println("Exec in "+stopWatch.getTotalTimeMillis());

    }

    
    public List<Directory> getListDirect() {
    	// listDirect = directoryMetier().findAll();
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

            listDirect = directoryMetier().findAll();
            List<Directory> toreturn = new ArrayList<Directory>();

            for (Directory direct : listDirect) {

                if (direct.getLastname().toLowerCase().contains(search.toLowerCase())
                        || direct.getFirstname().toLowerCase().contains(search.toLowerCase())
                        || direct.getEmail().toLowerCase().contains(search.toLowerCase())
                        || direct.getRessourceId().toLowerCase().contains(search.toLowerCase())) {

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

}
