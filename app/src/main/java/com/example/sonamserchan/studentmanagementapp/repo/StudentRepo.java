package com.example.sonamserchan.studentmanagementapp.repo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.text.TextUtils;
import android.util.Log;

import com.example.sonamserchan.studentmanagementapp.database.DatabaseManager;
import com.example.sonamserchan.studentmanagementapp.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepo {

    private Student student;
    private final String TAG = StudentRepo.class.getSimpleName().toString();

    public StudentRepo() {
        student = new Student();
    }

    public static String createTable() {
        String query = "CREATE TABLE " + Student.TABLE + "(" + Student.KEY_StudentId +
                " INTEGER PRIMARY KEY , " + Student.KEY_FirstName + " TEXT, " +
                Student.KEY_LastName + " TEXT, " + Student.KEY_Gender + " TEXT, " +
                Student.KEY_CourseStudy + " TEXT, " + Student.KEY_Age + " INTEGER, " +
                Student.KEY_Address + " TEXT );";
        return query;
    }

    public void insert(Student student) {
        //int studentId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Student.KEY_StudentId, student.getStudentId());
        values.put(Student.KEY_FirstName, student.getFirstName());
        values.put(Student.KEY_LastName, student.getLastName());
        values.put(Student.KEY_Gender, student.getGender());
        values.put(Student.KEY_CourseStudy, student.getCourseStudy());
        values.put(Student.KEY_Age, student.getAge());
        values.put(Student.KEY_Address, student.getAddress());

        //inserting row
        db.insert(Student.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();
        //return studentId;
    }

    public void update(Student student) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Student.KEY_StudentId, student.getStudentId());
        values.put(Student.KEY_FirstName, student.getFirstName());
        values.put(Student.KEY_LastName, student.getLastName());
        values.put(Student.KEY_Gender, student.getGender());
        values.put(Student.KEY_CourseStudy, student.getCourseStudy());
        values.put(Student.KEY_Age, student.getAge());
        values.put(Student.KEY_Address, student.getAddress());

        String studentId = String.valueOf(student.getStudentId());
        //updating row
        db.update(Student.TABLE, values, Student.KEY_StudentId + " = ?", new String[]{studentId});
        DatabaseManager.getInstance().closeDatabase();
    }

    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<Student>();

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        String selectQuery = "SELECT " + Student.KEY_StudentId + ", " + Student.KEY_FirstName
                + ", " + Student.KEY_LastName + ", " + Student.KEY_Gender + ", " + Student.KEY_CourseStudy
                + ", " + Student.KEY_Age + ", " + Student.KEY_Address + " FROM " + Student.TABLE;
        Log.d(TAG, selectQuery);
        Cursor cursor = db.rawQuery(selectQuery, null);
        //looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                student = new Student();
                student.setStudentId(cursor.getInt(0));
                student.setFirstName(cursor.getString(cursor.getColumnIndex(Student.KEY_FirstName)));
                student.setLastName(cursor.getString(cursor.getColumnIndex(Student.KEY_LastName)));
                student.setGender(cursor.getString(cursor.getColumnIndex(Student.KEY_Gender)));
                student.setCourseStudy(cursor.getString(cursor.getColumnIndex(Student.KEY_CourseStudy)));
                student.setAge(cursor.getInt(5));
                student.setAddress(cursor.getString(cursor.getColumnIndex(Student.KEY_Address)));

                studentList.add(student);
            } while (cursor.moveToNext());
        }
        cursor.close();
        DatabaseManager.getInstance().closeDatabase();
        return studentList;
    }

    public void delete(List<String> studentId) {
        String args = TextUtils.join(", ", studentId);
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Student.TABLE, Student.KEY_StudentId + " IN (" + args + ")", null);
        DatabaseManager.getInstance().closeDatabase();
    }

}
