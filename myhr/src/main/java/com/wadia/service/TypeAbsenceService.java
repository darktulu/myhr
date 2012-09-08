package com.wadia.service;

import java.util.List;

import com.wadia.beans.TypeAbsence;

public interface TypeAbsenceService {

    public List<TypeAbsence> loadTypeAbsence();

    public TypeAbsence updateTypeAbsence(TypeAbsence type);
    
    public TypeAbsence findOne(int id);

    public void deleteTypeAbsence(TypeAbsence type);

    public TypeAbsence addTypeAbsence(TypeAbsence type);

    public boolean existTypeAbsence(TypeAbsence type);

}
