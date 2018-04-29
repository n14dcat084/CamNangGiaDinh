package btl.com.noitro.fodermonandochai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;

import btl.com.noitro.R;


public class webviewmonandochai extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webviewmonandochai);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        WebView wvmonandochai = (WebView) findViewById(R.id.webViewmonandochai);
        String vt = getIntent().getStringExtra("value");
        int vtt = Integer.parseInt(vt);
        wvmonandochai.loadUrl("file:///android_asset/monandochai/"+vt+".html");
        wvmonandochai.getSettings().setBuiltInZoomControls(true);
        wvmonandochai.getSettings().setSupportZoom(true);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, monandochai.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
