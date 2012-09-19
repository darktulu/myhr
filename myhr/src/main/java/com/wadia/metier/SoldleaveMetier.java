/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.EContractData;
import com.wadia.beans.ELData;
import com.wadia.beans.Soldleave;
import com.wadia.local.sold;
import com.wadia.repos.EContractDataRepos;
import com.wadia.repos.ELDataRepos;
import com.wadia.repos.SoldleaveRepos;

/**
 * 
 * @author toshiba
 */
@Service
@Transactional
public class SoldleaveMetier {

    @Inject
    private SoldleaveRepos soldleaveRepos;
    @Inject
    private ELDataRepos elDataRepos;
    @Inject
    private EContractDataRepos eContractDataRepos;
    @Inject
    private ContratMetier contratMetier;
    
    private long CONST_DURATION_OF_DAY = 1000l * 60 * 60 * 24;

    public List<sold> findbyusername(String username) {

	List<Soldleave> listsold = new ArrayList<Soldleave>();
	List<sold> listsoldToReturn = new ArrayList<sold>();

	listsold = soldleaveRepos.findByUsername(username);
	
	

	for (Soldleave solds : listsold) {

	    sold soldToAdd = new sold();
	    soldToAdd.setYear(solds.getYear());
	    soldToAdd.setSold(solds.getSold());
	    soldToAdd.setConsumed(solds.getConsumed());
	    soldToAdd.setRest(solds.getSold() - solds.getConsumed());
	    soldToAdd.setPlanned(solds.getPlanned());
	    soldToAdd.setDelta((solds.getSold() - solds.getConsumed()) - solds.getPlanned());
	    listsoldToReturn.add(soldToAdd);
	}

	return listsoldToReturn;
    }

    /**
     * *************************************************************************
     * **********
     */
    public boolean isExist(String username) {

	boolean var = false;
	List<Soldleave> listsold = new ArrayList<Soldleave>();
	listsold = soldleaveRepos.findAll();

	for (Soldleave sold : listsold) {

	    if (sold.getResourceId().equals(username)) {
		var = true;
	    }

	}

	return var;

    }

    /**
     * *************************************************************************
     * **********
     */
    /*
     * public void updateUserSold(String username) {
     * 
     * ArrayList<Integer> yearsList = new ArrayList<Integer>(); List<Soldleave>
     * listsold = new ArrayList<Soldleave>(); yearsList = years(username);
     * listsold = findbyusername(username); for (Soldleave sold : listsold) {
     * 
     * for (Integer year : yearsList) {
     * 
     * if (sold.getYear() != year) { int soldByYear = (int)
     * userSoldByYear(username, year); Soldleave newSold = new
     * Soldleave(username, year, soldByYear, 0, soldByYear, soldByYear, 0,
     * soldByYear); if(KO(username, year)){ dao.save(newSold);}
     * 
     * }
     * 
     * }
     * 
     * }
     * 
     * }
     */
    
    /*public void updateSold(String username){
    	
    	List<ELData> list = elDataRepos.findByUsername(username);
    	
    }*/
    
    public double userSoldByYear(String username, int year) {

	double sold = 0;
	boolean var = true;
	List<EContractData> list = new ArrayList<EContractData>();
	
	list = contratMetier.findByUsername(username);
	for (EContractData contract : list) {

	    if (contract.getContractType().equals("CDD")) {

		if (contract.getContractStartDate() != null && contract.getContractEndDate() != null) {

		    if (getYear(contract.getContractStartDate()) == year) {
			sold = soldperDate(contract.getContractStartDate(), contract.getContractEndDate());
		    }
		}

	    }

	    if (contract.getContractType().equals("CDI")) {
		if (contract.getContractStartDate() != null) {
		    if (getYear(contract.getContractStartDate()) == year) {

			sold = soldperDate(contract.getContractStartDate(), endofYear(year));
		    }

		}

	    }

	}

	for (EContractData contract : list) {

	    if (contract.getContractStartDate() != null) {

		if (getYear(contract.getContractStartDate()) == year) {
		    var = false;
		}

	    }

	}

	if (var) {

	    sold = 18;
	}

	return sold;
    }

    public double soldperDate(Date start, Date end) {
	long difference = Math.abs(end.getTime() - start.getTime());
	long numberOfDay = (long) difference / CONST_DURATION_OF_DAY;
	long longSold;
	longSold = (numberOfDay * 18) / 365;
	double sold = Math.floor(longSold + 0.5);
	return sold;

    }

