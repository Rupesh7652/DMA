package com.example.todo_details;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

public class TodoDetailsActivity extends AppCompatActivity {

    private TextView txtview;
private  String[] description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_details);
       Intent intent = getIntent();
        Resources res = getResources();
        description = res.getStringArray(R.array.todo_description);
       txtview = findViewById(R.id.textView);


    }
}
