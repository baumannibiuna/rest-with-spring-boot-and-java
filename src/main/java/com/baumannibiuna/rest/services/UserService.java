package com.baumannibiuna.rest.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baumannibiuna.rest.exceptions.ResourceNotFoundException;
import com.baumannibiuna.rest.models.User;
import com.baumannibiuna.rest.repositories.UserRepository;


//Classe responsavel por persistir os dados na base de dados
@Service
public class UserService {

	private Logger logger = Logger.getLogger(UserService.class.getName());

	@Autowired
	UserRepository repository;

	public List<User> findAll() {
		logger.info("Finding All users!");
		return repository.findAll();
	}

	public User findById(Long id) {
		logger.info("Finding one user!");
		// conexao com o banco
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}

	public User create(User user) {
		logger.info("Created new user!");
		return repository.save(user);
	}

	public User update(User user) {
		logger.info("Updating One users!");
		var entity = repository.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		entity.setNome(user.getNome());
		entity.setEmail(user.getEmail());
		entity.setSenha(user.getSenha());
		return repository.save(user);
	}

	public void delete(Long id) {
		logger.info("Deleting One users!");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);

	}

}
