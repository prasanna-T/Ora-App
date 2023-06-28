package com.paperman.ora;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.opengl.GLES20;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.Color;
import com.google.ar.sceneform.rendering.ExternalTexture;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class AugumentedReality extends AppCompatActivity {
    Button b1;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_augumented_reality);
        MediaController mediaController=new MediaController(this);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final VideoView videoView=(VideoView) findViewById(R.id.video);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
        b1=findViewById(R.id.amazon);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAmazonLink();
            }
        });

    }

    private void openAmazonLink() {
        Uri amazonUri = Uri.parse("https://amzn.eu/d/i4Cbu7t");
        Log.d("AR", "Opening Amazon link");

        Intent intent = new Intent(Intent.ACTION_VIEW, amazonUri);
        startActivity(Intent.createChooser(intent, "Open with"));


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}