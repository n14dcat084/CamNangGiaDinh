package com.example.quanghai.noitro.monxao;

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

import java.util.ArrayList;

public class lvmonxao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvmonxao);
//màn hình dọc
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ListView lvxao=(ListView)findViewById(R.id.lvmonxao);
        ArrayList<danhsach> mangds=new ArrayList<danhsach>();
        mangds.add(new danhsach("Nấm xào sả ớt"));
        mangds.add(new danhsach("Cật heo xào chua ngọt"));
        mangds.add(new danhsach("Bún bò xào thơm ngon nức mũi"));
        mangds.add(new danhsach("Gân bò xào chua ngọt ngon tuyệt"));
        mangds.add(new danhsach("Rau muống xào bạch tuộc cực ngon"));
        mangds.add(new danhsach("Ốc biển sốt chua cay ngon tuyệt"));
        mangds.add(new danhsach("Ốc xào sả ớt ngon miệng, đảm bảo vệ sinh"));
        mangds.add(new danhsach("Mì xào giòn cực đơn giản và ngon mê ly"));
        mangds.add(new danhsach("Bắp xào tép thơm ngon, ăn là nghiền"));
        mangds.add(new danhsach("Ốc xào măng chua ngon lạ, cực độc đáo"));
        mangds.add(new danhsach("Mướp xào nấm"));
        mangds.add(new danhsach("Đậu phụ xào dưa chua"));
        mangds.add(new danhsach("Dưa chua xào nghêu"));
        mangds.add(new danhsach("Ốc mỡ xào sa tế"));
        mangds.add(new danhsach("Miến xào măng"));
        mangds.add(new danhsach("Đậu phụ xào giá đỗ "));
        mangds.add(new danhsach("Hến xào lá lốt làm nhanh ăn ngon "));
        mangds.add(new danhsach("Bạch tuộc xào sả ớt nhâm nhi cuối tuần "));
        mangds.add(new danhsach("Thịt lợn xào tiêu cay "));
        mangds.add(new danhsach("Mề gà xào cà tím "));
        mangds.add(new danhsach("Thịt gà xào dưa cải chua "));
        mangds.add(new danhsach("Nấm xào tỏi kiểu mới "));
        mangds.add(new danhsach("Đậu bắp xào tép khô "));
        mangds.add(new danhsach("Thịt bò xào ngô bao tử "));
        mangds.add(new danhsach("Đậu phụ xào cay ăn mãi không ngán "));
        mangds.add(new danhsach("Thịt bò xào củ đậu "));
        mangds.add(new danhsach("Mướp xào nấm giòn ngọt "));
        mangds.add(new danhsach("Thịt bò xào măng tươi và su su "));
        mangds.add(new danhsach("Miến xào thập cẩm dễ làm dễ ăn "));
        mangds.add(new danhsach("Nui gạo xào thịt bò "));
        mangds.add(new danhsach("Lưỡi lợn xào sả ớt "));
        mangds.add(new danhsach("Nấm đùi gà xào thịt bò "));
        mangds.add(new danhsach("Măng tươi xào bông hẹ "));
        mangds.add(new danhsach("Mề gà xào dứa"));
        mangds.add(new danhsach("Cá rán giòn xào chua ngọt thật ngon "));
        mangds.add(new danhsach("Ốc mỡ xào sa tế "));
        mangds.add(new danhsach("Thịt bò xào mướp đắng "));



        ListAdapter adapter=new ListAdapter(lvmonxao.this, R.layout.activity_dong, mangds);

        lvxao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(lvmonxao.this, webviewmonxao.class);
                intent.putExtra("value",""+position);
                lvmonxao.this.startActivity(intent);
            }
        });
        lvxao.setAdapter(adapter);

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
