package com.example.crud.service;

import com.example.crud.entity.Student;
import com.example.crud.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.example.crud.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        logger.info("Fetching all students");
        return repository.findAll();
    }

    public Student createStudent(Student student) {
        logger.info("Creating student: {}", student.getName());
        try {
            return repository.save(student);
        } catch (Exception e) {
            logger.error("Error while creating student", e);
            throw e;
        }
    }

    public Student getStudentById(Long id) {
        logger.info("Fetching student with ID: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Student not found with ID: {}", id);
                    return new ResourceNotFoundException("Student not found with id: " + id);
                });
    }

    public Student updateStudent(Long id, Student student) {
        logger.info("Updating student with ID: {}", id);

        Student existing = repository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Student not found for update with ID: {}", id);
                    return new ResourceNotFoundException("Student not found with id: " + id);
                });

        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setCourse(student.getCourse());
        existing.setFee(student.getFee());

        return repository.save(existing);
    }

    public void deleteStudent(Long id) {
        logger.warn("Deleting student with ID: {}", id);
        Student student = repository.findById(id)
                .orElseThrow(() -> {
                    logger.error("student not found for deletion with ID : {}", id);
                    return new ResourceNotFoundException("student not found with ID : " + id);
                });
        repository.delete(student);
    }
}