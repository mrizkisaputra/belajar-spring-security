package com.mrizkisaputra.controllers;

import com.mrizkisaputra.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class ApiStudentController {
    @Autowired StudentService studentService;

    @GetMapping(path = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> student(@PathVariable(name = "id") String idStudent) {
        return studentService.getStudentById(idStudent);
    }

    @GetMapping(path = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> students() {
        return studentService.getStudents();
    }
}
