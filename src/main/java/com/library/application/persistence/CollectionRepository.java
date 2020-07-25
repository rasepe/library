package com.library.application.persistence;

import org.springframework.data.repository.CrudRepository;

import com.library.application.domain.Collection;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CollectionRepository extends CrudRepository<Collection, Integer> {

}