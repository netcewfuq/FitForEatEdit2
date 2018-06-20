package fitforeat.fitforeat_2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Main2Activity_home extends AppCompatActivity {


    EditText editTextName;
    EditText editTextAge;
    EditText editTextWeight;
    EditText editTextHeight;

    Button b_Action;
    TextView txt_result;
    TextView text_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2activity_home);

        txt_result = (TextView) findViewById(R.id.txt_result);
        text_result = (TextView) findViewById(R.id.text_result);

        editTextName  = (EditText)findViewById(R.id.editTextName);
        editTextAge = (EditText)findViewById(R.id.editTextAge);
        editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        editTextHeight = (EditText)findViewById(R.id.editTextHeight);

        b_Action = (Button) findViewById(R.id.b_Action);


        b_Action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name  =  editTextName.getText().toString();
                String age  =  editTextAge.getText().toString();
                String weight =  editTextWeight.getText().toString();
                String height  =  editTextHeight.getText().toString();




                if(!name.isEmpty()&&!age.isEmpty()&&!weight.isEmpty()&&!height.isEmpty()){
                   // DatabaseHelper helper = new DatabaseHelper(Add.this);

                    final TextView text_result = (TextView) findViewById(R.id.text_result);
                    float heightValue = Float.parseFloat(String.valueOf(height)) / 100;
                    float weightValue = Float.parseFloat(String.valueOf(weight));
                    float bmi = weightValue / (heightValue * heightValue);
                    double result = bmi;
                    text_result.setText(String.valueOf(result));


                    if (result>18.5 & result<23.4) {
                        Intent i = new Intent(Main2Activity_home.this, Main3Activity_fitness.class);
                        i.putExtra("text_result", ""+result);
                        Toast.makeText(getApplicationContext(), "น้ำหนักอยู่ในเกณมาตาฐาน" + result, Toast.LENGTH_LONG).show();
                        startActivity(i);
                    }


                    else if (result>=25) {

                        //Intent i = new Intent(Main2Activity_home.this, Main7Activity_Bmifat.class);
                        Intent i = new Intent(Main2Activity_home.this, Food_1.class);

                        i.putExtra("text_result", ""+result);
                        startActivity(i);

                        Toast.makeText(getApplicationContext(), "ค่า BMI ของคุณ =" + result, Toast.LENGTH_LONG).show();
                    }


                    else if (result<=24) {

                        //  Intent i = new Intent(Main2Activity_home.this, Main8Activity_Bmithin.class);
                        Intent i = new Intent(Main2Activity_home.this, Food_2.class);
                        i.putExtra("text_result", ""+result);
                        startActivity(i);

                        Toast.makeText(getApplicationContext(), "ค่า BMI ของคุณ =" + result, Toast.LENGTH_LONG).show();
                    }



                }else{
                    Toast.makeText(Main2Activity_home.this,"กรุณากรอกข้อมูลให้ครบ",Toast.LENGTH_SHORT).show();
                }

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


        ImageView imageView5;
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder dialog = new AlertDialog.Builder(Main2Activity_home.this);
                dialog.setTitle("Exit");
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setCancelable(true);
                dialog.setMessage("Do you want to exit?");
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });

                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                dialog.show();
            }




        }); /////////////// exitApp
    }

        public void onBackPressed() {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Exit");
            dialog.setIcon(R.mipmap.ic_launcher);
            dialog.setCancelable(true);
            dialog.setMessage("Do you want to exit?");
            dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            });

            dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            dialog.show();
        }  /////////////// onBackPressed



    public boolean Action()
    {


        final TextView text_result = (TextView) findViewById(R.id.text_result);

        final EditText editTextName = (EditText)findViewById(R.id.editTextName);
        final EditText editTextAge = (EditText)findViewById(R.id.editTextAge);
        final EditText editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        final EditText editTextHeight = (EditText)findViewById(R.id.editTextHeight);

        Integer weight =  Integer.valueOf(editTextWeight.getText().toString());
        Integer height =  Integer.valueOf(editTextHeight.getText().toString());

        float heightValue = Float.parseFloat(String.valueOf(height)) / 100;
        float weightValue = Float.parseFloat(String.valueOf(weight));

        float bmi = weightValue / (heightValue * heightValue);
        double result = bmi;
        text_result.setText(String.valueOf(result));





            if (result>18.5 & result<23.4) {

            //Intent i = new Intent(Main2Activity_home.this, Main7Activity_Bmifat.class);
            Intent i = new Intent(Main2Activity_home.this, Main3Activity_fitness.class);

            i.putExtra("text_result", ""+result);
            Toast.makeText(getApplicationContext(), "น้ำหนักอยู่ในเกณมาตาฐาน" + result, Toast.LENGTH_LONG).show();
            startActivity(i);


                }



                if (result>=25) {

                    //Intent i = new Intent(Main2Activity_home.this, Main7Activity_Bmifat.class);
                    Intent i = new Intent(Main2Activity_home.this, Food_1.class);

                    i.putExtra("text_result", ""+result);
                    startActivity(i);

                    Toast.makeText(getApplicationContext(), "ค่า BMI ของคุณ = " + result, Toast.LENGTH_LONG).show();
                }


                if (result<=24) {

                  //  Intent i = new Intent(Main2Activity_home.this, Main8Activity_Bmithin.class);
                    Intent i = new Intent(Main2Activity_home.this, Food_2.class);
                    i.putExtra("text_result", ""+result);
                    startActivity(i);

                    Toast.makeText(getApplicationContext(), "ค่า BMI ของคุณ = " + result, Toast.LENGTH_LONG).show();
                }


        return true;
    }
}



