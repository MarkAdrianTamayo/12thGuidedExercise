package com.example.androidappfeatures;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AverageResultActivity extends AppCompatActivity {
    private TextView averageTextView;
    private Button backButton;
    private double average;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_result);

        averageTextView = findViewById(R.id.averageTextView);
        backButton = findViewById(R.id.btnBackList);

        average = getIntent().getDoubleExtra("average", 0.0);
        averageTextView.setText(String.format("Average: %.2f", average));

        backButton.setOnClickListener(v -> finish());
    }
}

