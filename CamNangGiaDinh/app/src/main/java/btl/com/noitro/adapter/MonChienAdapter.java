package btl.com.noitro.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import DoiTuong.MonChien;
import btl.com.noitro.R;

/**
 * Created by danh on 15/04/2018.
 */

public class MonChienAdapter extends ArrayAdapter<MonChien> {
    Context context;
    int resource;
    ArrayList<MonChien> objects;
    public MonChienAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MonChien> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(this.resource, null);
        TextView tv = (TextView) row.findViewById(R.id.tv);
        ImageView im = (ImageView) row.findViewById(R.id.imageDong);
        final MonChien mc = this.objects.get(position);
        tv.setText(mc.getTieude());
        Bitmap bm = BitmapFactory.decodeByteArray(mc.getUrl(), 0, mc.getUrl().length);
        im.setImageBitmap(bm);
        return row;
    }
}
