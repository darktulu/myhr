/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wadia.local.Recipients;
import com.wadia.repos.ESalaryDataRepos;
import com.wadia.service.SalaryService;
import com.wadia.service.impl.SalaryServiceImpl;
import com.wadia.service.impl.SendMail;



/**
 *
 * @author wadi3
 */
@Service
public class MailForm {
   
	@Autowired
    private SendMailTLS sendMailTLS;
    @Autowired
    private SendMail sendMail;
    @Inject
    private SalaryService salaryService;
    @Inject 
    private ESalaryDataRepos eSalaryDataRepos;
   
    public void RequestLeave(List<Recipients> toMail, String Manager, String User, String year, Date startDate, Date endDate, int days, String motif) {
        String mail;

        Calendar calendar = new GregorianCalendar();
        Date now = calendar.getTime();

        mail = " <div id='inside' style='margin: auto; width: 800px; height: 600px; font: 14px Calibri;'>"
                + "<p style='margin-top: 2px;'>"
                + "Dear " + Manager
                + "</p>"
                + "<p>"
                + "Kindly be informed that the resource " + User + " has raised a new vacation request on MyHR Portal <i style='color: blue;'>pending your approval </i> :"
                + "</p>"
                + "<div>"
                + "<table  style='margin: auto; border: solid 1px #c6c6c6; font: 14px Calibri; width: 640px;'>"
                + "<tbody>"
                + "<tr style='border: solid 1px #c6c6c6;'>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; border: solid 1px #c6c6c6; '>Requester Full Name</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; border: solid 1px #c6c6c6;'>" + User + "</td>"
                + "</tr>"
                + "<tr style='border: solid 1px #c6c6c6;'>"
                + "<td style='width: 320px; height: 30px; border: solid 1px #c6c6c6; '>Request Status</td>"
                + "<td style='width: 320px; height: 30px; border: solid 1px #c6c6c6; '>Requested</td>"
                + "</tr>"
                + "<tr style='border: solid 1px #c6c6c6;'>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; border: solid 1px #c6c6c6; '>Request Date</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; border: solid 1px #c6c6c6;'>" + now + "</td>"
                + "</tr>"
                + "<tr style='border: solid 1px #c6c6c6;'>"
                + "<td style='width: 320px; height: 30px; border: solid 1px #c6c6c6; '>Annual Leave</td>"
                + "<td style='width: 320px; height: 30px; border: solid 1px #c6c6c6;'>" + year + "</td>"
                + "</tr>"
                + "<tr style='border: solid 1px #c6c6c6;'>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; border: solid 1px #c6c6c6; '>Planned Vacation start Date</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; border: solid 1px #c6c6c6;'>" + startDate + "</td>"
                + "</tr>"
                + "<tr style='border: solid 1px #c6c6c6;'>"
                + "<td style='width: 320px; height: 30px; border: solid 1px #c6c6c6; '>Planned Vacation end Date</td>"
                + "<td style='width: 320px; height: 30px; border: solid 1px #c6c6c6;'>" + endDate + "</td>"
                + "</tr>"
                + "<tr style='border: solid 1px #c6c6c6;'>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; border: solid 1px #c6c6c6; '>Total Days requested</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; border: solid 1px #c6c6c6;'>" + days + "</td>"
                + "</tr>"
                + "<tr style='border: solid 1px #c6c6c6;'>"
                + "<td style='width: 320px; height: 100px; border: solid 1px #c6c6c6; '>Comments</td>"
                + "<td style='width: 320px; height: 100px; border: solid 1px #c6c6c6; '>" + motif + "</td>"
                + "</tr>"
                + "<tr style='border: solid 1px #c6c6c6;'>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; border: solid 1px #c6c6c6;'>MyHR Link to approve request</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; border: solid 1px #c6c6c6;'>http://myhr.3gcominside.com/faces/myTeam.xhtml</td>"
                + "</tr>"
                + "</tbody>"
                + "</table>"
                + " </div>"
                + "<p style='font: 14px Calibri;'>"
                + " Many Thanks "
                + "</p>"
                + "<p style='font: 14px Calibri;'>"
                + "MyHR"
                + "</p>"
                + "</div>";
        
        for(Recipients rep : toMail){
   	     System.out.println("MailFrom "+rep.getMail());	
   	    }
        
        sendMail.sendMailHTML(toMail, "Vacation Request", mail);

    }

