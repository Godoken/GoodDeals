package com.example.gooddeals;

import android.app.Activity;
import android.app.FragmentManager;
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
    Context context;

    public void setItems(Collection<Deal> deals){
        dealList.addAll(deals);
        notifyDataSetChanged();
    }

    public void clearItems(){
        dealList.clear();
        notifyDataSetChanged();
    }

    Adapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.deal, viewGroup, false);

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

    public void showDialogPopup(Deal deal){

        String tag = "dialog_popup";
        FragmentDialogPopup fragmentDialogPopup = new FragmentDialogPopup();
        fragmentDialogPopup.setDeal(deal);
        FragmentManager manager = ((Activity) context).getFragmentManager();
        fragmentDialogPopup.show(manager, tag);

    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView carma;
        private TextView header;

        private Deal deal;

        public void bind(Deal deal){

            this.deal = deal;

            header.setText(deal.getTitle());
        }

        public AdapterViewHolder(View itemView){

            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Your action here

                    showDialogPopup(deal);

                }
            });

            header = (TextView) itemView.findViewById(R.id.header);

            carma = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
