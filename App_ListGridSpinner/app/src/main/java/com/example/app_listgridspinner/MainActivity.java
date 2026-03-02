package com.example.app_listgridspinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
            getMenuInflater().inflate(R.menu.menu_test , menu);
            return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();
        if(id == R.id.a1){
           Intent i = new Intent(MainActivity.this ,  ContactActivity.class) ;
           startActivity(i);
        }
        else if(id == R.id.a2){
           Intent i = new Intent(MainActivity.this , AboutActivity.class) ;
           startActivity(i);
        }
        else if(id == R.id.quit){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}