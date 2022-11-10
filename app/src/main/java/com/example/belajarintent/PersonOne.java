package com.example.belajarintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PersonOne extends AppCompatActivity {
    // Class name untuk Log tag
    private static final String LOG_TAG = PersonOne.class.getSimpleName();
    // Unique tag required for the intent extra
    public static final String EXTRA_MESSAGE = "com.example.belajarintent.extra.MESSAGE";
    // Unique tag for the intent reply
    public static final int TEXT_REQUEST = 1;

    // EditText view untuk the message
    private EditText mMessageEditText;
    // TextView untuk reply header
    private TextView mReplyHeadTextView;
    // TextView untuk reply body
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_one);

        // Menginisialisasi semua variabel view.
        mMessageEditText = (EditText) findViewById(R.id.editText_main);
        mReplyHeadTextView = (TextView) findViewById(R.id.text_header_reply);
        mReplyTextView = (TextView) findViewById(R.id.text_message_reply);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");

        Intent intent = new Intent(this, PersonTwo.class);
        String message = mMessageEditText.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Test apakah intent reply sudah benar
        if (requestCode == TEXT_REQUEST) {
            // Test memastikan hasil dari intent reply sudah benar
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(PersonTwo.EXTRA_REPLY);

                // Membuat textview terlihat
                mReplyHeadTextView.setVisibility(View.VISIBLE);

                // Set reply dan membuat terlihat.
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}