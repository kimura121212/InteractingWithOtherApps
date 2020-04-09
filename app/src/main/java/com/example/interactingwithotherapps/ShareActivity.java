package com.example.interactingwithotherapps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        // Get the intent that started this activity
        Intent intent = getIntent();
        Uri data = intent.getData();

            // Figure out what to do based on the intent type
        if (intent.getType().indexOf("image/") != -1) {
            // Handle intents with image data ..
        } else if (intent.getType().equals("text/plain")) {
            TextView textView = (TextView) findViewById(R.id.share_text);
            textView.setText("Sent text: " + intent.getStringExtra(Intent.EXTRA_TEXT));
        }
    }

    public void share(View view) {
        // Create intent to deliver some kind of result data
        Intent result = new Intent("com.example.RESULT_ACTION", Uri.parse("content://result_uri"));
        result.setType("text/plain");
        result.putExtra(Intent.EXTRA_TEXT, "Shared text message.");
        setResult(Activity.RESULT_OK, result);
        finish();
    }
}
