package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class viewactivity extends AppCompatActivity {
    TextView a,b;
    Button view;
    DatabaseReference reff;
    FirebaseDatabase mdatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewactivity);
        a=(TextView)findViewById(R.id.n1) ;
        b=(TextView)findViewById(R.id.p1);
        view = (Button)findViewById(R.id.button1);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff = mdatabase.getInstance().getReference().child("Member");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String name = dataSnapshot.child("name").getValue().toString();
                        String number = dataSnapshot.child("phnumber").getValue().toString();
                        a.setText(name);
                        b.setText(number);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
