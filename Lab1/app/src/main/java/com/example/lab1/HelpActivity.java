package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        textView = findViewById(R.id.textView4);
        Bundle arguments = getIntent().getExtras();
        double liters = arguments.getDouble("liters");
        double gallons = arguments.getDouble("gallons");
        StringBuilder builder = new StringBuilder().append(liters).append(" litters = ")
                .append(gallons).append(" gallons");
        textView.setText(builder.toString());
    }
}
