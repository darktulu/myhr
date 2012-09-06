/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

/**
 *
 * @author toshiba
 */
public class HomeCtl {

   private static String link = "";
   
    public HomeCtl() {
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    public static void setString(String s){
        link = s;
    }
    
    public String go(){
        return link;
}

    
}
