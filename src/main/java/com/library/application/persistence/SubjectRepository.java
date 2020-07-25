package com.library.application.persistence;

import org.springframework.data.repository.CrudRepository;

import com.library.application.domain.Subject;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface SubjectRepository extends CrudRepository<Subject, Integer> {

}