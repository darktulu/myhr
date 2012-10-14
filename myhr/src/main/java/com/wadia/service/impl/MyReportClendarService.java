package com.wadia.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.Abscence;
import com.wadia.beans.ELData;
import com.wadia.repos.AbscenceRepos;
import com.wadia.repos.ELDataRepos;


@Service
@Transactional
public class MyReportClendarService  {
	
	@Inject
	private AbscenceRepos  abscenceRepos;
	@Inject
	private ELDataRepos  eLDataRepos;
	
	
	public boolean isJustifiedAbsence(String username, Date date){
		
		List<Abscence> list = new ArrayList<Abscence>();
		list = abscenceRepos.findByUsernameAndJustified(username,"YES");
		boolean var = false;
		
		for(Abscence abscence : list){
			
			
			//System.out.println("abs "+abscence.getJustified());
			int start = date.compareTo(abscence.getStartDay());
			int end = date.compareTo(abscence.getEndDay());
			if(start>=0 && end<=0){
				
				var = true;
				
			}
			
		}
		
		return var;
	}
	
	public boolean isNonJustifiedAbsence(String username, Date date){
		
		List<Abscence> list = new ArrayList<Abscence>();
		list = abscenceRepos.findByUsernameAndJustified(username,"NO");
		boolean var = false;
		
		for(Abscence abscence : list){
			
			
			
			int start = date.compareTo(abscence.getStartDay());
			int end = date.compareTo(abscence.getEndDay());
			if(start>=0 && end<=0){
				
				var = true;
				
			}
			
		}
		
		return var;
	}
	
  public boolean isPlanned(String username, Date date){
		
		List<ELData> list = new ArrayList<ELData>();
		list = eLDataRepos.findByUsername(username);
		boolean var = false;
		
		for(ELData leave : list){
		  if(leave.getStatus().equals("waiting") || leave.getStatus().equals("Approved By HR") || leave.getStatus().equals("Approved By PM"))	
			if((date.compareTo(leave.getLeaveStartDate())>=0) && ( date.compareTo(leave.getLeaveEndDate())<=0)){
				
				var = true;
				
			}
			
		}
		
		return var;
	  }
  

  
  public boolean isTaken(String username, Date date){
		
		List<ELData> list = new ArrayList<ELData>();
		list = eLDataRepos.findByUsername(username);
		boolean var = false;
		
		for(ELData leave : list){
		  if(leave.getStatus().equals("taken"))	
			if((date.compareTo(leave.getLeaveStartDate())>=0) && ( date.compareTo(leave.getLeaveEndDate())<=0)){
				
				var = true;
				
			}
			
		}
		
		return var;
	  }
  
  
  public int monthprovider(int month){
	
	  int numberDays = 0;
	  
	  switch (month) {

		case 0:
			numberDays = 31; break;
		case 1:
			numberDays = 29;  break;
		case 2:
			numberDays = 31;  break;
		case 3:
			numberDays = 30;  break;
		case 4:
			numberDays = 31;  break;
		case 5:
			numberDays = 30;  break;
		case 6:
			numberDays = 31;  break;
		case 7:
			numberDays = 31;  break;
		case 8:
			numberDays = 30;  break;
		case 9:
			numberDays = 31;  break;
		case 10:
			numberDays = 30;  break;
		case 11:
			numberDays = 31;  break;

		}
	  
	  
	  return numberDays;
  }
  
  public boolean isOngoing(String username) throws ParseException{
		
		List<ELData> list = new ArrayList<ELData>();
		list = eLDataRepos.findByUsername(username);
		
		    Calendar calendar = new GregorianCalendar();
	        //calendar.set(Year, Month, day);
	        calendar.getInstance();
	        
	        Date date = calendar.getTime();
	       
	        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	        String dateF = format.format(date);
	        Date date2 = format.parse(dateF);
		
		
		boolean var = false;
		
		for(ELData leave : list){
		  if(leave.getStatus().equals("waiting") || leave.getStatus().equals("Approved By HR") || leave.getStatus().equals("Approved By PM"))	
			if((date.compareTo(leave.getLeaveStartDate())>=0) && ( date.compareTo(leave.getLeaveEndDate())<=0)){
				
				var = true;
				
			}
			
		}
		
		return var;
	  }
	
	
	
}
