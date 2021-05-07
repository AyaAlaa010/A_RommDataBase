package com.example.amitrommdatabase.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities=MyContact.class,exportSchema = false,version = 1)
public  abstract class ContactsDataBase  extends RoomDatabase {
    public abstract interfaceContactDao contactDao();
    private static ContactsDataBase instance;
public static ContactsDataBase getInstance(Context context) {
    if(instance==null){
    instance = Room.databaseBuilder(context, ContactsDataBase.class, "Contacts DB").allowMainThreadQueries().build();}
   return instance;}


}
