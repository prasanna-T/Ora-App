package com.paperman.ora;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class Contactus extends AppCompatActivity {
    ActivityResultLauncher<String[]> mPermissionResultLauncher;
    private boolean isCallPermissionGranted=false;
    String wnum="7358503339";
    private static final int REQUEST_CALL=1;
    ImageView sun,dayland;
    View daysky,nightsky;
    SwitchCompat daynight;
    Button ca_1,w_1;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        sun=findViewById(R.id.sun);
        dayland=findViewById(R.id.day_landscape);
        ca_1=findViewById(R.id.butto);
        daysky=findViewById(R.id.day_bg);
        w_1=findViewById(R.id.web);
        nightsky=findViewById(R.id.night_bg);
        daynight=findViewById(R.id.DayNightSwitch);

        sun.setTranslationY(-110);
        daynight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    sun.animate().translationY(113).setDuration(1000);
                    dayland.animate().alpha(0).setDuration(1300);
                    daysky.animate().alpha(0).setDuration(1300);
                }
                else{
                    sun.animate().translationY(-350).setDuration(1000);
                    dayland.animate().alpha(1).setDuration(1300);
                    daysky.animate().alpha(1).setDuration(1300);
                }

                }

        });
        mPermissionResultLauncher=registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback<Map<String, Boolean>>() {
            @Override
            public void onActivityResult(Map<String, Boolean> result) {
                if (result.get(android.Manifest.permission.CALL_PHONE) != null) {
                    isCallPermissionGranted = result.get(Manifest.permission.CALL_PHONE);
                }
            }
        });
        requestPermissions();
        ca_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dial=new Intent(Intent.ACTION_CALL);
                dial.setData(Uri.parse("tel:"+wnum));
                startActivity(dial);

            }
        });
        w_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLink("https://ora-alpha2.web.app/home");
            }
        });




    }

    private void goLink(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }

    private void requestPermissions() {
        isCallPermissionGranted= ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CALL_PHONE
        )== PackageManager.PERMISSION_GRANTED;
        List<String> permissionRequest=new ArrayList<String>();
        if (!isCallPermissionGranted){
            permissionRequest.add(Manifest.permission.CALL_PHONE);
        }
        if (!permissionRequest.isEmpty()){
            mPermissionResultLauncher.launch(permissionRequest.toArray(new String[0]));
        }

    }

}