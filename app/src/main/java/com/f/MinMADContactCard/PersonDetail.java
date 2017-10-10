package com.f.MinMADContactCard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by ferdinand on 3-10-2017.
 */

public class PersonDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // layout components
        setContentView(R.layout.activity_detailed);

        Person selectedPerson = (Person) getIntent().getSerializableExtra("PERSON");
        TextView nameTv = (TextView) findViewById(R.id.nametextview);
        TextView ageTv = (TextView) findViewById(R.id.agetextView);

        String name = selectedPerson.getName();
        System.out.println("person name " + name);

        nameTv.setText("my name is " + name);
        ageTv.setText("My age is " + selectedPerson.getAge());
    }
}
