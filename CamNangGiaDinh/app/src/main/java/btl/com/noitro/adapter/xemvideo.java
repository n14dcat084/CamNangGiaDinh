package btl.com.noitro.adapter;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import btl.com.noitro.R;

public class xemvideo extends AppCompatActivity {

    TextView txt;
    VideoView vd;
    private int position;
    private MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xemvideo);
        txt = (TextView) findViewById(R.id.tvMonChien);
        vd = (VideoView) findViewById(R.id.videoMonChien);

        if (mediaController == null) {
            mediaController = new MediaController(xemvideo.this);

            // Neo vị trí của MediaController với VideoView.
            mediaController.setAnchorView(vd);


            // Sét đặt bộ điều khiển cho VideoView.
            vd.setMediaController(mediaController);
        }
        try {
            // ID của file video.
            int id = this.getRawResIdByName("comchien");
            vd.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
    }

    private int getRawResIdByName(String resName) {
        String pkgName = this.getPackageName();

        // Trả về 0 nếu không tìm thấy.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        // Lưu lại vị trí file video đang chơi.
        savedInstanceState.putInt("CurrentPosition", vd.getCurrentPosition());
        vd.pause();
    }


    // Sau khi điện thoại xoay chiều xong. Phương thức này được gọi,
    //  cần tái tạo lại ví trí file nhạc đang chơi.
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Lấy lại ví trí video đã chơi.
        position = savedInstanceState.getInt("CurrentPosition");
        vd.seekTo(position);
    }
}
