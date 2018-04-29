package com.example.quanghai.noitro.monnuong;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.quanghai.noitro.ListAdapter;
import com.example.quanghai.noitro.R;
import com.example.quanghai.noitro.danhsach;
import com.example.quanghai.noitro.danhsachmon;
import com.example.quanghai.noitro.monchien.webviewmonchien;

import java.util.ArrayList;

public class lvmonnuong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvmonnuong);
        //màn hình dọc
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        ListView lvdaycon=(ListView)findViewById(R.id.lvmonnuong);
        ArrayList<danhsach> mangds=new ArrayList<danhsach>();
        mangds.add(new danhsach("Sườn nướng xá xíu"));
        mangds.add(new danhsach("Gà nướng húng quế "));
        mangds.add(new danhsach("Gà nướng hương thảo"));
        mangds.add(new danhsach("Sườn cừu nướng chua cay"));

        mangds.add(new danhsach("Phi lê cá nướng xiên"));
        mangds.add(new danhsach("Heo nướng mè"));
        mangds.add(new danhsach("Nghêu nướng mỡ chài"));
        mangds.add(new danhsach("Cà ri nướng"));
        mangds.add(new danhsach("Thăn heo nướng trà xanh"));
        mangds.add(new danhsach("Bột cuộn cá chẽm nướng"));
        mangds.add(new danhsach("Lươn nướng lá dứa"));
        mangds.add(new danhsach("Nấm nướng giấy bạc"));
        mangds.add(new danhsach("Tim bò nướng cay"));
        mangds.add(new danhsach("Trứng đà điểu nướng"));
        mangds.add(new danhsach("Cá trứng nướng muối ớt"));
        mangds.add(new danhsach("Gà nướng ngũ vị"));
        mangds.add(new danhsach("Nem nướng chuối hột ngâm chua"));
        mangds.add(new danhsach("Vịt sốt cam"));

        ListAdapter adapter=new ListAdapter(lvmonnuong.this, R.layout.activity_dong, mangds);

        lvdaycon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(lvmonnuong.this, webviewmonnuong.class);
                intent.putExtra("value",""+position);
                lvmonnuong.this.startActivity(intent);
            }
        });
        lvdaycon.setAdapter(adapter);

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
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=vn.zalo.ngoalongmb");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
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
