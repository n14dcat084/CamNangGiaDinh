package com.example.quanghai.noitro.monkho;

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

public class lvmonkho extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvmonkho);
        //màn hình dọc
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        ListView lvkho=(ListView)findViewById(R.id.lvmonkho);
        ArrayList<danhsach> mangds=new ArrayList<danhsach>();
        mangds.add(new danhsach("Cá nục kho riềng và cà chua"));
        mangds.add(new danhsach("Ba chỉ kho su hào"));
        mangds.add(new danhsach("Cá hú kho riềng"));
        mangds.add(new danhsach("Thịt heo ba chỉ kho tiêu xanh"));
        mangds.add(new danhsach("Thịt đông"));
        mangds.add(new danhsach("Bắp bò um sả"));
        mangds.add(new danhsach("Nem thịt"));
        mangds.add(new danhsach("Ba rọi kho nấm đông cô"));
        mangds.add(new danhsach("Thịt ba rọi kho xí muội"));
        mangds.add(new danhsach("Sườn non kho đậu hũ"));
        mangds.add(new danhsach("Sườn non kho cái dừa tươi"));
        mangds.add(new danhsach("Củ sen kho tôm<"));
        mangds.add(new danhsach("Cá trắm kho dưa cải"));
        mangds.add(new danhsach("Cá cơm kho tiêu"));
        mangds.add(new danhsach("Tôm kho trứng cút"));
        mangds.add(new danhsach("Bò thưng"));
        mangds.add(new danhsach("Ba rọi kho tiêu"));
        mangds.add(new danhsach("Cá rô kho dưa hường"));
        mangds.add(new danhsach("Cá cơm kho thịt"));
        mangds.add(new danhsach("Cá kho riềng"));
        mangds.add(new danhsach("Mực khìa trái dừa"));
        mangds.add(new danhsach("Muối sả mắm ruốc kho"));
        mangds.add(new danhsach("Thịt ba rọi kho xí muội"));
        mangds.add(new danhsach("Bò kho tiêu"));
        mangds.add(new danhsach("Bò nấu nho"));
        mangds.add(new danhsach("Cá thu kho cà"));
        mangds.add(new danhsach("Thịt heo kho thơm, sả và ớt"));
        mangds.add(new danhsach("Cá hồi kho với dưa cải chua"));
        mangds.add(new danhsach("Cá cơm kho riềng"));
        mangds.add(new danhsach("Thịt heo kho tàu với hoa hồi và gừng"));
        mangds.add(new danhsach("Thịt vịt kho tàu với hạt sen, bột quế và cam tươi"));
        mangds.add(new danhsach("Gà kho gừng"));
        mangds.add(new danhsach("Cá ngừ kho với thơm"));
        mangds.add(new danhsach("Mì thịt hầm"));
        mangds.add(new danhsach("Bò sốt cay"));


        ListAdapter adapter=new ListAdapter(lvmonkho.this, R.layout.activity_dong, mangds);

        lvkho.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(lvmonkho.this, webviewmonkho.class);
                intent.putExtra("value",""+position);
                lvmonkho.this.startActivity(intent);
            }
        });
        lvkho.setAdapter(adapter);

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
