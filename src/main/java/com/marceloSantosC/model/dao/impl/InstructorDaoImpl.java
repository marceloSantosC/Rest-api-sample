package com.marceloSantosC.model.dao.impl;

import com.marceloSantosC.model.dao.InstructorDao;
import com.marceloSantosC.model.entity.Instructor;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorDaoImpl extends GenericDaoImpl<Instructor, Long> implements InstructorDao {

    @Override
    protected Class<Instructor> getEntityClass() {
        return Instructor.class;
    }

}
