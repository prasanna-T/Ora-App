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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    TextInputEditText b1,b2;
    Button b3;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    ProgressDialog progressdialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        b1=findViewById(R.id.us1);
        b2=findViewById(R.id.pa1);
        b3=findViewById(R.id.re1);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        progressdialog=new ProgressDialog(this);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam=b1.getText().toString();
                String pas=b2.getText().toString();

                if (nam.isEmpty()){
                    Toast.makeText(Register.this, "Enter the mail id", Toast.LENGTH_SHORT).show();
                }
                else if (pas.isEmpty()){
                    Toast.makeText(Register.this, "Enter the password", Toast.LENGTH_SHORT).show();
                }
                else {
                    mAuth.createUserWithEmailAndPassword(nam, pas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                progressdialog.dismiss();
                                sendUsertonextActivity();
                                Toast.makeText(Register.this, "Registration successfull", Toast.LENGTH_SHORT).show();
                            } else {
                                progressdialog.dismiss();
                                Toast.makeText(Register.this, "Already Account Registered", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                    progressdialog.setMessage("Registration");
                    progressdialog.setTitle("Registration");
                    progressdialog.setCanceledOnTouchOutside(false);
                    progressdialog.show();
                }



            }
        });
    }

    private void sendUsertonextActivity() {
        Intent ob1=new Intent(Register.this,Loginpage.class);
        startActivity(ob1);
    }
}
