/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.fileUpload;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.wadia.local.DateProvider;

import java.io.FileOutputStream;

/**
 *
 * @author toshiba
 */
public class attestationSalaire {
   

    
 public void generate(String name , String CIN, String job, String date, String today, String documentName, String salaireNet) throws Exception {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream(documentName));
        document.open();
        DateProvider dateProvider = new DateProvider();
        String month = dateProvider.getLastMonth();
        System.out.println("cheher "+month);
        /*image settings */
        
        Image image = Image.getInstance("C:/logo-login.png");
        image.scaleAbsolute(80f, 60f);
        document.add(image);
        
        /*title settings */
        
        Paragraph title = new Paragraph();
        Font f =new Font(Font.FontFamily.TIMES_ROMAN, 22);
        title.add(new Chunk("Attestation de Salaire ", f ));
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingBefore(20);
        
        
        /*Paragraphe settings*/
        
        Paragraph body = new Paragraph();
        Font fp =new Font(Font.FontFamily.TIMES_ROMAN, 14);
        body.add(new Chunk("      Nous soussigné, 3GCOM  Sise au 11 Secteur 22, Bloc G, Rue  Anissone , Hay Ryad  à Rabat,"
                + "  certifions par la présente  que "+name+", Titulaire de la carte d’Identité Nationale "
                +CIN+ " est employé en qualité  "+job+" par la société 3Gcom S.A.R.L depuis le "+date+". ", fp ));
        body.setAlignment(Element.ALIGN_JUSTIFIED);
        body.setSpacingBefore(20);
        body.setLeading(2f, 2f);
        
         
        /*date*/
        
        Paragraph dates = new Paragraph();
        Font fdate =new Font(Font.FontFamily.TIMES_ROMAN, 14);
        dates.add(new Chunk("Il est toujours présent dans notre établissement et a perçu pour le mois de "+month+" un salaire net de "+salaireNet+".", fdate ));
        dates.setAlignment(Element.ALIGN_LEFT);
        dates.setSpacingBefore(20);
        dates.setLeading(2f, 2f);
        
        /*post*/
        
        
        
        Paragraph doit = new Paragraph();
        Font doits=new Font(Font.FontFamily.TIMES_ROMAN, 14);
        doit.add(new Chunk("Cette attestation est faite pour servir et valoir ce que de droit", fdate ));
        doit.setAlignment(Element.ALIGN_CENTER);
        doit.setSpacingBefore(40);
        doit.setLeading(2f, 2f);
        
        /*doit*/
        
        Paragraph fait = new Paragraph();
        //Font doits=new Font(Font.FontFamily.TIMES_ROMAN, 14);
        fait.add(new Chunk("Fait à Rabat Le "+today, fdate ));
        fait.setAlignment(Element.ALIGN_RIGHT);
        fait.setSpacingBefore(20);
        fait.setLeading(2f, 2f);
        
        /*ligne*/
        
        Paragraph ligne = new Paragraph();
        //Font doits=new Font(Font.FontFamily.TIMES_ROMAN, 14);
        ligne.add(new Chunk("_____________________________", fdate ));
        ligne.setAlignment(Element.ALIGN_RIGHT);
        ligne.setSpacingBefore(20);
        ligne.setLeading(2f, 2f);
        
       /*direction*/
        
        Paragraph direction = new Paragraph();
        //Font doits=new Font(Font.FontFamily.TIMES_ROMAN, 14);
        direction.add(new Chunk("Direction des Ressources ", fdate ));
        direction.add(new Chunk("Humaine ", fdate ));
        direction.setAlignment(Element.ALIGN_RIGHT);
        direction.setSpacingBefore(5);
        direction.setLeading(2f, 2f);
        
        document.add(new Paragraph(title));
        document.add(new Paragraph(body));
        //document.add(new Paragraph(post));
        document.add(new Paragraph(dates));
        document.add(new Paragraph(doit));
        document.add(new Paragraph(fait));
        document.add(new Paragraph(ligne));
        document.add(new Paragraph(direction));
        
        document.close();

    }


}
