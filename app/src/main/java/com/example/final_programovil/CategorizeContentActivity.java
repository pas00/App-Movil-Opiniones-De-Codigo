package com.example.final_programovil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CategorizeContentActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextTags;
    private Spinner spinnerCategory;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorize_content);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextTags = findViewById(R.id.editTextTags);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Configurar el spinner con categorías de ejemplo
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapter);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitContent();
            }
        });
    }

    private void submitContent() {
        String title = editTextTitle.getText().toString();
        String category = spinnerCategory.getSelectedItem().toString();
        String tags = editTextTags.getText().toString();

        if (title.isEmpty() || tags.isEmpty()) {
            Toast.makeText(CategorizeContentActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            // Aquí se puede implementar la lógica para manejar el contenido categorizado
            Toast.makeText(CategorizeContentActivity.this, "Content categorized successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(CategorizeContentActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
