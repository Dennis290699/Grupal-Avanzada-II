package com.programacion.repository;

import com.programacion.db.Author;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface AuthorRepository extends EntityRepository<Author, Integer> {
}

