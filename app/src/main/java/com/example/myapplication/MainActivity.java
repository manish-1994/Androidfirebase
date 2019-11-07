package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
EditText txtname,txtphone;
Button btnsave,view;
DatabaseReference reff;
Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtname=(EditText)findViewById(R.id.name1);
        txtphone = (EditText)findViewById(R.id.number1);
        btnsave= (Button)findViewById(R.id.button1);
        member = new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            member.setName(txtname.getText().toString().trim());
            member.setPhnumber(txtphone.getText().toString().trim());
            if (txtname.length()>0 && txtphone.length()>0 ) {
            reff.push().getKey();
            reff.setValue(member);
            Toast.makeText(MainActivity.this,"Data is sucesfully sent",Toast.LENGTH_LONG).show();
                openactivity();
            }
            else{
                    Toast.makeText(MainActivity.this,"The fields are Empty",Toast.LENGTH_LONG).show();
            }

            }

        });
    }
    public void openactivity(){
        Intent i = new Intent(this,viewactivity.class);
        startActivity(i);
    }
}
