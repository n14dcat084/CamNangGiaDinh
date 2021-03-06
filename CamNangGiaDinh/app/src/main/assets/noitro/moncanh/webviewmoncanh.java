package com.example.quanghai.noitro.moncanh;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

import com.example.quanghai.noitro.R;
import com.example.quanghai.noitro.danhsachmon;
import com.example.quanghai.noitro.foderdaycon.daycon;

public class webviewmoncanh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webviewmoncanh);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        WebView canh = (WebView) findViewById(R.id.webviewmoncanh);
        String vt = getIntent().getStringExtra("value");
        int vtt = Integer.parseInt(vt);
        canh.loadUrl("file:///android_asset/nauan/canh/"+vt+".html");
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, lvmoncanh.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
