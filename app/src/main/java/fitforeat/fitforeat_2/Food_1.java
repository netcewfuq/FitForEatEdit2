package fitforeat.fitforeat_2;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Food_1 extends AppCompatActivity {

    // Explicit
    private Food_db_1 objFoodTABLE;
    private ListView foodListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_1);
        {
        }
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();

        foodListView = (ListView) findViewById(R.id.listView);

        Button b_Show_Calary_1= (Button) findViewById(R.id.b_Show_Calary_1);
        b_Show_Calary_1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View V) {
                Intent intent = new Intent(V.getContext(), Show_Calary_1.class);
                startActivityForResult(intent, 0);
            }

        });//Button

        Button buttonback = (Button) findViewById(R.id.buttonback);
        buttonback.setOnClickListener(new View.OnClickListener() {

            public void onClick(View V) {
                Intent intent = new Intent(V.getContext(), Main2Activity_home.class);
                startActivityForResult(intent, 0);
            }

        });//Button

        connectDataBase();

        //Create ListView
        createListView();

    }   // onCreate

    private void createListView() {

        final String[] strTitle = objFoodTABLE.readAllDataFood(1);
        final String[] strDetail = objFoodTABLE.readAllDataFood(2);
        String[] strIcon = objFoodTABLE.readAllDataFood(3);
        int[] intIcon = new int[strIcon.length];
        for (int i = 0; i < strIcon.length; i++) {

            if (strIcon[i].equals("อาหาร")) {
                intIcon[i] = R.drawable.r1;
            } else if (strIcon[i].equals("ของหวาน")) {
                intIcon[i] = R.drawable.w1;
            } else if (strIcon[i].equals("7-11")) {
                intIcon[i] = R.drawable.e7;
            } else if (strIcon[i].equals("ผลไม้")) {
                intIcon[i] = R.drawable.fruit;
//            } else {
//                intIcon[i] = R.drawable.steamed;
          }

        }   //for





        FoodList_1 objFoodList = new FoodList_1(Food_1.this, strTitle, strDetail, intIcon);
        foodListView.setAdapter(objFoodList);

        foodListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                myAlertDialog(strTitle[i], strDetail[i]);

            }   // event
        });

    }   // createListView

    private void myAlertDialog(final String strFood, final String strFactor) {

        AlertDialog.Builder objBuilder = new AlertDialog.Builder(this);

        DateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();
        final String strDate = myDateFormat.format(currentDate);  // strDate

        final EditText objEditText = new EditText(Food_1.this);

        objEditText.setInputType(InputType.TYPE_CLASS_NUMBER);

        objBuilder.setTitle("วันที่ " + strDate);
        objBuilder.setMessage(strFood + "\n\n" + strFood + " = " + strFactor +" calories" +"\n"
                + "ใส่จำนวนบริโภค :");

        objBuilder.setView(objEditText);

        objBuilder.setPositiveButton("เพิ่ม", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                try {

                    String strAmount = objEditText.getText().toString().trim();
                    confirmAlertDialog(strDate, strFood, strFactor, strAmount);
                    dialogInterface.dismiss();

                } catch (Exception e) {
                    Toast.makeText(Food_1.this, "กรุณาระบุจำนวน", Toast.LENGTH_SHORT).show();
                }

            }   // event
        });
        objBuilder.show();

    }   // myAlertDialog

    private void confirmAlertDialog(final String strDate, final String strFood, String strFactor, final String strAmount) {

        double douFactor = Double.parseDouble(strFactor);
        double douAmount = Double.parseDouble(strAmount);
        double douAnswer = douFactor * douAmount;
        final String strAnswer = Double.toString(douAnswer);

        AlertDialog.Builder objBuilder = new AlertDialog.Builder(this);
        objBuilder.setTitle(strFood);
        objBuilder.setMessage(strFactor + " x " + strAmount + " = " + strAnswer + " calories");
        objBuilder.setPositiveButton("เพิ่ม", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                updateCalaryTABLE(strDate, strFood, strAmount, strAnswer);



                dialogInterface.dismiss();
            }
        });
        objBuilder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        objBuilder.show();

    }   // confirmAlertDialog

    private void updateCalaryTABLE(String strDate,
                                   String strFood,
                                   String strAmount,
                                   String strAnswer) {

        MyManage_1 myManage = new MyManage_1(this);
        myManage.addCalary(strDate, strFood, strAmount, strAnswer);
        Toast.makeText(Food_1.this, "บันทึกรายการ " + strFood + " เรียบร้อยแล้ว", Toast.LENGTH_SHORT).show();

    }


    private void connectDataBase() {
        objFoodTABLE = new Food_db_1(this);
    }


}   // Main Class
