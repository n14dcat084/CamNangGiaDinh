package btl.com.noitro.monkho;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import btl.com.noitro.CheckConnection;
import btl.com.noitro.Databases.Database;
import btl.com.noitro.R;
import btl.com.noitro.danhsachmon;
import btl.com.noitro.monchien.Activity_MonChien;

public class ActivityMonKho extends AppCompatActivity {

    TextView tv, tv1;
    ImageView image;
    Button love;
    public String DATABASE_NAME = "camnanggiadinh.db";
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_kho);
        //LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        //View view = inflater.inflate(R.layout.activity__mon_canh,null);

        AnhXa();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        Action();

    }
    public void AnhXa()
    {
        db = new Database(this);
        love = (Button) findViewById(R.id.btnLoveKho);
        tv = (TextView) findViewById(R.id.tvTieudeKho);
        image = (ImageView) findViewById(R.id.imChiTietKho);
        tv1 = (TextView) findViewById(R.id.tvChitietKho);
    }
    public void Action(){
        Intent intent = getIntent();
        String id = intent.getStringExtra("value");
        int x = Integer.parseInt(id);
        SQLiteDatabase database = CheckConnection.initDatabase(this, DATABASE_NAME);

        Cursor cs = database.rawQuery("SELECT * FROM MonAn where id = "+(21+x),null);
        cs.moveToFirst();//de truyen vao du lieu, vi khi tao ra thi se khong co truyen vao bat cu
        //du lieu nao, nen phai moveto first
        final String tieude = cs.getString(1);
        final byte[] ima = cs.getBlob(2);
        final String chitiet = cs.getString(3);
        tv.setText(tieude);
        tv1.setText(chitiet);
        Bitmap bm = BitmapFactory.decodeByteArray(ima, 0, ima.length);
        image.setImageBitmap(bm);
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean re = db.addData(tieude, ima, chitiet);
                if(re == false)
                {
                    Toast.makeText(ActivityMonKho.this, "Thêm không thành công, vì đã có trong mục ưa thích", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(ActivityMonKho.this, "Đã thêm vào mục ưa thích", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, lvmonkho.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
