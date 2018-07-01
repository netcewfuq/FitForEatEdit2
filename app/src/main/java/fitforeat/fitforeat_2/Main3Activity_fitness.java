package fitforeat.fitforeat_2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Main3Activity_fitness extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main3activity_fitness);


        ImageView imageView6;
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(getApplicationContext(), Chest1.class);
                //startActivity(go);
                startActivityForResult(go, 0);
            }
        });

        ImageView imageView7;
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(getApplicationContext(), Arm1.class);
                //startActivity(go);
                startActivityForResult(go, 0);

            }
        });

        ImageView imageView8;
        imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(getApplicationContext(), Shoulder1.class);
                //startActivity(go);
                startActivityForResult(go, 0);
            }
        });

        ImageView imageView9;
        imageView9 = (ImageView) findViewById(R.id.imageView9);
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(getApplicationContext(), Leg1.class);
                //startActivity(go);
                startActivityForResult(go, 0);
            }
        });

        ImageView imageView10;
        imageView10 = (ImageView) findViewById(R.id.imageView10);
        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(getApplicationContext(), Abs1.class);
                //startActivity(go);
                startActivityForResult(go, 0);
            }
        });


        ImageView imageView11;
        imageView11 = (ImageView) findViewById(R.id.imageView11);
        imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(getApplicationContext(), Back1.class);
                //startActivity(go);
                startActivityForResult(go, 0);
            }
        });




        ImageView imageView1;
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(getApplicationContext(), Main2Activity_home.class);
                //startActivity(go);
                startActivityForResult(go, 0);
            }
        });

        ImageView imageView2;
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(getApplicationContext(), Main4Activity_food.class);
                startActivityForResult(go, 0);
            }
        });


        ImageView imageView3;
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(getApplicationContext(), Main3Activity_fitness.class);
                startActivityForResult(go, 0);
            }
        });

        ImageView imageView4;
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(getApplicationContext(), Page_About.class);
                startActivityForResult(go, 0);
            }
        });


        SharedPreferences sharedPreferences = getSharedPreferences("MyBmi", MODE_PRIVATE);
        final String nameString = sharedPreferences.getString("Name", "");

        ImageView imageView5;
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameString.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "ยังไม่มีข้อมูล กรุณากรอกข้อมูล", Toast.LENGTH_LONG).show();
                    Intent go = new Intent(getApplicationContext(), Main2Activity_home.class);
                    startActivityForResult(go, 0);
                } else {
                    Intent go = new Intent(getApplicationContext(), OverBmiActivity.class);
                    startActivityForResult(go, 0);
                }
            }
        });
    }
}