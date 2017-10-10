package com.f.MinMADContactCard;

import android.content.Intent;
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

public class ListActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Person> persons = new ArrayList<Person>();
    ArrayAdapter<Person> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // layout components
        setContentView(R.layout.activity_list);
        listView = (ListView) findViewById(R.id.listview);

        // mocking some data
        Person p1 = new Person(0, "tester", 12);
        Person p2 = new Person(1, "testertje2", 17);
        Person p3 = new Person(2, "teeest", 25);
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);

        // Adapter setup
        adapter = new ArrayAdapter<Person>(getApplicationContext(), android.R.layout.simple_list_item_1, persons);
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
    }
}
