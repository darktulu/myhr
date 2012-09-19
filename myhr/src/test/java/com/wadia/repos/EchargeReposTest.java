package com.wadia.repos;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wadia.beans.EGeneralData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:META-INF/spring/applicationContext-data.xml",
	"classpath:META-INF/spring/applicationContext-security.xml",
	"classpath:META-INF/spring/applicationContext.xml" })
public class EchargeReposTest {

    @Inject
    private EGeneralDataRepos eGeneralDataRepos;
    @Inject
    private ESalaryDataRepos eSalaryDataRepos;
    @Test
    public void test() {
	for(EGeneralData empl : eGeneralDataRepos.findAll()){
		System.out.println(empl.getResurceId());
		System.out.println(eSalaryDataRepos.findLastSalary(empl.getResurceId()));
		
	}
    }

}
