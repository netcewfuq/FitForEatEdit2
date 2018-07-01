package fitforeat.fitforeat_2;



import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Show_Calary_2 extends AppCompatActivity {

    //Explicit
    private TextView dateTextView, calaryTextView, burnTextView, BMRTextView, sumCalorie;
    private ListView calaryListView, burnListView;
    private SQLiteDatabase sqLiteDatabase;
    private String lastDateString;


    private MyOpenHelper_2 database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_calary_2);

        Button backHome2= (Button) findViewById(R.id.backHome2);
        backHome2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View V) {

                Intent intent = new Intent(V.getContext(), Food_2.class);
                startActivityForResult(intent, 0);
            }

        });//Button


        ////////////////
        database = new MyOpenHelper_2(Show_Calary_2.this);
        /////////////////////////////////

        Button clear_Button = (Button) findViewById(R.id.clear_Button);
        clear_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                AlertDialog.Builder dialog = new AlertDialog.Builder(Show_Calary_2.this);
                dialog.setTitle("ลบข้อมูลทั้งหมด");
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setCancelable(true);
                dialog.setMessage("คุณต้องการลบข้อมูลทั้งหมดใช้หรือไม่ ?");
                dialog.setPositiveButton("ใช่", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
//
                        database.deleteAll();
                        Intent newActivity = new Intent(Show_Calary_2.this,Food_2.class);
                        startActivity(newActivity);
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


        //Bind Widget
        bindWidget();

        //Read All calaryTABLE
        readAllCalary();


        //Read Where on Date of calaryTABLE
        whereCalaryTABLE();


        //Show Result Cal
        showResultCal();

    }

    private void showResultCal() {

        double douCal = Double.parseDouble(calaryTextView.getText().toString());
        double douSumCal = douCal ;


        TextView txt_showResultCal = (TextView) findViewById(R.id.txt_showResultCal);
        txt_showResultCal.setText(Double.toString(douSumCal));

    }



    private void whereCalaryTABLE() {

        Cursor whereCalaryCursor = sqLiteDatabase.rawQuery("SELECT * FROM calary_table ", null);
        whereCalaryCursor.moveToFirst();
        int intCount = whereCalaryCursor.getCount();
        String[] calFoodStrings = new String[intCount];
        double sumCalFood = 0;

        for (int i=0;i<intCount;i++) {

            calFoodStrings[i] = whereCalaryCursor.getString(whereCalaryCursor.getColumnIndex(MyManage_2.column_CalFood));
            sumCalFood = sumCalFood + Double.parseDouble(calFoodStrings[i]);

            whereCalaryCursor.moveToNext();
        }   // for

        whereCalaryCursor.close();
        calaryTextView.setText(Double.toString(sumCalFood));

    }

    private void readAllCalary() {

        sqLiteDatabase = openOrCreateDatabase(MyOpenHelper_2.DATABASE_NAME,
                MODE_PRIVATE, null);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = df.format(c.getTime());
        Cursor calaryCursor = sqLiteDatabase.rawQuery("SELECT * FROM calary_table ", null);
        calaryCursor.moveToFirst();
        if(calaryCursor.getCount()<=0){
            String[] foodCalaryStrings = new String[1];
            foodCalaryStrings[0]="ไม่มีข้อมูล";
            String[] amountCalaryStrings = new String[1];
            foodCalaryStrings[0]=" ";
            String[] calCalaryStrings = new String[1];
            foodCalaryStrings[0]=" ";
            String[] dateCalaryStrings = new String[1];
            dateCalaryStrings[0]="ไม่มีข้อมูล";

            ReportList_1 objReportList = new ReportList_1(Show_Calary_2.this, foodCalaryStrings, dateCalaryStrings, amountCalaryStrings, calCalaryStrings);
            calaryListView.setAdapter(objReportList);
        }
        else {
            String[] idCalStrings = new String[calaryCursor.getCount()];
            String[] dateCalaryStrings = new String[calaryCursor.getCount()];
            String[] foodCalaryStrings = new String[calaryCursor.getCount()];
            String[] amountCalaryStrings = new String[calaryCursor.getCount()];
            String[] calCalaryStrings = new String[calaryCursor.getCount()];
            int[] iconInts = new int[calaryCursor.getCount()];

            for (int i = 0; i < calaryCursor.getCount(); i++) {

                dateCalaryStrings[i] = calaryCursor.getString(calaryCursor.getColumnIndex(MyManage_2.column_date));
                foodCalaryStrings[i] = calaryCursor.getString(calaryCursor.getColumnIndex(MyManage_2.column_Food));
                amountCalaryStrings[i] = calaryCursor.getString(calaryCursor.getColumnIndex(MyManage_2.column_Amount));
                calCalaryStrings[i] = calaryCursor.getString(calaryCursor.getColumnIndex(MyManage_2.column_CalFood));
                iconInts[i] = R.mipmap.ic_launcher;
                Log.d("data=", dateCalaryStrings[i]);
                Log.d("food=", foodCalaryStrings[i]);
                Log.d("amou=", amountCalaryStrings[i]);
                Log.d("cal=", calCalaryStrings[i]);
                calaryCursor.moveToNext();
            }   //for


            lastDateString = dateCalaryStrings[calaryCursor.getCount() - 1];
            dateTextView.setText(lastDateString);

            calaryCursor.close();

            //Create ListView
            ReportList_1 objReportList = new ReportList_1(Show_Calary_2.this, foodCalaryStrings, dateCalaryStrings, amountCalaryStrings, calCalaryStrings);
            calaryListView.setAdapter(objReportList);
        }

    }

    private void bindWidget() {



        dateTextView = (TextView) findViewById(R.id.dateTextView);
        calaryTextView = (TextView) findViewById(R.id.calaryTextView);
        calaryListView = (ListView) findViewById(R.id.listView3);


    }   // bindWidget


}   // Main Class