    public void leaveApprouved(List<Recipients> toMail, String User, String year, Date startDate, Date endDate, int days, String motif, String who) {
        String mail;

        Calendar calendar = new GregorianCalendar();
        Date now = calendar.getTime();

        mail = "  <div id='inside' style='margin: auto; width: 800px; height: 600px; font: 14px Calibri;'>"
                + "<p style='margin-top: 2px;'>"
                + "Dear " + User
                + "</p>"
                + "<p>"
                + "Kindly be informed that your requested vacation herewith has been <b style='color : blue;' >Approved</b> by your "+who+" :"
                + "</p>"
                + "<div>"
                + "<table  style='margin: auto; border: solid 1px #c6c6c6; font: 14px Calibri; width: 640px;'>"
                + "<tbody>"
                + "<tr style='border: solid 1px #c6c6c6;'>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; border: solid 1px #c6c6c6; '>Requester Full Name</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; border: solid 1px #c6c6c6;'>" + User + "</td>"
                + "</tr>"
                + "<tr style='border: solid 1px #c6c6c6;'>"
                + "<td style='width: 320px; height: 30px; border: solid 1px #c6c6c6; '>Request Status</td>"
                + "<td style='width: 320px; height: 30px; color : blue; border: solid 1px #c6c6c6;'>Approved</td>"
                + "</tr>"
                + "<tr style='border: solid 1px #c6c6c6;'>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; border: solid 1px #c6c6c6; '>Planned Vacation start Date</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; border: solid 1px #c6c6c6;'>" + startDate + "</td>"
                + "</tr>"
                + "<tr style='border: solid 1px #c6c6c6;'>"
                + "<td style='width: 320px; height: 30px; border: solid 1px #c6c6c6; '>Planned Vacation end Date</td>"
                + "<td style='width: 320px; height: 30px; border: solid 1px #c6c6c6; '>" + endDate + "</td>"
                + "</tr>"
                + "<tr style='border: solid 1px #c6c6c6;'>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; border: solid 1px #c6c6c6; '>Total Days requested</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; border: solid 1px #c6c6c6;'>" + days + "</td>"
                + "</tr>"
                + "<tr style='border: solid 1px #c6c6c6;'>"
                + "<td style='width: 320px; height: 100px; border: solid 1px #c6c6c6; '>Comments</td>"
                + "<td style='width: 320px; height: 100px; border: solid 1px #c6c6c6; '>" + motif + "</td>"
                + "</tr>"
                + "</tbody>"
                + "</table>"
                + " </div>"
                + "<p style='font: 14px Calibri;'>"
                + " Many Thanks "
                + "</p>"
                + "<p style='font: 14px Calibri;'>"
                + "MyHR"
                + "</p>"
                + "</div>";
       
        sendMail.sendMailHTML(toMail, "Vacation Request", mail);

    }
    
    public void leaveDesapprouved(List<Recipients> toMail, String User, String year, Date startDate, Date endDate, int days, String motif, String who) {
        String mail;

        Calendar calendar = new GregorianCalendar();
        Date now = calendar.getTime();

        mail = "  <div id='inside' style='margin: auto; width: 800px; height: 600px; font: 14px Calibri;'>"
                + "<p style='margin-top: 2px;'>"
                + "Dear " + User
                + "</p>"
                + "<p>"
                + "Kindly be informed that your requested vacation herewith has been <b style='color : red;' >Rejected</b> by your "+who+" :"
                + "</p>"
                + "<div>"
                + "<table  style='margin: auto; border: solid 1px #c6c6c6; font: 14px Calibri; width: 640px;'>"
                + "<tbody>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; background: #c9c9c9; '>Requester Full Name</td>"
                + "<td style='width: 320px; height: 30px; background: #c9c9c9;'>" + User + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; '>Request Status</td>"
                + "<td style='width: 320px; height: 30px; color : blue; '>Rejected</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; '>Annual Leave</td>"
                + "<td style='width: 320px; height: 30px; '>" + year + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; background: #c9c9c9; '>Planned Vacation start Date</td>"
                + "<td style='width: 320px; height: 30px; background: #c9c9c9;'>" + startDate + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; '>Planned Vacation end Date</td>"
                + "<td style='width: 320px; height: 30px; '>" + endDate + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; background: #c9c9c9; '>Total Days requested</td>"
                + "<td style='width: 320px; height: 30px; background: #c9c9c9;'>" + days + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 100px; '>Comments</td>"
                + "<td style='width: 320px; height: 100px; '>" + motif + "</td>"
                + "</tr>"
                + "</tbody>"
                + "</table>"
                + " </div>"
                + "<p style='font: 14px Calibri;'>"
                + " Many Thanks "
                + "</p>"
                + "<p style='font: 14px Calibri;'>"
                + "MyHR"
                + "</p>"
                + "</div>";
        
        sendMail.sendMailHTML(toMail, "Vacation Request", mail);

    }

    public void BirthdayMail(List<String> toMail, String Username) {
        String mail;

        Calendar calendar = new GregorianCalendar();
        Date now = calendar.getTime();

        mail = " <div id='inside' style='margin: auto; width: 800px; height: 600px; border: solid 1px black;'>"
                + "<p style='margin-top: 2px;'>"
                + " Dear "+Username+" "
                + "</p>"
                + "<p>"
                + " For and on behalf of 3Gcom, we wish you a <b style='color: blue'>VERY HAPPY BIRTHDAY</b>"
                + "</p>"
                + "<p>"
                + "May you be blessed with abundance of good health, wealth, happiness and success "
                + "</p>"
                + "<p>   "
                + "You have always remained to be one of our most valued employees, you are always thought of in a very special way and you're wished the finestthings in life today and every day."
                + "</p>"
                + "<p style='color: lightseagreen;'>"
                + "Once again a very happy birthday and May you have many more on the way!"
                + "</p>"
                + "<p>"
                + "MyHR"
                + "</p>"
                + "<p>"
                + "For and on behalf of 3Gcom"
                + "</p>"
                + "<table style='width: 100%;'>"
                + "<tbody>"
                + "<tr>"
                + "<td><img src='images/bith.png'/></td>"
                + "<td><img src='images/bith2.png'/></td>"
                + "</tr>"
                + " </tbody>"
                + "</table>"
                + " </div>";
        sendMailTLS = new SendMailTLS();
        sendMailTLS.sendMailHTML(toMail, "Vacation Request", mail);

    }
    
