package com.example.quanghai.noitro.monnom;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

import com.example.quanghai.noitro.R;
import com.example.quanghai.noitro.monchien.lvmonchien;

public class webviewmonnom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webviewmonnom);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        WebView nom = (WebView) findViewById(R.id.webviewmonnom);
        String vt = getIntent().getStringExtra("value");
        int vtt = Integer.parseInt(vt);
        nom.loadUrl("file:///android_asset/nauan/nom/"+vt+".html");
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, lvmonnom.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
