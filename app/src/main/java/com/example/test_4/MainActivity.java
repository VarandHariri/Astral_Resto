package com.example.test_4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CardView startersCard;
    CardView mainsCard;
    CardView dessertsCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.text_view_namaresto), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        startersCard = findViewById(R.id.card_view_starters);
        mainsCard = findViewById(R.id.card_view_mains);
        dessertsCard = findViewById(R.id.card_view_desserts);

        // Starters Card Click
        startersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startersIntent = new Intent(MainActivity.this, StartersActivity.class);
                startActivity(startersIntent);
            }
        });

        mainsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainsIntent = new Intent(MainActivity.this, MainCourseActivity.class);
                startActivity(mainsIntent);
            }
        });

        dessertsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dessertsIntent = new Intent(MainActivity.this, DessertsActivity.class);
                startActivity(dessertsIntent);
            }
        });

        // Location TextView Click Listener
        TextView locText = findViewById(R.id.text_view_loc);
        locText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchMapAppIntent = new Intent(Intent.ACTION_VIEW);
                launchMapAppIntent.setData(Uri.parse("geo:-7.273946852849151,112.79371116759155?q=Politeknik Elektronika Negeri Surabaya"));
                startActivity(launchMapAppIntent);
            }
        });

        TextView orderText = findViewById(R.id.text_view_order);
        locText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent launchEmailAppIntent = new Intent(Intent.ACTION_SENDTO);
                launchEmailAppIntent.setData(Uri.parse("mailtofoodandmood@gmail.com"));
                startActivity(launchEmailAppIntent);
            }
        });
    }
}