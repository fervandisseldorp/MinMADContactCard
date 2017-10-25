package com.f.MinMADContactCard;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

/**
 * Created by ferdinand on 24-10-2017.
 */

public class PersonsDatabase extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "persons.db";
    private static final int DATABASE_VERSION = 1;



    public PersonsDatabase(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public Cursor getPersons(){
        SQLiteDatabase db = getReadableDatabase();

        String query = "Select firstname, lastname, email, thumbnailUrl, imageUrl FROM person";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        return c;
    }

    public void insertPerson(Person person){
        System.out.println("Inserting a person into the database");
        SQLiteDatabase db = getWritableDatabase();

        String query = "INSERT INTO person (firstname, lastname, email, thumbnailUrl, imageUrl) VALUES ('"+ person.getFirstName()+"', '"+ person.getLastName()+"', '"+person.getEmail()+"', '"+person.getThumbnailUrl()+"', '"+person.getImageUrl()+"')";
        db.execSQL(query);
    }

    public void clearDbforTestingPurposes(){
        SQLiteDatabase db = getWritableDatabase();
        String query = "DELETE FROM person";
        db.execSQL(query);
    }

}
