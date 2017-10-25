package com.f.MinMADContactCard;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by ferdinand on 12-10-2017.
 */

public class AsyncUserTask extends AsyncTask<String, Void, String> {
    private OnRandomUserAvailable listener;

    public AsyncUserTask(OnRandomUserAvailable listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... params) {
        InputStream inputStream = null;
        BufferedReader reader = null;
        String urlString = "";
        String response = "";

        try {
            URL url = new URL(params[0]);
            URLConnection connection = url.openConnection();

            reader = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));
            response = reader.readLine().toString();
            String line;
            while ((line = reader.readLine()) != null) {
                response += line;
            }
        } catch (MalformedURLException e) {
            Log.e("TAG", e.getLocalizedMessage());
            return null;
        } catch (IOException e) {
            Log.e("TAG", e.getLocalizedMessage());
            return null;
        } catch (Exception e) {
            Log.e("TAG", e.getLocalizedMessage());
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.e("TAG", e.getLocalizedMessage());
                    return null;
                }
            }
        }

        return response;
    }

    protected void onPostExecute(String response) {
        if(response == null || response == "") {
            return;
        }

        JSONObject jsonObject;
        try {
            // Top level json object
            jsonObject = new JSONObject(response);

            // For every person
            JSONArray persons = jsonObject.getJSONArray("results");
            for(int i = 0; i < persons.length(); i++) {
                JSONObject user = persons.getJSONObject(i);

                JSONObject name = user.getJSONObject("name");
                    String title = name.getString("title");
                    String firstName = name.getString("first");
                    String lastName = name.getString("last");
                String email = user.getString("email");

                JSONObject picture = user.getJSONObject("picture");
                    String thumbUrl = picture.getString("thumbnail");
                    String imageurl = picture.getString("large");

                // Create new Person object
                Person p = new Person(firstName, lastName, email, thumbUrl, imageurl);


                listener.OnRandomUserAvailable(p);

            }
        } catch( JSONException ex) {
            System.out.println("json error");
        }
    }
}
