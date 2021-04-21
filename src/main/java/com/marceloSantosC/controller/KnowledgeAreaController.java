package com.marceloSantosC.controller;


import com.marceloSantosC.model.entity.KnowledgeArea;
import com.marceloSantosC.model.service.GenericService;
import com.marceloSantosC.model.service.KnowledgeAreaService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.io.Serializable;

@Controller
@RequestMapping(value = "/knowledgeareas", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class KnowledgeAreaController extends DefaultRestController<KnowledgeArea, Long> {

    private KnowledgeAreaService service;

    @Autowired
    public void setService(KnowledgeAreaService service) { this.service = service; }

    @Override
    public GenericService<KnowledgeArea, Long> getService() {
        return this.service;
    }
}
