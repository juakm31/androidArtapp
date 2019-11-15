package com.example.artapp.informationspecific;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.artapp.R;
import com.example.artapp.entidades.Comentary;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class InformationSpecificAdapter  extends RecyclerView.Adapter<InformationSpecificAdapter.MyViewHolder> {

    private Context mContext;
    private List<Comentary> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name, message;
        public CircleImageView thumbnail;
        private View elementView;
        private CardView card;


        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.text_username_comentary);
            message = (TextView) itemView.findViewById(R.id.text_comentary);
            thumbnail = (CircleImageView) itemView.findViewById(R.id.image_profile_comentary);
            elementView = itemView;
            card = (CardView) itemView.findViewById(R.id.cardView_Publication_information);
        }
    }

    public InformationSpecificAdapter(Context mContext, List<Comentary> songList) {
        this.mContext = mContext;
        this.list = songList;
    }

    @NonNull
    @Override
    public InformationSpecificAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_comentaries, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, int position) {
        final Comentary chat = list.get(position);

        myViewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Click seleccionando: "+chat.getName(),Toast.LENGTH_SHORT).show();
                //mContext.startActivity(SpecificChatActivity.obtenerIntent(mContext, chat.getName()));
            }
        });

        myViewHolder.elementView.setOnClickListener(    new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"Click seleccionando: "+chat.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        myViewHolder.name.setText(chat.getName());
        myViewHolder.message.setText(chat.getMessage());

        Glide.with(mContext).load(chat.getThumbnail()).into(myViewHolder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
