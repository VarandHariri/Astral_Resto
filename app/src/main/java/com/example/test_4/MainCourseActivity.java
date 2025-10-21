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

public class MainCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_course);

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

        ListView mainsList = findViewById(R.id.list_view_mains);

        Dish[] dishes = {
                new Dish("Grilled Salmon", "Fresh salmon fillet grilled with herbs and lemon butter sauce", 125),
                new Dish("Beef Wellington", "Prime beef tenderloin wrapped in puff pastry with mushroom duxelles", 189),
                new Dish("Chicken Parmesan", "Breaded chicken breast with tomato sauce and melted mozzarella", 95),
                new Dish("Vegetable Lasagna", "Layers of pasta with roasted vegetables and three cheeses", 78),
                new Dish("Pork Ribs", "Slow-cooked pork ribs with BBQ glaze and coleslaw", 112)
        };

        ArrayAdapter<Dish> dishAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dishes);
        mainsList.setAdapter(dishAdapter);

        mainsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Dish selectedDish = dishes[position];
                Toast.makeText(MainCourseActivity.this, selectedDish.getDesc(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}