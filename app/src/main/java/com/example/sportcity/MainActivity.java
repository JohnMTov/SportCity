package com.example.sportcity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView sportRecycler;
    SportAdapter sportAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sportRecycler = findViewById(R.id.sportRecycler);
        sportRecycler.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        DatabaseAdapter databaseAdapter = new DatabaseAdapter(this);
        databaseAdapter.open();

        List<Sport> sports = databaseAdapter.getSports();

        sportAdapter = new SportAdapter(this, sports);
        sportRecycler.setAdapter(sportAdapter);

        databaseAdapter.close();
    }

    public void goToFavorites(View view) {
        Intent intent = new Intent(this, FavoritesActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

}