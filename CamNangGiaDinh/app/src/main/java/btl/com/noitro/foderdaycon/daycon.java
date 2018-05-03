package btl.com.noitro.foderdaycon;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
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
import android.widget.TextView;

import java.util.ArrayList;

import DoiTuong.MeoVat;
import btl.com.noitro.CheckConnection;
import btl.com.noitro.ListAdapter;
import btl.com.noitro.MainActivity;
import btl.com.noitro.R;
import btl.com.noitro.adapter.MeoVatAdapter;
import btl.com.noitro.danhsach;

public class daycon extends AppCompatActivity {

    final String DATABASE_NAME = "camnanggiadinh1.db";
    ListView l;
    ArrayList<MeoVat>  arrayListDayCon;
    SQLiteDatabase database;
    MeoVatAdapter adapterDayCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daycon);
        //màn hình dọc
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        AnhXa();

        getDatafromSQLite();

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(daycon.this, ActivityDayCon.class);
                intent.putExtra("value",""+position);
                daycon.this.startActivity(intent);
            }
        });
//        l.setAdapter(adapter);

    }
    public void AnhXa(){

        l = (ListView) findViewById(R.id.lvdaycon);
        arrayListDayCon = new ArrayList<>();
        adapterDayCon = new MeoVatAdapter(this, R.layout.activity_dong, arrayListDayCon);
        l.setAdapter(adapterDayCon);
    }
    public void getDatafromSQLite()
    {
        database = CheckConnection.initDatabase(this, DATABASE_NAME);
        Cursor cs = database.rawQuery("SELECT * FROM DayCon", null);
        arrayListDayCon.clear();
        for(int i=0;i<cs.getCount();i++)
        {
            cs.moveToPosition(i);
            int id = cs.getInt(0);
            String tieude = cs.getString(1);
            byte [] url = cs.getBlob(3);
            String chitiet = cs.getString(2);
            arrayListDayCon.add(new MeoVat(id, tieude,url,chitiet));
        }
        adapterDayCon.notifyDataSetChanged();
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
    public void abc()
    {
        ArrayList<danhsach> mangds=new ArrayList<danhsach>();
        mangds.add(new danhsach("Cách thay thế 8 câu nói tai hại bố mẹ thường nói với trẻ"));
        mangds.add(new danhsach("Những cách phạt con khéo léo giúp trẻ tiến bộ và thông minh"));
        mangds.add(new danhsach("Những kiểu dạy trẻ cần chấm dứt ngay kẻo hỏng con"));
        mangds.add(new danhsach("Bí quyết của mẹ khéo 'dụ' con biết làm việc nhà từ nhỏ"));
        mangds.add(new danhsach("5 hiệu ứng tâm lý nổi tiếng giúp bố mẹ dạy trẻ thông minh"));
        mangds.add(new danhsach("8 thói quen thời hiện đại của bố mẹ làm hỏng con"));
        mangds.add(new danhsach("Cách xử lí kịp thời khi thấy trẻ nói dối tránh làm hư con"));
        mangds.add(new danhsach("12 sai lầm dạy con kinh điển của cha mẹ làm hư con"));
        mangds.add(new danhsach("30 câu hỏi giúp mẹ biết con đi học đã xảy ra chuyện gì"));
        mangds.add(new danhsach("Cha mẹ nên dạy con biết trân trọng tiền mừng tuổi"));
        mangds.add(new danhsach("Thói quen sang năm mới bố mẹ cần học để dạy con ngoan hơn"));
        mangds.add(new danhsach("Những câu nói nhất định phải dạy con ngày Tết"));
        mangds.add(new danhsach("Những thói xấu của trẻ cần nắn ngay kẻo hỏng con"));
        mangds.add(new danhsach("Những mốc phát triển cần đạt được ở bé 3 tuổi"));
        mangds.add(new danhsach("7 câu cha mẹ hay nói tưởng tốt mà hóa hại cho con"));


        ListAdapter adapter=new ListAdapter(daycon.this, R.layout.activity_dong, mangds);
    }
}
