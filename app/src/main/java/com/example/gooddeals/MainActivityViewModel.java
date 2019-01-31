package com.example.gooddeals;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivityViewModel {

    public void initRecyclerView(RecyclerView recyclerView, Context context){

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        Adapter adapter =  new Adapter(context);
        recyclerView.setAdapter(adapter);

        testRecyclerView(adapter);

    }

    public void startAddDealActivity(Context context){

        Intent intent = new Intent(context, AddDealActivity.class);
        context.startActivity(intent);
    }

    public void testRecyclerView(final Adapter adapter){

        MainActivityModel mainActivityModel = new MainActivityModel();
        mainActivityModel.getAllDeals(new WorkerWithServer.DealsCallback() {
            @Override
            public void onSuccess(Collection<Deal> dealList) {
                adapter.setItems(dealList);
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.d("WTF", "exception", throwable);
            }
        });
        //Deal deal = new Deal("Test", "test1", 11);
        //Deal deal1 = new Deal("YYYYYYYYYYYYYYYYYYYYYY", "yy", 12);
//        Collection<Deal> dealList = mainActivityModel.getDealList();

        //Collection<Deal> collection = new ArrayList<Deal>(mainActivityModel.getDealList());
        //collection.add(deal);
        //collection.add(deal1);
//        adapter.setItems(dealList);
    }
}
