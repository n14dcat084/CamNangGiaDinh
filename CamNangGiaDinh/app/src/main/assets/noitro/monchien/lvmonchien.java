package com.example.quanghai.noitro.monchien;

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
import com.example.quanghai.noitro.moncanh.webviewmoncanh;

import java.util.ArrayList;

public class lvmonchien extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvmonchien);
        //màn hình dọc
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        ListView lvdaycon=(ListView)findViewById(R.id.lvmonchien);
        ArrayList<danhsach> mangds=new ArrayList<danhsach>();
        mangds.add(new danhsach("Tôm chiên nước cốt dừa ngon, béo ngậy"));
        mangds.add(new danhsach("Thịt thăn lợn chiên xù"));
        mangds.add(new danhsach("Cà tím kẹp thịt chiên giòn"));
        mangds.add(new danhsach("Bánh chưng rán giòn"));
        mangds.add(new danhsach("Cánh gà ngâm sữa chiên giòn"));
        mangds.add(new danhsach("Cơm chiên bí đỏ"));
        mangds.add(new danhsach("Bánh dày chiên xù xốt tương"));
        mangds.add(new danhsach("Sò điệp chiên xù"));
        mangds.add(new danhsach("Chả chìa Hạ Lũng"));
        mangds.add(new danhsach("Trứng chiên xù"));
        mangds.add(new danhsach("Gan heo chiên ngũ vị hương"));
        mangds.add(new danhsach("Bánh crêpe xốt cam"));
        mangds.add(new danhsach("Trứng chiên tôm mực"));
        mangds.add(new danhsach("Cút chiên sả ớt"));
        mangds.add(new danhsach("Giò lụa cuộn thịt xông khói"));
        mangds.add(new danhsach("Thịt vịt rang muối"));
        mangds.add(new danhsach("Ức gà nhồi phô mai"));
        mangds.add(new danhsach("Cơm chiên hoa thiên lý"));
        mangds.add(new danhsach("Cánh gà chiên xốt tương Java"));
        mangds.add(new danhsach("Chả giò nghêu"));
        mangds.add(new danhsach("Chả mực thì là"));
        mangds.add(new danhsach("Cừu Việt Nam nướng - khoai lang chiên"));
        mangds.add(new danhsach("Vũ khúc trứng"));
        mangds.add(new danhsach("Sandwich kẹp rong biển"));
        mangds.add(new danhsach("Ba rọi rút sườn chiên giòn"));
        mangds.add(new danhsach("Mực chiên xù với xốt thơm"));
        mangds.add(new danhsach("Cá thác lác chiên"));
        mangds.add(new danhsach("Gà chiên dừa"));
        mangds.add(new danhsach("Gà chiên"));
        mangds.add(new danhsach("Sườn chiên xả ớt"));


        ListAdapter adapter=new ListAdapter(lvmonchien.this, R.layout.activity_dong, mangds);

        lvdaycon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(lvmonchien.this, webviewmonchien.class);
                intent.putExtra("value",""+position);
                lvmonchien.this.startActivity(intent);
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
