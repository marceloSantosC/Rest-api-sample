package com.marceloSantosC.model.dao.impl;

import com.marceloSantosC.model.dao.CourseDao;
import com.marceloSantosC.model.entity.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Repository
public class CourseDaoImpl extends GenericDaoImpl<Course, Long> implements CourseDao {


    @Override
    protected Class<Course> getEntityClass() {
        return Course.class;
    }

    @Override
    public Course getById(Long id) {
        String queryText = "FROM Course c JOIN FETCH c.knowledgeArea LEFT JOIN FETCH c.instructors WHERE c.id = :id";

        
        TypedQuery<Course> query = this.getEntityManager()
                .createQuery(queryText, Course.class)
                .setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        }
    }
}
