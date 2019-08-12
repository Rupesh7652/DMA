package com.example.todofirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private String [] tasks ;
    private TextView textView;
    int currentIndex=0;
     private  int i = 0;
     Resources res;

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("tasks", i);
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
       if (savedInstanceState !=null){
           i = savedInstanceState.getInt("tasks", 0);
       }



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView.setText(tasks[currentIndex]);
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
    }

    public void NexClick(View view) {
        if (currentIndex < (tasks.length-1))
            currentIndex++;
        Log.d("MainActivity", "Value of current Index:" + currentIndex);
        textView.setText(tasks[currentIndex]);
    }
}
