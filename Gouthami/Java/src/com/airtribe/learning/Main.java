package com.airtribe.learning;

import com.airtribe.learning.exception.EntityNotFoundException;
import com.airtribe.learning.service.CourseService;
import com.airtribe.learning.service.EnrollmentService;
import com.airtribe.learning.service.StudentService;
import com.airtribe.learning.util.InputValidator;

import java.util.Scanner;

import static com.airtribe.learning.constants.AppConstant.*;
import static com.airtribe.learning.constants.MenuOptions.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        boolean exit = false;

        while (!exit) {
            System.out.println(MAIN_MENU_TITLE);
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = InputValidator.validateInt(scanner.nextLine());

                switch (choice) {
                    case STUDENT_MANAGEMENT -> studentMenu(scanner, studentService);
                    case COURSE_MANAGEMENT -> courseMenu(scanner, courseService);
                    case ENROLLMENT_MANAGEMENT -> enrollmentMenu(scanner, enrollmentService);
                    case EXIT -> {
                        exit = true;
                        System.out.println(EXIT_MESSAGE);
                    }
                    default -> System.out.println(INVALID_OPTION);
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }

    // ================= STUDENT MENU =================

    private static void studentMenu(Scanner scanner, StudentService studentService) {

        boolean back = false;

        while (!back) {
            System.out.println(STUDENT_MENU_TITLE);
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Deactivate Student");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");

            try {
                int choice = InputValidator.validateInt(scanner.nextLine());

                switch (choice) {
                    case ADD_STUDENT -> {
                        System.out.print("First Name: ");
                        String fn = InputValidator.validateString(scanner.nextLine(), "First Name");

                        System.out.print("Last Name: ");
                        String ln = InputValidator.validateString(scanner.nextLine(), "Last Name");

                        System.out.print("Batch: ");
                        String batch = InputValidator.validateString(scanner.nextLine(), "Batch");

                        studentService.addStudent(fn, ln, batch);
                        System.out.println("Student added successfully.");
                    }

                    case VIEW_STUDENTS ->
                            studentService.listStudents()
                                    .forEach(s -> System.out.println(
                                            s.getId() + " | " + s.getDisplayName() +
                                                    " | Active: " + s.isActive()));

                    case SEARCH_STUDENT -> {
                        System.out.print("Enter Student ID: ");
                        int id = InputValidator.validateInt(scanner.nextLine());
                        System.out.println(studentService.findStudentById(id).getDisplayName());
                    }

                    case DEACTIVATE_STUDENT -> {
                        System.out.print("Enter Student ID: ");
                        int id = InputValidator.validateInt(scanner.nextLine());
                        studentService.removeStudent(id);
                        System.out.println("Student deactivated successfully.");
                    }

                    case BACK -> back = true;

                    default -> System.out.println(INVALID_OPTION);
                }

            } catch (IllegalArgumentException | EntityNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // ================= COURSE MENU =================

    private static void courseMenu(Scanner scanner, CourseService courseService) {

        boolean back = false;

        while (!back) {
            System.out.println(COURSE_MENU_TITLE);
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Activate / Deactivate Course");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");

            try {
                int choice = InputValidator.validateInt(scanner.nextLine());


                switch (choice) {
                    case ADD_COURSE -> {
                        System.out.print("Course Name: ");
                        String name = InputValidator.validateString(scanner.nextLine(), "Course Name");

                        System.out.print("Description: ");
                        String desc = InputValidator.validateString(scanner.nextLine(), "Description");

                        System.out.print("Duration (weeks): ");
                        int weeks = InputValidator.validateInt(scanner.nextLine());

                        courseService.addCourse(name, desc, weeks);
                        System.out.println("Course added successfully.");
                    }

                    case VIEW_COURSES ->
                            courseService.listCourses()
                                    .forEach(c -> System.out.println(
                                            c.getId() + " | " + c.getCourseName() +
                                                    " | Active: " + c.isActive()));

                    case TOGGLE_COURSE_STATUS -> {
                        System.out.print("Enter Course ID: ");
                        int id = InputValidator.validateInt(scanner.nextLine());
                        courseService.toggleCourseStatus(id);
                        System.out.println("Course status updated.");
                    }

                    case BACK -> back = true;

                    default -> System.out.println(INVALID_OPTION);
                }

            } catch (IllegalArgumentException | EntityNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // ================= ENROLLMENT MENU =================

    private static void enrollmentMenu(Scanner scanner, EnrollmentService enrollmentService) {

        boolean back = false;

        while (!back) {
            System.out.println(ENROLLMENT_MENU_TITLE);
            System.out.println("1. Enroll Student");
            System.out.println("2. View Enrollments by Student");
            System.out.println("3. Update Enrollment Status");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");

            try {
                int choice = InputValidator.validateInt(scanner.nextLine());

                switch (choice) {
                    case ENROLL_STUDENT -> {
                        System.out.print("Student ID: ");
                        int sid = InputValidator.validateInt(scanner.nextLine());

                        System.out.print("Course ID: ");
                        int cid = InputValidator.validateInt(scanner.nextLine());

                        enrollmentService.enrollStudent(sid, cid);
                        System.out.println("Enrollment successful.");
                    }

                    case VIEW_ENROLLMENTS -> {
                        System.out.print("Student ID: ");
                        int sid = InputValidator.validateInt(scanner.nextLine());

                        enrollmentService.getEnrollmentsForStudent(sid)
                                .forEach(e -> System.out.println(
                                        "Enrollment ID: " + e.getId() +
                                                " | Course ID: " + e.getCourseId() +
                                                " | Status: " + e.getStatus()));
                    }

                    case UPDATE_ENROLLMENT_STATUS -> {
                        System.out.print("Enrollment ID: ");
                        int eid = InputValidator.validateInt(scanner.nextLine());

                        System.out.print("New Status (ACTIVE / COMPLETED / CANCELLED): ");
                        String status = scanner.nextLine().toUpperCase();

                        if (!InputValidator.isValidStatus(status)) {
                            System.out.println(INVALID_OPTION);
                            break;
                        }

                        enrollmentService.updateStatus(eid, status);
                        System.out.println("Enrollment status updated.");
                    }

                    case BACK -> back = true;

                    default -> System.out.println(INVALID_OPTION);
                }

            } catch (IllegalArgumentException | EntityNotFoundException e) {
                System.out.println(e.getMessage());
            }

    }
    }
}