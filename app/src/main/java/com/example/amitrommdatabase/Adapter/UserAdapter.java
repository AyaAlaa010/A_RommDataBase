package com.example.amitrommdatabase.Adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amitrommdatabase.DataBase.ContactsDataBase;
import com.example.amitrommdatabase.DataBase.MyContact;
import com.example.amitrommdatabase.R;
import com.example.amitrommdatabase.UI.EditeUserActivity;
import com.example.amitrommdatabase.UI.MainActivity;


import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

   List<MyContact> contacts;

//TextInputEditText editTitle,editBodey;
    public UserAdapter(List<MyContact> contacts) {

        this.contacts = contacts;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items_recycler,parent,false);
        UserHolder myUserHolder=new UserHolder(view);
        return myUserHolder;    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        MyContact myContact=contacts.get(position) ;
        holder.tvTitle.setText(myContact.getName());
        holder.tvBodey.setText(myContact.getPhone());
        holder.menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(v.getContext(),v);
                popupMenu.getMenuInflater().inflate(R.menu.menu,popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId()==R.id.item_delete) {

                            new AlertDialog.Builder(v.getContext()).setMessage("are you sure to delete this article")
                                    .setNegativeButton("cancle", null)
                                    .setPositiveButton("delete", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            ContactsDataBase.getInstance(v.getContext()).contactDao().deleteContact(myContact);
                                            contacts.remove(position);
                                            notifyDataSetChanged();
                                        }
                                    }).show();


                            //##############

                        }
                        else if(item.getItemId()==R.id.item_update){

                            Intent intent=new Intent(v.getContext(), EditeUserActivity.class);
                            intent.putExtra("NAME", holder.tvTitle.getText().toString());
                            intent.putExtra("PHONE", holder.tvBodey.getText().toString());
                          //  intent.putExtra("id",myContact.getId());

                            v.getContext().startActivity(intent);

                        }

                        return false;                    }
                });




            }
        });



    }





    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class UserHolder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvBodey ;
        ImageView menuButton;

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.tv_title);
            tvBodey=itemView.findViewById(R.id.tv_bodey);
            menuButton=itemView.findViewById(R.id.mymenue);
        }
    }
}
