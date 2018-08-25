package com.example.sonamserchan.studentmanagementapp.app;

import android.app.Application;
import android.content.Context;

import com.example.sonamserchan.studentmanagementapp.database.DatabaseHelper;
import com.example.sonamserchan.studentmanagementapp.database.DatabaseManager;

public class App extends Application {
    private static Context context;
    private static DatabaseHelper dbHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        dbHelper = new DatabaseHelper();
        DatabaseManager.intializeInstance(dbHelper);
    }

    public static Context getContext(){
        return context;
    }
}
