package com.example.final_programovil;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CommentsActivity extends AppCompatActivity {

    private EditText editTextComment;
    private Button buttonPostComment;
    private ListView listViewComments;
    private ArrayList<String> commentList;
    private ArrayAdapter<String> commentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        editTextComment = findViewById(R.id.editTextComment);
        buttonPostComment = findViewById(R.id.buttonPostComment);
        listViewComments = findViewById(R.id.listViewComments);

        commentList = new ArrayList<>();
        commentAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, commentList);
        listViewComments.setAdapter(commentAdapter);

        buttonPostComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postComment();
            }
        });
    }

    private void postComment() {
        String comment = editTextComment.getText().toString().trim();
        if (!comment.isEmpty()) {
            commentList.add(comment);
            commentAdapter.notifyDataSetChanged();
            editTextComment.setText(""); // Limpiar el campo de comentario después de agregarlo
        } else {
            Toast.makeText(CommentsActivity.this, "Please enter a comment", Toast.LENGTH_SHORT).show();
        }
    }
}