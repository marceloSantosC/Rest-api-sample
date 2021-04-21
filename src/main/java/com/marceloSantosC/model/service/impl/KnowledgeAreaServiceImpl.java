package com.marceloSantosC.model.service.impl;


import com.marceloSantosC.model.dao.GenericDao;
import com.marceloSantosC.model.dao.KnowledgeAreaDao;
import com.marceloSantosC.model.entity.KnowledgeArea;
import com.marceloSantosC.model.service.GenericService;
import com.marceloSantosC.model.service.KnowledgeAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KnowledgeAreaServiceImpl extends GenericServiceImpl<KnowledgeArea, Long> implements KnowledgeAreaService {

    private KnowledgeAreaDao dao;

    @Autowired
    public void setDao(KnowledgeAreaDao dao) { this.dao = dao; }

    @Override
    public GenericDao<KnowledgeArea, Long> getDao() { return this.dao; }
}
