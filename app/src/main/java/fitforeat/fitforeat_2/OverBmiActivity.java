package fitforeat.fitforeat_2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Random;

public class OverBmiActivity extends AppCompatActivity {

    private TextView nameTextView, ageTextView, weightTextView,
            heightTextView, bmiTextView, planTextView, startDateTextView;

    private String nameString, ageString, weightString, heightString,
            bmiString, planString, startDateString;

    private Calendar currentCalendar, notiCalendar, startCalendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_bmi);

//        Initial View
        initialView();

//        Get Value From Preferance
        getValue();

//        Show View
        showView();

//        Reset Controller
        resetController();

//        Check Notification
        checkNotification();


    }   // Main Method

    @Override
    protected void onResume() {
        super.onResume();

        checkNotification();

    }

    private void checkNotification() {

        currentCalendar = Calendar.getInstance();
        notiCalendar = Calendar.getInstance();
        startCalendar = Calendar.getInstance();

        String[] strings = startDateString.split("-");
        startCalendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(strings[0]));
        startCalendar.set(Calendar.MONTH, Integer.parseInt(strings[1]));
        startCalendar.set(Calendar.YEAR, Integer.parseInt(strings[2]));

        Log.d("20JuneV1", "currentCal ==> " + currentCalendar.getTime().toString());
        Log.d("20JuneV1", "startCal ==> " + startCalendar.getTime().toString());

        notiCalendar.set(Calendar.HOUR_OF_DAY, 17);
        notiCalendar.set(Calendar.MINUTE, 0);
        notiCalendar.set(Calendar.SECOND, 0);

//        Hard Status
        if (planString.equals("Hard")) {

            int resultInt = currentCalendar.get(Calendar.DAY_OF_YEAR) - startCalendar.get(Calendar.DAY_OF_YEAR);
            if (resultInt <= 7) {

                sentValueToReceiver(notiCalendar);

            }   // if

        }   // if

//        Normal Status;
        if (planString.equals("Normal")) {

            int resultInt = currentCalendar.get(Calendar.DAY_OF_YEAR) - startCalendar.get(Calendar.DAY_OF_YEAR);
            if (resultInt <= 15) {

                sentValueToReceiver(notiCalendar);

            }   // if

        }

//        Easy Status
        if (planString.equals("Easy")) {

            int resultInt = currentCalendar.get(Calendar.DAY_OF_YEAR) - startCalendar.get(Calendar.DAY_OF_YEAR);
            if (resultInt <= 30) {

                sentValueToReceiver(notiCalendar);

            }   // if

        }

        Log.d("20JuneV1", "notiCalendar ==> " + notiCalendar.getTime().toString());
        sentValueToReceiver(notiCalendar);

    }


    private void sentValueToReceiver(Calendar calendar) {

        int intRandom = 0;
        Random random = new Random();
        intRandom = random.nextInt(1000);

        Intent intent = new Intent(getBaseContext(), MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(),
                intRandom, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                pendingIntent);


    }   // sentValue


    private void resetController() {
        Button button = findViewById(R.id.btnReset);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("MyBmi",
                        MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Name", "");
                editor.putString("Age", "");
                editor.putString("Weight", "");
                editor.putString("Height", "");
                editor.putString("BMI", "");
                editor.putString("Plan", "");
                editor.putString("StartDate", "");
                editor.commit();

                startActivity(new Intent(OverBmiActivity.this, Main2Activity_home.class));
                finish();
            }
        });
    }

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

}
