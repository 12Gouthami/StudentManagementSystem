package com.airtribe.learning.service;

import com.airtribe.learning.entity.Enrollment;
import com.airtribe.learning.exception.EntityNotFoundException;
import com.airtribe.learning.repository.EnrollmentRepository;
import com.airtribe.learning.util.IdGenerator;

import java.util.List;

public class EnrollmentService {
    private EnrollmentRepository repository = new EnrollmentRepository();

    // Enroll student in a course
    public void enrollStudent(int studentId, int courseId) {
        int id = IdGenerator.getNextEnrollmentId();
        Enrollment enrollment = new Enrollment(id, studentId, courseId, "ACTIVE");
        repository.save(enrollment);
    }

    // Get enrollments for a student
    public List<Enrollment> getEnrollmentsForStudent(int studentId) {
        return repository.findByStudentId(studentId);
    }

    // Update enrollment status
    public void updateStatus(int enrollmentId, String status) {
        Enrollment enrollment = repository.findById(enrollmentId);

        if (enrollment == null) {
            throw new EntityNotFoundException("Enrollment not found with ID: " + enrollmentId);
        }

        enrollment.setStatus(status);
    }
}
