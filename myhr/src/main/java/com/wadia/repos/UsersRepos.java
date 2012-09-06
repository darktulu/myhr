package com.wadia.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wadia.beans.Users;

@Repository("usersRepos")
public interface UsersRepos extends JpaRepository<Users, String>{

    public Users findByUsername(String username);
}
