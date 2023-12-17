package com.example.applicationtpdevmobile.vue;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.applicationtpdevmobile.R;
import com.example.applicationtpdevmobile.controller.LoginController;

public class MainActivity2 extends AppCompatActivity {

    private Button btnConsultation;
    private EditText etUserName;
    private EditText etPassword;
    private LoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();

        etUserName.setText(loginController.getUserName());
        etPassword.setText(loginController.getPassword());

        btnConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName, password;
                boolean verifUserName = false, verifPassword = false;

                if(!etUserName.getText().toString().isEmpty())
                    verifUserName = true;
                else
                    Toast.makeText(MainActivity2.this, "Veuillez saisir votre nom d'utilisateur !", Toast.LENGTH_SHORT).show();

                if(!etPassword.getText().toString().isEmpty())
                    verifPassword = true;
                else
                    Toast.makeText(MainActivity2.this, "Veuillez saisir votre mot de passe !", Toast.LENGTH_LONG).show();

                if(verifPassword && verifUserName) {
                    userName = etUserName.getText().toString();
                    password = etPassword.getText().toString();
                    loginController.createUser(userName, password, MainActivity2.this);
                    Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void init()
    {
        loginController = LoginController.getInstance(MainActivity2.this);
        btnConsultation = (Button) findViewById(R.id.btnConsultation);
        etPassword = (EditText) findViewById(R.id.nomutilisateur);
        etUserName = (EditText) findViewById(R.id.mdp);
    }
}