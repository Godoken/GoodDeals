package com.example.gooddeals;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;

public class MainActivityViewModel {

    public void initRecyclerView(RecyclerView recyclerView, Context context){

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        Adapter adapter =  new Adapter(context);
        recyclerView.setAdapter(adapter);

        testRecyclerView(adapter);

    }

    public void testRecyclerView(Adapter adapter){
        Deal deal = new Deal("Test", "test1", 11);
        Deal deal1 = new Deal("YYYYYYYYYYYYYYYYYYYYYY", "yy", 12);
        Collection<Deal> collection = new ArrayList<Deal>();
        collection.add(deal);
        collection.add(deal1);
        adapter.setItems(collection);
    }
}
