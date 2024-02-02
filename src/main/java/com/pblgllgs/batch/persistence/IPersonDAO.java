package com.pblgllgs.batch.persistence;

import com.pblgllgs.batch.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface IPersonDAO extends CrudRepository<Person, Long> {
}
