package com.wadia.repos;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wadia.metier.AffectationMetier;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:META-INF/spring/applicationContext-data.xml",
	"classpath:META-INF/spring/applicationContext-security.xml",
	"classpath:META-INF/spring/applicationContext.xml" })
public class AffectationReposTest {

    @Inject 
    private AffectationRepos affectationRepos;
    @Inject
    private AffectationMetier affectationMetier;
    
    @Test
    public void test() {
	
	System.out.println(affectationMetier.getbyusername("m.bougri").getLob().getName());
    }

}
