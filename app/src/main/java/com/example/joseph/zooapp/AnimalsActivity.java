package com.example.joseph.zooapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class AnimalsActivity extends AppCompatActivity {

    private ListView lvAnimals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        lvAnimals = (ListView) findViewById(R.id.lvAnimals);

//        //dummy datat
//        String[] values = new String[]{
//                "value1",
//                "value2",
//                "value3",
//                "value4",
//        };

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
//        lvAnimals.setAdapter(adapter);


        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        List<Animal> animalList = databaseHelper.getAnimalList("Mammal");

        AnimalListAdapter animalListAdapter = new AnimalListAdapter(this, R.layout.custom_list_item, animalList);
        lvAnimals.setAdapter(animalListAdapter);

    }
}
