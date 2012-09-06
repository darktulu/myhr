/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.richfaces.component.SortOrder;

/**
 *
 * @author toshiba
 */
@ManagedBean
@RequestScoped
public class trierCtl {


    private SortOrder sortOrder = SortOrder.unsorted;
    public trierCtl () {
    }
    
    public void sort(){
        if(sortOrder.equals(SortOrder.ascending)){
            setSortOrder(sortOrder.descending);
        }
        else
        {
            setSortOrder(sortOrder.ascending);
        }
    }

    public SortOrder getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }
    


    
}
