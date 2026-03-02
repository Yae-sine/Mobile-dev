package com.example.app_listgridspinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    ImageButton backBtn ;
    List<String> countries =new ArrayList<>(Arrays.asList("Morocco", "Canada", "Japan", "Brazil", "Australia",
            "Germany", "France", "India", "Mexico", "Italy",
            "Egypt", "South Korea", "Spain", "Argentina", "Thailand",
            "Greece", "Norway", "South Africa", "Vietnam", "Turkey")
            );
    ListView list;
    TextInputEditText txtInput;
    TextInputEditText txtInputDlt;
    Button addButton ;
    Button deleteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);

        backBtn = findViewById(R.id.backBtnList);
        backBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );

        list = findViewById(R.id.countriesList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this , android.R.layout.simple_expandable_list_item_1, countries);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext() , ((TextView)
                view).getText(), Toast.LENGTH_SHORT).show();
            }
        });

        txtInput = findViewById(R.id.addInput);
        txtInputDlt= findViewById(R.id.inputDelete);
        addButton = findViewById(R.id.addBtn) ;
        deleteButton = findViewById(R.id.deleteBtn1);

        addButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String text = txtInput.getText().toString();
                if(!text.isEmpty()){
                    countries.add(text);
                    adapter.notifyDataSetChanged();
                    txtInput.setText("");
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               String deleteInput = txtInputDlt.getText().toString();
               if(!deleteInput.isEmpty() && countries.contains(deleteInput)){
                   countries.remove(deleteInput);
                   adapter.notifyDataSetChanged();
                   txtInputDlt.setText("");
               }
            }
        });



    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}