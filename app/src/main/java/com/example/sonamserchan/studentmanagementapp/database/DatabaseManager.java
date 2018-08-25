package com.example.sonamserchan.studentmanagementapp.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager {
    private Integer mOpenCounter = 0;

    private static DatabaseManager instance;
    private static SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public static synchronized void intializeInstance(SQLiteOpenHelper mSqLiteOpenHelper){
        if(instance == null){
            instance = new DatabaseManager();
            sqLiteOpenHelper = mSqLiteOpenHelper;
        }
    }

    public static synchronized DatabaseManager getInstance(){
        if(instance == null){
            throw new IllegalStateException(DatabaseManager.class.getSimpleName() +
            " is not initialized, call initializeInstance(..) method first. ");
        }
        return instance;
    }

    public synchronized SQLiteDatabase openDatabase(){
        mOpenCounter += 1;
        if(mOpenCounter == 1){
            //Opening new database
            sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
        }
        return sqLiteDatabase;
    }

    public synchronized void closeDatabase(){
        mOpenCounter -= 1;
        if(mOpenCounter == 0){
            //closing database
            sqLiteDatabase.close();
        }
    }
}
