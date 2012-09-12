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
			Month = "Janvier";
		case 2:
			Month = "Février";
		case 3:
			Month = "Mars";
		case 4:
			Month = "Avrile";
		case 5:
			Month = "Mai";
		case 6:
			Month = "Juin";
		case 7:
			Month = "Juiller";
		case 8:
			Month = "Août";
		case 9:
			Month = "Septembre";
		case 10:
			Month = "Octobre";
		case 11:
			Month = "Novembre";
		case 12:
			Month = "Décembre";

		}
		
		return Month;

	}

}
