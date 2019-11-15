package com.example.artapp.specificchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.artapp.R;

public class SpecificChatActivity extends AppCompatActivity {

    private static String namePerson;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        name = (TextView)findViewById(R.id.textView_head_chat);
     name.setText(namePerson);
    }

    public static Intent obtenerIntent(Context contexto, String name) {
        Intent intent = new Intent(contexto, SpecificChatActivity.class);
        namePerson = name;
        return intent;
    }
}
