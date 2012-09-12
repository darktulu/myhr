package com.wadia.repos;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.wadia.local.Recipients;
import com.wadia.metier.OrgFillMetier;
import com.wadia.metier.OrgShowList;
import com.wadia.service.OrganizationalService;
import com.wadia.service.SalaryService;
import com.wadia.service.SendMail;

public class UsersReposTest {

    
    private SendMail sendMail; 	
   
    @Test
    public void test() {
    
    List<Recipients> list = new ArrayList<Recipients>();
    Recipients rep = new Recipients();
    rep.setMail("o.GAMRANE@3gcon-int.com");
    rep.setType("To");
    list.add(rep);
    sendMail.sendMailHTML(list, "test", "Hello world");
    	
	
    }

}
