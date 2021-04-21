package com.marceloSantosC.model.service.impl;

import com.marceloSantosC.model.dao.GenericDao;
import com.marceloSantosC.model.dao.InstructorDao;
import com.marceloSantosC.model.entity.Instructor;
import com.marceloSantosC.model.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorServiceImpl extends GenericServiceImpl<Instructor, Long> implements InstructorService {

    private InstructorDao dao;

    @Autowired
    public void setDao(InstructorDao dao) { this.dao = dao; }

    @Override
    public GenericDao<Instructor, Long> getDao() {
        return this.dao;
    }
}
