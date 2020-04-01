package com.example.mobile_uts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobile_uts.Models.Session;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameInput, passwordInput;
    private Session session;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        session = Application.getSession();

        usernameInput = findViewById(R.id.username);
        passwordInput = findViewById(R.id.password);

        if (session.isKeepUsername()){
            usernameInput.setText(session.getUsername());
        }
    }

    public void loginHandle(View view) {
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        boolean success = session.validate(username, password);
        if (success){
            session.setUsername(username);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            Snackbar.make(view, "Autentikasi gagal", Snackbar.LENGTH_SHORT).show();
        }
    }
}
