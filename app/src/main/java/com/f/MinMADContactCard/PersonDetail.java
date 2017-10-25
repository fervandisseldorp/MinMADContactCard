package com.f.MinMADContactCard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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
        ImageView imageV = (ImageView) findViewById(R.id.personImageV);
        TextView emailTv = (TextView) findViewById(R.id.emailtextView);

        nameTv.setText(selectedPerson.getFirstName() + " " + selectedPerson.getLastName() );
        emailTv.setText(selectedPerson.getEmail());

        Picasso.with(this).load( selectedPerson.getImageUrl() ).transform( new RoundedCornersTransform() ).into(imageV);


    }
}
