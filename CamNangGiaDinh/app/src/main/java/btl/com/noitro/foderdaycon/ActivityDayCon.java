package btl.com.noitro.foderdaycon;

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

import java.util.ArrayList;

import DoiTuong.MeoVat;
import btl.com.noitro.CheckConnection;
import btl.com.noitro.Databases.Database;
import btl.com.noitro.R;
import btl.com.noitro.fodermeovatgiadinh.Activity_MeoVat;

public class ActivityDayCon extends AppCompatActivity {

    public String DATABASE_NAME = "camnanggiadinh1.db";


    TextView tv, tv1;
    ImageView im;
    Button btnLove;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_con);
        AnhXa();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Action();
    }
    public void AnhXa()
    {
        tv = (TextView) findViewById(R.id.tvTieudeDC);
        im = (ImageView) findViewById(R.id.imChiTietDC);
        tv1 = (TextView) findViewById(R.id.tvChitietDC);
        btnLove = (Button) findViewById(R.id.btnLoveDC);
        db = new Database(this);
        //love = (Button) findViewById(R.id.btnLove);

        //sc = (ScrollView) findViewById(R.id.scroll);
//        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//        View view = inflater.inflate(R.layout.activity_dong,null);
    }
    public void Action()
    {


        Intent intent = getIntent();
        String id = intent.getStringExtra("value");
        final int x = Integer.parseInt(id);
        SQLiteDatabase database = CheckConnection.initDatabase(this, DATABASE_NAME);

        Cursor cs = database.rawQuery("SELECT * FROM DayCon where id = "+(x+1),null);
        cs.moveToFirst();//de truyen vao du lieu, vi khi tao ra thi se khong co truyen vao bat cu
        //du lieu nao, nen phai moveto first
        final String tieude = cs.getString(1);
        final byte[] ima = cs.getBlob(3);
        final String chitiet = cs.getString(2);
        tv.setText(tieude);
        tv1.setText(chitiet);
        Bitmap bm = BitmapFactory.decodeByteArray(ima, 0, ima.length);
        im.setImageBitmap(bm);
        btnLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean re = db.addData( tieude, ima, chitiet);
                if(re == false)
                {
                    Toast.makeText(ActivityDayCon.this, "Them k thanh cong vi da co trong danh sach", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(ActivityDayCon.this, "Da them vao muc yeu thich", Toast.LENGTH_SHORT).show();

                }

            }
        });



    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, daycon.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
