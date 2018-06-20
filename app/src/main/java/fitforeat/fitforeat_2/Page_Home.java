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
import android.widget.ImageButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Page_Home extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_home);


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        Button b_Food_1 = (Button) findViewById(R.id.b_Food_1);
        b_Food_1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View V) {
                Intent intent = new Intent(V.getContext(), Food_1.class);
                startActivityForResult(intent, 0);
            }

        });//Button

        Button b_Food_2 = (Button) findViewById(R.id.b_Food_2);
        b_Food_2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View V) {
                Intent intent = new Intent(V.getContext(), Food_2.class);
                startActivityForResult(intent, 0);
            }

        });//Button

        Button b_Show_Calary_1= (Button) findViewById(R.id.b_Show_Calary_1);
        b_Show_Calary_1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View V) {
                Intent intent = new Intent(V.getContext(), Show_Calary_1.class);
                startActivityForResult(intent, 0);
            }

        });//Button

        Button b_Show_Calary_2= (Button) findViewById(R.id.b_Show_Calary_2);
        b_Show_Calary_2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View V) {
                Intent intent = new Intent(V.getContext(), Show_Calary_2.class);
                startActivityForResult(intent, 0);
            }

        });//Button



    }

    }