package com.example.gooddeals;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivityViewModel {

    static Context m_context;

    public void initRecyclerView(RecyclerView recyclerView, Context context){

        m_context = context;
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
    }

    public void showDialogLogin(Context context, TextView karma){

        String tag = "dialog_login";
        FragmentDialogLogin fragmentDialogLogin = new FragmentDialogLogin();
        fragmentDialogLogin.setKarma(karma);
        FragmentManager manager = ((Activity) context).getFragmentManager();
        fragmentDialogLogin.show(manager, tag);

    }
}
