package com.example.husen.impal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText email= (EditText) findViewById(R.id.email);
        final EditText password= (EditText) findViewById(R.id.password);
        final Button loginButton= (Button) findViewById(R.id.button);
        final Button regisButton= (Button)  findViewById(R.id.buttonregister);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailContent= email.getText().toString();
                String passwordContent= password.getText().toString();
                if (TextUtils.isEmpty(emailContent) || TextUtils.isEmpty(passwordContent)){
                    Toast.makeText(LoginActivity.this, "Please Fill Required Form", Toast.LENGTH_SHORT).show();
                }else{
                    if(emailContent.equals("panteque") && (passwordContent.equals("cinta"))){
                        Intent intent= new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "Username/Password Incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        regisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });


    }
}
