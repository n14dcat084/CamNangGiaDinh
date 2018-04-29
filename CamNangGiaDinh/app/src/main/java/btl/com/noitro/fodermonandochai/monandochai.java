package btl.com.noitro.fodermonandochai;

import android.content.Intent;
import android.content.pm.ActivityInfo;
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

import btl.com.noitro.ListAdapter;
import btl.com.noitro.MainActivity;
import btl.com.noitro.R;
import btl.com.noitro.danhsach;

public class monandochai extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monandochai);
        //màn hình dọc
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ListView lvmonandoc=(ListView)findViewById(R.id.lvmonandochai);
        ArrayList<danhsach> mangds=new ArrayList<danhsach>();
        mangds.add(new danhsach("8 thực phẩm chứa chất độc hại bạn vẫn ăn hàng ngày mà không biết"));
        mangds.add(new danhsach("Những món ăn nguy hiểm chết người"));
        mangds.add(new danhsach("Những tác hại nguy hiểm chết người của kẹo cao su"));
        mangds.add(new danhsach("Thực phẩm kỵ nhau có thể gây chết người"));
        mangds.add(new danhsach("Những món ăn khoái khẩu nguy hiểm chết người nên từ bỏ"));
        mangds.add(new danhsach("Những món đồ uống hấp dẫn nhưng nguy hiểm chết người"));
        mangds.add(new danhsach("20 loại hoa quả đẹp nhưng có chứa chất độc"));
        mangds.add(new danhsach("Thức uống có ga hủy hoại cơ thể bạn như thế nào"));
        mangds.add(new danhsach("Ăn nhiều xúc xích dễ bị suy tim"));
        mangds.add(new danhsach("Nuốt mật cá trắm có thể tử vong"));
        mangds.add(new danhsach("Ăn sứa mùa xuân dễ nhiễm độc tố"));
        mangds.add(new danhsach("Ô nhiễm tiếng ồn có thể gây bệnh"));
        mangds.add(new danhsach("Ô mai, mứt màu sặc sỡ thường độc hại"));
        mangds.add(new danhsach("Những thứ độc hại cần tống khứ khỏi nhà bếp"));
        mangds.add(new danhsach("Đường hóa học, chất ngọt chết người"));
        mangds.add(new danhsach("Các thực phẩm tưởng lợi hóa hại"));
        mangds.add(new danhsach("Nguy hiểm chết người từ 14 món ăn quen thuộc"));
        mangds.add(new danhsach("Những tác dụng ngoài ý muốn khi ăn chuối\n"));
        mangds.add(new danhsach("10 thực phẩm gây ung thư cao kinh hoàng"));
        mangds.add(new danhsach("Một số món ăn kị nhau"));


        ListAdapter adapter=new ListAdapter(monandochai.this, R.layout.activity_dong, mangds);

        lvmonandoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(monandochai.this, webviewmonandochai.class);
                intent.putExtra("value",""+position);
                startActivity(intent);
            }
        });
        lvmonandoc.setAdapter(adapter);
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
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
