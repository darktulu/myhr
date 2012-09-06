/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.Tercel;
import com.wadia.repos.TercelRepos;

/**
 *
 * @author toshiba
 */
@Service
@Transactional
public class terceMetier {

    @Inject
    private TercelRepos tercelRepos;
    
    public Tercel findbyusername(String username) {

        Tercel tercel = new Tercel();

        List<Tercel> list = new ArrayList<Tercel>();

        list = tercelRepos.findAll();
        if(list!=null) {
        
            for (Tercel ter : list) {
            if (ter.getResourceId().equals(username)) {

                tercel = ter;

            }

        } 
        }
        
        
    

        return tercel;

    }

    public int getTerce(String username) {
        int i = 0;
        Tercel t = new Tercel();
        t = findbyusername(username);
        if (t.getTercMin() != null && t.getTercMidle()!=null && t.getTercMax()!=null ) {
            if (t.getTercMin() != 0) {
                i = t.getTercMin();
            }
            if (t.getTercMidle() != 0) {
                i = t.getTercMidle();
            }
            if (t.getTercMax() != 0) {
                i = t.getTercMax();
            }
        }

        return i;

    }
}
