package com.example.quanghai.noitro.moncanh;

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
import com.example.quanghai.noitro.MainActivity;
import com.example.quanghai.noitro.R;
import com.example.quanghai.noitro.danhsach;
import com.example.quanghai.noitro.danhsachmon;
import com.example.quanghai.noitro.foderdaycon.webviebdaycon;
import com.example.quanghai.noitro.fodermeovatgiadinh.meovatgiadinh;

import java.util.ArrayList;

public class lvmoncanh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvmoncanh);
        //màn hình dọc
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        ListView lvdaycon=(ListView)findViewById(R.id.lvmoncanh);
        ArrayList<danhsach> mangds=new ArrayList<danhsach>();
        mangds.add(new danhsach("Canh chua dưa leo bắp bò"));
        mangds.add(new danhsach("Canh rau mồng tơi nấu mướp"));
        mangds.add(new danhsach("Canh dọc mùng nấu mọc"));
        mangds.add(new danhsach("Canh bầu nấu ngao"));
        mangds.add(new danhsach("Thịt bằm nấu nấm, bông hẹ"));
        mangds.add(new danhsach("Canh cua cá cơm"));
        mangds.add(new danhsach("Cá lóc nấu ngót"));
        mangds.add(new danhsach("Khổ qua nhồi hải sản"));
        mangds.add(new danhsach("Canh tôm nấu bóng thả"));
        mangds.add(new danhsach("Bí đao cuộn tôm thịt"));
        mangds.add(new danhsach("Sườn hầm tam sắc"));
        mangds.add(new danhsach("Canh tôm nấu nấm"));
        mangds.add(new danhsach("Canh dưa cải bắp bò"));
        mangds.add(new danhsach("Bí ngòi nấu cua đồng"));
        mangds.add(new danhsach("Cá lóc nấu bông thiên lý"));
        mangds.add(new danhsach("Riêu cá chép"));
        mangds.add(new danhsach("Canh thịt bò thuôn hành"));
        mangds.add(new danhsach("Canh sườn heo khổ qua"));
        mangds.add(new danhsach("Súp tôm nấu tía tô"));
        mangds.add(new danhsach("Tôm nấu thơm cà chua"));
        mangds.add(new danhsach("Gà nấu sả"));
        mangds.add(new danhsach("Canh cua rau nhút"));
        mangds.add(new danhsach("Canh chua cua nấu măng"));
        mangds.add(new danhsach("Canh khổ qua nhồi hải sản"));
        mangds.add(new danhsach("Canh riêu cá"));
        mangds.add(new danhsach("Canh chua tôm bông so đũa"));
        mangds.add(new danhsach("Canh đu đủ bò viên"));
        mangds.add(new danhsach("Canh gà nấu với nấm tuyết"));
        mangds.add(new danhsach("Canh mít non lá lốt"));
        mangds.add(new danhsach("Canh ngao rau răm"));
        mangds.add(new danhsach("Cá thu nấu dứa"));
        mangds.add(new danhsach("Canh bí đỏ nấu lạc"));
        mangds.add(new danhsach("Canh bún tàu đậu hũ"));
        mangds.add(new danhsach("Canh bún tàu tôm thịt"));
        mangds.add(new danhsach("Canh củ sen"));
        mangds.add(new danhsach("Canh hoa thiên lý chả cua"));
        mangds.add(new danhsach("Canh khổ qua dồn tàu hũ"));
        mangds.add(new danhsach("Canh mộc nấu thả"));
        mangds.add(new danhsach("Canh nấm hương bao mộc"));
        mangds.add(new danhsach("Canh nấm tàu hũ"));
        mangds.add(new danhsach("Canh rong biển tàu hũ"));
        mangds.add(new danhsach("Canh sườn bung"));
        mangds.add(new danhsach("Canh sườn khoai tây"));
        mangds.add(new danhsach("Canh xà lách xoong tàu hủ viên"));
        mangds.add(new danhsach("Canh chua rau muống tôm"));
        mangds.add(new danhsach("Canh chua cá bốp và măng"));
        mangds.add(new danhsach("Bông hẹ cuộn tôm nấu nấm"));
        mangds.add(new danhsach("Kim châm, bông bí nấu giò sống"));
        mangds.add(new danhsach("Canh bắp cải cuộn cá thác lác tôm"));


        ListAdapter adapter=new ListAdapter(lvmoncanh.this, R.layout.activity_dong, mangds);

        lvdaycon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(lvmoncanh.this, webviewmoncanh.class);
                intent.putExtra("value",""+position);
                lvmoncanh.this.startActivity(intent);
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
