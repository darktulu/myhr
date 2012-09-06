/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.thread;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.wadia.beans.EGeneralData;

/**
 * 
 * @author toshiba
 */
public class BirthDayThread extends Thread {

    @Override
    public void run() {

	while (true) {

	    try {

		Thread.currentThread();

		Thread.sleep(100000);

	    } catch (InterruptedException e) {

		// TODO Auto-generated catch block

		e.printStackTrace();

	    }

	    Calendar calendar = new GregorianCalendar();
	    Date now = calendar.getTime();
	    System.out.println(" Lioma " + now);

	    EGeneralData data = new EGeneralData();

	    // data = eGeneralDataDao.findByBirthDay(now);

	    if (data != null) {

		System.out.println("Data : " + data);

	    } else {
		System.out.println("No One today");

	    }

	}

    }
}
