package com.darayuth.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = User.class, exportSchema = false, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static final String DB_NAME = "user_db";
    public static UserDatabase instance;

    //create singleton for database;
    public static synchronized UserDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class,
                    DB_NAME).fallbackToDestructiveMigration().build();
        }
        return instance;
    }
    public abstract UserDao userDao();
}
