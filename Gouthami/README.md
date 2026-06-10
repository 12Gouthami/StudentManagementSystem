
# LearnTrack - Student & Course Management System

## Project Description
LearnTrack is a console-based Student and Course Management System built using Core Java.
It allows admins to manage students, courses, and enrollments.

## Features
- Add new student
- View all students
- Search student by ID
- Deactivate student
- Add new course
- View all courses
- Activate/Deactivate course
- Enroll student in course
- View enrollments for a student
- Update enrollment status

## Technologies Used
- Core Java
- OOP
- ArrayList
- Exception Handling

## Project Structure
- entity
- repository
- service
- util
- exception
- constants
- enums

## How to Compile
```bash
javac -d out src/com/airtribe/learntrack/Main.java src/com/airtribe/learntrack/entity/*.java src/com/airtribe/learntrack/repository/*.java src/com/airtribe/learntrack/service/*.java src/com/airtribe/learntrack/exception/*.java src/com/airtribe/learntrack/util/*.java src/com/airtribe/learntrack/constants/*.java src/com/airtribe/learntrack/enums/*.java 
```

## OOP Concepts Used
- Encapsulation
- Inheritance
- Polymorphism
- Constructor Overloading

## Class Diagram

classDiagram

    class Person {
        id
        firstName
        lastName
        email
        getDisplayName()
    }

    class Student {
        batch
        active
    }

    class Course {
        id
        courseName
        description
        durationInWeeks
        active
    }

    class Enrollment {
        id
        studentId
        courseId
        enrollmentDate
        status
    }

    class StudentRepository
    class CourseRepository
    class EnrollmentRepository

    class StudentService
    class CourseService
    class EnrollmentService

    class IdGenerator
    class InputValidator
    class EntityNotFoundException
    class InvalidInputException
    class EnrollmentStatus

    Person <|-- Student
    Enrollment --> EnrollmentStatus

    StudentService --> StudentRepository
    CourseService --> CourseRepository
    EnrollmentService --> EnrollmentRepository

    EnrollmentService --> StudentService
    EnrollmentService --> CourseService

    Enrollment --> Student : studentId
    Enrollment --> Course : courseId


### Diagram Explanation

- `Student` inherits common properties like `id`, `firstName`, `lastName`, and `email` from `Person`.
- `Enrollment` links a student and a course using `studentId` and `courseId`.
- Service classes contain business logic and use repository classes for in-memory data storage.
- Utility classes like `IdGenerator` and `InputValidator` help with reusable common functionality.
  ``


