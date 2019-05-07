package com.example.hp.susithra;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;

import com.example.hp.susithra.AccountActivity.user;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Registration extends AppCompatActivity implements View.OnClickListener{
         private EditText name,email,num,address,pass,con_pass;
         private Button signup;
         private FirebaseAuth mauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mauth = FirebaseAuth.getInstance();
        name=(EditText)findViewById(R.id.tusername);
        email=(EditText)findViewById(R.id.temail);
        num=(EditText)findViewById(R.id.tmob_no);
        address=(EditText)findViewById(R.id.tadddress);
        pass=(EditText)findViewById(R.id.tpassword);
        con_pass=(EditText)findViewById(R.id.tcon_password);
        signup=(Button)findViewById(R.id.bsignup);
        signup.setOnClickListener(this);


    }

    private void register() {
        final String mail = email.getText().toString().trim();
        final String username = name.getText().toString().trim();
        final String number = num.getText().toString().trim();
        final String add = address.getText().toString().trim();
        String password = pass.getText().toString().trim();
        String c_pass = con_pass.getText().toString().trim();

        if (TextUtils.isEmpty(mail)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Please enter username", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(number)) {
            Toast.makeText(this, "Please enter telephone number", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(add)) {
            Toast.makeText(this, "Please enter address", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(c_pass)) {
            Toast.makeText(this, "Please confirm password", Toast.LENGTH_LONG).show();
            return;
        }

        if (!c_pass.equals(password)) {
            Toast.makeText(this, "password doesn't match", Toast.LENGTH_LONG).show();
            return;
        }

        mauth.createUserWithEmailAndPassword(mail, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //create an object to store the datas of the user
                            user u1=new user(username,mail,number,add);
                            FirebaseDatabase.getInstance().getReference("users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(u1).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(Registration.this, "Authentication successful.",
                                                Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                        } else {
                            Toast.makeText(Registration.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mauth.getCurrentUser();
        if(mauth.getCurrentUser() !=null){
            //handles the already signed in user

        }
    }
    @Override
    public void onClick(View v) {
        register();
    }

}
