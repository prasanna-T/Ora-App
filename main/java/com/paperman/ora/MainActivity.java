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
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN=3000;
    Animation sideani,bottom,sider,siderss;
    TextView oa,oo,or;
    ImageView wh;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oo=findViewById(R.id.n);
        or=findViewById(R.id.b);
        oa=findViewById(R.id.z);
        wh=findViewById(R.id.whe);
        bottom=AnimationUtils.loadAnimation(this,R.anim.bottomanimation);
        siderss=AnimationUtils.loadAnimation(this,R.anim.sideanims);
        sider=AnimationUtils.loadAnimation(this,R.anim.sideanim_r);
        oa.setAnimation(siderss);
        sideani=AnimationUtils.loadAnimation(this,R.anim.sideanimation);

        wh.setAnimation(sideani);
        oo.setAnimation(sider);
        or.setAnimation(bottom);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent ob3=new Intent(MainActivity.this,Loginpage.class);
                Pair[] pairs=new Pair[2];
                pairs[0]=new Pair<View,String>(wh,"logo_image");
                pairs[1]=new Pair<View,String>(oo,"logo_text");
                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                startActivity(ob3,options.toBundle());
                finish();
            }
        },SPLASH_SCREEN);



    }
}