package com.wadia.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.wadia.local.Directory;


@ManagedBean(name="DirecSelectedEmp")
@RequestScoped
public class DirecSelectedEmp {
	
	private static Directory selectedEmploy = new Directory();
    
	public DirecSelectedEmp(){
	System.out.println("Cled now");	
	}
	
	public Directory getSelectedEmploy() {
		return selectedEmploy;
	}

	public void setSelectedEmploy(Directory selectedEmploy) {
		this.selectedEmploy = selectedEmploy;
	}

}
