package com.example.app_listgridspinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SpinnerActivity extends AppCompatActivity {

    ImageButton backBtn;
    Spinner spinner;

    String[] countries = {"Afghanistan", "Afrique du Sud", "Algérie", "Allemagne", "Arabie Saoudite",
            "Argentine", "Australie", "Belgique", "Brésil", "Canada",
            "Chine", "Colombie", "Corée du Sud", "Danemark", "Égypte",
            "Espagne", "États-Unis", "Finlande", "France", "Grèce",
            "Inde", "Indonésie", "Irlande", "Italie", "Japon",
            "Kenya", "Maroc", "Mexique", "Nigeria", "Norvège",
            "Nouvelle-Zélande", "Pakistan", "Pays-Bas", "Pérou", "Portugal",
            "Royaume-Uni", "Russie", "Sénégal", "Suède", "Suisse",
            "Thaïlande", "Turquie"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner);

        backBtn = findViewById(R.id.backBtnSpinner);
        backBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );
        spinner = findViewById(R.id.spinnerId);
        spinner.setAdapter(new
                ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 ,countries));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext() , ((TextView)
                view).getText() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}