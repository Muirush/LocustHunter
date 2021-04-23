package com.desertLocust.locusthunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
        private EditText edUname, edPass, edConPass;
        DbHelper dbHelper;
        Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUname = findViewById(R.id.RUsername);
        edPass = findViewById(R.id.RPassword);
        edConPass = findViewById(R.id.R_confirmPassword);
        button = findViewById(R.id.R_register);

        dbHelper = new DbHelper(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edPass.getText().toString() != edConPass.getText().toString()){
                    edPass.setError("Passwords do not match");
                    edConPass.setError("Passwords do not match");

              boolean insert = dbHelper.insertData(edUname.getText().toString(),edPass.getText().toString());
              if (insert == true){
                  Toast.makeText(Register.this, "User created", Toast.LENGTH_SHORT).show();
              }else Toast.makeText(Register.this, "Error", Toast.LENGTH_SHORT).show();
              Intent intent = new Intent(Register.this, LogIn.class);
              startActivity(intent);
              finish();

                }
            }
        });

    }

    public void logActivity(View view) {
        Intent intent = new Intent(Register.this, LogIn.class);
        startActivity(intent);
        finish();
    }
}