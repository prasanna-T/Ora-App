package com.paperman.ora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Showall extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Model>list;
    private MyAdaptor adaptor;
    private DatabaseReference root= FirebaseDatabase.getInstance().getReference("Image");

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showall);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        adaptor=new MyAdaptor(this, list, new MyAdaptor.ItemClickListner() {
            @Override
            public void onitemClick(Model model) {
                intent();
            }
        });
        recyclerView.setAdapter(adaptor);
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Model model=dataSnapshot.getValue(Model.class);
                    list.add(model);
                }
                adaptor.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void intent() {
        Intent o=new Intent(Showall.this,Comment.class);
        startActivity(o);
    }
}