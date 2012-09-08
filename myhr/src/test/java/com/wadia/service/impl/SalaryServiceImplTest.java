package com.wadia.service.impl;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StopWatch;

import com.wadia.beans.EGeneralData;
import com.wadia.metier.ChargeMetier;
import com.wadia.metier.ContrathrfillMetier;
import com.wadia.metier.SalaryListMetier;
import com.wadia.metier.SalaryMetier;
import com.wadia.repos.EContractDataRepos;
import com.wadia.repos.EGeneralDataRepos;
import com.wadia.repos.EIndemniteRepos;
import com.wadia.repos.ESalaryDataRepos;
import com.wadia.service.SalaryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/applicationContext-data.xml",
	"classpath:META-INF/spring/applicationContext-security.xml", "classpath:META-INF/spring/applicationContext.xml" })
public class SalaryServiceImplTest {

    @Inject
    private EGeneralDataRepos eGeneralDataRepos;
    @Inject
    private EContractDataRepos contractDataRepos;
    @Inject
    private ESalaryDataRepos eSalaryDataRepos;
    @Inject
    private EIndemniteRepos eIndemniteRepos;
    @Inject
    private SalaryMetier salaryMetier;
    @Inject
    private ChargeMetier chargeMetier;
    @Inject
    private SalaryListMetier salaryListMetier;
    @Inject
    private ContrathrfillMetier contrathrfillMetier;

    @Inject
    private SalaryService salaryService;
    
    //@Test
    public void test() {
	StopWatch stopWatch = new StopWatch();
	stopWatch.start();
	salaryService.listSalary();
	stopWatch.stop();
	System.out.println("method time : " + stopWatch.getTotalTimeMillis() + " ms");
    }
    
    @Test
    public void blaalala(){

	for(EGeneralData e :eGeneralDataRepos.findAll()){
	    System.out.println("************************* "+e.getResurceId()+" *********************");
	    System.out.println(contractDataRepos.findLastContract(e.getResurceId()));
	    System.out.println("**********************************************");
	}
    }

}
