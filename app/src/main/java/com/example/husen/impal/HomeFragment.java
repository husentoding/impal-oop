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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private EditText date;
    private String date_content;
    private Button submitDate;

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
        date= (EditText) layout.findViewById(R.id.inputDate);
        submitDate= (Button) layout.findViewById(R.id.submitDate);
        RecyclerView rv= (RecyclerView) layout.findViewById(R.id.datalist);
        Intent intent= getActivity().getIntent();
        this.app= (Application) intent.getSerializableExtra("application");

        RecyclerAdapter listAdapter= new RecyclerAdapter(prepareData());
        rv.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getActivity());
        rv.setLayoutManager(layoutManager);

        submitDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerView rv= (RecyclerView) view.findViewById(R.id.datalist);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd/HH:mm:ss:SS z");
                String date= submitDate.getText().toString();
                Date parsedDate;
                try {
                    parsedDate= sdf.parse(date);
                } catch (ParseException e) {
                    parsedDate= new Date();
                }

            }
        });



//        RecyclerAdapter listAdapter= new RecyclerAdapter(prepareData());
//        rv.setAdapter(listAdapter);
//        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getActivity());
//        rv.setLayoutManager(layoutManager);

        return layout;
    }

    public ArrayList<Report> prepareData(){

        ArrayList<Report> l= new ArrayList<>();
        try {
            app.getRM().generateDReport(new Date());

        } catch (Exception e) {
            e.printStackTrace();
        }
        l.addAll(app.getRM().getReportList());
        Report r = new Report();
        r.setiBarcode("TES");
        r.setName("NAME TES");
        r.setSold(5);
        r.setPrice(50000);
        r.setTotal();
        l.add(r);

//        try {
//            app.getRM().generateDReport(date);
//            l= app.getRM().getReportList();
//        } catch (Exception e) {
//            l= new ArrayList<>();
//        }

//        ArrayList<Movie> l= new ArrayList<>();
//        Report tes= new Report();
//        tes.setiBarcode("ini report tes");
//        tes.setName("ini barang");
//        tes.setPrice(500);
//        tes.setSold(23);
//        tes.setTotal();



//
//        l.add(new Movie("husen", "riri", "1997"));
//        l.add(new Movie("diantar", "kita", "1997"));
//        l.add(new Movie("berdua", "wkwkw", "1997"));
//        l.add(new Movie("anjay", "tes", "1997"));
//        l.add(new Movie("adapter", "list", "1997"));
        return l;

    }

}
