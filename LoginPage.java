package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.button);
        EditText name = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText pass = (EditText) findViewById(R.id.editTextTextPersonName2);
        Spinner roles = (Spinner) findViewById(R.id.spinner);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().equalsIgnoreCase("Qirat") && pass.getText().toString().equals("Aptech")){
                    if (roles.getSelectedItem().toString().equalsIgnoreCase("Students")) {
                        Intent obj= new Intent(getApplicationContext(),StudentDashboard.class);
                        startActivity(obj);
                    }
                    else if(roles.getSelectedItem().toString().equalsIgnoreCase("Faculty"))
                    {
                        Intent obj1= new Intent(getApplicationContext(),FacultyDashboard.class);
                        startActivity(obj1);
                    }
                }
                else
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}