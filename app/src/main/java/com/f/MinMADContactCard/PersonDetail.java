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
        TextView nameTextView = (TextView) findViewById(R.id.nametextview);
        TextView ageTextView = (TextView) findViewById(R.id.agetextView);
    }
}
