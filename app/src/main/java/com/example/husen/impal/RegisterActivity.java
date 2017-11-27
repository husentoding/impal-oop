package com.example.husen.impal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import database.DatabaseHelper;
import model.Employee;
import module.AccountModule;

public class RegisterActivity extends AppCompatActivity {

    AccountModule AM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        AM= new AccountModule(getApplicationContext());


        final EditText editUsername= (EditText) findViewById(R.id.regis_username);
        final EditText editPassword= (EditText) findViewById(R.id.regis_password);
        final EditText editName= (EditText) findViewById(R.id.regis_name);
        final EditText editAddress= (EditText) findViewById(R.id.regis_address);
        final Button buttonSignup= (Button) findViewById(R.id.buttonSignUp);

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_content= editUsername.getText().toString();
                String password_content= editPassword.getText().toString();
                String name_content= editName.getText().toString();
                String address_content= editAddress.getText().toString();

                if(TextUtils.isEmpty(username_content) || TextUtils.isEmpty(password_content) || TextUtils.isEmpty(name_content) || TextUtils.isEmpty(address_content)){
                    Toast.makeText(RegisterActivity.this, "Please fill the form", Toast.LENGTH_SHORT).show();
                }else{
                    //create model
                    Employee e= new Employee(0, username_content, password_content, name_content, address_content);
                    boolean cek= AddUser(e);
                    if(cek){
                        Toast.makeText(RegisterActivity.this, "Account Created", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(RegisterActivity.this, "Something wrong!", Toast.LENGTH_SHORT).show();
                    }
                    //register to db here

                }

            }
        });


    }

    public boolean AddUser(Employee e){

        return true;
    }
}
