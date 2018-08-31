package com.example.sonamserchan.studentmanagementapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        StudentFragment.OnFragmentInteractionListener,
        TodotasksFragment.OnFragmentInteractionListener,
        ExamFragment.OnFragmentInteractionListener,
        ImagesFragment.OnFragmentInteractionListener {

    BottomNavigationView bottomNavigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_student:
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    selectedFragment = StudentFragment.newInstance("Student", "Information");
                    transaction.replace(R.id.content, selectedFragment);
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

        bottomNavigationView = findViewById(R.id.navigation);

        int itemPosition = 0;

        Bundle extras = savedInstanceState != null ? savedInstanceState : getIntent().getExtras();
        if (extras != null) {
            itemPosition = extras.getInt("ItemPosition");
        }
        switch (itemPosition) {
            case 0:
                goToFragment(new StudentFragment(), itemPosition,false);
                break;
            case 1:
                goToFragment(new TodotasksFragment(), itemPosition,false);
                break;
            case 2:
                goToFragment(new ExamFragment(),itemPosition, false);
                break;
            case 3:
                goToFragment(new ImagesFragment(),itemPosition, false);
                break;
        }

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private void goToFragment(Fragment fragment, int itemPosition, boolean addToBackStack){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(addToBackStack){
            transaction.addToBackStack(null);
        }
        transaction.replace(R.id.content, fragment);
        transaction.commit();
        bottomNavigationView.getMenu().getItem(itemPosition).setChecked(true);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
