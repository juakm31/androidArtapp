package com.example.artapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.artapp.R;
import com.example.artapp.principal.PaginaPrincipalActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);


    }

public void sendPrincipal(View view) {
    Intent intent = new Intent(LoginActivity.this, PaginaPrincipalActivity.class);
    startActivity(intent);
}
}

