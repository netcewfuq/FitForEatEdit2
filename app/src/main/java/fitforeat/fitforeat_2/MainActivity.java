package fitforeat.fitforeat_2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();

        SharedPreferences sharedPreferences = getSharedPreferences("MyBmi", MODE_PRIVATE);
        final String nameString = sharedPreferences.getString("Name", "");

//        Doing Controller
        Thread tread = new Thread(){
            public void run() {
                try {
                    sleep(4000);

                    if (nameString.isEmpty()) {
//                        Empty Data
                        Intent intent =
                                new Intent(getApplicationContext(), Main2Activity_home.class);
                        startActivity(intent);

                    } else {

                        Intent intent =
                                new Intent(getApplicationContext(), OverBmiActivity.class);
                        startActivity(intent);

                    }

                } catch (Exception e) {
                    //show error
                }
            }
        };
        tread.start();


//
//            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//            Intent intent = new  Intent  (this, MainActivity.class);
//            PendingIntent pintent  = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);
//
//            builder.setSmallIcon(R.mipmap.ic_launcher);
//            builder.setTicker("FitForEat Alert");
//            builder.setWhen(System.currentTimeMillis());
//            builder.setContentTitle("ออกกำลังกันเถอะ");
//            builder.setContentText("เราจะออกกำลังกายไปด้วยกัน FITFOREAT");
//            builder.setContentIntent(pintent);
//            builder.setAutoCancel(false);
//
//
////        Uri soundUri = RingtoneManager.getDefaultUri(Notification.DEFAULT_ALL);
//            Uri notif = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//            builder.setSound(notif);
//
//            android.app.Notification notification = builder.build();
//
//            notification.flags |= Notification.DEFAULT_LIGHTS
//                    | Notification.FLAG_AUTO_CANCEL
//                    | Notification.FLAG_ONLY_ALERT_ONCE;
//
//
//            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//            notificationManager.notify(10, notification);


        }



    }   // Main Method

