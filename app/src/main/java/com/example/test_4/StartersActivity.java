package com.example.test_4;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StartersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_starters);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ListView startersList = findViewById(R.id.list_view_starters);

        Dish[] dishes = {
                new Dish("Pesto and mushroom wontons", "Thin wonton cases stuffed with sun-dried tomato pesto and pontobello mushroom", 59),
                new Dish("Cheese and crab dumplings", "Thin pastry cases stuffed with vintage cheese and crab", 64),
                new Dish("Apple and tuna soup", "Green apple and tuna combined into creamy soup", 45),
                new Dish("Veal and pigeon dumplings", "Thin pastry cases stuffed with veal and pigeon", 58),
                new Dish("Tomato and chickpea soup", "Plum tomatoes and fresh chickpea combined into chunky soup", 54)
        };

        ArrayAdapter<Dish> dishAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dishes);
        startersList.setAdapter(dishAdapter);

        startersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Dish selectedDish = dishes[position];
                Toast.makeText(StartersActivity.this, selectedDish.getDesc(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}