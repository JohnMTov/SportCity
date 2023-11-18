package com.example.sportcity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FieldsActivity extends AppCompatActivity {

    public static List<Field> fields = new ArrayList<>();

    static {
        fields.add(new Field(R.drawable.football_1, "Футбольное поле СФУ", "Свободный пр., 76Г",
                "Круглосуточно", "8 (391) 244-86-25", "Открытый", "Вход свободный", 1));
        fields.add(new Field(R.drawable.football_2, "Футбол - Арена Енисей", "Новгородская ул., 11",
                "08:00-23:00", "8 (391) 222-82-92", "Закрытый", "1500р/час", 1));
        fields.add(new Field(R.drawable.workout_1, "Площадка для воркаута", "Советский район",
                "Круглосуточно", "-", "Открытый", "Вход свободный", 2));
        fields.add(new Field(R.drawable.workout_2, "Площадка на набережной", "ул. Дубровинского",
                "Круглосуточно", "-", "Открытый", "Вход свободный", 2));
        fields.add(new Field(R.drawable.basketball_1, "Баскетбольная площадка", "Остров Татышева",
                "Круглосуточно", "-", "Открытый", "Вход свободный", 3));
        fields.add(new Field(R.drawable.basketball_2, "Красный Яр", "Маерчака, 57",
                "10:00-23:00", "8 (999) 441-55-51", "Закрытый", "700р/час", 3));
        fields.add(new Field(R.drawable.hockey_1, "Хоккейная коробка", "Мате Залки, 4а",
                "Круглосуточно", "-", "Открытый", "Вход свободный", 4));
        fields.add(new Field(R.drawable.hockey_2, "\"Спартаковец\"", "ул. Республики, 43а",
                "Круглосуточно", "-", "Открытый", "Вход свободный", 4));
        fields.add(new Field(R.drawable.skiing_1, "Лыжная база \"Берёзка\"", "ул. Саянская, 7Ж",
                "09:00-17:00", "8 (391) 295–09–31", "Открытый", "100р/час", 5));
        fields.add(new Field(R.drawable.skiing_2, "МФК \"Радуга\"", "ул. Е. Стасовой, 69Л",
                "08:00-22:00", "8 (391) 222-11-55", "Открытый", "100р/час", 5));
        fields.add(new Field(R.drawable.swimming_1, "Бассейн \"Сибиряк\"", "ул. Ладо Кецховели, 62",
                "07:00-23:00", "8 (391) 223-86-01", "Закрытый", "200р/час", 6));
        fields.add(new Field(R.drawable.swimming_2, "Клуб \"Сибирь\"", "ул. Карамзина, 26",
                "08:30-21:30", "+7 (391) 271‒40‒08", "Закрытый", "150р/час", 6));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fields);

        List<Field> filterFields = new ArrayList<>();

        int sportID = getIntent().getIntExtra("sportID", 0);

        for (Field field: fields) {
            if (field.getKindOfSport() == sportID) {
                filterFields.add(field);
            }
        }

        RecyclerView fieldRecycler = findViewById(R.id.fieldRecycler);
        FieldAdapter fieldAdapter = new FieldAdapter(this, filterFields);

        fieldRecycler.setAdapter(fieldAdapter);
    }

    public void goToFavorites(View view) {
        Intent intent = new Intent(this, FavoritesActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    public void goToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}