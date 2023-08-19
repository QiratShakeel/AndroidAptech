package com.example.coffeeshop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name = findViewById(R.id.name);
        EditText contact = findViewById(R.id.contact);
        RadioGroup type = findViewById(R.id.types);
        CheckBox choclate = findViewById(R.id.choc);
        CheckBox cream = findViewById(R.id.cream);
        CheckBox syrup = findViewById(R.id.Serum);
        RadioGroup payment = findViewById(R.id.payment);
        Button b = findViewById(R.id.button);
        TextView print = findViewById(R.id.print);
        StringBuilder res= new StringBuilder();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum=0;
                res.append("Name is: "+name.getText().toString());
                res.append(" Contact is: "+ contact.getText().toString());
                int typeId = type.getCheckedRadioButtonId();
                switch (typeId){
                    case R.id.americano:
                        sum+=200;
                        res.append("Americano: 200Rs");
                        break;
                    case R.id.expresso:
                        sum+=150;
                        res.append("Expresso: 150Rs");
                        break;
                    case R.id.capicino:
                        sum+=150;
                        res.append("Cappucinno: 150Rs");
                        break;
                    case R.id.latte:
                        sum+=250;
                        res.append("latte: 250Rs");
                        break;
                }
                if (choclate.isChecked()) {
                    sum+=50;
                    res.append("choclate topping: 50Rs ");
                }
                if (cream.isChecked()) {
                    sum+=25;
                    res.append("cream topping: 25Rs ");
                }
                if (syrup.isChecked()) {
                    sum+=30;
                    res.append("caramel syrup topping: 30Rs ");
                }
                int paymentId = payment.getCheckedRadioButtonId();
                switch (paymentId){
                    case R.id.COD:
                        res.append("Cash on Delivery");
                        break;
                    case R.id.card:
                        res.append("Card Payment");
                        break;
                }
                res.append("Total sum is: "+sum);
                //print.setText(res.toString());
              //  Toast.makeText(MainActivity.this, res.toString(), Toast.LENGTH_SHORT).show();
                Intent obj = new Intent(getApplicationContext(),Display.class);
                obj.putExtra("res", res.toString());
                startActivity(obj);
            }
        });
    }
//    public void onBackPressed(){
//        AlertDialog.Builder obj = new AlertDialog.Builder(getApplicationContext());
//        obj.setTitle("Danger!");
//        obj.setMessage("Are you sure you want ot exist");
//        obj.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                finish();
//            }
//        });
//        obj.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.cancel();
//            }
//        });
//        obj.setIcon(R.drawable.ic_launcher_foreground);
//        obj.create().show();
//    }

}