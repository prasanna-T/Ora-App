package com.paperman.ora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Loginpage extends AppCompatActivity {
    Button b3,b4;
    TextInputEditText e1,e2;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    ProgressDialog progressdialog;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        e1=findViewById(R.id.us);
        b4=findViewById(R.id.g);
        e2=findViewById(R.id.pa);
        b3=findViewById(R.id.reg);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        progressdialog=new ProgressDialog(this);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam = e1.getText().toString();
                String passs = e2.getText().toString();

                if (nam.isEmpty()) {
                    Toast.makeText(Loginpage.this, "Enter the mail id", Toast.LENGTH_SHORT).show();
                } else if (passs.isEmpty()) {
                    Toast.makeText(Loginpage.this, "Enter the password", Toast.LENGTH_SHORT).show();
                } else{


                    mAuth.signInWithEmailAndPassword(nam, passs).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                sendUSerActivity();
                                progressdialog.dismiss();
                                Toast.makeText(Loginpage.this, "Login successful", Toast.LENGTH_SHORT).show();
                            } else {
                                progressdialog.dismiss();
                                Toast.makeText(Loginpage.this, "login unsuccessful", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                    progressdialog.setMessage("Logging in");
                    progressdialog.setTitle("Logging in");
                    progressdialog.setCanceledOnTouchOutside(false);
                    progressdialog.show();
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ob7=new Intent(Loginpage.this,Register.class);
                startActivity(ob7);
            }
        });
    }

    private void sendUSerActivity() {
        Intent ob3 = new Intent(Loginpage.this, Homepage.class);
        startActivity(ob3);
        finish();
    }

}

