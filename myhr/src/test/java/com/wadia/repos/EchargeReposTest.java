package com.wadia.repos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wadia.beans.EGeneralData;
import com.wadia.beans.EIndemnite;
import com.wadia.beans.EPrime;
import com.wadia.beans.ESalaryData;
import com.wadia.beans.Echarge;
import com.wadia.fileUpload.PDFToImage;
import com.wadia.fileUpload.PaySlipGenerator;
import com.wadia.local.Recipients;
import com.wadia.metier.MailForm;
import com.wadia.service.EchargeElementService;
import com.wadia.service.EprimeElementService;
import com.wadia.service.IndemElementService;
import com.wadia.service.SalaryElementService;
import com.wadia.service.SalaryPerDateService;
import com.wadia.service.impl.MyReportClendarService;
import com.wadia.view.PaySlipCtl;
import com.wadia.view.userController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:META-INF/spring/applicationContext-data.xml",
	"classpath:META-INF/spring/applicationContext-security.xml",
	"classpath:META-INF/spring/applicationContext.xml" })
public class EchargeReposTest {

	@Inject
	private MyReportClendarService myReportClendarService;
    
   
    @Test
    public void test() throws Exception {
    	Calendar calendar = new GregorianCalendar();
        calendar.set(2012, 4, 23);
        Date date = calendar.getTime();

		System.out.println("may "+Calendar.MAY);  
    	//System.out.println("here is the value : "+myReportClendarService.isAbsence("m.rahali", date));
	
    }

}
