package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int index = extras.getInt("item_id", 0);
            TextView num = findViewById(R.id.tv_info);
            TextView detail = findViewById(R.id.tv_detail);
            num.setText(DummyContent.ITEMS.get(index-1).content);
            detail.setText(DummyContent.ITEMS.get(index-1).details);
        }


    }
}
