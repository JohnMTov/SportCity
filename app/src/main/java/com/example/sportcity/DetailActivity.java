package com.example.sportcity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    CheckBox likeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView fieldImage = findViewById(R.id.fieldImageDetail);
        TextView fieldTitle = findViewById(R.id.fieldTitleDetail);
        TextView fieldAddress = findViewById(R.id.fieldAddressDetail);
        TextView fieldOpeningHours = findViewById(R.id.fieldOpeningHoursDetail);
        TextView fieldPhone = findViewById(R.id.fieldPhoneDetail);
        TextView fieldType = findViewById(R.id.fieldTypeDetail);
        TextView fieldCost = findViewById(R.id.fieldCostDetail);
        likeButton = findViewById(R.id.likeButton);

        if (getIntent().getBooleanExtra("fieldFav", false)) {
            likeButton.setChecked(true);
        }

        fieldImage.setImageResource(getIntent().getIntExtra("fieldImage", 0));
        fieldTitle.setText(getIntent().getStringExtra("fieldTitle"));
        fieldAddress.setText(getIntent().getStringExtra("fieldAddress"));
        fieldOpeningHours.setText(getIntent().getStringExtra("fieldOpeningHours"));
        fieldPhone.setText(getIntent().getStringExtra("fieldPhone"));
        fieldType.setText(getIntent().getStringExtra("fieldType"));
        fieldCost.setText(getIntent().getStringExtra("fieldCost"));

    }

    public void addToFavorites(View view) {
        int fieldId = getIntent().getIntExtra("fieldId", 0);
        if (likeButton.isChecked()) {
            Favorites.fieldIds.add(fieldId);
            Objects.requireNonNull(FieldsActivity.fields.stream().filter(field -> (field.getId()) == fieldId)
                    .findFirst().orElse(null)).setFavorite(true);
        } else {
            Objects.requireNonNull(FieldsActivity.fields.stream().filter(field -> (field.getId()) == fieldId)
                    .findFirst().orElse(null)).setFavorite(false);
            Favorites.fieldIds.remove(Favorites.fieldIds.stream().filter(id -> (id == fieldId))
                    .findFirst().orElse(null));
        }
    }

    public void goBack(View view) {
        finish();
    }
}