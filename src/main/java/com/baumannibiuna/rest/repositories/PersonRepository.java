package com.baumannibiuna.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baumannibiuna.rest.models.Person;


public interface PersonRepository extends JpaRepository<Person, Long>{

}
