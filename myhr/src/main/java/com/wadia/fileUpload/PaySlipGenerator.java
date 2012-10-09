package com.wadia.fileUpload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.wadia.beans.EContractData;
import com.wadia.beans.EGeneralData;
import com.wadia.local.DateProvider;
import com.wadia.metier.PathProvider;
import com.wadia.metier.SalaryHrMetier;

public class PaySlipGenerator implements Serializable {
	
	private PathProvider pathProvider = new PathProvider();
	
	public String generatePaySlip(EGeneralData egen, EContractData eContractData, SalaryHrMetier salary ,Integer month, Integer year){
		
		
    	DateProvider dateProvider = new DateProvider();
    	
    	String bulttin = pathProvider.path()+"documents/bulltin.pdf";
    	String payslip  = pathProvider.path()+"documents/payslip_"+egen.getResurceId()+""+month+""+year+".pdf";
    	System.out.println("here in gen slip "+month);
    	String matricule = egen.getMatricule();
    	String fullname = egen.getName()+" "+egen.getSurname();
    	String dateNaissance = ""+egen.getBirthday();
    	String periodePaix = ""+dateProvider.convert(month)+"-"+year;
    	String situationFamiliale = egen.getMartialStatus();
    	String enfants = "5";
    	String deductions="300";
    	String CIN= egen.getCin();
    	String jobTitle= egen.getJobeTitle();
    	String dateEmbauche= ""+eContractData.getContractStartDate();
    	String mutuelle=egen.getCimr();
    	String CNSS=egen.getCnss();
    	String NatureContrat=eContractData.getContractType();
    	
    	try {
    	     
    		   
    		
    		  PdfReader pdfReader = new PdfReader(bulttin);
    	      PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(payslip));
    	     
    	      for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) // Must start at 1 because 0 is not an actual page.
    	    	       
    	      {

    	          PdfContentByte content = pdfStamper.getOverContent(i);
    	          content.beginText();
    	         
    	          // BaseFont baseFont = BaseFont.CreateFont(BaseFont.HELVETICA_BOLD, Encoding.ASCII.EncodingName, false);
    	          BaseFont baseFont =   BaseFont.createFont();
    	          baseFont.setPostscriptFontName(BaseFont.HELVETICA);
    	          content.setFontAndSize(baseFont, 8); // 40 point font
    	          content.setRGBColorFill(0, 0, 0); // Sets the color of the font, RED in this instance
    	         
    	          /******* PaySlip Details to add *******/
    	          
    	          content.showTextAligned(PdfContentByte.ALIGN_CENTER, periodePaix, 470 , 600, 0);
    	          // first row
    	          content.showTextAligned(PdfContentByte.ALIGN_CENTER, matricule, 85 , 557, 0);
    	          content.showTextAligned(PdfContentByte.ALIGN_CENTER, fullname, 200 , 557, 0);
    	          content.showTextAligned(PdfContentByte.ALIGN_CENTER, dateNaissance, 315 , 557, 0);
    	          content.showTextAligned(PdfContentByte.ALIGN_CENTER, situationFamiliale, 390 , 557, 0);
    	          content.showTextAligned(PdfContentByte.ALIGN_CENTER, enfants, 465 , 557, 0);
    	          content.showTextAligned(PdfContentByte.ALIGN_CENTER, deductions, 530 , 557, 0);
    	          //second row
    	          content.showTextAligned(PdfContentByte.ALIGN_CENTER, CIN, 85 , 530, 0);
    	          content.showTextAligned(PdfContentByte.ALIGN_CENTER, jobTitle, 200 , 530, 0);
    	          content.showTextAligned(PdfContentByte.ALIGN_CENTER, dateEmbauche, 315 , 530, 0);
    	          content.showTextAligned(PdfContentByte.ALIGN_CENTER, mutuelle, 390 , 530, 0);
    	          content.showTextAligned(PdfContentByte.ALIGN_CENTER, CNSS, 465 , 530, 0);
    	          content.showTextAligned(PdfContentByte.ALIGN_CENTER, NatureContrat, 530 , 530, 0);
    	        }
    	      
    	          pdfStamper.setFormFlattening(true);
    	     
    	          pdfStamper.close();

    	    } catch (IOException e) {
    	      e.printStackTrace();
    	    } catch (DocumentException e) {
    	      e.printStackTrace();
    	    }
    	  
    	return payslip;
		
	}

	public PathProvider getPathProvider() {
		return pathProvider;
	}

	public void setPathProvider(PathProvider pathProvider) {
		this.pathProvider = pathProvider;
	}

}
