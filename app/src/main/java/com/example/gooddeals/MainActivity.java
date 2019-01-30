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
    //Adapter adapter;
    private TextView carma;
    private TextView header;
    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carma = findViewById(R.id.textView);
        header = findViewById(R.id.header);

        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);

        mainActivityViewModel = new MainActivityViewModel();

        mainActivityViewModel.initRecyclerView(recyclerView, MainActivity.this);


    }
}
