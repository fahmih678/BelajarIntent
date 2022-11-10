package com.example.belajarintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Send extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
    }

    public void secondAct(View view) {
        Intent i = new Intent(this, Receive.class);
        i.putExtra("Value1", "This value one for ActivityTwo ");
        i.putExtra("Value2", "This value two ActivityTwo");
        startActivity(i);
    }
}