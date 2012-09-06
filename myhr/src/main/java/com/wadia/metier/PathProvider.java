/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 * 
 * @author toshiba
 */
public class PathProvider implements Serializable {

    private static final long serialVersionUID = 1L;

    public String path() {

	ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

	return ctx.getRealPath("/");

	// return
	// "C:/Users/toshiba/Desktop/NetBeansProjects/springSecurity/web/";

    }

}
