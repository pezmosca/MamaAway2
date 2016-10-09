package com.example.toni.pruebatabs;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Toni on 08/10/2016.
 */

public class GridAdapter extends BaseAdapter {
    private final Context mContext;
    private final Casilla[] items;

    public GridAdapter(Context c, Casilla[] items) {
        mContext = c;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.length - 1;
    }

    @Override
    public Casilla getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item, viewGroup, false);
        }

        Casilla item = getItem(position);

        // Seteando Imagen
        ImageView image = (ImageView) view.findViewById(R.id.imagen);
        Glide.with(image.getContext()).load(item.getIdThumbnail()).into(image);

        // Seteando Nombre
        TextView name = (TextView) view.findViewById(R.id.nombre);
        name.setText(item.getName());

        /*// Seteando Urgente
        TextView descripcion = (TextView) view.findViewById(R.id.descripcion);
        descripcion.setText(item.getDescripcion());*/

        view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = null;

                        switch (getItem(position).getName()) {
                            case "Home list":
                                i = new Intent(mContext, ListaHome.class);
                                break;
                            case "Home tasks":
                                i = new Intent(mContext, TareasHome.class);
                                break;
                            case "Home events":
                                i = new Intent(mContext, CalendarioHome.class);
                                break;
                            case "Naughty night ;)":
                                i = new Intent(mContext, AvisoHome.class);
                                break;
                            case "Personal list":
                                i = new Intent(mContext, ListaPersonal.class);
                                break;
                            case "Tutorials":
                                i = new Intent(mContext, Tutorials.class);
                                break;
                        }

                        if (i != null) {
                            i.putExtra("posicion", position);
                            mContext.startActivity(i);
                        }
                    }
                }
        );

        return view;
    }
}
