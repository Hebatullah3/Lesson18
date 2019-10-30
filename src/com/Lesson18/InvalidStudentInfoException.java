package com.Lesson18;

public class InvalidStudentInfoException  extends Exception {

    String firstName;
    String lastName;
    String course;
    int age;

    InvalidStudentInfoException() {

    }

    InvalidStudentInfoException(String msg) {
        super(msg);
    }
}
