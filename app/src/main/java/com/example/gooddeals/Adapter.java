package com.example.gooddeals;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.deal, viewGroup, false);

        /////
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Your action here

            }
        });
        /////

        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder adapterViewHolder, int i) {
        adapterViewHolder.bind(dealList.get(i));
    }

    @Override
    public int getItemCount() {
        return dealList.size();
    }


    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView carma;
        private TextView header;

        public void bind(Deal deal){

            header.setText(deal.getHeader());
        }

        public AdapterViewHolder(View itemView){

            super(itemView);

            header = (TextView) itemView.findViewById(R.id.header);

            carma = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
