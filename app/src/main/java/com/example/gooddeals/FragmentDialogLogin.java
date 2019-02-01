package com.example.gooddeals;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Collection;

public class FragmentDialogLogin extends DialogFragment {

    Deal deal;
    EditText name;
    EditText surname;
    Button button;

    TextView karma;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        //getDialog().setTitle(deal.getTitle());

        View v = inflater.inflate(R.layout.fragment_dialog_login, null);

        name = v.findViewById(R.id.dialog_name);
        surname = v.findViewById(R.id.dialog_surname);
        button = v.findViewById(R.id.login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivityModel mainActivityModel = new MainActivityModel();

                UserInfo userInfo = new UserInfo();
                userInfo.setUserName(name.getText().toString());
                userInfo.setUserSurname(surname.getText().toString());

                mainActivityModel.loginUser(new WorkerWithServer.UserCallback(){
                    @Override
                    public void onSuccess(User user) {
                        karma.setText(String.valueOf(user.getKarma()));

                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Log.d("WTF", "exception", throwable);
                    }
                }, userInfo);
                dismiss();
            }
        });


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

    public void setKarma(TextView karma) {
        this.karma = karma;
    }
}
