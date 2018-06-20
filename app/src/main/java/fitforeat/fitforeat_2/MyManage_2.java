package fitforeat.fitforeat_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class MyManage_2 {

    //Explicit
    private MyOpenHelper_2 myOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;

    public static final String table_calary = "calary_table";

    public static final String column_Food = "Food";
    public static final String column_Amount = "Amount";
    public static final String column_CalFood = "CalFood";
    public static final String column_Exercise = "Exercise";
    public static final String column_Hour = "Hour";
    public static final String column_CalBurn = "CalBurn";
    public static final String column_date = "Date";

    public MyManage_2(Context context) {

        //Connected Database
        myOpenHelper = new MyOpenHelper_2(context);
        writeSqLiteDatabase = myOpenHelper.getWritableDatabase();

    }   // Constructor


    public long addCalary(String strDate,
                          String strFood,
                          String strAmount,
                          String strCalFood) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_date, strDate);
        contentValues.put(column_Food, strFood);
        contentValues.put(column_Amount, strAmount);
        contentValues.put(column_CalFood, strCalFood);

        return writeSqLiteDatabase.insert(table_calary, null, contentValues);
    }

}   // Main Class