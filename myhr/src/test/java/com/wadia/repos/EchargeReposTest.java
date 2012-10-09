package com.wadia.repos;

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
import com.wadia.service.EchargeElementService;
import com.wadia.service.EprimeElementService;
import com.wadia.service.IndemElementService;
import com.wadia.service.SalaryElementService;
import com.wadia.service.SalaryPerDateService;
import com.wadia.view.PaySlipCtl;
import com.wadia.view.userController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:META-INF/spring/applicationContext-data.xml",
	"classpath:META-INF/spring/applicationContext-security.xml",
	"classpath:META-INF/spring/applicationContext.xml" })
public class EchargeReposTest {

	@Inject
	private SalaryElementService salaryElementService;
    
   
    @Test
    public void test() throws Exception {
		  
    	 System.out.println("salary "+salaryElementService.findMargeSalary("m.bougri", 1, 2012).getAns());
	
    }

}
