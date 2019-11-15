package com.example.artapp.profile;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.artapp.R;
import com.example.artapp.entidades.Fotos;
import com.example.artapp.profileothers.ProfileOthersAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Fotos> fotosList;
    private static int fotoPosicion;
    private ProfileOthersAdapter adapter;


    public static Intent obtenerIntent(Context contexto) {
        Intent intent = new Intent(contexto, com.example.artapp.profileothers.ProfileOthersActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_perfil);

        fotosList = new ArrayList<>();
        adapter = new ProfileOthersAdapter(this, fotosList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new com.example.artapp.profile.ProfileActivity.GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        preparePictures();
    }

    private void preparePictures() {
        int[] fotos = new int[]{
                R.drawable.graffiti,
                R.drawable.images,
                R.drawable.img,
                R.drawable.graffiti,
                R.drawable.images,
                R.drawable.img,
                R.drawable.graffiti,
                R.drawable.images,
                R.drawable.img,
                R.drawable.graffiti,
                R.drawable.images,
                R.drawable.img,
                R.drawable.descarga};

        Fotos a = new Fotos(fotos[0]);
        fotosList.add(a);

        a = new Fotos(fotos[1]);
        fotosList.add(a);

        a = new Fotos(fotos[2]);
        fotosList.add(a);

        a = new Fotos(fotos[3]);
        fotosList.add(a);

        a = new Fotos(fotos[4]);
        fotosList.add(a);

        a = new Fotos( fotos[5]);
        fotosList.add(a);

        a = new Fotos(fotos[6]);
        fotosList.add(a);

        a = new Fotos(fotos[7]);
        fotosList.add(a);

        a = new Fotos(fotos[8]);
        fotosList.add(a);

        a = new Fotos(fotos[9]);
        fotosList.add(a);

        a = new Fotos(fotos[10]);
        fotosList.add(a);

        a = new Fotos(fotos[11]);
        fotosList.add(a);

        a = new Fotos(fotos[12]);
        fotosList.add(a);

        adapter.notifyDataSetChanged();
    }



    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}

