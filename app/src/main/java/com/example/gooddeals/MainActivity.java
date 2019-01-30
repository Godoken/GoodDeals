package com.example.gooddeals;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    Adapter adapter;
    private TextView carma;
    private TextView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carma = findViewById(R.id.textView);
        header = findViewById(R.id.header);

        initRecyclerView();

        //TEST
        Deal deal = new Deal("Test", "test1", 11);
        Deal deal1 = new Deal("YYYYYYYYYYYYYYYYYYYYYY", "yy", 12);
        Collection<Deal> collection = new ArrayList<Deal>();
        collection.add(deal);
        collection.add(deal1);
        adapter.setItems(collection);
        //TEST END
    }


    public void initRecyclerView(){

        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter =  new Adapter();
        recyclerView.setAdapter(adapter);
        /*recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
                return true;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
                Toast.makeText(getApplicationContext(), "Test", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean b) {

            }
        });*/
    }
}
