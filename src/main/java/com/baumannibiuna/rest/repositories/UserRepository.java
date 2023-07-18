package com.baumannibiuna.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baumannibiuna.rest.models.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
