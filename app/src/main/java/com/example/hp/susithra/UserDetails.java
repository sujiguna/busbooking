package com.example.hp.susithra;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hp.susithra.AccountActivity.userX;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserDetails extends AppCompatActivity {
ListView listView;
FirebaseDatabase db;
DatabaseReference ref;
ArrayList<String> list;
ArrayAdapter<String> adapter;
userX u1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        u1=new userX();
        listView=(ListView)findViewById(R.id.listview);
        list=new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,R.layout.user_info,R.id.user_info,list);
        db=FirebaseDatabase.getInstance();
        ref=db.getReference("users");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren() ){
                  u1=ds.getValue(userX.class);
                  list.add(u1.getName().toString()+" "+u1.getEmail().toString()+" "+u1.getNum().toString()+" "+u1.getAddress().toString());
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
