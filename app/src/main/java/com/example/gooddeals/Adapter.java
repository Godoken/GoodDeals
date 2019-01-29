package com.example.gooddeals;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {

    private List<Deal> dealList = new ArrayList<>();

    public void setItems(Collection<Deal> deals){
        dealList.addAll(deals);
        notifyDataSetChanged();
    }

    public void clearItems(){
        dealList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder adapterViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView carma;

        public AdapterViewHolder(View itemView){

            super(itemView);

            carma = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
