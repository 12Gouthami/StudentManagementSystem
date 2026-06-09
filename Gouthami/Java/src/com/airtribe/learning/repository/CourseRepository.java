package com.airtribe.learning.repository;

import com.airtribe.learning.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private List<Course> courses = new ArrayList<>();

    // Save a new course
    public void save(Course course) {
        courses.add(course);
    }

    // Find course by ID
    public Course findById(int id) {
        for (Course c : courses) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    // Return all courses
    public List<Course> findAll() {
        return courses;
    }
}
