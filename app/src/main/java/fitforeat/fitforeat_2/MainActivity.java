package fitforeat.fitforeat_2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

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


    }   // Main Method
}
