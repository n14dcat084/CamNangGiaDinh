package com.example.quanghai.noitro.monkho;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

import com.example.quanghai.noitro.R;
import com.example.quanghai.noitro.monxao.lvmonxao;

public class webviewmonkho extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webviewmonkho);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        WebView xao = (WebView) findViewById(R.id.webviewmonkho);
        String vt = getIntent().getStringExtra("value");
        int vtt = Integer.parseInt(vt);
        xao.loadUrl("file:///android_asset/nauan/kho/"+vt+".html");
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, lvmonkho.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
