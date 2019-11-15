package com.example.artapp.principal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.artapp.R;
import com.example.artapp.categories.CategoryActivity;
import com.example.artapp.chat.ChatActivity;
import com.example.artapp.entidades.Publicacion;
import com.example.artapp.informationspecific.InformationSpecificActivity;
import com.example.artapp.login.LoginActivity;
import com.example.artapp.profile.ProfileActivity;
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

public class PaginaPrincipalActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PaginaPrincipalAdapter adapter;
    private List<Publicacion> listaPublicaciones;
    private RapidFloatingActionHelper rfabHelper;
    RapidFloatingActionLayout rfaLayout;
    RapidFloatingActionButton rfaButton;
    private static Context contexto;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        rfaLayout = findViewById(R.id.label_list_sample);
        rfaButton = findViewById(R.id.fab_acciones);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_principal);

        listaPublicaciones = new ArrayList<>();
        adapter = new PaginaPrincipalAdapter(this, listaPublicaciones);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        manejarBotonFlotante();
        preparePublication();
    }

    private void manejarBotonFlotante() {
        RapidFloatingActionContentLabelList contenidoFloatingAction = new RapidFloatingActionContentLabelList(this);
        RapidFloatingActionContentLabelList.OnRapidFloatingActionContentLabelListListener onRapidFloatingActionContentLabelListListener = new RapidFloatingActionContentLabelList.OnRapidFloatingActionContentLabelListListener() {
            @Override
            public void onRFACItemLabelClick(int position, RFACLabelItem item) {

            }

            @Override
            public void onRFACItemIconClick(int position, RFACLabelItem item) {
                switch (position) {
                    case 0:
                        intent = new Intent(PaginaPrincipalActivity.this, ProfileActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(PaginaPrincipalActivity.this, CategoryActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                         intent = new Intent(PaginaPrincipalActivity.this, ChatActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                         intent = new Intent(PaginaPrincipalActivity.this, LoginActivity.class);
                        startActivity(intent);
                        break;
                }
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
                .setLabel("Perfil")
                .setResId(R.drawable.ic_account_circle_white_24dp)
                .setIconNormalColor(getResources().getColor(R.color.colorPrimaryDark))
                .setIconPressedColor(getResources().getColor(R.color.colorPrimary))
                .setLabelColor(getResources().getColor(R.color.colorWhite))
                .setLabelBackgroundDrawable(RFABShape.generateCornerShapeDrawable(R.color.colorBlack, 5))
                //.setLabelBackgroundDrawable(RFABShape.generateCornerShapeDrawable(getResources().getColor(R.color.colorIcons), RFABTextUtil.dip2px(getAppContext(), 4)))
                .setWrapper(1));

        listaAcciones.add(new RFACLabelItem<Integer>()
                .setLabel("Categorias")
                .setResId(R.drawable.ic_dashboard_white_24dp)
                .setIconNormalColor(getResources().getColor(R.color.colorPrimaryDark))
                .setIconPressedColor(getResources().getColor(R.color.colorPrimary))
                .setLabelColor(getResources().getColor(R.color.colorWhite))
                .setLabelBackgroundDrawable(RFABShape.generateCornerShapeDrawable(R.color.colorBlack, 5))
                //.setLabelBackgroundDrawable(RFABShape.generateCornerShapeDrawable(getResources().getColor(R.color.colorIcons), RFABTextUtil.dip2px(getAppContext(), 4)))
                .setWrapper(2));

        listaAcciones.add(new RFACLabelItem<Integer>()
                .setLabel("Chats")
                .setResId(R.drawable.ic_chat_white_24dp)
                .setIconNormalColor(getResources().getColor(R.color.colorPrimaryDark))
                .setIconPressedColor(getResources().getColor(R.color.colorPrimary))
                .setLabelColor(getResources().getColor(R.color.colorWhite))
                .setLabelBackgroundDrawable(RFABShape.generateCornerShapeDrawable(R.color.colorBlack, 5))
                //.setLabelBackgroundDrawable(RFABShape.generateCornerShapeDrawable(getResources().getColor(R.color.colorIcons), RFABTextUtil.dip2px(getAppContext(), 4)))
                .setWrapper(2));

        listaAcciones.add(new RFACLabelItem<Integer>()
                .setLabel("Cerrar sesión")
                .setResId(R.drawable.ic_highlight_off_white_24dp)
                .setIconNormalColor(getResources().getColor(R.color.colorPrimaryDark))
                .setIconPressedColor(getResources().getColor(R.color.colorAccent))
                .setLabelColor(getResources().getColor(R.color.colorWhite))
                .setLabelBackgroundDrawable(RFABShape.generateCornerShapeDrawable(R.color.colorBlack, 5))
                //.setLabelBackgroundDrawable(RFABShape.generateCornerShapeDrawable(getResources().getColor(R.color.colorIcons), RFABTextUtil.dip2px(getAppContext(), 4)))
                .setWrapper(3));
        return listaAcciones;
    }

    private void preparePublication() {
        int[] pictures = new int[]{
                R.drawable.publication,
                R.drawable.publication,
                R.drawable.publication,
                R.drawable.publication,
                R.drawable.publication,
                R.drawable.publication,
                R.drawable.publication,
                R.drawable.publication,
                R.drawable.publication,
                R.drawable.publication,
                R.drawable.publication,
                R.drawable.publication,
                R.drawable.publication};

        Publicacion a = new Publicacion(pictures[0], "Juan Enrique", "Obra que representa el sentimiento retrocentrista del alma");
        listaPublicaciones.add(a);
        a = new Publicacion(pictures[0], "Juan Enrique", "Obra que representa el sentimiento retrocentrista del alma");
        listaPublicaciones.add(a);
        a = new Publicacion(pictures[0], "Juan Enrique", "Obra que representa el sentimiento retrocentrista del alma");
        listaPublicaciones.add(a);
        a = new Publicacion(pictures[0], "Juan Enrique", "Obra que representa el sentimiento retrocentrista del alma");
        listaPublicaciones.add(a);
        a = new Publicacion(pictures[0], "Juan Enrique", "Obra que representa el sentimiento retrocentrista del alma");
        listaPublicaciones.add(a);
        a = new Publicacion(pictures[0], "Juan Enrique", "Obra que representa el sentimiento retrocentrista del alma");
        listaPublicaciones.add(a);
        a = new Publicacion(pictures[0], "Juan Enrique", "Obra que representa el sentimiento retrocentrista del alma");
        listaPublicaciones.add(a);
        a = new Publicacion(pictures[0], "Juan Enrique", "Obra que representa el sentimiento retrocentrista del alma");
        listaPublicaciones.add(a);
    }

    public synchronized static Context getAppContext() {
        return PaginaPrincipalActivity.contexto;
    }
}
