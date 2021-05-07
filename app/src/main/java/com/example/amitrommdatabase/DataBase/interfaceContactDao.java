package com.example.amitrommdatabase.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface interfaceContactDao {
    @Insert
    void addContact(MyContact contact);


    @Delete
    void deleteContact(MyContact contact);

    @Update
    void updateContact(MyContact contact);

    @Query("SELECT* FROM contacts")
    List<MyContact> getContact();
@Query("DELETE FROM contacts")
    void deleteAllContacts();

}
