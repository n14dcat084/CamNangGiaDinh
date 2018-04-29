package btl.com.noitro;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import btl.com.noitro.foderdaycon.daycon;
import btl.com.noitro.fodermeovatgiadinh.meovat;
import btl.com.noitro.fodermonandochai.monandochai;

import btl.com.noitro.adapter.*;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slidingmenu);
        //màn hình dọc
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
                Intent inten3=new Intent(MainActivity.this, monandochai.class);
                startActivity(inten3);
            }
        });
        //font chu
        Typeface font1 = Typeface.createFromAsset(getAssets(),"font/17-5560-VNI-Whimsy.ttf");
        Typeface font5 = Typeface.createFromAsset(getAssets(),"font/UVF Brankovic.ttf");
        final TextView txtmeovat=(TextView)findViewById(R.id.txtmeovat);
                txtmeovat.setTypeface(font5);
        TextView txtmonngon=(TextView)findViewById(R.id.txtnauan);
                 txtmonngon.setTypeface(font5);
        TextView txtdochai=(TextView)findViewById(R.id.txtdochai);
                 txtdochai.setTypeface(font5);
        TextView txtdodaycon=(TextView)findViewById(R.id.txtdaycon);
                txtdodaycon.setTypeface(font5);
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
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=btl.com.noitro");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
                    startActivity(sharingIntent);

                }
                catch (Exception c) {
                }
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

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
        Dialog settingsDialog = new Dialog(this);
        settingsDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        settingsDialog.setContentView(getLayoutInflater().inflate(R.layout.activity_thongtin
                , null));
        settingsDialog.show();
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_meovat) {
            Intent meovat=new Intent(MainActivity.this, btl.com.noitro.fodermeovatgiadinh.meovat.class);
            startActivity(meovat);
            // Handle the camera action
        } else if (id == R.id.nav_monan) {
            Intent monan=new Intent(MainActivity.this, btl.com.noitro.danhsachmon.class);
            startActivity(monan);

        } else if (id == R.id.nav_dochai) {
            Intent dochai=new Intent(MainActivity.this, monandochai.class);
            startActivity(dochai);

        } else if (id == R.id.nav_daycon) {
            Intent daycon=new Intent(MainActivity.this, daycon.class);
            startActivity(daycon);

        } else if (id == R.id.nav_share) {
            final ShareActionProvider myShareActionProvider = (ShareActionProvider) MenuItemCompat
                    .getActionProvider(item);
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    //menu share

                    try{

                        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=btl.com.noitro");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
                        startActivity(sharingIntent);

                    }
                    catch (Exception c) {
                    }
                    return false;
                }
            });

        } else if (id == R.id.nav_send) {
            Dialog settingsDialog = new Dialog(this);
            settingsDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            settingsDialog.setContentView(getLayoutInflater().inflate(R.layout.activity_thongtin
                    , null));
            settingsDialog.show();
        }
        else if (id == R.id.nav_star) {
            try {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=btl.com.noitro"));
                startActivity(myIntent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(this, "Lỗi trình duyệt không thể hiển thị",  Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
