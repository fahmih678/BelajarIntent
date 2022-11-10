package com.example.belajarintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PersonTwo extends AppCompatActivity {
    // Tag unik untuk intent reply.
    public static final String EXTRA_REPLY = "com.example.belajarintent.extra.REPLY";

    // EditText untuk reply.
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_two);

        // Menginisialisasi variabel view.
        mReply = (EditText) findViewById(R.id.editText_second);

        // mengambil inten yang menjalankan activity ini dan mengambil pesan di intent extra
        Intent intent = getIntent();
        String message = intent.getStringExtra(PersonOne.EXTRA_MESSAGE);


        // Menampilkan pesan dalam TextView text_message
        TextView textView = (TextView) findViewById(R.id.text_message);
        if (textView != null) {
            textView.setText(message);
        }
    }

    public void returnReply(View view) {
        // Mengambil pesan reply dari edit text.
        String reply = mReply.getText().toString();

        // Membuat intent baru untuk reply, masukkan pesan reply kedalamnya sebagai extra,
        // set intent result, and tutup activity ini.
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}