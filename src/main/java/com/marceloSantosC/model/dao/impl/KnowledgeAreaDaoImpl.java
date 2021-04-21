package com.marceloSantosC.model.dao.impl;


import com.marceloSantosC.model.dao.KnowledgeAreaDao;
import com.marceloSantosC.model.entity.KnowledgeArea;
import org.springframework.stereotype.Repository;

@Repository
public class KnowledgeAreaDaoImpl extends GenericDaoImpl<KnowledgeArea, Long> implements KnowledgeAreaDao {

    @Override
    protected Class<KnowledgeArea> getEntityClass() { return KnowledgeArea.class; }
}
