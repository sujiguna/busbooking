package com.example.hp.susithra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Navigation extends AppCompatActivity {
    private Button home,signout;

    private Button updatepassword;
    private Button history;
    private Button profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        signout=(Button)findViewById(R.id.bout);
        home=(Button)findViewById(R.id.bhome);
        updatepassword=(Button)findViewById(R.id.bupdatepassword);
        history=(Button)findViewById(R.id.bhistory);
        profile=(Button)findViewById(R.id.bprofile);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent= new Intent(Navigation.this,Home.class);
                startActivity(intent);
            }
        });


        updatepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent= new Intent(Navigation.this,UpdatePassword.class);
                startActivity(intent);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent= new Intent(Navigation.this,History.class);
                startActivity(intent);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent= new Intent(Navigation.this,UserDetails.class);
                startActivity(intent);
            }
        });
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                FirebaseAuth.getInstance().signOut();
                Intent intent= new Intent(Navigation.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
