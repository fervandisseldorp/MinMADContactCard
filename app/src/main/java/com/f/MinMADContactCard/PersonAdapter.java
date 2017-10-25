package com.f.MinMADContactCard;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

// import com.squareup.picasso.Picasso;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ferdinand on 12-10-2017.
 */

public class PersonAdapter extends ArrayAdapter<Person> {

    public PersonAdapter(Context context, ArrayList<Person> persons) {
        super(context, 0, persons);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Recyle view (eventueel)
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_row, parent, false);
        }

        // layout components
        TextView nameTV = (TextView) convertView.findViewById(R.id.nametv);
        ImageView personThumb = (ImageView) convertView.findViewById(R.id.imagethumb);

        Person p = getItem(position);

        nameTV.setText(p.getFirstName() + " " + p.getLastName());
        Picasso.with(getContext()).load(p.getThumbnailUrl()).into(personThumb);

        // Beetje animeren
        convertView.setAlpha(0.01f);
        convertView.animate().alpha(1.0f).setDuration(2000);

        // return View
        return convertView;

    }
}
