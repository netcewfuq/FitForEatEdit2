package fitforeat.fitforeat_2;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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

//        Show Exercise
        showExercise();

//        Reset Controller
        resetController();

//       BACK TO HOME
        backtoHOME();


//        Check Notification
        MyConstant myConstant = new MyConstant();
        Log.d("23JuneV1", "boolean --> " + myConstant.isaBoolean());
        if (myConstant.isaBoolean()) {
            checkNotification();
        }


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

        int amountInt = 7;

        if (planString.equals("Easy")) {
            amountInt = 7;
        } else if (planString.equals("Normal")) {
            amountInt = 15;
        } else {
            amountInt = 30;
        }

        for (int i = 0; i < amountInt; i += 1) {
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

    @Override
    protected void onResume() {
        super.onResume();

        checkNotification();

    }

    private void checkNotification() {

        currentCalendar = Calendar.getInstance();
        notiCalendar = Calendar.getInstance();
        startCalendar = Calendar.getInstance();

//
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
           if (resultInt <= 30) {

               sentValueToReceiver(notiCalendar);

         }

       }


//        Normal Status;
        if (planString.equals("Normal")) {

            int resultInt = currentCalendar.get(Calendar.DAY_OF_YEAR) - startCalendar.get(Calendar.DAY_OF_YEAR);
            if (resultInt <= 15) {

                sentValueToReceiver(notiCalendar);

            }

        }

 //       Easy Status
        if (planString.equals("Easy")) {

            int resultInt = currentCalendar.get(Calendar.DAY_OF_YEAR) - startCalendar.get(Calendar.DAY_OF_YEAR);
            if (resultInt <= 7) {

            sentValueToReceiver(notiCalendar);

        }

    }



        Log.d("20JuneV1", "notiCalendar ==> " + notiCalendar.getTime().toString());
        sentValueToReceiver(notiCalendar);

    }




    private void sentValueToReceiver(Calendar calendar) {

        int intRandom = 0;
        Random random = new Random();
        intRandom = random.nextInt(1000);

//        final int _id = (int) System.currentTimeMillis();
//
//        Intent intent = new Intent(getBaseContext(), MyReceiver.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), _id, intent, 0);
//
//        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        Intent intent = new Intent(getBaseContext(), MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), intRandom, intent, 0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

    }   // sentValue

    private void backtoHOME() {
        Button button = findViewById(R.id.btnHome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(OverBmiActivity.this);
                dialog.setTitle("กลับหน้าหลัก ?");
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setCancelable(true);
                dialog.setPositiveButton("ใช่", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        startActivity(new Intent(OverBmiActivity.this, Main2Activity_home.class));
                        finish();
                    }
                });
                dialog.setNegativeButton("ไม่", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                dialog.show();
            }
        });
    }


    private void resetController() {
        Button button = findViewById(R.id.btnReset);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(OverBmiActivity.this);
                dialog.setTitle("ล้างข้อมูลทั้งหมด");
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setCancelable(true);
                dialog.setMessage("คุณต้องการล้างข้อมูลทั้งหมดใช่หรือไม่ ?");
                dialog.setPositiveButton("ใช่", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {


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
                dialog.setNegativeButton("ไม่", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                dialog.show();
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
