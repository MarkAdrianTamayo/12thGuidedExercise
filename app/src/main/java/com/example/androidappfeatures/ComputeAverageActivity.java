package com.example.androidappfeatures;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ComputeAverageActivity extends AppCompatActivity {
    private EditText mathGrade, filipinoGrade, scienceGrade, mapehGrade, englishGrade;
    private Button submitButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute_average);

        mathGrade = findViewById(R.id.mathGrade);
        filipinoGrade = findViewById(R.id.filipinoGrade);
        scienceGrade = findViewById(R.id.scienceGrade);
        mapehGrade = findViewById(R.id.mapehGrade);
        englishGrade = findViewById(R.id.englishGrade);
        submitButton = findViewById(R.id.submitButton);
        backButton = findViewById(R.id.btnBackList);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeAverage();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void computeAverage() {
        try {
            double math = Double.parseDouble(mathGrade.getText().toString());
            double filipino = Double.parseDouble(filipinoGrade.getText().toString());
            double science = Double.parseDouble(scienceGrade.getText().toString());
            double mapeh = Double.parseDouble(mapehGrade.getText().toString());
            double english = Double.parseDouble(englishGrade.getText().toString());

            double average = (math + filipino + science + mapeh + english) / 5;

            Intent intent = new Intent(ComputeAverageActivity.this, AverageResultActivity.class);
            intent.putExtra("average", average);
            startActivity(intent);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid grades", Toast.LENGTH_SHORT).show();
        }
    }
}
