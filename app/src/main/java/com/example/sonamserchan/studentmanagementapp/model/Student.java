package com.example.sonamserchan.studentmanagementapp.model;

import java.util.ArrayList;

public class Student {

    public static final String TAG = Student.class.getSimpleName();
    public static final String TABLE = "Student";

    //labels Table Columns names
    public static final String KEY_StudentId = "StudentId";
    public static final String KEY_FirstName = "FirstName";
    public static final String KEY_LastName = "LastName";
    public static final String KEY_Gender = "Gender";
    public static final String KEY_CourseStudy = "CourseStudy";
    public static final String KEY_Age = "Age";
    public static final String KEY_Address = "Address";

    //declare private data instead of public to ensure the privacy of data field of each class
    private int studentId;
    private String firstName;
    private String lastName;
    private String gender;
    private String courseStudy;
    private int age;
    private String address;

    //retrieve student's ID
    public int getStudentId(){
        return studentId;
    }

    //set student's ID
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }

    //retrieve student's first name
    public String getFirstName() {
        return firstName;
    }

    //set student's first name
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    //retrieve student's last name
    public String getLastName() {
        return lastName;
    }

    //set student's last name
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    //retrieve student's gender
    public String getGender() {
        return gender;
    }

    //set student's gender
    public void setGender(String gender){
        this.gender = gender;
    }

    //retrieve student's course study
    public String getCourseStudy() {
        return courseStudy;
    }

    //set student's course study
    public void setCourseStudy(String courseStudy){
        this.courseStudy = courseStudy;
    }

    //retrieve student's age
    public int getAge() {
        return age;
    }

    //set student's age
    public void setAge(int age){
        this.age = age;
    }

    //retrieve student's address
    public String getAddress() {
        return address;
    }

    //set student's address
    public void setAddress(String address){
        this.address = address;
    }

}
