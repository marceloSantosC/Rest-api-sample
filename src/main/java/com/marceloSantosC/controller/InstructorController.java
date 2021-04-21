package com.marceloSantosC.controller;

import com.marceloSantosC.model.entity.Instructor;
import com.marceloSantosC.model.service.GenericService;
import com.marceloSantosC.model.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/instructors", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class InstructorController extends DefaultRestController<Instructor, Long> {

    private InstructorService service;

    @Autowired
    public void setService(InstructorService service) { this.service = service; }


    @Override
    public GenericService<Instructor, Long> getService() {
        return this.service;
    }
}
