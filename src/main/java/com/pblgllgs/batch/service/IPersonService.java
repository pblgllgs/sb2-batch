package com.pblgllgs.batch.service;
/*
 *
 * @author pblgl
 * Created on 02-02-2024
 *
 */

import com.pblgllgs.batch.entities.Person;

import java.util.List;

public interface IPersonService {

    void saveAll(List<Person> persons);

}
