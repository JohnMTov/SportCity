package com.example.sportcity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

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

        if (getIntent().getIntExtra("fieldFav", 0) == 1) {
            likeButton.setChecked(true);
        }

        byte[] byteArray = getIntent().getByteArrayExtra("fieldImage");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        fieldImage.setImageBitmap(bitmap);
        fieldTitle.setText(getIntent().getStringExtra("fieldTitle"));
        fieldAddress.setText(getIntent().getStringExtra("fieldAddress"));
        fieldOpeningHours.setText(getIntent().getStringExtra("fieldOpeningHours"));
        fieldPhone.setText(getIntent().getStringExtra("fieldPhone"));
        fieldType.setText(getIntent().getStringExtra("fieldType"));
        fieldCost.setText(getIntent().getStringExtra("fieldCost"));


    }

    public void addToFavorites(View view) {
        DatabaseAdapter databaseAdapter = new DatabaseAdapter(this);
        databaseAdapter.open();

        int fieldId = getIntent().getIntExtra("fieldId", 0);
        if (likeButton.isChecked()) {
            databaseAdapter.addToFavorites(fieldId);
            databaseAdapter.changeFavStatus(fieldId, 1);
        } else {
            databaseAdapter.changeFavStatus(fieldId, 0);
            databaseAdapter.deleteFromFavorites(fieldId);
        }

        databaseAdapter.close();
    }

    public void goBack(View view) {
        finish();
    }
}