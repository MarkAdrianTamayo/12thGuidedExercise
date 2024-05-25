package com.example.androidappfeatures;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ContactDetailsActivity extends AppCompatActivity {
    private TextView nameTextView, phoneTextView, emailTextView, ageTextView;
    private ImageView callImageView, deleteImageView;
    private Button backButton;
    private String contactName, contactPhone, contactEmail, contactAge;
    private int contactPosition, pos;
    private static ArrayList<String> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        nameTextView = findViewById(R.id.nameTextView);
        phoneTextView = findViewById(R.id.phoneTextView);
        emailTextView = findViewById(R.id.emailTextView);
        ageTextView = findViewById(R.id.ageTextView);
        callImageView = findViewById(R.id.callImageView);
        deleteImageView = findViewById(R.id.deleteImageView);
        backButton = findViewById(R.id.btnBackList);

        contacts = MainActivity.contacts;
        pos = ContactListActivity.pos;
        Intent intent = getIntent();
        contactPosition = intent.getIntExtra("contactPosition", pos);
        if (contactPosition != -1) {
            String contact = contacts.get(contactPosition);
            String[] contactDetails = contact.split("\n");
            contactName = contactDetails[0];
            contactPhone = contactDetails[1];
            contactEmail = contactDetails[2];
            contactAge = contactDetails[3];

            nameTextView.setText(contactName);
            phoneTextView.setText(contactPhone);
            emailTextView.setText(contactEmail);
            ageTextView.setText(contactAge);
        }

        callImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + contactPhone));
                startActivity(callIntent);
            }
        });

        deleteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contacts.remove(contactPosition);
                Toast.makeText(ContactDetailsActivity.this, "Contact deleted", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
