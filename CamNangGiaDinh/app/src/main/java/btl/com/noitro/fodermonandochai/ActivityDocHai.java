package btl.com.noitro.fodermonandochai;

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
import btl.com.noitro.Databases.Database;
import btl.com.noitro.R;
import btl.com.noitro.fodermeovatgiadinh.Activity_MeoVat;

public class ActivityDocHai extends AppCompatActivity {

    public String DATABASE_NAME = "camnanggiadinh1.db";
    Database db;
    TextView tv, tv1;
    ImageView im;
    Button love;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_hai);
        AnhXa();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Action();
    }
    public void AnhXa()
    {
        tv = (TextView) findViewById(R.id.tvTieudeDocHai);
        im = (ImageView) findViewById(R.id.imChiTietDocHai);
        tv1 = (TextView) findViewById(R.id.tvChitietDocHai);
        love = (Button) findViewById(R.id.btnLoveDocHai);

        //sc = (ScrollView) findViewById(R.id.scroll);
//        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//        View view = inflater.inflate(R.layout.activity_dong,null);
    }
    public void Action()
    {

        db = new btl.com.noitro.Databases.Database(this);
        Intent intent = getIntent();
        String id = intent.getStringExtra("value");
        final int x = Integer.parseInt(id);
        SQLiteDatabase database = CheckConnection.initDatabase(this, DATABASE_NAME);

        Cursor cs = database.rawQuery("SELECT * FROM DocHai where id = "+(x+1),null);
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
                    Toast.makeText(ActivityDocHai.this, "Thêm không thành công, vì đã có trong mục ưa thích", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(ActivityDocHai.this, "Đã thêm vào mục ưa thích", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