    /*
     * public void updateListSold() {
     * 
     * ArrayList<Integer> yearsList = new ArrayList<Integer>(); List<Soldleave>
     * listsold = new ArrayList<Soldleave>(); EGeneralDataDao eGeneralDataDao =
     * new EGeneralDataDao(); List<EGeneralData> generalDatas = new
     * ArrayList<EGeneralData>(); generalDatas = eGeneralDataDao.findAll();
     * listsold = dao.findAll(); boolean var = false;
     * 
     * for (EGeneralData egen : generalDatas) { if
     * (isExist(egen.getResurceId())) { updateUserSold(egen.getResurceId()); }
     * else {
     * 
     * yearsList = years(egen.getResurceId()); for (Integer year : yearsList) {
     * int soldByYear = (int) userSoldByYear(egen.getResurceId(), year);
     * Soldleave newSold = new Soldleave(egen.getResurceId(), year, soldByYear,
     * 0, soldByYear, soldByYear, 0, soldByYear);
     * 
     * var =KO(egen.getResurceId(), year); System.out.println("var "
     * +egen.getResurceId()+" "+ var); if (var) { dao.save(newSold); } }
     * 
     * }
     * 
     * } }
     */

    /*
     * ***************************************************************************************
     */
    public ArrayList<Integer> years(String username) {

	ArrayList<Integer> years = new ArrayList<Integer>();
	Calendar cal = GregorianCalendar.getInstance();
	Date date = eContractDataRepos.getFirstContract(username);
	if (date != null) {
	    Calendar myCalendar = GregorianCalendar.getInstance();
	    myCalendar.setTime(date);

	    int currentYear = cal.get(Calendar.YEAR);
	    int contractYear = myCalendar.get(Calendar.YEAR);
	    int year = contractYear;
	    while (year <= currentYear) {
		years.add(year);
		year++;

	    }
	}

	return years;
    }

    public Date endofYear(int year) {

	Calendar calendar2 = new GregorianCalendar();
	calendar2.set(Calendar.YEAR, year);
	calendar2.set(Calendar.MONTH, 12);
	calendar2.set(Calendar.DAY_OF_MONTH, 31);
	Date date2 = calendar2.getTime();

	return date2;
    }

    public int getYear(Date date) {

	Calendar myCalendar = GregorianCalendar.getInstance();
	myCalendar.setTime(date);
	return (myCalendar.get(Calendar.YEAR));

    }

    public boolean KO(String username, int year) {

	boolean ko = true;
	List<Soldleave> lists = new ArrayList<Soldleave>();
	lists = soldleaveRepos.findAll();
	for (Soldleave sold : lists) {

	    if (sold.getResourceId().equals(username) && sold.getYear() == year) {

		ko = false;
	    }

	}

	return ko;
    }
    
    
    /** this method update your sold leave **/ 

    public void updateSoldProvider(String username) {
    
    int planned = 0;
    int consumed = 0;
	List<ELData> l_data = new ArrayList<ELData>();
	List<Soldleave> listSolds = new ArrayList<Soldleave>();
	
	l_data = elDataRepos.findByUsername(username);
	listSolds = soldleaveRepos.findByUsername(username);

	for (Soldleave sold : listSolds) {
	    planned = 0;
	    consumed = 0;
	    for (ELData leave : l_data) {

		if (!leave.getStatus().equals("taken") && !leave.getStatus().equals("canceled")
			&& extractInt(leave.getDate()) == sold.getYear()) {
		    planned += leave.getTotalDays();
		}else if(leave.getStatus().equals("taken")&& extractInt(leave.getDate()) == sold.getYear()) {
			
			consumed += leave.getTotalDays();
			
		}
	   
	    
	    }
	    sold.setPlanned(planned);
	    sold.setConsumed(consumed);
	    soldleaveRepos.save(sold);
	}

    }

    public static int extractInt(String str) {
	Matcher matcher = Pattern.compile("\\d+").matcher(str);

	if (!matcher.find()) {
	    throw new NumberFormatException("For input string [" + str + "]");
	}

	return Integer.parseInt(matcher.group());
    }
    
    public boolean soldKO(String username, Integer year , Integer days){
    	
    	boolean var = false;
    	
    	Soldleave soldleave = soldleaveRepos.findByUsernameAndYear(username, year);
    	if(days<=soldleave.getPlanned()){
    		
    		var = true;
    	}
    	return var;
    }
    
    
}
