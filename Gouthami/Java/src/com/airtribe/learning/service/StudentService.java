package com.airtribe.learning.service;

import com.airtribe.learning.entity.Student;
import com.airtribe.learning.exception.EntityNotFoundException;
import com.airtribe.learning.repository.StudentRepository;
import com.airtribe.learning.util.IdGenerator;

import java.util.List;

public class StudentService {
    private StudentRepository repository = new StudentRepository();

    // Add student (without email)
    public void addStudent(String firstName, String lastName, String batch) {
        int id = IdGenerator.getNextStudentId();
        Student student = new Student(id, firstName, lastName, batch);
        repository.save(student);
    }

    // List all students
    public List<Student> listStudents() {
        return repository.findAll();
    }

    // Find student by ID
    public Student findStudentById(int id) {
        Student student = repository.findById(id);
        if (student == null) {
            throw new EntityNotFoundException("Student not found with ID: " + id);
        }
        return student;
    }

    // Deactivate student (soft delete)
    public void removeStudent(int id) {
        Student student = findStudentById(id);
        student.setActive(false);
    }
}
