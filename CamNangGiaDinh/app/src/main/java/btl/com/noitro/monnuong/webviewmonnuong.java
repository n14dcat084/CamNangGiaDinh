package btl.com.noitro.monnuong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;

import btl.com.noitro.R;

public class webviewmonnuong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webviewmonnuong);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        WebView nuong = (WebView) findViewById(R.id.webviewmonnuong);
        String vt = getIntent().getStringExtra("value");
        int vtt = Integer.parseInt(vt);
        nuong.loadUrl("file:///android_asset/nauan/nuong/"+vt+".html");
        nuong.getSettings().setBuiltInZoomControls(true);
        nuong.getSettings().setSupportZoom(true);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, lvmonnuong.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
