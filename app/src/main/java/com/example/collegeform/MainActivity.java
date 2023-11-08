package com.example.collegeform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    CheckBox checkBox;
    Spinner spinner;
    Button button1 , button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        checkBox = findViewById(R.id.checkbox1);
        spinner = findViewById(R.id.spinner);
        button1 = findViewById(R.id.submit);
        button2 = findViewById(R.id.button2);

        // Radio Group

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(MainActivity.this, "You Select n" + radioButton.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        // Check Box

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Check Box is check",Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(MainActivity.this, "Check Box is not check",Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Spinner
        String [] Course = {"Java","Html","Dart","Flutter","React native"}; // Arry List
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,Course);
        spinner.setAdapter((adapter));
        // For Submit Button
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Intent",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });
        // button 2
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.bing.com/search?q=rolls+royce+ghost+wallpaper+4k&qs=SC&pq=rolls-royce+gost&sk=SC2&sc=10-16&cvid=15742428B9A74DED990F11BDED688C6A&FORM=QBRE&sp=3&ghc=1&lq=0"));
                startActivity(i);
            }
        });

    }
}