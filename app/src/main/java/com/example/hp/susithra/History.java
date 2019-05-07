package com.example.hp.susithra;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hp.susithra.AccountActivity.journeyX;
import com.example.hp.susithra.AccountActivity.userX;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class History extends AppCompatActivity {
    ListView listView;
    FirebaseDatabase db;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    journeyX j1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        j1=new journeyX();
        listView=(ListView)findViewById(R.id.listview);
        list=new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,R.layout.journey_info,R.id.journey_info,list);
        db=FirebaseDatabase.getInstance();
        ref=db.getReference("journey");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren() ){
                    j1=ds.getValue(journeyX.class);
                    list.add(j1.getLocation().toString()+" "+j1.getDestination().toString()+" "+j1.getJdate().toString()+" "+j1.getJtype().toString()+" "+j1.getSeat()+"");
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
