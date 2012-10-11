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

import com.wadia.beans.EGeneralData;
import com.wadia.beans.ELData;
import com.wadia.metier.AffectationMetier;
import com.wadia.metier.LeavesMetier;
import com.wadia.metier.myTeamMetier;

/**
 *
 * @author toshiba
 */
@ManagedBean (name="LeaveListManagerCtl")
@RequestScoped
public class LeaveListManagerCtl {
    
   private userController user = new userController();
   private List<ELData> teamLeaves = new ArrayList<ELData>();
   private List<ShowTask> showTask = new ArrayList<ShowTask>();
  
   @ManagedProperty(value="#{affectationMetier}")
   private AffectationMetier affectationMetier;
  
   @ManagedProperty(value="#{leavesMetier}")
   private LeavesMetier leavesMetier;
   
   private List<EGeneralData> team = new ArrayList<EGeneralData>();
   private int tasks = 0;
   private List<ELData> taskList = new ArrayList<ELData>();
  
   @PostConstruct
   public void init(){
   
       team = affectationMetier.getbyManager(user.getUsername());
       int i = 1;
       for(EGeneralData usern : team){
    	   List<ELData> list = new ArrayList<ELData>();
    	   list = leavesMetier.findTask(usern.getResurceId());
    	   if(list.size()!=0){
    		   
    		   ShowTask task = new ShowTask();
    		   task.setUsername(usern.getName()+" "+usern.getSurname());
    		   task.setIdtask(""+i);
    		   task.setNumber(""+list.size());
    		   showTask.add(task);
    		   i++;
    		   
    	   }
       }
      
               
   }

    public List<ELData> getTeamLeaves() {
        return teamLeaves;
    }

    public void setTeamLeaves(List<ELData> teamLeaves) {
        this.teamLeaves = teamLeaves;
    }

    public List<EGeneralData> getTeam() {
        return team;
    }

    public void setTeam(List<EGeneralData> team) {
        this.team = team;
    }

    public userController getUser() {
        return user;
    }

    public void setUser(userController user) {
        this.user = user;
    }

    public AffectationMetier getAffectationMetier() {
        return affectationMetier;
    }

    public void setAffectationMetier(AffectationMetier affectationMetier) {
        this.affectationMetier = affectationMetier;
    }

	public LeavesMetier getLeavesMetier() {
		return leavesMetier;
	}

	public void setLeavesMetier(LeavesMetier leavesMetier) {
		this.leavesMetier = leavesMetier;
	}

	public int getTasks() {
		return tasks;
	}

	public void setTasks(int tasks) {
		this.tasks = tasks;
	}

	public List<ELData> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<ELData> taskList) {
		this.taskList = taskList;
	}
    
	public class ShowTask{
		
		private String idtask;
		private String number;
		private String username;
		public String getIdtask() {
			return idtask;
		}
		public void setIdtask(String idtask) {
			this.idtask = idtask;
		}
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
		
		
	}

	public List<ShowTask> getShowTask() {
		return showTask;
	}

	public void setShowTask(List<ShowTask> showTask) {
		this.showTask = showTask;
	}




}







