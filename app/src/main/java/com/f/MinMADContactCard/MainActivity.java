package com.f.MinMADContactCard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button showListButton;
    TextView titleView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // layout components
        setContentView(R.layout.activity_main);
        showListButton = (Button) findViewById(R.id.showListButton);
        titleView = (TextView) findViewById(R.id.titleView);

        // Button adapter
        showListButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getBaseContext(), ListActivity.class);
        startActivity(intent);
    }


}
