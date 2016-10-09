package com.example.toni.pruebatabs;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import in.srain.cube.views.GridViewWithHeaderAndFooter;

/**
 * Created by Toni on 08/10/2016.
 */

public class GridFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static GridFragment newInstance(int sectionNumber) {
        GridFragment fragment = new GridFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public GridFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v("Entro", "HOLA");

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        GridViewWithHeaderAndFooter grid =
                (GridViewWithHeaderAndFooter) rootView.findViewById(R.id.gridview);

        setUpGridView(grid);

        return rootView;

    }

    private void setUpGridView(GridViewWithHeaderAndFooter grid) {
        int section_number = getArguments().getInt(ARG_SECTION_NUMBER);
        switch (section_number) {
            case 1:
                grid.addHeaderView(createHeaderView(4, Casillas.getHome()));
                grid.setAdapter(new GridAdapter(getActivity(),Casillas.getHome()));
                break;
            case 2:
                grid.addHeaderView(createHeaderView(2, Casillas.getPersonal()));
                grid.setAdapter(new GridAdapter(getActivity(), Casillas.getPersonal()));
                break;
        }
    }

    private View createHeaderView(int position, Casilla[] items) {

        View view;

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.grid_header, null, false);

        Casilla item = items[position];

        // Seteando Descripción
        TextView descripcion = (TextView) view.findViewById(R.id.descripcion);
        descripcion.setText(item.getDescripcion());


        return view;
    }
}
