package fitforeat.fitforeat_2;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    private TextView nameTextView, ageTextView, weightTextView,
            heightTextView, bmiTextView, planTextView, startDateTextView;

    private String nameString, ageString, weightString, heightString,
            bmiString, planString, startDateString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        showNoti();

        getValue();

        initialView();

        showView();


    }   // Main Method

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
        builder.setSmallIcon(R.drawable.ic_action_noti);
        builder.setTicker("FitForEat Alert");
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle("Please Exercise");
        builder.setContentText("Get Up Exercise");
        builder.setAutoCancel(false);


        Uri soundUri = RingtoneManager.getDefaultUri(Notification.DEFAULT_SOUND);
        builder.setSound(soundUri);

        android.app.Notification notification = builder.build();

        notification.flags |= Notification.DEFAULT_LIGHTS
                | Notification.FLAG_AUTO_CANCEL
                | Notification.FLAG_ONLY_ALERT_ONCE;


        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1000, notification);


    }



}
