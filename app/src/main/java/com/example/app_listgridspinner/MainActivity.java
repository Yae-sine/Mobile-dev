package com.example.app_listgridspinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button gridBtn;
    Button listBtn;
    Button spinnerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        gridBtn = findViewById(R.id.gridBtn);
        listBtn = findViewById(R.id.listBtn);
        spinnerBtn = findViewById(R.id.spinnerBtn);

        gridBtn.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this , GridActivity.class);
                        startActivity(i);
                    }
                }
        );


        listBtn.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this , ListActivity.class);
                        startActivity(i);
                    }
                }
        );


        spinnerBtn.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this , SpinnerActivity.class);
                        startActivity(i);
                    }
                }
        );






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}