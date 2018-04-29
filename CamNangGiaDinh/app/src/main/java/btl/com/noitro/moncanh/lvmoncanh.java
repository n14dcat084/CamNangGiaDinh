package btl.com.noitro.moncanh;

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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import DoiTuong.MeoVat;
import DoiTuong.MonCanh;
import btl.com.noitro.CheckConnection;
import btl.com.noitro.R;
import btl.com.noitro.adapter.MonCanhAdapter;
import btl.com.noitro.danhsach;
import btl.com.noitro.danhsachmon;

import btl.com.noitro.ultil.*;

import java.util.ArrayList;

public class lvmoncanh extends AppCompatActivity {

    private ListView l;
    SQLiteDatabase database;
    final String DATABASE_NAME = "camnanggiadinh.db";
    ArrayList<MonCanh> arrayListMonCanh;
    MonCanhAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvmoncanh);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar();
        AnhXa();

        getDatafromSQLite();
        //màn hình dọc

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(lvmoncanh.this, Activity_MonCanh.class);
                intent.putExtra("value",""+position);
                lvmoncanh.this.startActivity(intent);
            }
        });


    }

    public void AnhXa()
    {
        l = (ListView) findViewById(R.id.lvmoncanh);
        arrayListMonCanh = new ArrayList<>();
        adapter = new MonCanhAdapter(this, R.layout.activity_dong, arrayListMonCanh);
        l.setAdapter(adapter);
    }

    public void getDatafromSQLite()
    {
        database = CheckConnection.initDatabase(this, DATABASE_NAME);
        Cursor cs = database.rawQuery("SELECT * FROM MonAn WHERE idLoaiMonAn = 1", null);
        arrayListMonCanh.clear();

            for(int i=0;i<cs.getCount();i++)
            {

                cs.moveToPosition(i);
                int id = cs.getInt(0);
                String tieude = cs.getString(1);
                byte [] url = cs.getBlob(2);
                String chitiet = cs.getString(3);
                int idLoai = cs.getInt(4);
                arrayListMonCanh.add(new MonCanh(id,tieude,url, chitiet, idLoai));
            }

        adapter.notifyDataSetChanged();
    }

    public void ActionBar()
    {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
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
