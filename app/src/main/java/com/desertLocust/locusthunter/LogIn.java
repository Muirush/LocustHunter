package com.desertLocust.locusthunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
    DbHelper dbHelper1;
    EditText edname, edpass;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        dbHelper1 = new DbHelper(this);
        edname = findViewById(R.id.lUsername);
        edpass = findViewById(R.id.lPassword);
        btn  = findViewById(R.id.lLogin);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String U = edname.getText().toString();
                String P  = edpass.getText().toString();
                boolean checkUP = dbHelper1.checkPasswordName(U, P);
                if (checkUP == true){
                    Intent intent = new Intent(LogIn.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else
                    Toast.makeText(LogIn.this, "Invalid log in", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void regActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), Register.class);
        startActivity(intent);
        finish();

    }


}