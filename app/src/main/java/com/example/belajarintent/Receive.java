package com.example.belajarintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Receive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);

        Intent intent = getIntent();
        // get data via the key
        String value1 = intent.getStringExtra("Value2");
        if (value1 != null) {
            TextView textView = (TextView) findViewById(R.id.text_message1);
            if (textView != null) {
                textView.setText(value1);
            }
        }
    }
}