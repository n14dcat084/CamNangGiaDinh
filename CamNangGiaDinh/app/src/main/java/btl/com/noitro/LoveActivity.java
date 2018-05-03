package btl.com.noitro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class LoveActivity extends AppCompatActivity {

    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);
        l = (ListView) findViewById(R.id.lvLove);
    }
}
