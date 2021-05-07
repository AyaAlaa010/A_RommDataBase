package com.example.amitrommdatabase.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts")
public class MyContact {



    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private  int id;
    @ColumnInfo(name="name")
    private String name;
    @ColumnInfo(name="phone")
    private String phone;

    public MyContact() {
    }

    public MyContact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
