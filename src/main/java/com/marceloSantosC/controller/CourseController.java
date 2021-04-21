package com.marceloSantosC.controller;

import com.marceloSantosC.model.entity.Course;
import com.marceloSantosC.model.service.CourseService;
import com.marceloSantosC.model.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/courses", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class CourseController extends DefaultRestController<Course, Long> {

    private CourseService service;

    @Autowired
    public void setService(CourseService service) { this.service = service; }

    @Override
    public GenericService<Course, Long> getService() {
        return this.service;
    }
}
