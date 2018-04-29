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

import DoiTuong.MeoVat;
import btl.com.noitro.R;


/**
 * Created by danh on 13/04/2018.
 */

public class MeoVatAdapter extends ArrayAdapter<MeoVat>{
    Context context;
    int resource;
    ArrayList<MeoVat> objects;
    public MeoVatAdapter(Context context, int resource, ArrayList<MeoVat> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public MeoVat getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getPosition(@Nullable MeoVat item) {
        return super.getPosition(item);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(this.resource, null);
        TextView tv = (TextView) row.findViewById(R.id.tv);
        ImageView image = (ImageView) row.findViewById(R.id.imageDong);
        final MeoVat mv = this.objects.get(position);
        tv.setText(mv.getTieude());
        Bitmap bm = BitmapFactory.decodeByteArray(mv.getUrlImage(), 0, mv.getUrlImage().length);
        image.setImageBitmap(bm);
        return row;
    }

}
