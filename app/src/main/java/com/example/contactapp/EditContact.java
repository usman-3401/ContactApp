package com.example.contactapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EditContact extends AppCompatActivity {

    private ImageView profileIv;
    private EditText name_Et,phone_Et,email_Et,note_Et;
    private FloatingActionButton add_btn;
    private String name,phone,email,note;
    private ActionBar actionBar;
    private DbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        dbHelper = new DbHelper(this);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        profileIv = findViewById(R.id.profileIv);
        name_Et = findViewById(R.id.name_Et);
        phone_Et= findViewById(R.id.phone_Et);
        email_Et= findViewById(R.id.email_Et);
        note_Et= findViewById(R.id.note_Et);
        add_btn = findViewById(R.id.add_btn);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void saveData() {

        name = name_Et.getText().toString();
        phone = phone_Et.getText().toString();
        email = email_Et.getText().toString();
        note = note_Et.getText().toString();

        if (!name.isEmpty() || !phone.isEmpty() || !email.isEmpty() || !note.isEmpty()){
            long id = dbHelper.insertContact(
                    ""+name,
                    ""+phone,
                    ""+email,
                    ""+note
            );
            Toast.makeText(getApplicationContext(), "Contact Saved", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(), "Nothing to save....", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}