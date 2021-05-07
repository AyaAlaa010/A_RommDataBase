package com.example.amitrommdatabase.UI;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.amitrommdatabase.Adapter.UserAdapter;
import com.example.amitrommdatabase.DataBase.ContactsDataBase;
import com.example.amitrommdatabase.DataBase.MyContact;
import com.example.amitrommdatabase.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
UserAdapter userAdapter;
List<MyContact> contacts=new ArrayList<>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView) findViewById(R.id.myrecycler);
        contacts= ContactsDataBase.getInstance(this).contactDao().getContact();
        userAdapter=new UserAdapter(contacts);
        recyclerView.setAdapter(userAdapter);


    }

    public void openAddNoteActivity(View view) {
        startActivityForResult(new Intent(MainActivity.this,AddContactActivity.class),101);

    }

    @Override // make for refresh the added data to get all data in activity
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==101&& resultCode==RESULT_OK){
            contacts= ContactsDataBase.getInstance(this).contactDao().getContact();
            userAdapter=new UserAdapter(contacts);
            recyclerView.setAdapter(userAdapter);

        }


    }


//    EditInterface editInterface= new EditInterface() {
//        @Override
//        public void editDeleteuser(String name, String phone) {
//           // ContactsDataBase.getInstance(MainActivity.this).contactDao().addContact(mycontact);
//        }
//    };



}