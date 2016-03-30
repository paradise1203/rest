package com.aidar.controller;

import com.aidar.model.Student;
import com.aidar.repository.StudentRepository;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by paradise on 30.03.16.
 */
@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        return studentRepository.findOne(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ObjectNode addStudent(@ModelAttribute Student student) {
        Student s = studentRepository.save(student);
        ObjectNode response = new ObjectNode(JsonNodeFactory.instance);
        response.put("id", s.getId());
        response.put("status", "success");
        return response;
    }

}
