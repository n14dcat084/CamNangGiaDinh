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

import DoiTuong.Food;
import DoiTuong.MonCanh;
import btl.com.noitro.R;

/**
 * Created by danh on 16/04/2018.
 */

public class MonAnAdapter extends ArrayAdapter<Food> {

    Context context;
    int resource;
    ArrayList<Food> objects;
    public MonAnAdapter(Context context, int resource, ArrayList<Food> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(this.resource, null);
        TextView tv = (TextView) view.findViewById(R.id.tv);
        ImageView ima = (ImageView) view.findViewById(R.id.imageDong);

        final Food food = this.objects.get(position);
        tv.setText(food.getTieude());
        Bitmap bm = BitmapFactory.decodeByteArray(food.getUrl(), 0, food.getUrl().length);
        ima.setImageBitmap(bm);
        return view;
    }
}

