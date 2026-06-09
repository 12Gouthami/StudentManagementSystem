package com.airtribe.learning.util;

public class IdGenerator {
    // Static counters (application-wide)
    private static int studentIdCounter = 1000;
    private static int courseIdCounter = 2000;
    private static int enrollmentIdCounter = 3000;

    // Static methods
    public static int getNextStudentId() {
        return ++studentIdCounter;
    }

    public static int getNextCourseId() {
        return ++courseIdCounter;
    }

    public static int getNextEnrollmentId() {
        return ++enrollmentIdCounter;
    }
}
