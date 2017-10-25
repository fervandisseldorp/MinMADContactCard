package com.f.MinMADContactCard;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by ferdinand on 10-10-2017.
 */

public class ListActivity extends AppCompatActivity implements OnRandomUserAvailable {
    ListView listView;
    ArrayList<Person> persons = new ArrayList<Person>();
    ArrayAdapter<Person> adapter;
    PersonsDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // layout components
        setContentView(R.layout.activity_list);
        listView = (ListView) findViewById(R.id.listview);


        // DATABASE SETUP
        if(database == null){
            System.out.println("Creating new Database");
            database = new PersonsDatabase(this);

        }

        database.clearDbforTestingPurposes();


        // Adapter setup
        adapter = new PersonAdapter( getApplicationContext(), persons);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        // Item clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), PersonDetail.class);
                Person selectedPerson = (Person) persons.get( position );

                intent.putExtra("PERSON", selectedPerson);
                startActivity(intent);
            }
        });

        // get data in app
        getRandomPersons();
        //updateCachedPersons();
    }

    void getRandomPersons() {
        String[] urls = new String[] { "https://randomuser.me/api/" };
        for(int idx = 0; idx < 5; idx++) {
            AsyncUserTask getRandomUser = new AsyncUserTask(this);
            getRandomUser.execute(urls);
        }
    }

    @Override
    public void OnRandomUserAvailable(Person person) {
            database.insertPerson(person);
            persons.add(person);
            adapter.notifyDataSetChanged();
    }

    public void updateCachedPersons(){
        Cursor cursor = database.getPersons();
        cursor.moveToFirst();
        System.out.println("cursor count: " + cursor.getCount());
        while( cursor.moveToNext() ) {
            try{
                String firstname = cursor.getString(cursor.getColumnIndex("firstname"));
                String lastname = cursor.getString(cursor.getColumnIndex("lastname"));
                String email = cursor.getString(cursor.getColumnIndex("email"));
                String thumbnailUrl = cursor.getString(cursor.getColumnIndex("thumbnailUrl"));
                String imageUrl = cursor.getString(cursor.getColumnIndex("imageUrl"));
                Person p = new Person(firstname, lastname, email, thumbnailUrl, imageUrl);
                System.out.println("adding peraon: " + p.toString());
                persons.add(p);
            }

            catch(Exception ex){
                System.out.println(ex.getMessage());
            }

        }
        adapter.notifyDataSetChanged();
    }
}
