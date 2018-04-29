package btl.com.noitro.monchien;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import btl.com.noitro.CheckConnection;
import btl.com.noitro.R;
import btl.com.noitro.danhsachmon;
import btl.com.noitro.fodermeovatgiadinh.meovat;

public class Activity_MonChien extends AppCompatActivity {
    public String DATABASE_NAME = "camnanggiadinh.db";
    TextView tv, tv1;
    ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__mon_chien);
        AnhXa();
        Action();
    }

    public void AnhXa()
    {
        tv = (TextView) findViewById(R.id.tvTieudeChien);
        im = (ImageView) findViewById(R.id.imChiTietChien);
        tv1 = (TextView) findViewById(R.id.tvChitietChien);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    public void Action() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("value1");
        int x = Integer.parseInt(id);
        SQLiteDatabase database = CheckConnection.initDatabase(this, DATABASE_NAME);
        if (x == 0) {
            x=1;
            Cursor cs = database.rawQuery("SELECT * FROM MonAn where  id = " + (41 + x), null);
            cs.moveToFirst();//de truyen vao du lieu, vi khi tao ra thi se khong co truyen vao bat cu
            //du lieu nao, nen phai moveto first
            String tieude = cs.getString(1);
            byte[] ima = cs.getBlob(2);
            String chitiet = cs.getString(3);
            tv.setText(tieude);
            tv1.setText(chitiet);
            Bitmap bm = BitmapFactory.decodeByteArray(ima, 0, ima.length);
            im.setImageBitmap(bm);

        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, lvmonchien.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
