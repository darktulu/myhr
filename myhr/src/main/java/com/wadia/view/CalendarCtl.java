package com.wadia.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="CalendarCtl")
@RequestScoped
public class CalendarCtl {
	
	private int month;
	private List<Integer> list = new ArrayList<Integer>();
	
	
	@PostConstruct
	public void init(){
	
    for(int i=1 ; i<=30 ; i++)	{
		list.add(i);
    }
	
	}
	
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public List<Integer> getList() {
		return list;
	}
	public void setList(List<Integer> list) {
		this.list = list;
	}
	
	

}
