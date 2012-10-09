package com.wadia.local;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateProvider {

	public String getCurrentMonth() {
		String Month = null;
		Calendar cal = new GregorianCalendar();
		int mois = cal.get(Calendar.MONTH) + 1;
		

		switch (mois) {

		case 1:
			Month = "Janvier"; break;
		case 2:
			Month = "Février";  break;
		case 3:
			Month = "Mars";  break;
		case 4:
			Month = "Avrile";  break;
		case 5:
			Month = "Mai";  break;
		case 6:
			Month = "Juin";  break;
		case 7:
			Month = "Juiller";  break;
		case 8:
			Month = "Août";  break;
		case 9:
			Month = "Septembre";  break;
		case 10:
			Month = "Octobre";  break;
		case 11:
			Month = "Novembre";  break;
		case 12:
			Month = "Décembre";  break;

		}
		
		return Month;

	}
	
	public String convert(int mois) {
		String Month = null;

		switch (mois) {

		case 1:
			Month = "Janvier";  break;
		case 2:
			Month = "Février";  break;
		case 3:
			Month = "Mars";  break;
		case 4:
			Month = "Avrile";  break;
		case 5:
			Month = "Mai";  break;
		case 6:
			Month = "Juin";  break;
		case 7:
			Month = "Juiller";  break;
		case 8:
			Month = "Août";  break;
		case 9:
			Month = "Septembre";  break;
		case 10:
			Month = "Octobre";  break;
		case 11:
			Month = "Novembre";  break;
		case 12:
			Month = "Décembre";  break;

		}
		
		return Month;

	}
	
	
	public MonthYear getNubLastMonth(int numb){
		
		MonthYear monthYear = new MonthYear();
		Calendar cal = new GregorianCalendar();
		int mois = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		int last = mois-numb;
		
		if(last==0){
			
			monthYear.setMonth(12);
			monthYear.setYear(year-1);
		}else{
			
			monthYear.setMonth(last);
			monthYear.setYear(year);
			
		}
		
		return monthYear;
		
	}
	
	
	public String getLastMonth() {
		String Month = null;
		Calendar cal = new GregorianCalendar();
		int mois = cal.get(Calendar.MONTH) + 1;
		int Last = mois - 1;
		
		if(Last==0){ Last = 12;}

		switch (Last) {

		case 1:
			Month = "Janvier"; break;
		case 2:
			Month = "Février";  break;
		case 3:
			Month = "Mars";  break;
		case 4:
			Month = "Avrile";  break;
		case 5:
			Month = "Mai";  break;
		case 6:
			Month = "Juin";  break;
		case 7:
			Month = "Juiller";  break;
		case 8:
			Month = "Août";  break;
		case 9:
			Month = "Septembre";  break;
		case 10:
			Month = "Octobre";  break;
		case 11:
			Month = "Novembre";  break;
		case 12:
			Month = "Décembre";  break;

		}
		
		return Month;

	}
	

}
