package com.baumannibiuna.rest.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baumannibiuna.rest.exceptions.ResourceNotFoundException;
import com.baumannibiuna.rest.models.Person;
import com.baumannibiuna.rest.repositories.PersonRepository;


//Classe responsavel por persistir os dados na base de dados
@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public List<Person> findAll() {

		logger.info("Finding All persons!");

		return repository.findAll();
	}

	public Person findById(Long id) {

		logger.info("Finding one person!");
		// conexao com o banco

		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}

	public Person create(Person person) {

		logger.info("Finding One persons!");
		// conexao com o banco
		return repository.save(person);
	}

	public Person update(Person person) {

		logger.info("Updating One persons!");
		// conexao com o banco
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return repository.save(person);
	}

	public void delete(Long id) {

		// conexao com o banco
		logger.info("Deleting One persons!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);

	}

}
