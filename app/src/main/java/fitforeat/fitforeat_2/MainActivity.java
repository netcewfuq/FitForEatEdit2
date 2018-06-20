package fitforeat.fitforeat_2;

import android.content.Intent;
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

        Thread tread = new Thread(){
            public void run() {
                try {
                    sleep(4000);
                    Intent intent =
                            new Intent(getApplicationContext(), Main2Activity_home.class);
                    startActivity(intent);
                } catch (Exception e) {
                    //show error
                }
            }
        };
        tread.start();
    }
}
