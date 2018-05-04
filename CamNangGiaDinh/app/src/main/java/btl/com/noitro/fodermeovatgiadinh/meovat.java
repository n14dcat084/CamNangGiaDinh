package btl.com.noitro.fodermeovatgiadinh;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import DoiTuong.MeoVat;
import btl.com.noitro.CheckConnection;
import btl.com.noitro.MainActivity;
import btl.com.noitro.R;
import btl.com.noitro.adapter.MeoVatAdapter;
import btl.com.noitro.danhsach;

public class meovat extends AppCompatActivity implements SearchView.OnQueryTextListener {


    private SearchView searchView;
    private ListView l;
    private ShareActionProvider myShareActionProvider;

    final String DATABASE_NAME = "camnanggiadinh1.db";
    ArrayList<MeoVat>  arrayListMeovat;
    SQLiteDatabase database;
    MeoVatAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meovat);

//màn hình dọc
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Nút Back trên menu
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);

        actionBar.setDisplayHomeAsUpEnabled(true);
        //meoVatDatabase = new MeoVatDatabase(this);
        AnhXa();
        getDatafromSQLite();
        final ArrayList<danhsach> mangds = new ArrayList<danhsach>();
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//lay vi tri
                    Intent intent = new Intent(meovat.this, Activity_MeoVat.class);
                    intent.putExtra("value", "" + position);
                    startActivity(intent);
                }
            });
            //l.setAdapter(adapter);

        }

    //nút back
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

    public void AnhXa(){

        l = (ListView) findViewById(R.id.lv);
        arrayListMeovat = new ArrayList<>();
        adapter = new MeoVatAdapter(this, R.layout.activity_dong, arrayListMeovat);
        l.setAdapter(adapter);
    }

    public void getDatafromSQLite()
    {
        database = CheckConnection.initDatabase(this, DATABASE_NAME);
        Cursor cs = database.rawQuery("SELECT * FROM meovat", null);
        arrayListMeovat.clear();
        for(int i=0;i<cs.getCount();i++)
        {
            cs.moveToPosition(i);
            int id = cs.getInt(0);
            String tieude = cs.getString(1);
            byte [] url = cs.getBlob(2);
            String chitiet = cs.getString(3);
            arrayListMeovat.add(new MeoVat(id, tieude,url,chitiet));
        }
        adapter.notifyDataSetChanged();
    }

    public void addData(ArrayList<danhsach> mangds)
    {
        mangds.add(new danhsach("Làm thế nào để cơm lâu thiu trong ngày hè?"));

        mangds.add(new danhsach("Mẹo làm cua nhanh mà không bị kẹp"));

        mangds.add(new danhsach("Mẹo biến việc làm bếp trở nên cực kỳ đơn giản"));
        mangds.add(new danhsach("Mẹo chọn thực phẩm an toàn cho gia đình"));
        mangds.add(new danhsach("Tự chế thuốc trừ sâu an toàn cho vườn rau nhà bạn"));
        mangds.add(new danhsach("Chọn măng cụt để 10 quả ngon cả 10"));
        mangds.add(new danhsach("Bí quyết để nấu canh cua gạch đóng thành tảng"));
        mangds.add(new danhsach("Bí quyết để có món lươn ngon"));
        mangds.add(new danhsach("Cách tẩy vết cháy mà không làm xước xong nồi"));
        mangds.add(new danhsach("Cách đơn giản để nhà không có muỗi"));
        mangds.add(new danhsach("Cách nhận biết thịt lợn 'đội lốt' thịt bò"));
        mangds.add(new danhsach("7 bước đơn giản làm sạch tủ lạnh"));
        mangds.add(new danhsach("Bí quyết để có món ốc ngon"));
        mangds.add(new danhsach("Mẹo chọn và nấu tôm biển tươi ngon"));
        mangds.add(new danhsach("10 cách đơn giản để đuổi ruồi khỏi nhà"));
        mangds.add(new danhsach("Bí quyết gắp thức ăn không vỡ khi dính chảo"));
        mangds.add(new danhsach("Bí quyết đông lạnh thực phẩm một cách thông minh nhất"));
        mangds.add(new danhsach("Vài mẹo giúp món rau ngon hơn"));
        mangds.add(new danhsach("Mẹo giữ thịt heo tươi mà không cần cho vào tủ lạnh"));
        mangds.add(new danhsach("Cách luộc gà cúng căng mọng, bóng đẹp"));
        mangds.add(new danhsach("Cách đơn giản khử mùi hôi trong nhà vệ sinh"));
        mangds.add(new danhsach("Thực phẩm ngăn ngừa bệnh thiếu máu"));
        mangds.add(new danhsach("8 mẹo nấu ăn để có món cá thơm ngon"));
        mangds.add(new danhsach("Mẹo giữ rau quả tươi lâu"));
        mangds.add(new danhsach("Cách chọn thực phẩm sạch ngày Tết"));
        mangds.add(new danhsach("Không nên để thịt, cá trong tủ lạnh quá 7 ngày"));
        mangds.add(new danhsach("Mẹo làm bánh trôi bánh chay ngon"));
        mangds.add(new danhsach("Cách hạn chế mất vitamin C khi chế biến rau"));
        mangds.add(new danhsach("Loại bỏ mùi tỏi sau khi ăn"));
        mangds.add(new danhsach("Cách làm sạch ngao ốc, đơn giản và hiệu quả"));
        mangds.add(new danhsach("Mẹo nấu khoai tây ngon"));
        mangds.add(new danhsach("Cách hay làm giảm mùi tanh cá"));
        mangds.add(new danhsach("Mẹo luộc gà ngon"));
        mangds.add(new danhsach("Mách bạn cách xào rau thật xanh"));
        mangds.add(new danhsach("Mẹo chiên trứng, đậu phụ ngon"));
        mangds.add(new danhsach("Những mẹo hay từ quả chuối"));
        mangds.add(new danhsach("Cách chữa cơm nhão, khê"));
        mangds.add(new danhsach("Mẹo khử mùi hôi gà, bò, cá"));
        mangds.add(new danhsach("Bí quyết giúp thức ăn không bị cháy khét"));
        mangds.add(new danhsach("Để luộc thịt không bị hôi"));

    }
    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return true;
    }

}