package btl.com.noitro.monnuong;

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
import android.widget.Toast;

import btl.com.noitro.CheckConnection;
import btl.com.noitro.R;
import btl.com.noitro.danhsachmon;

public class ActivityMonNuong extends AppCompatActivity {

    TextView tv,tv1;
    ImageView im;
    final String DATABASE_NAME = "camnanggiadinh.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_nuong);
        AnhXa();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        Action();

    }
    public void AnhXa()
    {
        tv = (TextView) findViewById(R.id.tvTieudeNuong);
        tv1 = (TextView) findViewById(R.id.tvChitietNuong);
        im= (ImageView) findViewById(R.id.imChiTietNuong);
    }
    public void Action()
    {
        Intent intent = getIntent();
        String id = intent.getStringExtra("value2");
        int x = Integer.parseInt(id);
        SQLiteDatabase database = CheckConnection.initDatabase(this, DATABASE_NAME);
        Toast.makeText(this, "x= "+x, Toast.LENGTH_LONG).show();
        Cursor cs = database.rawQuery("SELECT * FROM MonAn where id = " +(11+x), null);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, lvmonnuong.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
