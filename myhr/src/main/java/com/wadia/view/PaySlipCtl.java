package com.wadia.view;

import java.io.File;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.wadia.beans.EContractData;
import com.wadia.beans.EGeneralData;
import com.wadia.fileUpload.PDFToImage;
import com.wadia.fileUpload.PaySlipGenerator;
import com.wadia.local.CreatFolders;
import com.wadia.local.DateProvider;
import com.wadia.metier.DirectoryMetier;
import com.wadia.metier.PathProvider;
import com.wadia.metier.SalaryHrMetier;
import com.wadia.repos.EContractDataRepos;
import com.wadia.repos.EGeneralDataRepos;
import com.wadia.service.SalaryPerDateService;

@ManagedBean
@RequestScoped
public class PaySlipCtl implements Serializable {
	
	
	 private PaySlipGenerator paySlipGenerator = new PaySlipGenerator();
     private userController user = new userController();
     private PDFToImage pdfToImage = new PDFToImage();
     private String link ; 
     private String linkToShow1;
     private String linkToShow2;
     private String linkToShow3;
     private PathProvider pathProvider = new PathProvider();
     private Integer month = 0 , year = 0;
     private static String GeneratedLink;
     private boolean showlink = false;
     
     @ManagedProperty("#{salaryPerDateService}")
     private SalaryPerDateService salaryPerDateService;
     
     @ManagedProperty("#{eGeneralDataRepos}")
     private EGeneralDataRepos eGeneralDataRepos;
     
     @ManagedProperty("#{eContractDataRepos}")
     private EContractDataRepos eContractDataRepos;
     
     
     
     public void generate() throws Exception{
    	 
    	 SalaryHrMetier hrMetier = new SalaryHrMetier(); 
    	 DateProvider dateProvider = new DateProvider();
    	 CreatFolders creatFolders = new CreatFolders();
    	 
    	
    	 
    	 /****** First Pay Slip ********/
    	 hrMetier = salaryPerDateService.salaryPerDate(user.getUsername(),dateProvider.getNubLastMonth(1).getMonth(), dateProvider.getNubLastMonth(1).getYear());
    	 System.out.println("here");
    	 if(hrMetier.getMonthlyBaeSalary()!=null){
    	 link = paySlipGenerator.generatePaySlip(eGeneralDataRepos.findOne(user.getUsername()), eContractDataRepos.findLastContract(user.getUsername()),hrMetier,dateProvider.getNubLastMonth(1).getMonth(),dateProvider.getNubLastMonth(1).getYear());
    	 pdfToImage.convert(link, creatFolders.createFolderByUser(user.getUsername(), 1));
         linkToShow1 =  "paySlipsJpg"+"/"+user.getUsername()+"/1/"+"1.jpg";
         System.out.println(""+linkToShow1);
    	 }
         
    	 /****** Second Pay Slip ********/
         
         hrMetier = salaryPerDateService.salaryPerDate(user.getUsername(),dateProvider.getNubLastMonth(2).getMonth(), dateProvider.getNubLastMonth(2).getYear());
    	 if(hrMetier.getMonthlyBaeSalary()!=null){
    	 link = paySlipGenerator.generatePaySlip(eGeneralDataRepos.findOne(user.getUsername()), eContractDataRepos.findLastContract(user.getUsername()),hrMetier,dateProvider.getNubLastMonth(2).getMonth(),dateProvider.getNubLastMonth(2).getYear());
    	 pdfToImage.convert(link, creatFolders.createFolderByUser(user.getUsername(), 2));
         linkToShow2 =  "paySlipsJpg"+"/"+user.getUsername()+"/2/"+"1.jpg";
         System.out.println(""+linkToShow2);
    	 }
         
          /****** 3rd Pay Slip ********/
         
         hrMetier = salaryPerDateService.salaryPerDate(user.getUsername(),dateProvider.getNubLastMonth(3).getMonth(), dateProvider.getNubLastMonth(3).getYear());
    	 if(hrMetier.getMonthlyBaeSalary()!=null){
    	 link = paySlipGenerator.generatePaySlip(eGeneralDataRepos.findOne(user.getUsername()), eContractDataRepos.findLastContract(user.getUsername()),hrMetier,dateProvider.getNubLastMonth(3).getMonth(),dateProvider.getNubLastMonth(3).getYear());
    	 pdfToImage.convert(link, creatFolders.createFolderByUser(user.getUsername(), 3));
         linkToShow3 =  "paySlipsJpg"+"/"+user.getUsername()+"/3/"+"1.jpg";
         System.out.println("toto"+linkToShow3);
         }
         
         
    	 
         
     }
     
