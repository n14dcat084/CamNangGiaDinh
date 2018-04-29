package btl.com.noitro.monxao;

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

import DoiTuong.Food;
import btl.com.noitro.CheckConnection;
import btl.com.noitro.ListAdapter;
import btl.com.noitro.R;
import btl.com.noitro.adapter.MonAnAdapter;
import btl.com.noitro.danhsach;
import btl.com.noitro.danhsachmon;
import btl.com.noitro.listMonXao;

import java.util.ArrayList;

public class lvmonxao extends AppCompatActivity {

    private ListView l;
    final String DATABASE_NAME = "camnanggiadinh.db";
    SQLiteDatabase database;
    ArrayList<Food> arr;
    MonAnAdapter monXaoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvmonxao);
//màn hình dọc
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        AnhXa();
        getDataFromSQLite();


        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(lvmonxao.this, ActivityMonXao.class);
                intent.putExtra("value",""+position);
                lvmonxao.this.startActivity(intent);
            }
        });


    }

    public void AnhXa()
    {
        l = (ListView) findViewById(R.id.lvmonxao);
        arr = new ArrayList<>();
        monXaoAdapter = new MonAnAdapter(this, R.layout.activity_dong, arr);
        l.setAdapter(monXaoAdapter);
    }
    public void getDataFromSQLite()
    {
        database = CheckConnection.initDatabase(this,DATABASE_NAME);
        Cursor cs = database.rawQuery("SELECT * FROM MonAn WHERE idLoaiMonAn = 6", null);
        arr.clear();
        for(int i=0;i<cs.getCount();i++)
        {
            cs.moveToPosition(i);
            int id = cs.getInt(0);
            String tieude = cs.getString(1);
            byte[] url = cs.getBlob(2);
            String chitiet = cs.getString(3);
            int idLoai = cs.getInt(4);
            arr.add(new Food(id,tieude,url,chitiet,idLoai));
        }
        monXaoAdapter.notifyDataSetChanged();
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
}
