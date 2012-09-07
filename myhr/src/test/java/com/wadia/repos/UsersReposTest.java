package com.wadia.repos;

import static org.junit.Assert.fail;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wadia.metier.EEducationDataMetier;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:META-INF/spring/applicationContext-data.xml",
	"classpath:META-INF/spring/applicationContext-security.xml",
	"classpath:META-INF/spring/applicationContext.xml" })
public class UsersReposTest {

    @Inject
    private EEducationDataMetier eEducationDataMetier;
    @Test
    public void test() {
	System.out.println(eEducationDataMetier.findByUsername("m.bougri").size());
    }

}
