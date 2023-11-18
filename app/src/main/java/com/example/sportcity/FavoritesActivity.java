package com.example.sportcity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FavoritesActivity extends AppCompatActivity {

    private final List<Field> favFields = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        RecyclerView favRecycler = findViewById(R.id.favRecycler);
        TextView favStatus = findViewById(R.id.favStatus);

        for (Field field: FieldsActivity.fields) {
            if (Favorites.fieldIds.contains(field.getId())) {
                favFields.add(field);
            }
        }

        if (favFields.size() > 0) {
            favStatus.setVisibility(View.GONE);
            FavoritesAdapter favoritesAdapter = new FavoritesAdapter(this, favFields);
            favRecycler.setAdapter(favoritesAdapter);
        } else {
            favRecycler.setVisibility(View.GONE);
            favStatus.setVisibility(View.VISIBLE);
        }

        Log.v("FavoritesActivity", "onCreate");
        getIntent().setAction("Already created");
    }

    @Override
    protected void onResume() {
        Log.v("FavoritesActivity", "onResume");

        String action = getIntent().getAction();
        if(action == null || !action.equals("Already created")) {
            Log.v("FavoritesActivity", "Force restart");
            Intent intent = new Intent(this, FavoritesActivity.class);
            startActivity(intent);
            finish();
        }
        else
            getIntent().setAction(null);

        super.onResume();
    }

    public void goToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}