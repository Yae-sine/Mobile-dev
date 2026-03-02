package com.example.app_listgridspinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
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

public class GridActivity extends AppCompatActivity {

    ImageButton backBtn;

    GridView grid;
    Button deleteBtn;

    Button addBtn;
    TextInputEditText txtInput;
    TextInputEditText txtInputDlt;
    ArrayList<String> countries = new ArrayList<>(Arrays.asList("Afghanistan", "Afrique du Sud", "Algérie", "Allemagne", "Arabie Saoudite",
            "Argentine", "Australie", "Belgique", "Brésil", "Canada",
            "Chine", "Colombie", "Corée du Sud", "Danemark", "Égypte",
            "Espagne", "États-Unis", "Finlande", "France", "Grèce",
            "Inde", "Indonésie", "Irlande", "Italie", "Japon",
            "Kenya", "Maroc", "Mexique", "Nigeria", "Norvège",
            "Nouvelle-Zélande", "Pakistan", "Pays-Bas", "Pérou", "Portugal",
            "Royaume-Uni", "Russie", "Sénégal", "Suède", "Suisse",
            "Thaïlande", "Turquie"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid);

        backBtn = findViewById(R.id.backBtnGrid);
        backBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );

        grid = findViewById(R.id.gridId);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 , countries);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext() , ((TextView)
                view).getText() , Toast.LENGTH_SHORT).show();
            }
        });

        txtInput = findViewById(R.id.textInputGrid);
        addBtn = findViewById(R.id.addBtnGrid);
        addBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String text = txtInput.getText().toString();
                if(!text.isEmpty()){
                    countries.add(text);
                    adapter.notifyDataSetChanged();
                    txtInput.setText("");
                }
                else{
                    Toast.makeText(getApplicationContext() , "Please a country" , Toast.LENGTH_SHORT ).show();
                }

            }
        });
        txtInputDlt = findViewById(R.id.inputTextDelete);
        deleteBtn = findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String text = txtInputDlt.getText().toString();
                if(!text.isEmpty()){
                    countries.remove(text);
                    adapter.notifyDataSetChanged();
                    txtInputDlt.setText("");
                }
                else{
                    Toast.makeText(getApplicationContext() , "Please enter a country" , Toast.LENGTH_SHORT).show();
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