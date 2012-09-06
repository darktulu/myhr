package com.wadia.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wadia.beans.Abscence;

public interface AbscenceRepos extends JpaRepository<Abscence, Integer> {

    public Abscence findById(Integer id);
}
