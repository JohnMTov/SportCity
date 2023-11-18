package com.example.sportcity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Sport> sports = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sports.add(new Sport(1, R.drawable.football, "Футбол"));
        sports.add(new Sport(2, R.drawable.workout, "Воркаут"));
        sports.add(new Sport(3, R.drawable.basketball, "Баскетбол"));
        sports.add(new Sport(4, R.drawable.hockey, "Хоккей"));
        sports.add(new Sport(5, R.drawable.skiing, "Лыжи"));
        sports.add(new Sport(6, R.drawable.swimming, "Плавание"));

        RecyclerView sportRecycler = findViewById(R.id.sportRecycler);
        sportRecycler.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        SportAdapter sportAdapter = new SportAdapter(this, sports);

        sportRecycler.setAdapter(sportAdapter);
    }

    public void goToFavorites(View view) {
        Intent intent = new Intent(this, FavoritesActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

}