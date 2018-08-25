package com.example.sonamserchan.studentmanagementapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        StudentFragment.OnFragmentInteractionListener,
        TodotasksFragment.OnFragmentInteractionListener,
        ExamFragment.OnFragmentInteractionListener,
        ImagesFragment.OnFragmentInteractionListener {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_student:
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    selectedFragment = StudentFragment.newInstance("Student","Information");
                    transaction.replace(R.id.content,selectedFragment);
                    transaction.commit();
                    return true;
                case R.id.navigation_to_do_tasks:
                    FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                    selectedFragment = TodotasksFragment.newInstance("TodoTasks", "Fragment");
                    transaction2.replace(R.id.content, selectedFragment);
                    transaction2.commit();
                    return true;
                case R.id.navigation_exam:
                    FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                    selectedFragment = ExamFragment.newInstance("Exam", "Fragment");
                    transaction3.replace(R.id.content, selectedFragment);
                    transaction3.commit();
                    return true;
                case R.id.navigation_image:
                    FragmentTransaction transaction4 = getSupportFragmentManager().beginTransaction();
                    selectedFragment = ImagesFragment.newInstance("Images", "Fragment");
                    transaction4.replace(R.id.content, selectedFragment);
                    transaction4.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, StudentFragment.newInstance("FirstStudent", "FragmentToDisplay"));
        transaction.commit();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void addStudent(View view){
        TextView textView = findViewById(R.id.textViewName);
        textView.setText("New Student Added - Sonam");
    }
}
