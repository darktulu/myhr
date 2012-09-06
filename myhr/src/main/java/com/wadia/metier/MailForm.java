/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author wadi3
 */
public class MailForm {

    private SendMailTLS sendMailTLS;
    


    public void RequestLeave(List<String> toMail, String Manager, String User, String year, Date startDate, Date endDate, int days, String motif) {
        String mail;

        Calendar calendar = new GregorianCalendar();
        Date now = calendar.getTime();

        mail = " <div id='inside' style='margin: auto; width: 800px; height: 600px;'>"
                + "<p style='margin-top: 2px;'>"
                + "Dear " + Manager
                + "</p>"
                + "<p>"
                + "Kindly be informed that the resource " + User + " has raised a new vacation request on MyHR Portal <i style='color: blue;'>pending your approval </i> :"
                + "</p>"
                + "<div>"
                + "<table  style='margin: auto; border: solid 1px #c9c9c9;'>"
                + "<tbody>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; '>Requester Full Name</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1;'>" + User + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; '>Request Status</td>"
                + "<td style='width: 320px; height: 30px; '>Requested</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; '>Request Date</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1;'>" + now + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; '>Annual Leave</td>"
                + "<td style='width: 320px; height: 30px; '>" + year + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; '>Planned Vacation start Date</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1;'>" + startDate + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; '>Planned Vacation end Date</td>"
                + "<td style='width: 320px; height: 30px; '>" + endDate + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; '>Total Days requested</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1;'>" + days + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 100px; '>Comments</td>"
                + "<td style='width: 320px; height: 100px; '>" + motif + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1;'>MyHR Link to approve request</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1;'>http://myhr.3gcominside.com/faces/myTeam.xhtml</td>"
                + "</tr>"
                + "</tbody>"
                + "</table>"
                + " </div>"
                + "<p>"
                + " Many Thanks "
                + "</p>"
                + "<p>"
                + "MyHR"
                + "</p>"
                + "</div>";
        sendMailTLS = new SendMailTLS();
        sendMailTLS.sendMailHTML(toMail, "Vacation Request", mail);

    }

    public void leaveApprouved(List<String> toMail, String User, String year, Date startDate, Date endDate, int days, String motif, String who) {
        String mail;

        Calendar calendar = new GregorianCalendar();
        Date now = calendar.getTime();

        mail = " <div id='inside' style='margin: auto; width: 800px; height: 600px;'>"
                + "<p style='margin-top: 2px;'>"
                + "Dear " + User
                + "</p>"
                + "<p>"
                + "Kindly be informed that your requested vacation herewith has been <b style='color : blue;' >Approved</b> by your "+who+" :"
                + "</p>"
                + "<div>"
                + "<table  style='margin: auto; border: solid 1px #c9c9c9;'>"
                + "<tbody>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; '>Requester Full Name</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1;'>" + User + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; '>Request Status</td>"
                + "<td style='width: 320px; height: 30px; color : blue; '>Approved</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; '>Request Date</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1;'>" + now + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; '>Annual Leave</td>"
                + "<td style='width: 320px; height: 30px; '>" + year + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; '>Planned Vacation start Date</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1;'>" + startDate + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; '>Planned Vacation end Date</td>"
                + "<td style='width: 320px; height: 30px; '>" + endDate + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; '>Total Days requested</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1;'>" + days + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 100px; '>Comments</td>"
                + "<td style='width: 320px; height: 100px; '>" + motif + "</td>"
                + "</tr>"
                + "</tbody>"
                + "</table>"
                + " </div>"
                + "<p>"
                + " Many Thanks "
                + "</p>"
                + "<p>"
                + "MyHR"
                + "</p>"
                + "</div>";
        sendMailTLS = new SendMailTLS();
        sendMailTLS.sendMailHTML(toMail, "Vacation Request", mail);

    }
    
    public void leaveDesapprouved(List<String> toMail, String User, String year, Date startDate, Date endDate, int days, String motif, String who) {
        String mail;

        Calendar calendar = new GregorianCalendar();
        Date now = calendar.getTime();

        mail = " <div id='inside' style='margin: auto; width: 800px; height: 600px;'>"
                + "<p style='margin-top: 2px;'>"
                + "Dear " + User
                + "</p>"
                + "<p>"
               + "Kindly be informed that your requested vacation herewith has been <b style='color : blue;' >Rejected </b> by your "+who+" :"
                + "</p>"
                + "<div>"
                + "<table  style='margin: auto; border: solid 1px #c9c9c9;'>"
                + "<tbody>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; '>Requester Full Name</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1;'>" + User + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; '>Request Status</td>"
                + "<td style='width: 320px; height: 30px; color : red; '>Rejected</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; '>Request Date</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1;'>" + now + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; '>Annual Leave</td>"
                + "<td style='width: 320px; height: 30px; '>" + year + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; '>Planned Vacation start Date</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1;'>" + startDate + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; '>Planned Vacation end Date</td>"
                + "<td style='width: 320px; height: 30px; '>" + endDate + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1; '>Total Days requested</td>"
                + "<td style='width: 320px; height: 30px; background: #f1f1f1;'>" + days + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td style='width: 320px; height: 100px; '>Line Manager Rejection Reason</td>"
                + "<td style='width: 320px; height: 100px; '>" + motif + "</td>"
                + "</tr>"
                + "<tr>"
                + "</tbody>"
                + "</table>"
                + " </div>"
                + "<p>"
                + " Many Thanks "
                + "</p>"
                + "<p>"
                + "MyHR"
                + "</p>"
                + "</div>";
        sendMailTLS = new SendMailTLS();
        sendMailTLS.sendMailHTML(toMail, "Vacation Request", mail);

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
}
