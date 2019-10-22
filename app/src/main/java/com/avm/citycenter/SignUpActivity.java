package com.avm.citycenter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    private EditText signUpPhoneNumEditText, signUpNameEditText, signUpPasswordEditText, signUpMailEditText;
    private TextView termsOfUseTextView, signUpButton;
    private CheckBox termsOfUseCheckBox;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        toolbar = findViewById(R.id.signUpPageToolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.navigate_back);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        if(getActionBar() != null)
            getActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavUtils.navigateUpFromSameTask(SignUpActivity.this);
            }
        });

        bindViews();

        termsOfUseTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignUpActivity.this, "Kullanım Koşulları butonu", Toast.LENGTH_SHORT).show();
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignUpActivity.this, "Üye Ol butonu", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void bindViews() {
        // View binding işlemleri
        signUpPhoneNumEditText = findViewById(R.id.signUpPhoneNumberEditText);
        signUpMailEditText = findViewById(R.id.signUpMailEditText);
        signUpNameEditText = findViewById(R.id.signUpNameEditText);
        signUpPasswordEditText = findViewById(R.id.signUpPasswordEditText);
        signUpButton = findViewById(R.id.signUpPageSignUpButton);
        termsOfUseTextView = findViewById(R.id.termsOfUserTextView);
        termsOfUseCheckBox = findViewById(R.id.termsOfUseCheckBox);
    }
}
