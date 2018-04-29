package btl.com.noitro.moncanh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;

import btl.com.noitro.R;

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
        canh.getSettings().setBuiltInZoomControls(true);
        canh.getSettings().setSupportZoom(true);
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
