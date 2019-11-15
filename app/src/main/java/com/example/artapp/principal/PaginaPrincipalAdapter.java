package com.example.artapp.principal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.artapp.R;
import com.example.artapp.entidades.Publicacion;
import com.example.artapp.informationspecific.InformationSpecificActivity;

import java.util.List;

public class PaginaPrincipalAdapter extends RecyclerView.Adapter<PaginaPrincipalAdapter.MyViewHolder> {

    private Context mContext;
    private List<Publicacion> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView autor;
        public ImageView thumbnail;
        private View elementView;
        private CardView card;


        public MyViewHolder(View itemView) {
            super(itemView);
            autor = (TextView) itemView.findViewById(R.id.text_autor);
            thumbnail = (ImageView) itemView.findViewById(R.id.image_publication);
            elementView = itemView;
            card = (CardView) itemView.findViewById(R.id.cardView_Publication);
        }
    }

    public PaginaPrincipalAdapter(Context mContext, List<Publicacion> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_publication, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        final Publicacion publicacion = list.get(position);

        myViewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(InformationSpecificActivity.obtenerIntent(mContext, publicacion.getAutor(), publicacion.getDescricpion()));
            }
        });

        myViewHolder.elementView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Click seleccionando: " + publicacion.getAutor(), Toast.LENGTH_SHORT).show();
            }
        });
        myViewHolder.autor.setText(publicacion.getAutor());

        //Glide.with(mContext).load(publicacion.getThumbnail()).into(myViewHolder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
