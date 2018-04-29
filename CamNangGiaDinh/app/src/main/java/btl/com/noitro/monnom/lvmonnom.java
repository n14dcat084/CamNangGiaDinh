package btl.com.noitro.monnom;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import DoiTuong.Food;
import DoiTuong.MonCanh;
import btl.com.noitro.CheckConnection;
import btl.com.noitro.R;
import btl.com.noitro.adapter.MonAnAdapter;
import btl.com.noitro.danhsach;
import btl.com.noitro.danhsachmon;
import btl.com.noitro.listMonNomAdapter;

public class lvmonnom extends AppCompatActivity {

    ListView l ;
    ArrayList<Food> arr;
    MonAnAdapter monNomAdapter;
    SQLiteDatabase database;
    final String DATABASE_NAME = "camnanggiadinh.db";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvmonnom);
        //màn hình dọc
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        AnhXa();
        getDataFromSQLite();


        //listMonNomAdapter adapter = new listMonNomAdapter(lvmonnom.this, R.layout.activity_dong, arr);
        //ListAdapter adapter=new ListAdapter(lvmonnom.this, R.layout.activity_dong, mangds);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(lvmonnom.this, ActivityMonNom.class);
                intent.putExtra("value",""+position);
                lvmonnom.this.startActivity(intent);
            }
        });


    }

    public void AnhXa()
    {
        l = (ListView) findViewById(R.id.lvmonnom);
        arr = new ArrayList<>();
        monNomAdapter = new MonAnAdapter(this, R.layout.activity_dong, arr);
        l.setAdapter(monNomAdapter);
    }

    public void getDataFromSQLite()
    {
        database = CheckConnection.initDatabase(this, DATABASE_NAME);
        Cursor cs = database.rawQuery("SELECT * FROM MonAn WHERE idLoaiMonAn = 4", null);
        arr.clear();

        for(int i=0;i<cs.getCount();i++)
        {

            cs.moveToPosition(i);
            int id = cs.getInt(0);
            String tieude = cs.getString(1);
            byte [] url = cs.getBlob(2);
            String chitiet = cs.getString(3);
            int idLoai = cs.getInt(4);
            arr.add(new Food(id,tieude,url, chitiet, idLoai));
        }

        monNomAdapter.notifyDataSetChanged();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share,menu);

        //menu share
        MenuItem item = menu.findItem(R.id.action_share);
        final ShareActionProvider myShareActionProvider = (ShareActionProvider) MenuItemCompat
                .getActionProvider(item);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //menu share

                try{

                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=btl.com.noitro");
                    sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                    startActivity(Intent.createChooser(sharingIntent, "Chia sẻ"));
                    myShareActionProvider.setShareIntent(sharingIntent);

                }
                catch (Exception c) {
                }
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, danhsachmon.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void themTieude()
    {
        ArrayList<danhsach> mangds=new ArrayList<danhsach>();
        mangds.add(new danhsach("Gỏi ngó sen"));
        mangds.add(new danhsach("Gỏi măng thịt heo trộn thính"));
        mangds.add(new danhsach("Nộm hành tây"));
        mangds.add(new danhsach("Nộm chân gà ngó sen"));
        mangds.add(new danhsach("Gỏi măng tây"));
        mangds.add(new danhsach("Gỏi gà ngó sen"));
        mangds.add(new danhsach("Nộm thập cẩm"));
        mangds.add(new danhsach("Gỏi bông thiên điển"));
        mangds.add(new danhsach("Nộm đu đủ xanh và tai lợn ăn"));
        mangds.add(new danhsach("Nộm dưa chuột, cà rốt với tôm thịt"));
        mangds.add(new danhsach("Nộm gà xé phay"));
        mangds.add(new danhsach("Gỏi rau má thịt bò"));
        mangds.add(new danhsach("Bánh đa cua trộn"));
        mangds.add(new danhsach("Gỏi mực táo xanh"));
        mangds.add(new danhsach("Gỏi da cá"));
        mangds.add(new danhsach("Gỏi đậu cô ve tai heo"));
        mangds.add(new danhsach("Gỏi khô cá sặc"));
        mangds.add(new danhsach("Nộm ốc "));
        mangds.add(new danhsach("Nộm tép tươi"));
        mangds.add(new danhsach("Nộm rau muống thịt bò"));
    }
}
