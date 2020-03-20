package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_result_all;
    private TextView tv_result;
    private String generated;
    private String base = "Всё, что нам нужно – это ";
    private Phaser phaser = new Phaser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_result_all = findViewById(R.id.tv_result_all);
        tv_result = findViewById(R.id.tv_result);
        generated = phaser.PhraserGen();
        String result = base + generated;

        tv_result_all.setText(result);
        tv_result.setText(generated.substring(0, 1).toUpperCase() + generated.substring(1)
                + " - это все, что нам нужно.");
    }

    public void generate(View v){
        generated = phaser.PhraserGen();
        String result = base + generated;
        tv_result_all.setText(result);
        tv_result.setText(generated.substring(0, 1).toUpperCase() + generated.substring(1)
                + " - это все, что нам нужно.");
    }
}
