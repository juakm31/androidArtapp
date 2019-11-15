package com.example.artapp.informationspecific;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.artapp.profileothers.ProfileOthersActivity;
import com.example.artapp.R;
import com.example.artapp.entidades.Comentary;

import java.util.List;

public class InformationSpecificActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private InformationSpecificAdapter adapter;
    private List<Comentary> lista;
    private TextView autor;
    private TextView description;
    private static String publicationAutor;
    private static String publicationDescription;
    private CardView card;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_specific);

        card = (CardView) findViewById(R.id.cardView_Publication_information);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationSpecificActivity.this, ProfileOthersActivity.class);
                startActivity(intent);
            }
        });
/*
        recyclerView = (RecyclerView) findViewById(R.id.recycler_information);
        autor = (TextView) findViewById(R.id.text_autor_information);
        description = (TextView) findViewById(R.id.text_description);

        prepareComentaries();

        autor.setText(publicationAutor);
        description.setText(publicationDescription);

        lista = new ArrayList<>();
        adapter = new InformationSpecificAdapter(this, lista);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

*/
    }

    public static Intent obtenerIntent(Context contexto, String autor, String description) {
        Intent intent = new Intent(contexto, InformationSpecificActivity.class);
        publicationAutor = autor;
        publicationDescription = description;
        return intent;
    }

    private void prepareComentaries() {
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

        Comentary a = new Comentary("Julia", "me gusto como retrataste al señor", pictures[0]);
        lista.add(a);
        a = new Comentary("Julia", "me gusto como retrataste al señor", pictures[0]);
        lista.add(a);
        a = new Comentary("Julia", "me gusto como retrataste al señor", pictures[0]);
        lista.add(a);
        a = new Comentary("Julia", "me gusto como retrataste al señor", pictures[0]);
        lista.add(a);
        a = new Comentary("Julia", "me gusto como retrataste al señor", pictures[0]);
        lista.add(a);
        a = new Comentary("Julia", "me gusto como retrataste al señor", pictures[0]);
        lista.add(a);
        a = new Comentary("Julia", "me gusto como retrataste al señor", pictures[0]);
        lista.add(a);
        a = new Comentary("Julia", "me gusto como retrataste al señor", pictures[0]);
        lista.add(a);
        a = new Comentary("Julia", "me gusto como retrataste al señor", pictures[0]);
        lista.add(a);
        a = new Comentary("Julia", "me gusto como retrataste al señor", pictures[0]);
        lista.add(a);
        a = new Comentary("Julia", "me gusto como retrataste al señor", pictures[0]);
        lista.add(a);
        a = new Comentary("Julia", "me gusto como retrataste al señor", pictures[0]);
        lista.add(a);
        a = new Comentary("Julia", "me gusto como retrataste al señor", pictures[0]);
        lista.add(a);
        a = new Comentary("Julia", "me gusto como retrataste al señor", pictures[0]);
        lista.add(a);
        a = new Comentary("Julia", "me gusto como retrataste al señor", pictures[0]);
        lista.add(a);
        a = new Comentary("Julia", "me gusto como retrataste al señor", pictures[0]);
        lista.add(a);
        a = new Comentary("Julia", "me gusto como retrataste al señor", pictures[0]);
        lista.add(a);
    }
}
