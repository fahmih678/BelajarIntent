package com.example.belajarintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class differentImplicitIntent extends AppCompatActivity {
    private Spinner spinner;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_different_implicit_intent);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.intents, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onClick(View view) {
        int position = spinner.getSelectedItemPosition();
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.vogella.com/"));
                break;
            case 1:
                intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:(+49)12345789"));
                break;
            case 2:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:50.123,7.1434?z=19"));
                break;
            case 3:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=query"));
                break;
            case 4:
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                break;
            case 5:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("content://contacts/people/"));
                break;
            case 6:
                intent = new Intent(Intent.ACTION_EDIT,
                        Uri.parse("content://contacts/people/1"));
                break;

        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}