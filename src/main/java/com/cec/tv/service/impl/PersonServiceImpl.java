package com.cec.tv.service.impl;

import com.cec.tv.dao.PersonMapper;
import com.cec.tv.model.Person;
import com.cec.tv.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {


    @Autowired
    PersonMapper personMapper;
    @Override
    public int commitPersonDetailInformation(Person person) {
        return personMapper.insert(person);
    }
}
