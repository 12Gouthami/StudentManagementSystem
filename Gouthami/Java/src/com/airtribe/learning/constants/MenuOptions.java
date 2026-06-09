package com.airtribe.learning.constants;

public class MenuOptions {

    // -------- com.airtribe.learning.ui.Main Menu --------
    public static final int STUDENT_MANAGEMENT = 1;
    public static final int COURSE_MANAGEMENT = 2;
    public static final int ENROLLMENT_MANAGEMENT = 3;
    public static final int EXIT = 0;

    // -------- Student Menu --------
    public static final int ADD_STUDENT = 1;
    public static final int VIEW_STUDENTS = 2;
    public static final int SEARCH_STUDENT = 3;
    public static final int DEACTIVATE_STUDENT = 4;
    public static final int BACK = 0;

    // -------- Course Menu --------
    public static final int ADD_COURSE = 1;
    public static final int VIEW_COURSES = 2;
    public static final int TOGGLE_COURSE_STATUS = 3;

    // -------- Enrollment Menu --------
    public static final int ENROLL_STUDENT = 1;
    public static final int VIEW_ENROLLMENTS = 2;
    public static final int UPDATE_ENROLLMENT_STATUS = 3;

    // Private constructor to prevent object creation
    private MenuOptions() {
    }
}

