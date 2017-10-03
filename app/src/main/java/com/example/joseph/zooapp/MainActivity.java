package com.example.joseph.zooapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnViewAnimals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnViewAnimals = (Button) findViewById(R.id.btnViewCategories);



    }

    public void goToCategories(View view) {

        Intent intent = new Intent(this, Categories.class);
        startActivity(intent);

    }

    public void populateDatabse(View view) {

        DatabaseHelper db = new DatabaseHelper(this);

        Animal octopus = new Animal("Octopus", "Invertebrate");
        Animal shark = new Animal("Shark", "Fish");
        Animal salamander = new Animal("Salamander", "Amphibian");
        Animal alligator = new Animal("Alligator", "Reptile");
        Animal mockingbird = new Animal("Mockingbird", "Bird");
        Animal tiger = new Animal("Tiger", "Mammal");

        //save data to the database
        db.saveAnimal(octopus);
        db.saveAnimal(shark);
        db.saveAnimal(salamander);
        db.saveAnimal(alligator);
        db.saveAnimal(mockingbird);
        db.saveAnimal(tiger);


        Toast.makeText(this, "Database Populated", Toast.LENGTH_SHORT).show();

    }
}
