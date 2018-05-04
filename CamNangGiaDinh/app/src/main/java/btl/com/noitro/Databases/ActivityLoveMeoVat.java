package btl.com.noitro.Databases;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import btl.com.noitro.CheckConnection;
import btl.com.noitro.R;
import btl.com.noitro.fodermeovatgiadinh.Activity_MeoVat;

public class ActivityLoveMeoVat extends AppCompatActivity {

    Database db;
    TextView tv, tv1;
    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_meo_vat2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        AnhXa();
        Action();
    }
    public void AnhXa()
    {
        tv = (TextView) findViewById(R.id.tvTieudeLovemv);
        im = (ImageView) findViewById(R.id.imChiTietLovemv);
        tv1 = (TextView) findViewById(R.id.tvChitietLovemv);
        db= new Database(this);
    }
    public void Action()
    {

        Intent intent = getIntent();
        String id = intent.getStringExtra("value1");
        id = "'" + id +"'";
        String sql = "select * from meovat where tieude =" + (id);
        Cursor cs = db.getData1(sql);

        cs.moveToFirst();
        final String tieude = cs.getString(0);
        final byte[] ima = cs.getBlob(1);
        final String chitiet = cs.getString(2);
        tv.setText(tieude);
        tv1.setText(chitiet);
        Bitmap bm = BitmapFactory.decodeByteArray(ima, 0, ima.length);
        im.setImageBitmap(bm);

    }
}
