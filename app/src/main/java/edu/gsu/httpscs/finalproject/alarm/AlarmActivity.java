package edu.gsu.httpscs.finalproject.alarm;


import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpscs.finalproject.service.BackgroundSoundService;
import edu.gsu.httpscs.finalproject.R;

public class AlarmActivity extends Activity

{

    private int intervalMin;
    private boolean alarmEnabled=false;


    @BindView(R.id.alarm_date_picker)
    DatePicker datePicker;

    @BindView(R.id.alarm_time_picker)
    TimePicker timePicker;


    @OnClick(R.id.alarm_set_btn)
    public void setAlarm(){
        scheduleAlarm();
        alarmEnabled=true;
    }

    @OnClick(R.id.alarm_stop_btn)
    public void stopAlarm(){
        Intent svc=new Intent(getApplicationContext(), BackgroundSoundService.class);
        getApplicationContext().stopService(svc);

        if (alarmEnabled) {
            Toast.makeText(this, "Alarm Stopped!!", Toast.LENGTH_LONG).show();
            alarmEnabled=false;
        }
    }



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        ButterKnife.bind(this);
        setCurrentDateTime();

    }

    public void scheduleAlarm()
    {

        Long time = new GregorianCalendar().getTimeInMillis()+10*1000;


        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.MONTH, datePicker.getMonth());
        calendar.set(Calendar.YEAR, datePicker.getYear());
        calendar.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());

        calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
        calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());
        calendar.set(Calendar.SECOND, 0);

        Intent intentAlarm = new Intent(this, AlarmReceiver.class);

        // create the object
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        //set the alarm for particular time
        alarmManager.set(AlarmManager.RTC,calendar.getTimeInMillis(), PendingIntent.getBroadcast(this,1,  intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT));

        Toast.makeText(this, "Alarm Scheduled!!", Toast.LENGTH_LONG).show();

    }

    private void setCurrentDateTime(){
        Calendar cal=Calendar.getInstance();

        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        int hour=cal.get(Calendar.HOUR_OF_DAY);
        int min=cal.get(Calendar.MINUTE);

        datePicker.updateDate(year, month, day);

        timePicker.setCurrentHour(hour);
        timePicker.setCurrentMinute(min);
    }




}