    public void SalaryAward(List<Recipients> toMail, String fullname,String username,String baseSalary) {
        String mail;

        Calendar calendar = new GregorianCalendar();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date now = calendar.getTime();
        String lastSalary = null;
	    String newSalary = null;
	    String totalAlloance = null;
	    String totalSalary = null;
	    java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");
	    
        lastSalary = ""+eSalaryDataRepos.findLastSalary(username).getBaseSalary();
        totalAlloance = ""+salaryService.getTotalAllowance(username);			 
	    newSalary = ""+salaryService.calculeSalaireNet(username);		
		totalSalary = ""+df.format(salaryService.calculeSalaireImposable(username));
        
        String today = ""+dateFormat.format(calendar.getTime());
        
        mail = "<div id='inside' style='margin: auto; width: 800px; height: 900px; font: 14px Calibri;'>"
		+"<p>3Gcom SARL"
		+"N°11, Rue aniouusne, Bloc G <br/>"
		+"Secteur 22, Hay Ryad, Rabat<br/>"
		+"Tel: +212 37 56 67 82<br/>"
		+" Fax: +212 37 56 67 81<br/>"
		+" http://www.3gcom.ma</p>"+
		
		
		"<p style='float : left;'>" +
		"3GCOM<br/>" +
		"Rabat,Morocco" +
		" </p>" +
		
		"<p>Dear "+fullname+",</p>" +
		"<p>We are pleased to inform you that in recognition of your performance and hard work during 2012, "+
		   "your monthly salary has been increased to "+newSalary+" MAD effective date "+today+" .</p>" +
		"<p>Given below is the revised salary structure: </p><br/>" +
		"<table  style='margin: auto; border: solid 1px #c6c6c6; font: 14px Calibri; width: 640px;'>" +
		" <tbody>" +
		" <tr style='border: solid 1px #c6c6c6;'>" +
		"<td style='width: 320px; height: 30px; background: #c1c1c1; border: solid 1px #c6c6c6; '>Basic Salary </td>" +
		"<td style='width: 320px; height: 30px; border: solid 1px #c6c6c6;'>"+baseSalary+"MAD</td>" +
		"</tr>" +
		"<tr style='border: solid 1px #c6c6c6;'>" +
		" <td style='width: 320px; height: 30px; background: #f1f1f1; border: solid 1px #c6c6c6; '>Total allowance</td>" +
		" <td style='width: 320px; height: 30px; border: solid 1px #c6c6c6;'>"+totalAlloance+"MAD</td>" +
		" </tr>" +
		" <tr style='border: solid 1px #c6c6c6;'>" +
		" <td style='width: 320px; height: 30px; background: #c1c1c1; border: solid 1px #c6c6c6; '>Total Salary</td>" +
		" <td style='width: 320px; height: 30px; border: solid 1px #c6c6c6;'>"+totalSalary+"MAD</td>" +
		" </tr>" +
		" <tr style='border: solid 1px #c6c6c6;'>" +
		"<td style='width: 320px; height: 30px; background: #f1f1f1; border: solid 1px #c6c6c6; '><b>Net Salary</b></td>" +
		"<td style='width: 320px; height: 30px; border: solid 1px #c6c6c6;'>"+newSalary+"MAD</td>" +
		" </tr>" +
		"</tbody>" +
		"</table>" +
		"<br/>" +
		"<p> We appreciate the dedication and hard work that you have put in your work and hope that you "+
		  " continue to perform even better in the coming year. </p>" +
		
		"<p> Please note that this increase is a part of your personal compensation and thus confidential."+ 
		 " Any sharing of such information is strictly against the company policy.</p>" +
		
		"<p> We look forward to seeing the same level of commitment, devotion and excellence going forward. </p>" +
		
		"<p>Congratulations and Best Wishes. </p>" +
		"<br/>" +
		"<p>Sincerely,</p>" +
		"<img src='images/sigh.png'/>" +
		" <p>________________________</p>" +
		"<p>Radia Baroudi<br/>HR Manager<br/>3Gcom<br/></p>" +
		"</div>";
        
        for(Recipients rep : toMail){
      	     System.out.println("MailFrom "+rep.getMail());	
      	    }
       
        sendMail.sendMailHTML(toMail, "Award certificate", mail);
        
    
    }
    
    
}
