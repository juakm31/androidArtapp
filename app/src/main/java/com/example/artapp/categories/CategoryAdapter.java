package com.example.artapp.categories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.artapp.R;
import com.example.artapp.entidades.Category;
import com.example.artapp.profileothers.ProfileOthersAdapter;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private Context mContext;
    private List<Category> categoryList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView thumbnail;
        private View elementView;
        private CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name_category);
            thumbnail = (ImageView) view.findViewById(R.id.foto_category);
            elementView = view;
            cardView = (CardView) view.findViewById(R.id.card_category);
        }
    }

    public CategoryAdapter(Context mContext, List<Category> fotosList) {
        this.mContext = mContext;
        this.categoryList = fotosList;
    }

    @NonNull
    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_categories, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.MyViewHolder holder, int position) {
        final Category category = categoryList.get(position);

        holder.elementView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mContext.startActivity(ProfileOthersActivity.obtenerIntent(mContext, position));
            }
        });

        holder.name.setText(category.getName());
        // loading album cover using Glide library
        Glide.with(mContext).load(category.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
