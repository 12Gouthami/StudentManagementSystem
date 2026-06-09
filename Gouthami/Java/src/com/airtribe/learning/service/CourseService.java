package com.airtribe.learning.service;

import com.airtribe.learning.entity.Course;
import com.airtribe.learning.exception.EntityNotFoundException;
import com.airtribe.learning.repository.CourseRepository;
import com.airtribe.learning.util.IdGenerator;

import java.util.List;

public class CourseService {
    private CourseRepository repository = new CourseRepository();

    // Add course
    public void addCourse(String name, String description, int durationInWeeks) {
        int id = IdGenerator.getNextCourseId();
        Course course = new Course(id, name, description, durationInWeeks);
        repository.save(course);
    }

    // List all courses
    public List<Course> listCourses() {
        return repository.findAll();
    }

    // Find course by ID
    public Course findCourseById(int id) {
        Course course = repository.findById(id);
        if (course == null) {
            throw new EntityNotFoundException("Course not found with ID: " + id);
        }
        return course;
    }

    // Activate / Deactivate course
    public void toggleCourseStatus(int id) {
        Course course = findCourseById(id);
        course.setActive(!course.isActive());
    }
}
