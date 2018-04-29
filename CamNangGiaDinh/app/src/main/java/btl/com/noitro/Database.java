package btl.com.noitro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by danh on 11/04/2018.
 */

public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "camnang.db";
    public static String TABLE_NAME = "nauan";
    public static String COL_1 = "type";
    public static String COL_2 = "title";
    public static String COL_3 = "urlImage";
    public static String COL_4 = "details";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql  = "create table "+TABLE_NAME + " ( " +COL_1 + " text primary key, " + COL_2 +" text, "
                + COL_3 +" text, "+ COL_4 + " text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists" + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    //them du lieu

    public Boolean addData(String type, String title, String urlImage, String info)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        Boolean result = true;
        cv.put(COL_1, type);
        cv.put(COL_2, title);
        cv.put(COL_3, urlImage);
        cv.put(COL_4, info);
        long r = db.insert(TABLE_NAME, null, cv);
        if(r==-1)
        {
            result = false;
        }
        return result;
    }


    public Boolean layData()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String SQLStr = "Select * from "+TABLE_NAME;
        Cursor cs = db.rawQuery(SQLStr, null);
//        if(cs.moveToFirst())
//        {
//            do{
//
//                int id = cs.getInt(cs.getColumnIndex(COL_1));
//                String tieude = cs.getString(cs.getColumnIndex(COL_2));
//                String urlAnh = cs.getString(cs.getColumnIndex(COL_3));
//                String chitiet = cs.getString(cs.getColumnIndex(COL_4));
//
//            }while(cs.moveToNext());



//        }
        return true;
    }
}
