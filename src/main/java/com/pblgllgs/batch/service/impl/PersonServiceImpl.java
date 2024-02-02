package com.pblgllgs.batch.service.impl;
/*
 *
 * @author pblgl
 * Created on 02-02-2024
 *
 */

import com.pblgllgs.batch.entities.Person;
import com.pblgllgs.batch.persistence.IPersonDAO;
import com.pblgllgs.batch.service.IPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements IPersonService {

    private final IPersonDAO iPersonDAO;

    @Override
    @Transactional
    public void saveAll(List<Person> persons) {
        iPersonDAO.saveAll(persons);
    }
}
