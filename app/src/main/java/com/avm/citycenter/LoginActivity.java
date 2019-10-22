package com.avm.citycenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText loginPhoneNumEditText, loginPasswordEditText;
    private TextView loginButton, signUpButton, forgottenPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Giriş yapıldı", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        forgottenPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Şifremi sıfırlama postası gönderildi", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void bindViews() {
        // View binding işlemleri
        loginPhoneNumEditText = findViewById(R.id.loginPhoneNumberEditText);
        loginPasswordEditText = findViewById(R.id.loginPasswordEditText);

        loginButton = findViewById(R.id.loginPageLoginButton);
        signUpButton = findViewById(R.id.loginPageSignUpButton);
        forgottenPassword = findViewById(R.id.loginPageForgottenPassword);
    }
}
