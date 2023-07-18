package com.baumannibiuna.rest.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baumannibiuna.rest.exceptions.ResourceNotFoundException;
import com.baumannibiuna.rest.models.Order;
import com.baumannibiuna.rest.repositories.OrderRepository;


//Classe responsavel por persistir os dados na base de dados
@Service
public class OrderService {

	private Logger logger = Logger.getLogger(OrderService.class.getName());

	@Autowired
	OrderRepository repository;

	public List<Order> findAll() {
		logger.info("Finding All orders!");
		return repository.findAll();
	}

	public Order findById(Long id) {
		logger.info("Finding one order!");
		// conexao com o banco
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}

	public Order create(Order order) {
		logger.info("Finding One orders!");
		return repository.save(order);
	}

	public Order update(Order order) {
		logger.info("Updating One orders!");
		var entity = repository.findById(order.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		entity.setClient(order.getClient());
		entity.setInstant(order.getInstant());
		return repository.save(order);
	}

	public void delete(Long id) {
		logger.info("Deleting One orders!");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);

	}

}
