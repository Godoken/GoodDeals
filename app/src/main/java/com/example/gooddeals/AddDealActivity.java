package com.example.gooddeals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddDealActivity extends AppCompatActivity {

    TextView textView;
    EditText add_header;
    EditText add_coast;
    EditText add_text;

    Button add_set_deal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_deal);

        textView = findViewById(R.id.textView2);
        add_header = findViewById(R.id.add_header);
        add_coast = findViewById(R.id.add_coast);
        add_text = findViewById(R.id.add_text);

        add_set_deal = findViewById(R.id.add_set_deal);
        add_set_deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddDealActivityViewModel addDealActivityViewModel = new AddDealActivityViewModel();
                String author = FragmentDialogLogin.m_user.getName().concat(FragmentDialogLogin.m_user.getSurname());
                Deal deal = new Deal(add_header.getText().toString(), add_text.getText().toString(), Integer.parseInt(add_coast.getText().toString()), author, false, " ");
                addDealActivityViewModel.addDeal(deal);
            }
        });
    }
}
