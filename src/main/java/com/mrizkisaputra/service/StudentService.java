package com.mrizkisaputra.service;

import org.springframework.http.ResponseEntity;

public interface StudentService {
    public ResponseEntity<Object> getStudentById(String idStudent);

    public ResponseEntity<Object> getStudents();
}
