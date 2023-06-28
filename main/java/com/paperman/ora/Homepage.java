package com.paperman.ora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Homepage extends AppCompatActivity {
    RelativeLayout b2,b5,a_r,eme,b0;
    ImageView b3,b6,emer;
    Animation sideani,bottom,sider,siderss;
    private static int SPLASH_SCREEN=0000;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        bottom= AnimationUtils.loadAnimation(this,R.anim.bottomanimation);
        siderss=AnimationUtils.loadAnimation(this,R.anim.sideanims);
        sider=AnimationUtils.loadAnimation(this,R.anim.sideanim_r);
        b2=findViewById(R.id.mech);
        b3=findViewById(R.id.car);
        emer=findViewById(R.id.emere);
        a_r=findViewById(R.id.ar);
        b5=findViewById(R.id.contact);
        b0=findViewById(R.id.community);
        eme=findViewById(R.id.emergen);
        b6=findViewById(R.id.search);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nearby=new Intent(Homepage.this,Findmechanic.class);
                startActivity(nearby);
            }
        });
        eme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent eme=new Intent(Homepage.this,Emergency.class);
               startActivity(eme);
            }
        });







        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o=new Intent(Homepage.this,Logout.class);
                startActivity(o);
                finish();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ne=new Intent(Homepage.this,Contactus.class);
                startActivity(ne);
            }
        });
        a_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(Homepage.this,AugumentedReality.class);
                startActivity(a);
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent comm=new Intent(Homepage.this,Community.class);
                startActivity(comm);
            }
        });

    }
}