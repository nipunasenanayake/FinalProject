package edu.gsu.httpscs.finalproject;

import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimerActivity extends BaseActivity {

    @BindView(R.id.activity_handler_et)
    EditText editText;

    @BindView(R.id.activity_handler_btn)
    Button btn;



    private View.OnClickListener startListener;
    private View.OnClickListener stopListener;
    private View.OnClickListener resetListener;



    Handler handler = new Handler();
    private int time=0;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            time--;
            if (time>=0){
                editText.setText(String.valueOf(time));
                handler.postDelayed(runnable,1000);
            }
        }
    };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        ButterKnife.bind(this);

        startListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("Stop");
                editText.setEnabled(false);
                btn.setOnClickListener(stopListener);
                time = Integer.valueOf(editText.getText().toString());
                handler.postDelayed(runnable,1000);
            }
        };

        stopListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("Reset");
                btn.setOnClickListener(resetListener);
                handler.removeCallbacks(runnable);
            }
        };

        resetListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("Start");
                editText.setEnabled(true);
                btn.setOnClickListener(startListener);
            }
        };

        btn.setOnClickListener(startListener);

    }

}

