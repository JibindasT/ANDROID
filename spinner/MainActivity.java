package com.example.spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner countrySpinner;
    private TextView selectedCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        countrySpinner = findViewById(R.id.country_spinner);
        selectedCountry = findViewById(R.id.selected_country);

        // Create an array of countries
        String[] countries = {"USA", "Canada", "UK", "Germany", "France", "Australia"};

        // Set up the spinner adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(adapter);

        // Set up the spinner item selection listener
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get selected country
                String selected = parent.getItemAtPosition(position).toString();
                // Display the selected country
                selectedCountry.setText("Selected Country   : " + selected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedCountry.setText("No country selected");
            }
        });
    }
}
