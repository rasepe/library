package com.library.application.persistence;

import org.springframework.data.repository.CrudRepository;

import com.library.application.domain.Author;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
