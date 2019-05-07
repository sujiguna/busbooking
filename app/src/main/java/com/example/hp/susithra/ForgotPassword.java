package com.example.hp.susithra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    private EditText mail;
    private Button sendmail;
    private FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        mauth = FirebaseAuth.getInstance();
        mail=(EditText)findViewById(R.id.etemail);
        sendmail=(Button)findViewById(R.id.bsend);

        sendmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              mauth.sendPasswordResetEmail(mail.getText().toString())
                      .addOnCompleteListener(new OnCompleteListener<Void>() {
                          @Override
                          public void onComplete(@NonNull Task<Void> task) {
                              if (task.isSuccessful()){
                                  Toast.makeText(ForgotPassword.this,"Reset link sent to your email",Toast.LENGTH_LONG).show();
                              }
                              else {
                                  Toast.makeText(ForgotPassword.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                              }
                          }
                      });

            }
        });
    }

}
