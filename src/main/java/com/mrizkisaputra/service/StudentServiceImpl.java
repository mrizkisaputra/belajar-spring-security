package com.mrizkisaputra.service;

import com.mrizkisaputra.model.entity.Student;
import com.mrizkisaputra.model.response.ApiSuccessResponse;
import com.mrizkisaputra.model.response.PagingResponse;
import com.mrizkisaputra.repository.StudentRepository;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Locale;


@Service
public class StudentServiceImpl implements StudentService, MessageSourceAware {
    private final StudentRepository repository;
    private MessageSource messageSource;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<Object> getStudentById(String idStudent) {
        Student student = repository.findById(idStudent)
                .orElseThrow(() -> {
                    return new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            messageSource.getMessage("api.response.error.student.notfound", new Object[]{idStudent}, null));
                });
        ApiSuccessResponse<Student> response = new ApiSuccessResponse<>(
                HttpStatus.OK,
                messageSource.getMessage("api.response.success.message", null, Locale.getDefault()),
                List.of(student),
                null
        );
        return buildResponseEntity(response);
    }

    @Override
    public ResponseEntity<Object> getStudents() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Student> students = repository.findAll(pageable);
        PagingResponse pagingResponse = new PagingResponse(students.getTotalElements(), students.getTotalPages(), students.getSize());
        ApiSuccessResponse<Student> response = new ApiSuccessResponse<>(
                HttpStatus.OK,
                messageSource.getMessage("api.response.success.message", null, Locale.getDefault()),
                students.toList(),
                pagingResponse
        );
        return buildResponseEntity(response);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiSuccessResponse<Student> response) {
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
