package com.library.application.persistence;

import org.springframework.data.repository.CrudRepository;

import com.library.application.domain.SongVersion;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface SongVersionRepository extends CrudRepository<SongVersion, Integer> {

}