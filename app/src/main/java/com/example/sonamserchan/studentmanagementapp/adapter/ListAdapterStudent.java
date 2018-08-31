package com.example.sonamserchan.studentmanagementapp.adapter;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.sonamserchan.studentmanagementapp.R;
import com.example.sonamserchan.studentmanagementapp.model.Student;

import java.util.ArrayList;
import java.util.List;

public class ListAdapterStudent extends ArrayAdapter<Student> {

    /*Declaring variables that are properties of this class*/

    //to reference the activity
    private final Context context;
    private Student student;

    //View lookup cache
    static class ViewHolder {
        TextView tvId, tvName;
        CheckBox cbStudent;
    }

    ViewHolder viewHolder; //view lookup cache stored in tage

    //boolean array for storing the state of each checkbox
    boolean[] checkBoxState;

    //SparseBooleanArray selectedStrings ;

    public ListAdapterStudent(Context context, List<Student> students) {
        super(context, R.layout.listview_student, students);
        this.context = context;
        checkBoxState = new boolean[students.size()];
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //Get the data item for this position
        student = getItem(position);
        //Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            //If there's no view to re-use, inflate a brand new view for row
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_student, parent, false);

            viewHolder = new ViewHolder();
            //cache the views
            viewHolder.tvId = convertView.findViewById(R.id.tVID);
            viewHolder.tvName = convertView.findViewById(R.id.tvName);
            viewHolder.cbStudent = convertView.findViewById(R.id.cbStudent);

            //link the cached views to the viewholder
            convertView.setTag(viewHolder); //cache the viewHolder object inside the fresh view

        } else {
            //View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if(student != null) {
            //Populate the data from the data object via the viewHolder object into the tage
            viewHolder.tvId.setText(String.valueOf(student.getStudentId()));
            viewHolder.tvName.setText(student.getFirstName());

            //for managing the state of the boolean array according to the state of the checkbox
            viewHolder.cbStudent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(((CheckBox)view).isChecked()){
                        checkBoxState[position] = true;
                    } else {
                        checkBoxState[position] = false;
                    }
                }
            });
        }

        //return the completed view to render on screen
        return convertView;
    }

    public boolean[]getCheckBoxState(){
        return checkBoxState;
    }

}
