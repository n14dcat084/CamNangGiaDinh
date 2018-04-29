package btl.com.noitro.fodermeovatgiadinh;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import btl.com.noitro.CheckConnection;
import btl.com.noitro.R;

public class Activity_MeoVat extends AppCompatActivity {
    public String DATABASE_NAME = "camnanggiadinh.db";


    TextView tv, tv1;
    ImageView im;
    RatingBar lo;
    ScrollView sc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mv);
        AnhXa();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Action();

    }

    public void AnhXa()
    {
         tv = (TextView) findViewById(R.id.tvTieude);
         im = (ImageView) findViewById(R.id.imChiTiet);
         tv1 = (TextView) findViewById(R.id.tvChitiet);
         lo = (RatingBar) findViewById(R.id.love);
         //sc = (ScrollView) findViewById(R.id.scroll);
//        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//        View view = inflater.inflate(R.layout.activity_dong,null);
    }

    public void Action()
    {
        Intent intent = getIntent();
        String id = intent.getStringExtra("value");
        int x = Integer.parseInt(id);
        SQLiteDatabase database = CheckConnection.initDatabase(this, DATABASE_NAME);

        Cursor cs = database.rawQuery("SELECT * FROM meovat where id = "+(x+1),null);
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
                Intent intent = new Intent(this, meovat.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
