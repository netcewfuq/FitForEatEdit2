package fitforeat.fitforeat_2;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

public class UserTable {
    private MySQLiteOpenHelper dbHelper;
    private SQLiteDatabase db;
    public  String error ="";
    public  UserTable(Context context){
        this.dbHelper = new MySQLiteOpenHelper(context);
    }
    public void close(){
        this.db.close();
    }
    public Cursor getAll(){
        String sql = "SELECT * FROM User";
        this.db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }
    public List<User> getUsers(){
        String sql = "SELECT * FROM User";
        this.db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        List<User> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("_id"));
            String fname = cursor.getString(cursor.getColumnIndex("fname"));
            Integer weight = cursor.getInt(cursor.getColumnIndex("weight"));
            Integer height = cursor.getInt(cursor.getColumnIndex("height"));
            Integer age = cursor.getInt(cursor.getColumnIndex("age"));
            list.add(new User(id,fname,weight,height,age));
        }
        cursor.close();
        db.close();
        return  list;
    }
    public int delete(int id){
        int effect = 0;
        this.db = dbHelper.getReadableDatabase();
        try{
            db = dbHelper.getWritableDatabase();
            String sql = "DELETE FROM User WHERE _id =?";
            SQLiteStatement stm = db.compileStatement(sql);
            stm.bindLong(1, id);
            effect = stm.executeUpdateDelete();
        }
        catch (SQLiteException e){
            error = "Delete Error: " + e.getMessage();
        }
        finally {
            db.close();
        }
        return effect;
    }
    public boolean insert(String fname, Integer weight, Integer height, Integer age){
        boolean success = false;
        this.db = dbHelper.getReadableDatabase();
        try{
            db = dbHelper.getWritableDatabase();
            String sql = "INSERT INTO User(fname,age,weight,height) VALUES(?, ?, ?, ?)";
            SQLiteStatement stm = db.compileStatement(sql);
            stm.bindString(1, fname);
            stm.bindLong(2, age);
            stm.bindLong(3, weight);
            stm.bindLong(4, height);

            stm.executeInsert();
            success = true;
        }
        catch (SQLiteException e){
            error = "Insert Error: " + e.getMessage();
        }
        finally {
            db.close();
        }
        return success;
    }
    public int update(int _id, String fname, String lname){
        int effect = 0;
        try{
            db = dbHelper.getWritableDatabase();
            String sql = " UPDATE User SET fname=?, lname=? WHERE _id=?";
            SQLiteStatement stm = db.compileStatement(sql);
            stm.bindString(1, fname);
            stm.bindString(2, lname);
            stm.bindLong(3, _id);
            effect = stm.executeUpdateDelete();
        }
        catch (SQLiteException e){
            error = "Update Error: " + e.getMessage();
        }
        finally {
            db.close();
        }
        return effect;
    }
}

