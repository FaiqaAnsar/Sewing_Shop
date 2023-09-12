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

public class PlaceOrder extends AppCompatActivity {
    EditText name, address, cell, size,order;
    Button submit;
    DatabaseReference reff;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        name = findViewById(R.id.ed1);
        address = findViewById(R.id.ed2);
        cell = findViewById(R.id.ed4);
        size = findViewById(R.id.ed5);

        order = findViewById(R.id.ed3);
        submit = findViewById(R.id.btn);
        reff = FirebaseDatabase.getInstance().getReference();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
    }



    private void submit() {
        String username = name.getText().toString().trim();
        String useraddress = address.getText().toString().trim();
        String usercell = cell.getText().toString().trim();
        String usersize = size.getText().toString().trim();
        String userorder = order.getText().toString().trim();


        if (TextUtils.isEmpty(username)) {
            name.setError("please enter email ");

        } else if (TextUtils.isEmpty(useraddress)) {
            address.setError("please enter password");
        } else if (TextUtils.isEmpty(usercell)) {
            cell.setError("please enter password");
        } else if (TextUtils.isEmpty(usersize)) {
            size.setError("please enter password");
        } else if (TextUtils.isEmpty(userorder)) {
            order.setError("please enter password");
        } else {
            String id = reff.push().getKey();
            Customer customer = new Customer(username, useraddress, usercell, usersize,userorder);
            reff.child("Tailor1").child(id).setValue(customer).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(PlaceOrder.this, "User Details inserted", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }

        }
}