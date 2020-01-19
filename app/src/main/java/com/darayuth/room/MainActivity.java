package com.darayuth.room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    private UserDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = UserDatabase.getInstance(this);
        new DatabaseAync().execute();
    }
    private class DatabaseAync extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            User user = new User();
            user.setFirstName("john");
            user.setLastName("mage");

            database.userDao().insert(user);
            return null;
        }
    }
}
