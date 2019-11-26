package com.example.sonamserchan.studentmanagementapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sonamserchan.studentmanagementapp.model.Student;

public class StudentRecordActivity extends AppCompatActivity {

    TextView tvStId, tvStName, tvGender, tvCourse, tvAge, tvAddress;
    ImageView ivImage;
    Button btnMap;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_record);

        //enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvStId = findViewById(R.id.tvStId);
        tvStName = findViewById(R.id.tvStName);
        tvGender = findViewById(R.id.tvGender);
        tvCourse = findViewById(R.id.tvCourse);
        tvAge = findViewById(R.id.tvAge);
        tvAddress = findViewById(R.id.tvAddress);

        Bundle bundle = getIntent().getExtras();
        student = (Student)bundle.getSerializable("student");

        tvStId.setText(String.valueOf(student.getStudentId()));
        tvStName.setText(student.getFirstName()+" " + student.getLastName());
        tvGender.setText(student.getGender());
        tvCourse.setText(student.getCourseStudy());
        tvAge.setText(String.valueOf(student.getAge()));
        tvAddress.setText(student.getAddress());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                onBackPressed();;
                break;
            case R.id.menu_edit:
                editData();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("ItemPosition", 0);
        startActivity(intent);
    }

    public void editData(){
        Intent intent = new Intent(this, StudentAddActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("student", student);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
