package com.javainuse.java;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javainuse.entity.User;

public interface CustomerRepository extends CrudRepository<User, Integer> {

    List<User> findByLastName(String lastName);
}
