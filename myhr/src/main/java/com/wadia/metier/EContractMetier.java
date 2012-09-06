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

import com.wadia.beans.EContractData;
import com.wadia.repos.EContractDataRepos;

/**
 *
 * @author toshiba
 */
@Service
@Transactional
public class EContractMetier {
    @Inject
    private EContractDataRepos eContractDataRepos;
    public EContractData getLastContract(String username) {


        List<EContractData> listContract = new ArrayList<EContractData>();
        List<EContractData> listTranscientContracts = new ArrayList<EContractData>();
        List<EContractData> listTranscientContract = new ArrayList<EContractData>();
        EContractData contractReutrn = new EContractData();
      

        listContract = eContractDataRepos.findAll();

        boolean var = true;

        for (EContractData contract : listContract) {

            if (contract.getContractStatus().equals("Ongoing") && contract.getResurceId().equals(username)) {

                contractReutrn = contract;
                var = false;

            } else if ((contract.getContractStatus().equals("Expired") | contract.getContractStatus().equals("ENDED")) && contract.getResurceId().equals(username)) {

                listTranscientContract.add(contract);

            }

        }

        if (listTranscientContract.size() != 0 && var) {

            boolean lock;
            //System.out.print(listTranscientContract.size());
            for (EContractData contract : listTranscientContract) {
                System.out.println("ddd");
                lock = true;
                System.out.println("o" + listTranscientContract.size());



                for (EContractData contract2 : listTranscientContract) {

                    if (contract.getContractEndDate().before(contract2.getContractEndDate())) {
                        lock = false;
                    }
                }


                if (lock) {
                    contractReutrn = contract;
                }


            }
        }

        return contractReutrn;

    }

    public List<EContractData> removeMe(List<EContractData> list, EContractData contract) {
        List<EContractData> listContracts = new ArrayList<EContractData>();
        listContracts = list;

        for (EContractData cont : listContracts) {


            if (cont.equals(contract)) {

                listContracts.remove(contract);

            }

        }

        return listContracts;

    }
}
