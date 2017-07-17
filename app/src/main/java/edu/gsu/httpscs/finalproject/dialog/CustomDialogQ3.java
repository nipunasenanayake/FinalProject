package edu.gsu.httpscs.finalproject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpscs.finalproject.R;

import static edu.gsu.httpscs.finalproject.R.id.q3_radio_group;

/**
 * Created by nipunasenanayake on 7/3/17.
 */

public class CustomDialogQ3 extends Dialog {
    private final ICustomDialogQ3Listener listener;

    @BindView(q3_radio_group)
    RadioGroup radioGroupQ3;
    private int checkID;

    public interface ICustomDialogQ3Listener {
        public void onOKClicked(String msg);

        public void onCancelClicked(String msg);
    }

    @OnClick(R.id.q3_ok)
    public void ok(View v) {

        RadioButton rd =(RadioButton) findViewById(radioGroupQ3.getCheckedRadioButtonId());

        if(rd==null){

        }else {

            String radiovalue = ((RadioButton) findViewById(radioGroupQ3.getCheckedRadioButtonId())).getText().toString();
            listener.onOKClicked(radiovalue);
            cancel();
        }

    }

    @OnClick(R.id.q3_Cancel)
    public void cancel(View v) {
        //listener.onCancelClicked("You clicked cancel");
        cancel();
    }

    public CustomDialogQ3(@NonNull Context context, CustomDialogQ3.ICustomDialogQ3Listener listener) {
        super(context, R.style.dialog);
        setContentView(R.layout.dialog_custom_q3);
        ButterKnife.bind(this);
        this.listener = listener;

        radioGroupQ3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                checkID = checkedId;
            }
        });
    }
}
