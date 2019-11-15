package com.example.artapp.profileothers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.artapp.R;
import com.example.artapp.entidades.Fotos;

import java.util.List;

public class ProfileOthersAdapter extends RecyclerView.Adapter<ProfileOthersAdapter.MyViewHolder>{

    private Context mContext;
    private List<Fotos> fotosList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;
        private View elementView;
        private CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            thumbnail = (ImageView) view.findViewById(R.id.fo);
            elementView = view;
            cardView = (CardView) view.findViewById(R.id.ca);
        }
    }

    public ProfileOthersAdapter(Context mContext, List<Fotos> fotosList) {
        this.mContext = mContext;
        this.fotosList = fotosList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_foto, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Fotos album = fotosList.get(position);

        holder.elementView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(ProfileOthersActivity.obtenerIntent(mContext, position));
            }
        });
        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return fotosList.size();
    }
}
