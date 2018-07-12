package com.javainuse.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javainuse.entity.Transaction;
import com.javainuse.entity.User;

@Service
@Transactional(
		propagation = Propagation.SUPPORTS,
		readOnly = true)
public class UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TransactionService transactionService;
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll()
		.forEach(users::add);
		return users;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void addUser(User user) {
		Transaction transaction = new Transaction();
		user.setId(23);
		try {
			userRepository.save(user);
			transaction.setMessage(user.getLastName() +" was added succesfuly");
			transaction.setAction("SAVE");
			transaction.setStatus("COMMIT");
			transactionService.addTransaction(transaction);
		}catch(RuntimeException e) {
			transaction.setMessage(user.getLastName() +" was not added succesfuly");
			transaction.setAction("SAVE");
			transaction.setStatus("ROLLBACK");
			transactionService.addTransaction(transaction);
		}
	}

	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	public Optional<User> getUser(Integer id) {
		return userRepository.findById(id);
	}
	
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
}
