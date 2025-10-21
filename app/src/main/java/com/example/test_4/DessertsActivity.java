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

public class DessertsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_desserts);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Back Button
        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ListView dessertsList = findViewById(R.id.list_view_desserts);

        Dish[] dishes = {
                new Dish("Chocolate Lava Cake", "Warm chocolate cake with molten center and vanilla ice cream", 65),
                new Dish("Tiramisu", "Classic Italian dessert with coffee-soaked ladyfingers and mascarpone", 55),
                new Dish("Cheesecake", "New York style cheesecake with berry compote", 58),
                new Dish("Crème Brûlée", "Vanilla custard with caramelized sugar crust", 48),
                new Dish("Apple Pie", "Homemade apple pie with cinnamon and served warm", 52)
        };

        ArrayAdapter<Dish> dishAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dishes);
        dessertsList.setAdapter(dishAdapter);

        dessertsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Dish selectedDish = dishes[position];
                Toast.makeText(DessertsActivity.this, selectedDish.getDesc(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}