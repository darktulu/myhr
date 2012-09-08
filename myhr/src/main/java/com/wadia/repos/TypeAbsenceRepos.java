package com.wadia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wadia.beans.TypeAbsence;

public interface TypeAbsenceRepos extends JpaRepository<TypeAbsence, Integer>{

    public List<TypeAbsence> findByName(String name);

}
