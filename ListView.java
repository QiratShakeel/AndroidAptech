package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String list1[]= {"anoosha","zara","maaz","warda","ali"};
        String list2[]= {"mango","apple","kiwi","orange","avacado"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list1);
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list2);
        ListView li = findViewById(R.id.list1);
        ListView li2 = findViewById(R.id.list2);
        li.setAdapter(adapter);
        li2.setAdapter(adapter2);
        Button b = findViewById(R.id.button);
        Button b2 = findViewById(R.id.button2);
        ToggleButton t = findViewById(R.id.toggleButton);
        li.setVisibility(View.INVISIBLE);
        li2.setVisibility(View.INVISIBLE);




        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(t.isChecked()){
                    li.setVisibility(View.VISIBLE);
                    li2.setVisibility(View.VISIBLE);
                }
                else{
                    li.setVisibility(View.INVISIBLE);
                    li2.setVisibility(View.INVISIBLE);
                }
            }
        });


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                li.setVisibility(View.VISIBLE);
                li2.setVisibility(View.INVISIBLE);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                li2.setVisibility(View.VISIBLE);
                li.setVisibility(View.INVISIBLE);
            }
        });
    }
}