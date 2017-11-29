package com.example.husen.impal;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import Module.Application;
import Object.Report;
import Object.Movie;

import Adapter.RecyclerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private Application app= null;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public HomeFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout= inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView rv= (RecyclerView) layout.findViewById(R.id.datalist);
        Intent intent= getActivity().getIntent();
        this.app= (Application) intent.getSerializableExtra("application");

        RecyclerAdapter listAdapter= new RecyclerAdapter(prepareData());
        rv.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getActivity());
        rv.setLayoutManager(layoutManager);





        return layout;
    }

    public ArrayList<Movie> prepareData(){
//        ArrayList<Report> l= app.getRM().getReportList();
        ArrayList<Movie> l= new ArrayList<>();
        Report tes= new Report();
        tes.setiBarcode("ini report tes");
        tes.setName("ini barang");
        tes.setPrice(500);
        tes.setSold(23);
        tes.setTotal();




        l.add(new Movie("husen", "riri", "1997"));
        l.add(new Movie("diantar", "kita", "1997"));
        l.add(new Movie("berdua", "wkwkw", "1997"));
        l.add(new Movie("anjay", "tes", "1997"));
        l.add(new Movie("adapter", "list", "1997"));
        return l;

    }

}
