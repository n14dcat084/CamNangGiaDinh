package btl.com.noitro;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import btl.com.noitro.R;
import btl.com.noitro.danhsach;

/**
 * Created by danh on 10/04/2018.
 */

public class listMonNuongAdapter extends ArrayAdapter<danhsach> {
    public listMonNuongAdapter(Context context, int resource, ArrayList<danhsach> objects) {
        super(context, resource, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.activity_dong, null);
        }
        danhsach p = getItem(position);
        if (p != null) {
            // Anh xa + Gan gia tri
            TextView txt = (TextView) view.findViewById(R.id.tv);
            txt.setText(p.tieude);
            TextView txt1=(TextView) view.findViewById(R.id.tv1);
            int c=position+1;
            //txt1.setText(""+c);
            txt1.setText("");

            //ImageView img = (ImageView) view.findViewById(R.id.imvicon);
            // if (position % 2 == 0) {
            //   img.setImageResource(R.drawable.monanngon);
            //} else img.setImageResource(R.drawable.iconmeovat);
            ImageView img = (ImageView) view.findViewById(R.id.imageDong);

            ArrayList<Integer> mangHinh = new ArrayList<Integer>(18);

            mangHinh.add(0,new Integer(R.drawable.suonxaxiu));
            mangHinh.add(1,new Integer(R.drawable.ganuonghungque));
            mangHinh.add(2,new Integer(R.drawable.ganuonghuongthao));
            mangHinh.add(3,new Integer(R.drawable.suoncuu));
            mangHinh.add(4,new Integer(R.drawable.philecanuongcien));
            mangHinh.add(5,new Integer(R.drawable.heonuongme));
            mangHinh.add(6,new Integer(R.drawable.ngheunuongmochai));
            mangHinh.add(7,new Integer(R.drawable.carinuong));
            mangHinh.add(8,new Integer(R.drawable.thanheonuongtrcanh));
            mangHinh.add(9,new Integer(R.drawable.botcuonlachemnuonmgg));
            mangHinh.add(10,new Integer(R.drawable.luonnuongladua));
            mangHinh.add(11,new Integer(R.drawable.namnuonggiaybac));
            mangHinh.add(12,new Integer(R.drawable.timbonuongcay));
            mangHinh.add(13,new Integer(R.drawable.trungdadieu));
            mangHinh.add(14,new Integer(R.drawable.catrungmuoiot));
            mangHinh.add(15,new Integer(R.drawable.ganuongnguvi));
            mangHinh.add(16,new Integer(R.drawable.nemnuongchuoihotngm));
            mangHinh.add(17,new Integer(R.drawable.vingamacamt));





            for(int i=0;i<=17;i++)
            {
                if(position==i)
                {
                    img.setImageResource(mangHinh.get(i));
                }
            }

        }
        return view;
    }
}
