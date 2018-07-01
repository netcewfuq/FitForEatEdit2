package fitforeat.fitforeat_2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {

    private TextView nameTextView, ageTextView, weightTextView,
            heightTextView, bmiTextView, planTextView, startDateTextView;

    private String nameString, ageString, weightString, heightString,
            bmiString, planString, startDateString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        MyConstant myConstant = new MyConstant();
        myConstant.setaBoolean(false);

      showNoti();

        getValue();

        initialView();

        showView();

    showExercise();


    }   // Main Method

    private void showExercise() {

        RecyclerView recyclerView = findViewById(R.id.recyclerViewExercise);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        MyConstant myConstant = new MyConstant();
        String[] titleStrings = myConstant.getTitleStrings();
        String[] detailStrings = myConstant.getDetailStrings();
        int[] ints = myConstant.getIconInts();

        List<String> titleStringList = new ArrayList<>();
        List<String> detailStringList = new ArrayList<>();
        List<Integer> iconIntegerList = new ArrayList<>();

        for (int i=0; i<titleStrings.length; i+=1) {
            titleStringList.add(titleStrings[i]);
            detailStringList.add(detailStrings[i]);
            iconIntegerList.add(ints[i]);
        }

        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(this,
                titleStringList, detailStringList, iconIntegerList);
        recyclerView.setAdapter(recycleViewAdapter);


//        ImageView imageView = findViewById(R.id.imvExercise);
//        int[] ints = new int[]{R.drawable.hard, R.drawable.normal, R.drawable.easy};
//
//        if (planString.equals("Hard")) {
//            imageView.setImageResource(ints[0]);
//        } else if (planString.equals("Normal")) {
//            imageView.setImageResource(ints[1]);
//        } else {
//            imageView.setImageResource(ints[2]);
//        }

    }   // showExercise

    private void showView() {
        nameTextView.setText(nameString);
        ageTextView.setText(ageString + " YearOld");
        weightTextView.setText(weightString + " kg");
        heightTextView.setText(heightString + " cm");
        bmiTextView.setText(bmiString);
        planTextView.setText(planString);
        startDateTextView.setText(startDateString);
    }

    private void getValue() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyBmi", MODE_PRIVATE);
        nameString = sharedPreferences.getString("Name", "");
        ageString = sharedPreferences.getString("Age", "");
        weightString = sharedPreferences.getString("Weight", "");
        heightString = sharedPreferences.getString("Height", "");
        bmiString = sharedPreferences.getString("BMI", "");
        planString = sharedPreferences.getString("Plan", "");
        startDateString = sharedPreferences.getString("StartDate", "");
    }

    private void initialView() {
        nameTextView = findViewById(R.id.txtName);
        ageTextView = findViewById(R.id.txtAge);
        weightTextView = findViewById(R.id.txtWeight);
        heightTextView = findViewById(R.id.txtHeight);
        bmiTextView = findViewById(R.id.txtBmi);
        planTextView = findViewById(R.id.txtPlan);
        startDateTextView = findViewById(R.id.txtDate);
    }



    private void showNoti() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Intent intent = new  Intent  (this, NotificationActivity.class);
        PendingIntent pintent  = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker("FitForEat Alert");
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle("ออกกำลังกันเถอะ");
        builder.setContentText("เราจะออกกำลังกายไปด้วยกัน FITFOREAT");
        builder.setContentIntent(pintent);
        builder.setAutoCancel(false);


//        Uri soundUri = RingtoneManager.getDefaultUri(Notification.DEFAULT_ALL);
        Uri notif = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(notif);

        android.app.Notification notification = builder.build();

        notification.flags |= Notification.DEFAULT_LIGHTS
                | Notification.FLAG_AUTO_CANCEL
                | Notification.FLAG_ONLY_ALERT_ONCE;


        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1000, notification);


    }



}
