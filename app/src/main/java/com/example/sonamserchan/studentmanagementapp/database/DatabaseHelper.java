package com.example.sonamserchan.studentmanagementapp.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.sonamserchan.studentmanagementapp.app.App;
import com.example.sonamserchan.studentmanagementapp.model.Student;
import com.example.sonamserchan.studentmanagementapp.repo.StudentRepo;

public class DatabaseHelper extends SQLiteOpenHelper {

    //version number to upgrade database version
    //each time if you add, edit table, you need to change the version number
    private static final int DATABASE_VERSION = 1;

    //database name
    private static final String DATABASE_NAME = "studentManagementDB.db";
    private static final String TAG = DatabaseHelper.class.getSimpleName();

    public DatabaseHelper(){
        super(App.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //All the necessary tables to create will be created here
        sqLiteDatabase.execSQL(StudentRepo.createTable());
        //and the rest
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.d(TAG, String.format("SQLiteDatabase.onUpgrade(%d -> %d)", oldVersion, newVersion));

        //drop tables if exist
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Student.TABLE);
        //and the rest
        onCreate(sqLiteDatabase);
    }
}
