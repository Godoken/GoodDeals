package com.example.gooddeals;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentDialogPopup extends DialogFragment {

    Deal deal;
    TextView header;
    TextView coast;
    TextView textView;
    Button button;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        getDialog().setTitle(deal.getTitle());

        View v = inflater.inflate(R.layout.fragment_dialog_deal_information, null);

        header = v.findViewById(R.id.dialog_header);
        coast = v.findViewById(R.id.dialog_coast);
        textView = v.findViewById(R.id.textView4);
        button = v.findViewById(R.id.get_deal);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Запрос на сервер о том, что дело взято на выполнение
                dismiss();
            }
        });

        header.setText(deal.getTitle());
        coast.setText(String.valueOf(deal.getCost()));
        textView.setText(deal.getDiscription());


        return v;

    }


    public void onDismiss(DialogInterface dialogInterface) {
        super.dismiss();
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void setDeal(Deal deal){
        this.deal = deal;
    }
}
