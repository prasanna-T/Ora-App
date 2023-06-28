package com.paperman.ora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class Logout extends AppCompatActivity {
    LottieAnimationView lo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        lo=findViewById(R.id.lottie);

        lo.animate().translationX(2000).setDuration(2000).setStartDelay(2900);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Logout.this, "logout successful", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),Loginpage.class);
                startActivity(i);
                finish();
            }
        },5000);
    }
}