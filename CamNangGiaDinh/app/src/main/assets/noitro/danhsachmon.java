package com.example.quanghai.noitro;

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
import android.widget.Button;

import com.example.quanghai.noitro.moncanh.lvmoncanh;
import com.example.quanghai.noitro.foderdaycon.daycon;
import com.example.quanghai.noitro.monchien.lvmonchien;
import com.example.quanghai.noitro.monkho.lvmonkho;
import com.example.quanghai.noitro.monnom.lvmonnom;
import com.example.quanghai.noitro.monnuong.lvmonnuong;
import com.example.quanghai.noitro.monxao.lvmonxao;

public class danhsachmon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachmon);
        //màn hình dọc
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Button moncanh = (Button) findViewById(R.id.btnmoncanh);
        moncanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moncanh = new Intent(danhsachmon.this, lvmoncanh.class);
                startActivity(moncanh);
            }
        });
        Button monchien = (Button) findViewById(R.id.btnmonchien);
        monchien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monchien = new Intent(danhsachmon.this, lvmonchien.class);
                startActivity(monchien);
            }
        });
        Button monxao = (Button) findViewById(R.id.btnmonxao);
        monxao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monchien = new Intent(danhsachmon.this, lvmonxao.class);
                startActivity(monchien);
            }
        });
        Button monnuong = (Button) findViewById(R.id.btnmonnuong);
        monnuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monchien = new Intent(danhsachmon.this, lvmonnuong.class);
                startActivity(monchien);
            }
        });
        Button monkho = (Button) findViewById(R.id.btnmonkho);
        monkho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monchien = new Intent(danhsachmon.this, lvmonkho.class);
                startActivity(monchien);
            }
        });
        Button monnom = (Button) findViewById(R.id.btnmonnom);
        monnom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monchien = new Intent(danhsachmon.this, lvmonnom.class);
                startActivity(monchien);
            }
        });


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
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
