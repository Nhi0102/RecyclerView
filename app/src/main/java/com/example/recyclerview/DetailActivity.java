package com.example.recyclerview;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    ImageView detailImageView;
    TextView detailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        detailImageView = findViewById(R.id.detailImageView);
         detailTextView = findViewById(R.id.detailTextView);

        String foodName = getIntent().getStringExtra("foodName");
        int foodImage = getIntent().getIntExtra("foodImage", 0);
        String foodDescription = getIntent().getStringExtra("foodDescription");
        double foodPrice = getIntent().getDoubleExtra("foodPrice",0);

        detailImageView.setImageResource(foodImage);
        SharedPreferences prefs = getSharedPreferences("LastViewedFood",MODE_PRIVATE);
        SharedPreferences.Editor editor =  prefs.edit();
        editor.putString("lastFoodName", foodName);
        editor.putString("orderedFoodName",foodName);
        editor.apply();

        String detailText = "Tên món ăn: " + foodName +
                            "\nMo tả: " + foodDescription +
                            "\nGiá: " + foodPrice + "VND";

        detailTextView.setText(detailText);
        Button orderButton = findViewById(R.id.orderButton);
        orderButton.setOnClickListener(v -> {
            Toast.makeText(this,"Bạn đã gọi món: " + foodName, Toast.LENGTH_SHORT).show();
        });

    }


}
