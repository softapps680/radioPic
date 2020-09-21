package com.example.radiopic;

import android.os.Bundle;

import android.widget.GridView;
import android.widget.RadioButton;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Pet> pets = new ArrayList<Pet>();
     //   RadioButton btn = (RadioButton)findViewById(R.id.btnCountry);

        Pet newItem = new Pet("ETT",R.drawable.radio_selector0);
        pets.add(newItem);
        newItem = new Pet("TWO",R.drawable.radio_selector1);
        pets.add(newItem);
        newItem = new Pet("TRE",R.drawable.radio_selector2);
        pets.add(newItem);
        newItem = new Pet("FYR",R.drawable.radio_selector3);
        pets.add(newItem);
    /*    Pet newItem = new Pet("ETT");
        pets.add(newItem);  
        newItem = new Pet("TWO");
        pets.add(newItem);
        newItem = new Pet("TRE");
        pets.add(newItem);
        newItem = new Pet("FYR");
        pets.add(newItem);*/

        GridView gridView = (GridView)this.findViewById(R.id.gridview);
        ImageAdapter adapter = new ImageAdapter(this,pets);
        gridView.setAdapter(adapter);
    }
}