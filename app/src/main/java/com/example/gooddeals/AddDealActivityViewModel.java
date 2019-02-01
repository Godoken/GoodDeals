package com.example.gooddeals;

import android.util.Log;

import java.util.Collection;

public class AddDealActivityViewModel {



    public void addDeal(Deal deal) {

            AddDealActivityModel addDealActivityModel = new AddDealActivityModel();
            addDealActivityModel.addDeal(new WorkerWithServer.DealCallback() {
                @Override
                public void onSuccess(Deal deal) {
                    //adapter.setItems(dealList);
                    Adapter adapter = new Adapter(MainActivityViewModel.m_context);
                    adapter.setItem(deal);
                }

                @Override
                public void onFailure(Throwable throwable) {
                    Log.d("WTF", "exception", throwable);
                }
            }, deal);
    }
}
