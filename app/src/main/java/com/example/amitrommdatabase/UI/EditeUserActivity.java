package com.example.amitrommdatabase.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.amitrommdatabase.DataBase.ContactsDataBase;
import com.example.amitrommdatabase.DataBase.MyContact;
import com.example.amitrommdatabase.R;
import com.google.android.material.textfield.TextInputEditText;


public class EditeUserActivity extends AppCompatActivity {
    TextInputEditText editName, editPhone;
    MyContact mycontact;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edite_user);
        editName = (TextInputEditText) findViewById(R.id.edit_bodey_edd);
        editPhone = (TextInputEditText) findViewById(R.id.edit_title_edd);

//        if(getIntent().hasExtra("edit")) {
//
//            note = (Note) getIntent().getSerializableExtra("edit");
//        }
        Intent intent=getIntent();
          String useName=intent.getStringExtra("NAME");
     String userPhone=intent.getStringExtra("PHONE");
      //   id=intent.getIntExtra("id",0);

        editPhone.setText(userPhone);
        editName.setText(useName);


    }
    public void editeContact(String name,String phone) {
        MyContact contact= new MyContact(name,phone);
        ContactsDataBase.getInstance(this).contactDao().updateContact(contact);
        Toast.makeText(EditeUserActivity.this,"contact edited", Toast.LENGTH_LONG).show();
        finish();
    }

    public void getDataFromUi(View view){
        String name=editName.getText().toString().trim();
        String phone=editPhone.getText().toString().trim();
        if(name.isEmpty()|| phone.isEmpty()){
            Toast.makeText(EditeUserActivity.this,"please fill data", Toast.LENGTH_LONG).show();
            return;
        }
        editeContact(name,phone);



    }







}