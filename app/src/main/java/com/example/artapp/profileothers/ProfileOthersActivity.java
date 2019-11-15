package com.example.artapp.profileothers;

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
import com.example.artapp.specificchat.SpecificChatActivity;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionButton;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionHelper;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionLayout;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RFACLabelItem;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RapidFloatingActionContentLabelList;
import com.wangjie.rapidfloatingactionbutton.util.RFABShape;
import com.wangjie.rapidfloatingactionbutton.util.RFABTextUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ProfileOthersActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Fotos> fotosList;
    private static int fotoPosicion;
    private ProfileOthersAdapter adapter;
    private RapidFloatingActionHelper rfabHelper;
    RapidFloatingActionLayout rfaLayout;
    RapidFloatingActionButton rfaButton;


    public static Intent obtenerIntent(Context contexto,  int position) {
        Intent intent = new Intent(contexto, ProfileOthersActivity.class);
        fotoPosicion = position;
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_others);

        rfaLayout = findViewById(R.id.label_list);
        rfaButton = findViewById(R.id.fab_acciones);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_perfil);

        fotosList = new ArrayList<>();
        adapter = new ProfileOthersAdapter(this, fotosList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        manejarBotonFlotante();
        preparePictures();
    }

    private void manejarBotonFlotante() {
        RapidFloatingActionContentLabelList contenidoFloatingAction = new RapidFloatingActionContentLabelList(this);
        RapidFloatingActionContentLabelList.OnRapidFloatingActionContentLabelListListener onRapidFloatingActionContentLabelListListener = new RapidFloatingActionContentLabelList.OnRapidFloatingActionContentLabelListListener() {
            @Override
            public void onRFACItemLabelClick(int position, RFACLabelItem item) {

            }

            @Override
            public void onRFACItemIconClick(int position, RFACLabelItem item) {
                Intent intent = new Intent(ProfileOthersActivity.this, SpecificChatActivity.class);
                startActivity(intent);
            }
        };
        contenidoFloatingAction.setItems(obtenerAccionesFAB())
                .setIconShadowRadius(RFABTextUtil.dip2px(Objects.requireNonNull(this), 5))
                .setIconShadowColor(R.color.colorAccent)
                .setIconShadowDy(RFABTextUtil.dip2px(this, 5))
                .setOnRapidFloatingActionContentLabelListListener(onRapidFloatingActionContentLabelListListener);
        rfabHelper = new RapidFloatingActionHelper(
                this,
                rfaLayout,
                rfaButton,
                contenidoFloatingAction
        ).build();
    }

    private List<RFACLabelItem> obtenerAccionesFAB() {
        List<RFACLabelItem> listaAcciones = new LinkedList<>();
        listaAcciones.add(new RFACLabelItem<Integer>()
                .setLabel("Enviar Mensaje")
                .setResId(R.drawable.ic_send_white_24dp)
                .setIconNormalColor(getResources().getColor(R.color.colorPrimaryDark))
                .setIconPressedColor(getResources().getColor(R.color.colorPrimary))
                .setLabelColor(getResources().getColor(R.color.colorWhite))
                .setLabelBackgroundDrawable(RFABShape.generateCornerShapeDrawable(R.color.colorBlack, 5))
                //.setLabelBackgroundDrawable(RFABShape.generateCornerShapeDrawable(getResources().getColor(R.color.colorIcons), RFABTextUtil.dip2px(getAppContext(), 4)))
                .setWrapper(1));

        return listaAcciones;
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
