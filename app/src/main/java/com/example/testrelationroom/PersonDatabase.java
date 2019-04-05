package com.example.testrelationroom;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Person.class, PhoneNumbers.class}, version = 2)
public abstract class PersonDatabase extends RoomDatabase {
    private static PersonDatabase instance;

    public abstract PersonDao personDao();
    public abstract PhoneDao phoneDao();

    public static synchronized PersonDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext()
                    , PersonDatabase.class, "person_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
