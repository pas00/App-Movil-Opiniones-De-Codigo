package com.example.final_programovil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UploadContentActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextDescription, editTextContent;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_content);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextContent = findViewById(R.id.editTextContent);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitContent();
            }
        });
    }

    private void submitContent() {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        String content = editTextContent.getText().toString();

        if (title.isEmpty() || description.isEmpty() || content.isEmpty()) {
            Toast.makeText(UploadContentActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            String fullContent = "Title: " + title + "\nDescription: " + description + "\nContent: " + content;
            Intent resultIntent = new Intent();
            resultIntent.putExtra("content", fullContent);
            setResult(RESULT_OK, resultIntent);
            finish();
        }
    }
}