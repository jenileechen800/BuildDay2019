package com.example.testingforbuildday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class FoodActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    static TextView tv_food1;
    static TextView tv_food2;
    static TextView tv_food3;
    static TextView tv_food4;
    static TextView tv_food5;

    static TextView tv_desc1;
    static TextView tv_desc2;
    static TextView tv_desc3;
    static TextView tv_desc4;
    static TextView tv_desc5;

    static Spinner spinner;

    static ArrayList<TextView> list_tv_foods = new ArrayList<>();
    static ArrayList<TextView> list_tv_desc = new ArrayList<>();

    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter;

    static FoodItems foodItems = new FoodItems();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        init_gui();
        populate_gui();

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.food_categories, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        if (parent.getItemAtPosition(position) == "Campus Partners") {
//            for (int i=0; i<foodItems.foodCategories.get(0).size(); i++) {
//                TextView tv_food_item = list_tv_foods.get(i);
//                TextView tv_food_description = list_tv_desc.get(i);
//
//                FoodItem food_item = foodItems.foodCategories.get(0).get(i);
//
//                tv_food_item.setText(food_item.name);
//                tv_food_description.setText(food_item.description);
//            }
//        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    private void init_gui() {

        // init food text views
        tv_food1 = (TextView) findViewById(R.id.tv_food1);
        tv_food2 = (TextView) findViewById(R.id.tv_food2);
        tv_food3 = (TextView) findViewById(R.id.tv_food3);
        tv_food4 = (TextView) findViewById(R.id.tv_food4);
        tv_food5 = (TextView) findViewById(R.id.tv_food5);

        list_tv_foods.add(tv_food1);
        list_tv_foods.add(tv_food2);
        list_tv_foods.add(tv_food3);
        list_tv_foods.add(tv_food4);
        list_tv_foods.add(tv_food5);

        tv_desc1 = (TextView) findViewById(R.id.tv_description1);
        tv_desc2 = (TextView) findViewById(R.id.tv_description2);
        tv_desc3 = (TextView) findViewById(R.id.tv_description3);
        tv_desc4 = (TextView) findViewById(R.id.tv_description4);
        tv_desc5 = (TextView) findViewById(R.id.tv_description5);

        list_tv_desc.add(tv_desc1);
        list_tv_desc.add(tv_desc2);
        list_tv_desc.add(tv_desc3);
        list_tv_desc.add(tv_desc4);
        list_tv_desc.add(tv_desc5);

        spinner = (Spinner) findViewById(R.id.sp_category);

    }

    private void populate_gui() {

        for (int i=0; i<list_tv_foods.size(); i++) {
            TextView tv_food_item = list_tv_foods.get(i);
            TextView tv_food_description = list_tv_desc.get(i);

            FoodItem food_item = foodItems.foodItems.get(i);

            tv_food_item.setText(food_item.name);
            tv_food_description.setText(food_item.description);
        }

    }


}
