package btl.com.noitro.Databases;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import DoiTuong.MeoVat;
import btl.com.noitro.LoveActivity;
import btl.com.noitro.MainActivity;
import btl.com.noitro.R;
import btl.com.noitro.adapter.MeoVatAdapter;
import btl.com.noitro.fodermeovatgiadinh.Activity_MeoVat;
import btl.com.noitro.fodermeovatgiadinh.meovat;

public class LoveMeoVat extends AppCompatActivity {
    ListView l;
    Database db;
    MeoVatAdapter adapter;
    ArrayList<MeoVat> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_meo_vat);
        AnhXa();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//lay vi tri
                Intent intent = new Intent(LoveMeoVat.this, ActivityLoveMeoVat.class);
                intent.putExtra("value1", arrayList.get(position).getTieude());
                startActivity(intent);

            }
        });
        action();

    }

    private void AnhXa() {
        l = (ListView) findViewById(R.id.lvLoveMeoVat);
        db = new Database(this);
        arrayList = new ArrayList<>();
        adapter = new MeoVatAdapter(this, R.layout.activity_dong,arrayList );
        l.setAdapter(adapter);

    }
    public void action()
    {
        Cursor cs = db.getData();
        arrayList.clear();
        for(int i=0;i<cs.getCount();i++)
        {
            cs.moveToPosition(i);
            String tieude = cs.getString(0);
            byte [] url = cs.getBlob(1);
            String chitiet = cs.getString(2);
            arrayList.add(new MeoVat(tieude,url,chitiet));
        }
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
