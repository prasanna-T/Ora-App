package com.paperman.ora;



import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Emergency extends AppCompatActivity {
    ActivityResultLauncher<String[]> mPermissionResultLauncher;
    private boolean isCallPermissionGranted=false;
    String wnum="100";
    String ambu="108";
    String Tow="1033";
    String firs="1800-180-1104";

    private static final int REQUEST_CALL=1;
    ArrayList<Integer>imageIDList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        imageIDList=new ArrayList<>();
        setInitialData();
        BoomMenuButton bm=findViewById(R.id.boommenu);
        bm.setButtonEnum(ButtonEnum.TextOutsideCircle);
        bm.setPiecePlaceEnum(PiecePlaceEnum.DOT_4_2);
        bm.setButtonPlaceEnum(ButtonPlaceEnum.SC_4_2);
        for(int i=0;i<bm.getPiecePlaceEnum().pieceNumber();i++){
            TextOutsideCircleButton.Builder builder=new TextOutsideCircleButton.Builder()
                    .normalImageRes(imageIDList.get(i))
                    .listener(new OnBMClickListener() {
                        @Override
                        public void onBoomButtonClick(int index) {
                            if(index==0){
                                Intent dial=new Intent(Intent.ACTION_CALL);
                                dial.setData(Uri.parse("tel:"+wnum));
                                startActivity(dial);
                            }
                            else if(index==1){
                                Intent dial=new Intent(Intent.ACTION_CALL);
                                dial.setData(Uri.parse("tel:"+ambu));
                                startActivity(dial);

                            }
                            else if(index==2){
                                Intent dial=new Intent(Intent.ACTION_CALL);
                                dial.setData(Uri.parse("tel:"+Tow));
                                startActivity(dial);
                            }
                            else if (index==3){
                                Intent dial=new Intent(Intent.ACTION_CALL);
                                dial.setData(Uri.parse("tel:"+firs));
                                startActivity(dial);
                            }


                        }
                    });
            bm.addBuilder(builder);

        }
        mPermissionResultLauncher=registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback<Map<String, Boolean>>() {
            @Override
            public void onActivityResult(Map<String, Boolean> result) {
                if (result.get(android.Manifest.permission.CALL_PHONE) != null) {
                    isCallPermissionGranted = result.get(Manifest.permission.CALL_PHONE);
                }
            }
        });
        requestPermissions();


    }


    private void setInitialData() {
        imageIDList.add(R.drawable.police);
        imageIDList.add(R.drawable.ambulance);
        imageIDList.add(R.drawable.tow);
        imageIDList.add(R.drawable.firstaid);
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