     public void payPerMonth(){
    	SalaryHrMetier hrMetier = new SalaryHrMetier(); 
    	hrMetier = salaryPerDateService.salaryPerDate(user.getUsername(), month, year);
    	
    	if(hrMetier.getMonthlyBaeSalary()==null){
    		
    		FacesContext.getCurrentInstance().addMessage(
    			    null,
    			    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalide pay periode",
    				    null));
    		
    	}else{
    		 GeneratedLink = "documents/payslip_"+user.getUsername()+""+month+""+year+".pdf";
    		File dir = new File(GeneratedLink);
    		if(dir.exists()){
    			
    			dir.delete();
    		}
    	    paySlipGenerator.generatePaySlip(eGeneralDataRepos.findOne(user.getUsername()), eContractDataRepos.findLastContract(user.getUsername()),hrMetier,month,year);
    	   

    	    FacesContext.getCurrentInstance().addMessage(
    			    null,
    			    new FacesMessage(FacesMessage.SEVERITY_INFO, "Your PDF file is generated could you please download it",
    				    null));
    	    
    	}
    	
    	
    	
     }



	public userController getUser() {
		return user;
	}

	public void setUser(userController user) {
		this.user = user;
	}



	public PaySlipGenerator getPaySlipGenerator() {
		return paySlipGenerator;
	}



	public void setPaySlipGenerator(PaySlipGenerator paySlipGenerator) {
		this.paySlipGenerator = paySlipGenerator;
	}



	public PDFToImage getPdfToImage() {
		return pdfToImage;
	}



	public void setPdfToImage(PDFToImage pdfToImage) {
		this.pdfToImage = pdfToImage;
	}



	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}



	public PathProvider getPathProvider() {
		return pathProvider;
	}



	public void setPathProvider(PathProvider pathProvider) {
		this.pathProvider = pathProvider;
	}



	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public SalaryPerDateService getSalaryPerDateService() {
		return salaryPerDateService;
	}

	public void setSalaryPerDateService(SalaryPerDateService salaryPerDateService) {
		this.salaryPerDateService = salaryPerDateService;
	}

	public String getGeneratedLink() {
		return GeneratedLink;
	}

	public void setGeneratedLink(String generatedLink) {
		GeneratedLink = generatedLink;
	}

	public EGeneralDataRepos geteGeneralDataRepos() {
		return eGeneralDataRepos;
	}

	public void seteGeneralDataRepos(EGeneralDataRepos eGeneralDataRepos) {
		this.eGeneralDataRepos = eGeneralDataRepos;
	}

	public EContractDataRepos geteContractDataRepos() {
		return eContractDataRepos;
	}

	public void seteContractDataRepos(EContractDataRepos eContractDataRepos) {
		this.eContractDataRepos = eContractDataRepos;
	}

	public String getLinkToShow1() {
		return linkToShow1;
	}

	public void setLinkToShow1(String linkToShow1) {
		this.linkToShow1 = linkToShow1;
	}

	public String getLinkToShow2() {
		return linkToShow2;
	}

	public void setLinkToShow2(String linkToShow2) {
		this.linkToShow2 = linkToShow2;
	}

	public String getLinkToShow3() {
		return linkToShow3;
	}

	public void setLinkToShow3(String linkToShow3) {
		this.linkToShow3 = linkToShow3;
	}

	public boolean isShowlink() {
		return showlink;
	}

	public void setShowlink(boolean showlink) {
		this.showlink = showlink;
	}




}
