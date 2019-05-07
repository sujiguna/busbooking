package com.example.hp.susithra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.susithra.AccountActivity.journey;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Home extends AppCompatActivity {
     private EditText date,seat;
     private Button check;
     private RadioGroup radioGroup1,radioGroup2,radioGroup3;
     private RadioButton radioButton1,radioButton2,radioButton3;
    DatabaseReference ref;
    FirebaseDatabase database;
     journey j1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        date=(EditText)findViewById(R.id.edate);
        seat=(EditText)findViewById(R.id.eseats);
        radioGroup1=(RadioGroup)findViewById(R.id.radioGroup1);
        radioGroup2=(RadioGroup)findViewById(R.id.radioGroup2);
        radioGroup3=(RadioGroup)findViewById(R.id.radioGroup3);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference().child("journey");
        ref.setValue(j1);
        check=(Button)findViewById(R.id.bcheck);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkButton1(v);
                checkButton2(v);
                checkButton3(v);
                details();
                finish();

            }
        });


    }
    private void details(){
        final String loc=radioButton2.getText().toString().trim();
        final String des=radioButton3.getText().toString().trim();
        final String dt=date.getText().toString().trim();
        final int seats=Integer.parseInt(seat.getText().toString());
        final String type=radioButton1.getText().toString();

         journey j1=new journey(loc,des,dt,type,seats);
       ref.push().setValue(j1);
        Toast.makeText(Home.this,"details of the journey saved...",Toast.LENGTH_LONG).show();

    }



   private void checkButton1(View v){
        int radioId=radioGroup1.getCheckedRadioButtonId();
        radioButton1=findViewById(radioId);

   }

    private void checkButton2(View v){
        int radioId2=radioGroup2.getCheckedRadioButtonId();
        radioButton2=findViewById(radioId2);

    }
    private void checkButton3(View v){
        int radioId3=radioGroup3.getCheckedRadioButtonId();
        radioButton3=findViewById(radioId3);

    }
}




