package com.example.artapp.chat;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.artapp.R;
import com.example.artapp.entidades.Chat;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ChatAdapter adapter;
    private List<Chat> lista;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_chats);

        lista = new ArrayList<>();
        adapter = new ChatAdapter(this, lista);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareChats();
    }

    private void prepareChats() {
        int[] pictures = new int[]{
                R.drawable.userpic,
                R.drawable.userpic,
                R.drawable.userpic,
                R.drawable.userpic,
                R.drawable.userpic,
                R.drawable.userpic,
                R.drawable.userpic,
                R.drawable.userpic,
                R.drawable.userpic,
                R.drawable.userpic,
                R.drawable.userpic,
                R.drawable.userpic,
                R.drawable.userpic};

        Chat a = new Chat("Lucia", "mensaje", pictures[0]);
        lista.add(a);

        a = new Chat("Lucia", "mira que debo contarte una historia super larga porque necesito probar que sucede al escribir mucho texto", pictures[0]);
        lista.add(a);
        a = new Chat("Maria", "mensaje", pictures[0]);
        lista.add(a);
        a = new Chat("Adriana", "mensaje", pictures[0]);
        lista.add(a);
        a = new Chat("Julieta", "mensaje", pictures[0]);
        lista.add(a);
        a = new Chat("Lucia", "mensaje", pictures[0]);
        lista.add(a);
        a = new Chat("Lucia", "mensaje", pictures[0]);
        lista.add(a);
        a = new Chat("Lucia", "mensaje", pictures[0]);
        lista.add(a);
        a = new Chat("Lucia", "mensaje", pictures[0]);
        lista.add(a);
        a = new Chat("Lucia", "mensaje", pictures[0]);
        lista.add(a);
        a = new Chat("Lucia", "mensaje", pictures[0]);
        lista.add(a);
        a = new Chat("Lucia", "mensaje", pictures[0]);
        lista.add(a);
        a = new Chat("Lucia", "mensaje", pictures[0]);
        lista.add(a);
        a = new Chat("Lucia", "mensaje", pictures[0]);
        lista.add(a);
        a = new Chat("Lucia", "mensaje", pictures[0]);
        lista.add(a);
        a = new Chat("Lucia", "mensaje", pictures[0]);
        lista.add(a);
        a = new Chat("Lucia", "mensaje", pictures[0]);
        lista.add(a);
        a = new Chat("Lucia", "mensaje", pictures[0]);
        lista.add(a);
        a = new Chat("Lucia", "mensaje", pictures[0]);
        lista.add(a);
        a = new Chat("Lucia", "mensaje", pictures[0]);
        lista.add(a);
        a = new Chat("Lucia", "mensaje", pictures[0]);
        lista.add(a);
        a = new Chat("Lucia", "mensaje", pictures[0]);
        lista.add(a);
    }
}
