package com.example.amitrommdatabase.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amitrommdatabase.DataBase.ContactsDataBase;
import com.example.amitrommdatabase.DataBase.MyContact;
import com.example.amitrommdatabase.R;

public class AddContactActivity extends AppCompatActivity {
EditText editName,editPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        editName=(EditText) findViewById(R.id.ed_name);
        editPhone=(EditText) findViewById(R.id.ed_phone);



    }

    public void addContact(String name,String phone) {
        MyContact contact= new MyContact(name,phone);
        ContactsDataBase.getInstance(this).contactDao().addContact(contact);
        Toast.makeText(AddContactActivity.this,"contact added", Toast.LENGTH_LONG).show();
        setResult(RESULT_OK);
        finish();
    }

    public void getDataFromUI(View view) {
        String name=editName.getText().toString().trim();
        String phone=editPhone.getText().toString().trim();
        if(name.isEmpty()|| phone.isEmpty()){
            Toast.makeText(AddContactActivity.this,"please fill data", Toast.LENGTH_LONG).show();
            return;
        }
        addContact(name,phone);

    }
}