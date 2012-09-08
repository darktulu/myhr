package com.wadia.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.TypeAbsence;
import com.wadia.repos.TypeAbsenceRepos;
import com.wadia.service.TypeAbsenceService;

@Transactional
@Service("typeAbsenceService")
public class TypeAbsenceServiceImpl implements TypeAbsenceService {

    @Inject
    private TypeAbsenceRepos typeAbsenceRepos;

    @Override
    public boolean existTypeAbsence(TypeAbsence type) {
	List<TypeAbsence> result = typeAbsenceRepos.findByName(type.getName());
	if (result == null || result.size() == 0)
	    return false;
	else
	    return true;
    }

    @Override
    public TypeAbsence addTypeAbsence(TypeAbsence type) {
	return typeAbsenceRepos.save(type);
    }

    @Override
    public void deleteTypeAbsence(TypeAbsence type) {
	typeAbsenceRepos.delete(type);
    }

    @Override
    public TypeAbsence updateTypeAbsence(TypeAbsence type) {
	return typeAbsenceRepos.save(type);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TypeAbsence> loadTypeAbsence() {
	List<TypeAbsence> result = new ArrayList<TypeAbsence>();
	result = typeAbsenceRepos.findAll();
	return result;
    }

    @Override
    public TypeAbsence findOne(int id) {
	return typeAbsenceRepos.findOne(id);
    }
}
