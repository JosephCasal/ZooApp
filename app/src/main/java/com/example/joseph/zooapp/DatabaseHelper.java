package com.example.joseph.zooapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joseph on 10/3/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    //when you change the schema, change the version number

    private static final String DATABASE_NAME = "Animals.db";

    private static final String TABLE_NAME = "Animals";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_TYPE = "Type";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_NAME + " TEXT PRIMARY KEY, " +
                COLUMN_TYPE + " TEXT" +
                ")";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE ID EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long saveAnimal(Animal animal){

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //key column name, value
        contentValues.put(COLUMN_NAME, animal.getName());
        contentValues.put(COLUMN_TYPE, animal.getType());

        //database.insert returns row value where this data was saved
        long isSaved = database.insert(TABLE_NAME, null, contentValues);

        return isSaved;

    }

    public List<Animal> getAnimalList(String type){

        List<Animal> animalList = new ArrayList<>();
        SQLiteDatabase databse = this.getWritableDatabase();

//        SELECT DISTINCT COLUMN_CATEGORY FROM TABLE_NAME

        String QUERY = "SELECT * from " + TABLE_NAME + " WHERE " + COLUMN_TYPE + "=" + type;
        Cursor cursor = databse.rawQuery(QUERY, null);
//        String QUERY = "SELECT * from " + TABLE_NAME + " where name = ?";
//        Cursor cursor = databse.rawQuery(QUERY, new String[]{"34"});

        //returns boolean true if there is a record
        if(cursor.moveToFirst()){
            do {
                Animal animal = new Animal(
                        cursor.getString(0),
                        cursor.getString(1));
                animalList.add(animal);
            } while(cursor.moveToNext());
        }

        return animalList;

    }

}
