package com.healthcare.cbcanalyzer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button checkButton;
    private Button cbcRangeBook;
    private Button recommendationBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkButton = findViewById(R.id.checkCBC);
        cbcRangeBook = findViewById(R.id.cbcRangebook);
        recommendationBook = findViewById(R.id.recommendationBook);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Proceed to analysis",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,CBCAnalysis.class));
            }
        });

        //back and exit button
        cbcRangeBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cbcRangeIntent = new Intent(MainActivity.this, CBC_RangeBook.class);
                startActivity(cbcRangeIntent);
            }
        });

        //back and exit button
        recommendationBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recommendationBookIntent = new Intent(MainActivity.this, Recommendation_Book.class);
                startActivity(recommendationBookIntent);
            }
        });

    }
}