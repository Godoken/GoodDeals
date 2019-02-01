package com.example.gooddeals;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    private TextView carma;
    private TextView header;
    private Button button;
    MainActivityViewModel mainActivityViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carma = findViewById(R.id.textView);
        header = findViewById(R.id.header);
        button = findViewById(R.id.button);

        mainActivityViewModel = new MainActivityViewModel();

        if (FragmentDialogLogin.m_user == null){
            mainActivityViewModel.showDialogLogin(MainActivity.this, carma);
        }

        carma = findViewById(R.id.textView);
        header = findViewById(R.id.header);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainActivityViewModel.startAddDealActivity(MainActivity.this);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);

        mainActivityViewModel.initRecyclerView(recyclerView, MainActivity.this);


    }
}
