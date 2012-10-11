package com.wadia.service;

import java.util.List;

import com.wadia.metier.SalaryHrMetier;

public interface SalaryService {

   public List<SalaryHrMetier> listSalary();
   public float getTotalAllowance(String username);
   public Double calculeSalaireNet(String username);
   public Double calculeSalaireImposable(String username);

}
