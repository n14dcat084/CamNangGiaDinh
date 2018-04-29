package btl.com.noitro.monchien;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;

import btl.com.noitro.R;

public class webviewmonchien extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webviewmonchien);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        WebView chien = (WebView) findViewById(R.id.webviewmonchien);
        String vt = getIntent().getStringExtra("value");
        int vtt = Integer.parseInt(vt);
        chien.loadUrl("file:///android_asset/nauan/chien/"+vt+".html");
        chien.getSettings().setBuiltInZoomControls(true);
        chien.getSettings().setSupportZoom(true);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, lvmonchien.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
