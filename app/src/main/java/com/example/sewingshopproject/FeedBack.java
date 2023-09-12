package com.example.sewingshopproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedBack extends AppCompatActivity {
    EditText name,msg;
    Button send;
    DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        name = findViewById(R.id.ed1);
        msg= findViewById(R.id.ed2);
        send= findViewById(R.id.btn);
        reff = FirebaseDatabase.getInstance().getReference();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
    }


    private void submit() {
        String username = name.getText().toString().trim();
        String usermsg = msg.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            name.setError("please enter email ");

        } else if (TextUtils.isEmpty(usermsg)) {
            msg.setError("please enter password");

        } else {
            String id = reff.push().getKey();
            Feed feed = new Feed(username, usermsg);
            reff.child("feedb").child(id).setValue(feed).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(FeedBack.this, "User Details inserted", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    }
}