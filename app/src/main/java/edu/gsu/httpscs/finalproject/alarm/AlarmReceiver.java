package edu.gsu.httpscs.finalproject.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import edu.gsu.httpscs.finalproject.service.BackgroundSoundService;

public class AlarmReceiver extends BroadcastReceiver
{


    @Override
    public void onReceive(final Context context, Intent intent)
    {
        // TODO Auto-generated method stub



        Toast.makeText(context, "Alarm Triggered!!!", Toast.LENGTH_LONG).show();

        Intent svc=new Intent(context, BackgroundSoundService.class);
        context.startService(svc);
//
//        final CustomDialogQ3 customDialog = new CustomDialogQ3(context, new CustomDialogQ3.ICustomDialogQ3Listener() {
//            @Override
//            public void onOKClicked(String msg) {
//                if (msg.equals("Yes") || msg.equals("No")) {
//                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
//                }else if (msg.equals("Exit")){
//                    System.exit(0);
//                }
//            }
//
//            @Override
//            public void onCancelClicked(String msg) {
//                Toast.makeText(context, "You clicked Cancel", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        customDialog.setCanceledOnTouchOutside(true);
//        customDialog.show();


    }

}
