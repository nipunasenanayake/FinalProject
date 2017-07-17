package edu.gsu.httpscs.finalproject;

import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.gsu.httpscs.finalproject.adapter.ListNormalAdapter;
import edu.gsu.httpscs.finalproject.dialog.CustomDialogQ3;
import edu.gsu.httpscs.finalproject.fragment.CheckListFragment;
import edu.gsu.httpscs.finalproject.fragment.DrawingsFragment;
import edu.gsu.httpscs.finalproject.fragment.EmgSMSFragment;
import edu.gsu.httpscs.finalproject.fragment.MemoFragment;
import edu.gsu.httpscs.finalproject.fragment.PasswordManagerFragment;
import edu.gsu.httpscs.finalproject.fragment.TaskReminderFragment;
import edu.gsu.httpscs.finalproject.fragment.TimerFragment;
import edu.gsu.httpscs.finalproject.adapter.ViewFragmentStateAdapter;


public class MVCSplash extends FragmentActivity {

    private ArrayList<String> contentList = new ArrayList<String>();
    private ArrayList<Pair<String,Fragment>> fragmentList = new ArrayList<Pair<String,Fragment>> ();


    @BindView(R.id.splash_lv)
    ListView listView;

    @BindView(R.id.splash_view_pager)
    ViewPager viewPager;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_splash);
        ButterKnife.bind(this);



        if(!(getIntent().getExtras()==null)){
            Bundle extras = getIntent().getExtras();
            String tmp = extras.getString("myKey");
            Toast.makeText(this,"Returned from password manager content - skipped unlock code",Toast.LENGTH_LONG).show();
        }

        initList();
        initFargments();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent("edu.gsu.httpscs.finalproject.MVCView");//check list
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent("edu.gsu.httpscs.finalproject.MVCViewReminder");//memos
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent("edu.gsu.httpscs.finalproject.DrawingActivityCanvas");//drawings
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent("edu.gsu.httpscs.finalproject.alarm.AlarmActivity");//task reminder
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent("edu.gsu.httpscs.finalproject.PasswordManagerLoginActivity");//password manager
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent("edu.gsu.httpscs.finalproject.TimerActivity");//timer
                        startActivity(intent5);
                        break;

                    case 6:
                       Intent intent6 = new Intent("edu.gsu.httpscs.finalproject.LocationActivity");//Emg SMS
                       startActivity(intent6);
                        break;

                    case 7://Exit
                        final CustomDialogQ3 customDialog = new CustomDialogQ3(MVCSplash.this, new CustomDialogQ3.ICustomDialogQ3Listener() {
                            @Override
                            public void onOKClicked(String msg) {
                                if (msg.equals("Stay")) {
                                    Toast.makeText(MVCSplash.this, "Welcome back!", Toast.LENGTH_SHORT).show();
                                }else if (msg.equals("Exit")){
                                    System.exit(0);
                                }
                            }

                            @Override
                            public void onCancelClicked(String msg) {
                                Toast.makeText(MVCSplash.this, "You clicked Cancel", Toast.LENGTH_SHORT).show();

                            }
                        });

                        customDialog.setCanceledOnTouchOutside(true);
                        customDialog.show();

                        break;

                    default:
                }
            }
        });



    }

    private void initList(){
        contentList.add("Check List");
        contentList.add("Memos");
        contentList.add("Drawings");
        contentList.add("Task Reminder");
        contentList.add("Password Manager");
        contentList.add("Timer");
        contentList.add("Send Emergency SMS");
        contentList.add("Exit");

        ListNormalAdapter adapter = new ListNormalAdapter(this,contentList);
        listView.setAdapter(adapter);



    }

    private void initFargments(){
        fragmentList.add(new Pair<String, Fragment>("CheckListFragment",new CheckListFragment()));
        fragmentList.add(new Pair<String, Fragment>("MemoFragment",new MemoFragment()));
        fragmentList.add(new Pair<String, Fragment>("DrawingsFragment",new DrawingsFragment()));
        fragmentList.add(new Pair<String, Fragment>("TaskReminderFragment",new TaskReminderFragment()));
        fragmentList.add(new Pair<String, Fragment>("PasswordManagerFragment",new PasswordManagerFragment()));
        fragmentList.add(new Pair<String, Fragment>("TimerFragment",new TimerFragment()));
        fragmentList.add(new Pair<String, Fragment>("EmgSMSFragment",new EmgSMSFragment()));




        ViewFragmentStateAdapter fragAdapter =
                new ViewFragmentStateAdapter(this.getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(fragAdapter);

    }
}

