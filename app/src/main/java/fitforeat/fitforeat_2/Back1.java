package fitforeat.fitforeat_2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Back1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back1);

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