package com.example.joseph.zooapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Categories extends AppCompatActivity {

    private static final String TAG = "Categories: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        ListView lvCategories = (ListView) findViewById(R.id.lvCategories);

        //dummy datat
        String[] values = new String[]{
                "Mammals",
                "Fish",
                "Birds",
                "Reptiles",
                "Amphibians",
                "Invertebrates",
        };

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
//        lvAnimals.setAdapter(adapter);


//        DatabaseHelper databaseHelper = new DatabaseHelper(this);
//        List<Animal> animalList = databaseHelper.getAnimalList();

//        AnimalListAdapter personListAdapter = new AnimalListAdapter(this, R.layout.custom_list_item, animalList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
        lvCategories.setAdapter(adapter);

        //onclick for items
        lvCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String x = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItemClick: " + i + " " + x);
                goToAnimals();
                // TODO: 10/3/17 pass type to animalsActivity and display animals for that category
            }
        });

    }

    public void goToAnimals(){
        Intent intent = new Intent(this, AnimalsActivity.class);
        startActivity(intent);
    }

}
