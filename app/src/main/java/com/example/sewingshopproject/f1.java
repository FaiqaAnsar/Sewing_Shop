package com.example.sewingshopproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class f1 extends Fragment {

    Button btn;

    RecyclerView recyclerView;
    ArrayList<Feed> list;
    DatabaseReference reff;
    FBAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_f1, container, false);
        btn = (Button) myView.findViewById(R.id.btn);
        recyclerView = (RecyclerView) myView.findViewById(R.id.recycleview);
        reff = FirebaseDatabase.getInstance().getReference("feedb");
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new FBAdapter(this.getContext(),list);
        recyclerView.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),FeedBack.class));

            }
        });
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Feed feedb = dataSnapshot.getValue(Feed.class);
                    list.add(feedb);
                }
                adapter.notifyDataSetChanged();
            }@Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return myView;
    }
}