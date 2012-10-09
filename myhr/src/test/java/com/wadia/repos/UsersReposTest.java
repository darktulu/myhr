package com.wadia.repos;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.wadia.fileUpload.attestationSalaire;
import com.wadia.local.Recipients;
import com.wadia.metier.OrgFillMetier;
import com.wadia.metier.OrgShowList;
import com.wadia.service.OrganizationalService;
import com.wadia.service.SalaryService;
import com.wadia.service.SendMail;

public class UsersReposTest {

    
    private attestationSalaire att; 	
   
    @Test
    public void test() throws Exception {
    
    att.generate("toto", "toto", "toto", "toto", "toto", "toto", "toto");
    	
	
    }

}
