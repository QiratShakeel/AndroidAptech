package com.example.listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ToggleButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToggleButton t = findViewById(R.id.toggleButton);
        //list
        String list[]= {"Home","About","Contact"};
        ArrayAdapter adap = new ArrayAdapter(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list);
        ListView li = findViewById(R.id.list);
        li.setAdapter(adap);
        li.setVisibility(View.INVISIBLE);
        //Image initialize
        ImageView imgOff = findViewById(R.id.imageView);
        //toggle button click work
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t.isChecked()){
                    li.setVisibility(View.VISIBLE);
                    imgOff.setImageResource(R.drawable.on);
                }
                else{
                    li.setVisibility(View.INVISIBLE);
                    imgOff.setImageResource(R.drawable.off);
                }
            }
        });
        //List select item work
        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (list[i].equals("Home")){
                    Intent obj = new Intent(getApplicationContext(),Home.class);
                    startActivity(obj);
                }
                else if (list[i].equals("About")){
                    Intent obj = new Intent(getApplicationContext(),About.class);
                    startActivity(obj);
                }
                else if(list[i].equals("Contact")){
                    Intent obj = new Intent(getApplicationContext(),Contact.class);
                    startActivity(obj);
                }
            }
        });
    }
}