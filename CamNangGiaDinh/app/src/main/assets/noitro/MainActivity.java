package com.example.quanghai.noitro;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.quanghai.noitro.foderdaycon.daycon;
import com.example.quanghai.noitro.fodermeovatgiadinh.meovat;
import com.example.quanghai.noitro.fodermonandochai.monandochai;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//màn hình dọc
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ImageView Imgmeovat=(ImageView) findViewById(R.id.imgmeovat);
        Imgmeovat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten=new Intent(MainActivity.this,meovat.class);
                startActivity(inten);
            }
        });
        ImageView Imgdaycon=(ImageView)findViewById(R.id.imgdaycon);
        Imgdaycon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten1=new Intent(MainActivity.this,daycon.class);
                startActivity(inten1);
            }
        });
        final ImageView Imgnauan=(ImageView)findViewById(R.id.imgnauan);
        Imgnauan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten2=new Intent(MainActivity.this,danhsachmon.class);
                startActivity(inten2);
            }
        });
        final ImageView Imgmonandochai=(ImageView)findViewById(R.id.imgmondochai);
        Imgmonandochai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten3=new Intent(MainActivity.this,monandochai.class);
                startActivity(inten3);
            }
        });
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // if ((keyCode == KeyEvent.KEYCODE_BACK))
        keyCode=KeyEvent.KEYCODE_BACK;
        AlertDialog myAlertDialog = Dialog();
        myAlertDialog.show();
        return false;
        // return super.onKeyDown(keyCode, event);
    }

    private AlertDialog Dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông Báo");
        builder.setMessage("Bạn có muốn thoát! ");
        builder.setCancelable(false);
        builder.setNeutralButton("Hủy", null);
        builder.setNegativeButton("Thoát",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog dialog = builder.create();
        return dialog;

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
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

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
    if(id==R.id.action_thoat){
        alertDialogThoat();
        return true;
    }
    if(id==R.id.action_thongtin){
        alertDialogThongtin();

    }

    return super.onOptionsItemSelected(item);
}

    public void alertDialogThoat() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông Báo");
        builder.setMessage("Bạn có muốn thoát! ");
        builder.setIcon(R.drawable.exit);
        builder.setPositiveButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    public void alertDialogThongtin() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle("c");
        builder1.setIcon(R.drawable.nhom1);

        builder1.show();
    }
}
