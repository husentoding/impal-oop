package Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.widget.TextView;

import com.example.husen.impal.R;

import java.util.List;

import Object.ProcurementOrder;

/**
 * Created by husen on 29/11/17.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder>{

    private List<ProcurementOrder> moviesList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView iBarcode, name, year;

        public MyViewHolder(View view) {
            super(view);
            iBarcode = (TextView) view.findViewById(R.id.judul);
            name = (TextView) view.findViewById(R.id.stokterjual);
            year = (TextView) view.findViewById(R.id.totalBiaya);
        }

    }


    public OrderAdapter(List<ProcurementOrder> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ProcurementOrder movie = moviesList.get(position);
        String total= Integer.toString(movie.getBill());
        String sold= movie.gettAuthor().getName();
        holder.iBarcode.setText(movie.getSupplier());
        holder.name.setText(total);
        holder.year.setText(sold);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
