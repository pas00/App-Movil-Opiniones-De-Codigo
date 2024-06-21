package com.example.final_programovil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private Button buttonUploadContent, buttonCategorizeContent, buttonComments, btnLoadContent;
    private ListView listViewContent;
    private ArrayList<String> contentList;
    private ArrayAdapter<String> contentAdapter;

    private static final int REQUEST_UPLOAD_CONTENT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonUploadContent = findViewById(R.id.buttonUploadContent);
        buttonCategorizeContent = findViewById(R.id.buttonCategorizeContent);
        buttonComments = findViewById(R.id.buttonComments);
        btnLoadContent = findViewById(R.id.btnLoadContent);
        listViewContent = findViewById(R.id.listViewContent);

        // Inicializar la lista de contenidos y el adaptador
        contentList = new ArrayList<>();
        contentAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contentList);
        listViewContent.setAdapter(contentAdapter);

        buttonUploadContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, UploadContentActivity.class);
                startActivityForResult(intent, REQUEST_UPLOAD_CONTENT);
            }
        });

        buttonCategorizeContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CategorizeContentActivity.class);
                startActivity(intent);
            }
        });

        buttonComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CommentsActivity.class);
                startActivity(intent);
            }
        });

        btnLoadContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadContentIntoListView();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_UPLOAD_CONTENT && resultCode == RESULT_OK && data != null) {
            String newContent = data.getStringExtra("content");
            if (newContent != null) {
                contentList.add(newContent);
                contentAdapter.notifyDataSetChanged();
            }
        }
    }

    private void loadContentIntoListView() {
        // Aquí podrías cargar contenido inicial o realizar una acción específica
        // Para este ejemplo, simplemente mostraremos un mensaje Toast
        Toast.makeText(this, "Loading Content into ListView", Toast.LENGTH_SHORT).show();
    }
}
