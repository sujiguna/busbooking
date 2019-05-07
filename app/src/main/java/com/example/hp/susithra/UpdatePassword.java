package com.example.hp.susithra;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UpdatePassword extends AppCompatActivity  {
    private EditText mail;
    private Button change;
    private FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);
        mauth = FirebaseAuth.getInstance();
        mail=(EditText)findViewById(R.id.etmail);
        change=(Button)findViewById(R.id.bchange);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mauth.sendPasswordResetEmail(mail.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(UpdatePassword.this,"Change link sent to your email",Toast.LENGTH_LONG).show();
                                }
                                else {
                                    Toast.makeText(UpdatePassword.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                }
                            }
                        });

            }
        });


        }

}