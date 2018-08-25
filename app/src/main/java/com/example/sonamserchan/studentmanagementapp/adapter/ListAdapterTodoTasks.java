package com.example.sonamserchan.studentmanagementapp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sonamserchan.studentmanagementapp.R;

public class ListAdapterTodoTasks extends ArrayAdapter {

    /**Declaring valirables that are properties of this class**/

    //to reference the Activity
    private final Activity context;

    //to store the pizza images
    private final Integer[] imageIDarray;

    //to store the list of pizzas
    private final String[] nameArray;

    //to store the description of pizzas
    private final String[] infoArray;

    //to store the price of the pizza
    private final String[] priceArray;

    private boolean checked = false;

    //boolean array for storing the state of each checkbox
    boolean[] checkBoxState;

    static class ViewHolder{
        TextView tvName, tvInfo, tvPrice;
        ImageView ivImage;
        CheckBox checkbox;
    }
    ViewHolder viewHolder;


    public ListAdapterTodoTasks(Activity context, String[] nameArrayParam, String[] infoArrayParam, Integer[] imageIDarrayParam, String[] priceArrayParam){
        super(context, R.layout.listview_todotask, nameArrayParam);

        this.context = context;
        this.imageIDarray = imageIDarrayParam;
        this.nameArray = nameArrayParam;
        this.infoArray = infoArrayParam;
        this.priceArray = priceArrayParam;
        checkBoxState = new boolean[this.nameArray.length];
    }

    public View getView(final int position, View convertView, ViewGroup parent){
        //reuse views
        if(convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.listview_todotask, null, true);

            //getting reference of objects
            //cache the views
            viewHolder.tvName = convertView.findViewById(R.id.textViewName);
            viewHolder.tvInfo = convertView.findViewById(R.id.textViewInfo);
            viewHolder.tvPrice = convertView.findViewById(R.id.textViewPrice);
            viewHolder.ivImage = convertView.findViewById(R.id.imageView);
            viewHolder.checkbox = convertView.findViewById(R.id.checkboxSelect);

            //link the chached views to the view
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        //setting the values of the objects to values from the arrays
        viewHolder.tvName.setText(nameArray[position]);
        viewHolder.tvInfo.setText(infoArray[position]);
        viewHolder.tvPrice.setText(priceArray[position]);
        viewHolder.ivImage.setImageResource(imageIDarray[position]);

        //setting the state of the checkbox using the boolean array
        viewHolder.checkbox.setChecked(checkBoxState[position]);

        //for managing the state of the boolean array according to the state of the checkbox
        viewHolder.checkbox.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(((CheckBox)v).isChecked())
                    checkBoxState[position] =  true;
                else
                    checkBoxState[position] =  false;
            }
        });

        //return the view to be displayed
        return convertView;

    }

    public boolean[] getCheckBoxState(){
        return checkBoxState;
    }

    public String getName(int position){
        String name = nameArray[position];
        return name;
    }

}
