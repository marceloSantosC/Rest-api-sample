package com.marceloSantosC.model.service.impl;

import com.marceloSantosC.model.dao.CourseDao;
import com.marceloSantosC.model.dao.GenericDao;
import com.marceloSantosC.model.entity.Course;
import com.marceloSantosC.model.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends GenericServiceImpl<Course, Long> implements CourseService {

    private CourseDao dao;

    @Autowired
    public void setDao(CourseDao dao) {this.dao = dao;}

    @Override
    public GenericDao<Course, Long> getDao() {
        return this.dao;
    }
}
