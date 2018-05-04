package btl.com.noitro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import btl.com.noitro.Databases.LoveMeoVat;
import btl.com.noitro.fodermeovatgiadinh.*;

public class LoveActivity extends AppCompatActivity {

    ImageView mv, monan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);
        AnhXa();


    }
    public void AnhXa()
    {
        mv = (ImageView) findViewById(R.id.imLoveMeovat);
        monan  = (ImageView) findViewById( R.id.imLoveMonAn);
        mv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LoveActivity.this, LoveMeoVat.class);
                startActivity(in);
            }
        });
        monan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoveActivity.this, Activity_MeoVat.class));
            }
        });
    }

}
