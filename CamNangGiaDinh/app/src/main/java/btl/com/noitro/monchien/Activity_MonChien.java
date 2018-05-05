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
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import btl.com.noitro.CheckConnection;
import btl.com.noitro.Databases.Database;
import btl.com.noitro.R;
import btl.com.noitro.adapter.xemvideo;
import btl.com.noitro.danhsachmon;
import btl.com.noitro.fodermeovatgiadinh.meovat;
import btl.com.noitro.moncanh.Activity_MonCanh;

public class Activity_MonChien extends AppCompatActivity {
    public String DATABASE_NAME = "camnanggiadinh.db";
    TextView tv, tv1;
    ImageView im;
    Button love, video;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__mon_chien);
        AnhXa();
        Action();
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_MonChien.this, xemvideo.class));
            }
        });
    }

    public void AnhXa()
    {
        video = (Button) findViewById(R.id.btnVideo);
        db = new Database(this);
        tv = (TextView) findViewById(R.id.tvTieudeChien);
        im = (ImageView) findViewById(R.id.imChiTietChien);
        tv1 = (TextView) findViewById(R.id.tvChitietChien);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        love = (Button) findViewById(R.id.btnLoveChien);
    }
    public void Action() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("value1");
        int x = Integer.parseInt(id);
        SQLiteDatabase database = CheckConnection.initDatabase(this, DATABASE_NAME);

            //x=1;
            Cursor cs = database.rawQuery("SELECT * FROM MonAn where  id = " + (41 + x), null);
            cs.moveToFirst();//de truyen vao du lieu, vi khi tao ra thi se khong co truyen vao bat cu
            //du lieu nao, nen phai moveto first
            final String tieude = cs.getString(1);
            final byte[] ima = cs.getBlob(2);
            final String chitiet = cs.getString(3);
            tv.setText(tieude);
            tv1.setText(chitiet);
            Bitmap bm = BitmapFactory.decodeByteArray(ima, 0, ima.length);
            im.setImageBitmap(bm);
            love.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean re = db.addData(tieude, ima, chitiet);
                    if(re == false)
                    {
                        Toast.makeText(Activity_MonChien.this, "Thêm không thành công, vì đã có trong mục ưa thích", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(Activity_MonChien.this, "Đã thêm vào mục ưa thích", Toast.LENGTH_SHORT).show();

                    }

                }
            });

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
