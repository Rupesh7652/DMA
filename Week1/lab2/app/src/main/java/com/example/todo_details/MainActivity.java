package com.example.todo_details;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String [] tasks ;
    private TextView textView;
    int currentIndex=0;
    Resources res;
    private Button detailbutton;
    public static String TodoIndex;
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("tasks", currentIndex);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "OnStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "OnStop");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt("tasks", 0);
        }
        Log.d("MainActivity", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView.setText(tasks[currentIndex]);
        Resources res = getResources();
        detailbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TodoDetailsActivity.class);
                intent.putExtra(TodoIndex, currentIndex);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "OnPause");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("MainActivity", "onPostResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }


    public void PreClick(View view) {
        if (currentIndex > 0)
        {
            currentIndex = currentIndex % tasks.length;
        }
        else
        {
            currentIndex = tasks.length;
        }
        currentIndex = --currentIndex % tasks.length;
        Log.d("MainActivity", "This is android class");
        textView.setText(tasks[currentIndex]);
    }

    public void NexClick
            (View view) {
        if (currentIndex < (tasks.length-1))
            currentIndex++;
        Log.d("MainActivity", "Value of current Index:" + currentIndex);
        textView.setText(tasks[currentIndex]);
    }
}
