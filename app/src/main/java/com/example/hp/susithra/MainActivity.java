package com.example.hp.susithra;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText mail;
    private EditText password;
    private Button login;
    private TextView info;
    private int count=3;
    private Button signup;
    private Button for_password;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        mail=(EditText)findViewById(R.id.etmail);
        password=(EditText)findViewById(R.id.etpass);
        login=(Button)findViewById(R.id.blogin);
        info=(TextView)findViewById(R.id.tinfo);
        signup=(Button)findViewById(R.id.bsignup);
        for_password=(Button)findViewById(R.id.bfor_password);
        info.setText("no of attempts remaining: 3");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email = mail.getText().toString().trim();
                String Pass = password.getText().toString().trim();
                signIn(Email,Pass);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {

                Intent intent= new Intent(MainActivity.this,Registration.class);
                startActivity(intent);

            }
        });

        for_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Intent intent= new Intent(MainActivity.this,ForgotPassword.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(mAuth.getCurrentUser() !=null){}
    }



    private void signIn(String email, String password) {

                 mAuth.signInWithEmailAndPassword(email, password)
                          .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                     @Override
                      public void onComplete(@NonNull Task<AuthResult> task) {
                                         if (task.isSuccessful()) {

                                                 FirebaseUser user = mAuth.getCurrentUser();
                                             Intent intent= new Intent(MainActivity.this,Navigation.class);
                                             intent.putExtra("userId",user.getUid().toString());
                                             startActivity(intent);

                                            } else {
                                         }
                                          // [START_EXCLUDE]
                                         if (!task.isSuccessful()) {
                                              count--;
                                              info.setText("no of attempts remaining:"+String.valueOf(count));
                                              if (count==0){
                                                  login.setEnabled(false);
                                              }
                                           }

                                       // [END_EXCLUDE]
                                    }
                  });

           }

}

