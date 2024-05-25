package com.example.androidappfeatures;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddContactActivity extends AppCompatActivity {
    private EditText nameField, contactNumberField, emailField, ageField;
    private Button submitButton, backButton;
    private static ArrayList<String> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        nameField = findViewById(R.id.nameField);
        contactNumberField = findViewById(R.id.contactNumberField);
        emailField = findViewById(R.id.emailField);
        ageField = findViewById(R.id.ageField);
        submitButton = findViewById(R.id.submitButton);
        backButton = findViewById(R.id.backButton);

        contacts = MainActivity.contacts;

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContact();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addContact() {
        String name = nameField.getText().toString();
        String contactNumber = contactNumberField.getText().toString();
        String email = emailField.getText().toString();
        String ageStr = ageField.getText().toString();

        if (name.isEmpty() || contactNumber.isEmpty() || email.isEmpty() || ageStr.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            try {
                int age = Integer.parseInt(ageStr);
                if (age <= 0 || age >= 150) {
                    Toast.makeText(this, "Please enter a valid age between 0 and 150", Toast.LENGTH_SHORT).show();
                } else {
                    String contact = "Name: " + name + "\nPhone: " + contactNumber + "\nEmail: " + email + "\nAge: " + age;
                    contacts.add(contact);
                    Toast.makeText(this, "Contact added", Toast.LENGTH_SHORT).show();
                    finish();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Please enter a valid number for age", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
