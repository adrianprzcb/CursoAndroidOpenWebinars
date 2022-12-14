package com.example.recyclerview;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AveriaFragment extends Fragment {
    OnAveriaInteractionListener mListener;
    List<Averia> averiaList;

    public AveriaFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_averia_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            // Lista de averias
            averiaList = new ArrayList<>();
            averiaList = new ArrayList<>();
            averiaList.add(new Averia("Espejo roto","Audi - A4","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQBFuEqWqmMr_rCXufk7g9X1waX8yrG57yXOcFQcqUAvw&s",2));
            averiaList.add(new Averia("Paragolpes delantero","Citroen - C4","",0));
            averiaList.add(new Averia("Embrague","Seat - Ibiza","",0));
            averiaList.add(new Averia("Cambio de aceite","Seat - Toledo","",1));

            recyclerView.setAdapter(new MyAveriaRecyclerViewAdapter(getActivity(), averiaList, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAveriaInteractionListener) {
            mListener = (OnAveriaInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnAveriaInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
