package fitforeat.fitforeat_2;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MyOpenHelper_1 extends SQLiteOpenHelper {

    //Explicit
    public static final String DATABASE_NAME = "my_db38.db";
    private static final int DATABASE_VERSION = 1;


    private static final String calary_table = "create table calary_table (" +
            "_id integer primary key, " +
            "Date text, " +
            "Food text, " +
            "Amount text," +
            "CalFood text);";

    private static final String TABLE_NAME_1 = "calary_table";

    private static final String FOOD_TABLE = "create table foodTABLE (_id integer primary key, " +
            "namefood text, " +
            "calfood text, " +
            "aboutfood text);";



    public MyOpenHelper_1(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    } //Construstor

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(calary_table);
        db.execSQL(FOOD_TABLE);


        //db.execSQL("INSERT INTO USER_TABLE(name) VALUES ('1');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ข้าวสวย 1 ทัพพั (60กรัม)', 80.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('สลัดผัก', 120.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('สลัดไก่', 120.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('สลัดทูน่า', 140.00, 'อาหาร');");

        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ต้มแซ่บกระดูกหมู', 115.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ต้มผักกาดดองซ๊่โครงหมู', 90.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('แกงเลียง', 150.00, 'อาหาร');");

        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ผัดเผ็ดปลาดุก', 200.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ผัดผักบุ้ง', 200.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ผัดพริกแกงหมู', 200.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ผัดถั่วงอกเต้าหู้', 155.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ผัดกระหล่ำปีกุ้ง', 190.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ผัดผักกระเฉดน้ำมันหอย', 185.00, 'อาหาร');");


        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ต้มยำเห็ด 1 ถ้วย', 40.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ต้มยำกุ้ง 1 ถ้วย', 80.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('สุกี้ไก่ไม่ใส่วุ้นเส้น', 200.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('แกงจือเต้าหู้', 150.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('แกงจืดน่องไก่ตุ๋น', 150.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('แกงส้มไม่ใส่ชะอม', 50.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ไข่พะโล้', 150.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ต้มเล้งแซ่บ', 140.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ต้มจับฉ่าย', 90.00, 'อาหาร');");

        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ส้มตำข้าวโพด', 100.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ส้มตำไทย', 60.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ส้มตำปู', 40.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ลาบหมู', 130.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('หมูน้ำตก (หมูไม่มัน)', 165.00, 'อาหาร');");



        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ซูปหน่อไม้', 90.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ยำวุ้นเส้น', 100.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ยำหมูยอ', 120.00, 'อาหาร');");

        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ยำเห็ดเข็มทอง', 120.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ยำรวมมิตรทะเล', 120.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ยำปลากระป๋อง', 150.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ยำถั่วพลู', 185.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ยำปลาแซลม่อน', 150.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ไข่ตุ๋น', 150.00, 'อาหาร');");
        //อาหารในเซเว่น
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ไข่ต้ม 1 ฟอง', 70.00, '7-11');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ปลาทูน่ากระป๋อง', 180.00, '7-11');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('อกไก่นุ่ม', 80.00, '7-11');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('สันในไก่นุ่ม', 90.00, '7-11');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('กล้วยหอม', 120.00, '7-11');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('น้ำเต้าหู้', 100.00, '7-11');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ขนมกราโนล่า', 170.00, '7-11');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('เมล็ดมะม่วงหินพานต์อบเกลือ', 170.00, '7-11');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('โจ๊กหมูอีซี่โก', 150.00, '7-11');");

        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ส้มเขียนหวาน 1 ลูก ', 32.00, 'ผลไม้');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('เงาะ 1 ลูก', 13.00, 'ผลไม้');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('สัปปะรด 6 ชิ้น', 54.00, 'ผลไม้');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ฝรั่ง 1 ลูก', 52.00, 'ผลไม้');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ชมพู่ 1 ลูก', 16.00, 'ผลไม้');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('แอปเปิ้ล 1 ลูก', 42.00, 'ผลไม้');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('มะละกอสุก 6 ชิ้น', 39.00, 'ผลไม้');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ทุเรียน 1 เม็ด', 59.00, 'ผลไม้');");





















    } //onCreate สร้างฐานข้อมูล

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        onCreate(db);
    } //onUpgrade อัพเกรดฐานข้อมูล



    public void deleteAll(){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_NAME_1,null, null);
        //database.deleteDatabase(new File(TABLE_NAME_1));

        database.close();
    }



} //main class
