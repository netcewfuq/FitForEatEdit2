package fitforeat.fitforeat_2;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MyOpenHelper_2 extends SQLiteOpenHelper {

    //Explicit
    public static final String DATABASE_NAME = "my_db46.db";
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



    public MyOpenHelper_2(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    } //Construstor

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(calary_table);
        db.execSQL(FOOD_TABLE);


        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ข้าวผัดอเมริกัน', 690.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('กระเพาหมู + ไข่ดาว', 650.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('เส้นใหญ่ผัดซีอิ๊วหมู', 600.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ราดหน้าบะหมี่กรอบหมู', 550.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ข้าวไข่เจียว', 450.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ข้าวแกงกระหรี่หมูทอด', 900.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ผัดไทยกุ้งสดใส่ไข่', 550.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ข้าวขาหมู', 650.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ข้าวราดคะน้าหมูกรอบ', 620.00, 'อาหาร');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ข้าวมันไก่ 1 จาน', 550.00, 'อาหาร');");
        //อาหารในร้าน kfc
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ไก่นุ่มต้นตำรับ(สะโพก)', 280.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ไก่นุ่มต้นตำรับ(อก)', 330.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ไก่นุ่มต้นตำรับ(น่อง)', 160.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ไก่นุ่มต้นตำรับ(สันหลัง)', 400.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ไก่นุ่มต้นตำรับ(ปีก)', 230.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ไก่กรอบฮอทแอนด์สไปซี่(สะโพก)', 320.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ไก่กรอบฮอทแอนด์สไปซี่(อก)', 340.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ไก่กรอบฮอทแอนด์สไปซี่(น่อง)', 170.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ไก่กรอบฮอทแอนด์สไปซี่(สันหลัง)', 430.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ไก่กรอบฮอทแอนด์สไปซี่(ปีก)', 230.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ซิงเกอร์เบอเกอร์', 530.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('เบอร์เกอร์ปลาคริสปี้', 530.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ข้าวยำไก่แซ่บ', 640.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ข้าวยำไก่ซี๊ด', 480.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('วิงแซ่บ 1 ชิ้น', 100.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ไก่ป๊อบ 1 กล่อง', 300.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ฟิช ฟิงเกอร์ 3 ชิ้น', 180.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('นักเก็ตส์ 1 ชิ้น', 45.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('เฟรนซ์ฟรายส์ (ปกติ)', 150.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('เฟรนซ์ฟรายส์ (ใหญ่)', 230.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('เฟรนซ์ฟรายส์ (จัมโบ้)', 350.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('มันบด (เล็ก)', 50.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('มันบด (ใหญ่)', 210.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ทูน่าคอร์นสลัด (ปกติ)', 170.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ทูน่าคอร์นสลัด (ใหญ่)', 260.00, 'kfc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ทาร์ตไข่ 1 ชิ้น', 170.00, 'kfc');");
        //อาหารในร้าน McDonalds
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ชีสเบอรเกอร์ 1 ชิ้น', 300.00, 'mc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ดับเบิ้ลชีสเบอรเกอร์ 1 ชิ้น', 430.00, 'mc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ดีลักซ์ชีสเบอร์เกอร์ 1 ชิ้น', 320.00, 'mc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('บิ๊กแมค 1 ชิ้น', 530.00, 'mc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ซามูไรเบอร์เกอร์หมู 1 ชิ้น', 370.00, 'mc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('แม็คฟิช 1 ชิ้น', 370.00, 'mc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ดับเบิ้ลแม็คฟิช 1 ชิ้น', 300.00, 'mc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('แมคไก่ 1 ชิ้น', 370.00, 'mc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('แม็คสไปซี่ชิกเกนเบอร์เกอร์ 1 ชิ้น', 510.00, 'mc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('สไปซี่แม็ควิงส์ 4 ชิ้น ', 370.00, 'mc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('ไก่ทอด(สะโพก) 1 ชิ้น', 370.00, 'mc');");
        db.execSQL("INSERT INTO FoodTABLE(namefood, calfood, aboutfood) VALUES ('แม็คนักเก็ต 6 ชิ้น', 260.00, 'mc');");











































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
