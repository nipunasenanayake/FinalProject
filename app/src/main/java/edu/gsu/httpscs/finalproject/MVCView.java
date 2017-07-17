package edu.gsu.httpscs.finalproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MVCView extends Activity {
    public static final String APP_TAG = "edu.gsu.httpscs.finalproject";
    private MVCController controller;

    @BindView(R.id.lvTask)
    ListView lvTask;

    @BindView(R.id.btNewTask)
    Button btNewTask;

    @BindView(R.id.etNewTask)
    EditText etNewTask;

    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ui_main);
        ButterKnife.bind(this);


        controller = new MVCController(this);

        btNewTask.setOnClickListener(this.handleNewTaskEvent);
        populateTasks();
    }

    private void populateTasks() {
        final List<String> tasks = controller.getTasks();
        //Log.d(MVCView.APP_TAG, String.format("%d found tasks ", tasks.size()));
        lvTask.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tasks.toArray(new String[]{})));
        lvTask.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
                //Log.d(MVCView.APP_TAG, String.format("task id: %d and position: %d", id, position));
                final TextView v = (TextView) view;
                controller.deleteTask(v.getText().toString());
                populateTasks();
            }
        });
    }

    private final View.OnClickListener handleNewTaskEvent = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            //Log.d(APP_TAG, "New Task button added");
            controller.addTask(etNewTask.getText().toString());
            populateTasks();
            etNewTask.setText("");
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}

