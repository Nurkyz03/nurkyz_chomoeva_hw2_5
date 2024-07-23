package com.geeks.nurkyz_chomoeva_hw2_5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    private ImageButton heartButton;

    String [] item = { "Coffeshop", "Bar", "Club"};

    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        String result = getIntent().getStringExtra("RESULT = 30");
        TextView answer = findViewById(R.id.answer);
        answer.setText(result);
        heartButton = findViewById(R.id.heartButton);

        autoCompleteTextView = findViewById(R.id.auto_complete_textview);

        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item, item);

        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(SecondActivity.this, "item " + item, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onHeartButtonClick(View view) {
        heartButton.setSelected(!heartButton.isSelected());
        int imageResource = heartButton.isSelected() ? R.drawable.heart : R.drawable.heart;
        heartButton.setImageResource(imageResource);
    }
    public void onNextButtonClick(View view) {
        finish();
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        finish();
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}