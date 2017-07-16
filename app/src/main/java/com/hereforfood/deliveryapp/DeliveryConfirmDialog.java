package com.hereforfood.deliveryapp;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by Shreyak Kumar on 17-07-2017.
 */

public class DeliveryConfirmDialog extends Dialog implements
        android.view.View.OnClickListener {

    public Activity callingActivity;
    public Button yes, no;

    public DeliveryConfirmDialog(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.callingActivity = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_delivery_confirm);
        yes = (Button) findViewById(R.id.yesButton);
        no = (Button) findViewById(R.id.noButton);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.yesButton:
                // TODO set the delivery's status to complete in the database !!
                break;

            case R.id.noButton:
                // TODO set the delivery's status to incomplete in the database !!
                break;

            default:
                break;
        }
        dismiss();
    }
}
