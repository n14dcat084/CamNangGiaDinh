package btl.com.noitro.Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import DoiTuong.MeoVat;

/**
 * Created by danh on 03/05/2018.
 */

public class Database extends SQLiteOpenHelper{
    final public static String DATABASE_NAME = "love1.db";
    final public static String TABLE_NAME = "meovat";

    final public static String COL_1 = "tieude";
    final public static String COL_2 = "url";
    final public static String COL_3 = "chitiet";
    public Database(Context context) {
        super(context, DATABASE_NAME, null  ,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table "+TABLE_NAME+" ( "+COL_1 +" text primary key unique ,"+ COL_2+" blob, "+COL_3+ " text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addData( String tieude, byte[] url, String chitiet)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1, tieude);
        cv.put(COL_2, url);
        cv.put(COL_3, chitiet);
        long r = db.insert(TABLE_NAME, null, cv);
        if(r == -1)
            return false;
        return true;
    }
    public Cursor getData()
    {
        Cursor cs = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from "+TABLE_NAME;
        cs = db.rawQuery(sql,null);

        return cs;
    }
    public Cursor getData1(String sql) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(sql, null);
    }
}
