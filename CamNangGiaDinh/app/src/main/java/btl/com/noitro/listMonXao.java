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

public class listMonXao extends ArrayAdapter<danhsach> {
    public listMonXao(Context context, int resource, ArrayList<danhsach> objects) {
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

            ArrayList<Integer> mangHinh = new ArrayList<Integer>(37);

            mangHinh.add(0,new Integer(R.drawable.namxaoot));
            mangHinh.add(1,new Integer(R.drawable.catheochua));
            mangHinh.add(2,new Integer(R.drawable.bunboxao1));
            mangHinh.add(3,new Integer(R.drawable.ganbo1));
            mangHinh.add(4,new Integer(R.drawable.raubachtuoc1));
            mangHinh.add(5,new Integer(R.drawable.ocbien1));
            mangHinh.add(6,new Integer(R.drawable.ocxaoxaot1));
            mangHinh.add(7,new Integer(R.drawable.mixaogion1));
            mangHinh.add(8,new Integer(R.drawable.bapxaptep1));
            mangHinh.add(9,new Integer(R.drawable.ocxaomangchua1));
            mangHinh.add(10,new Integer(R.drawable.muopxaonam));
            mangHinh.add(11,new Integer(R.drawable.dfvdvsv));
            mangHinh.add(12,new Integer(R.drawable.duachuaxaongheu));
            mangHinh.add(13,new Integer(R.drawable.ocmoxaosate));
            mangHinh.add(14,new Integer(R.drawable.mienxaomang));
            mangHinh.add(15,new Integer(R.drawable.hinh1));
            mangHinh.add(16,new Integer(R.drawable.hinh2));
            mangHinh.add(17,new Integer(R.drawable.hinh3));
            mangHinh.add(18,new Integer(R.drawable.hinh4));
            mangHinh.add(19,new Integer(R.drawable.hinh5));
            mangHinh.add(20,new Integer(R.drawable.hinh6));
            mangHinh.add(21,new Integer(R.drawable.hinh7));
            mangHinh.add(22,new Integer(R.drawable.hinh8));
            mangHinh.add(23,new Integer(R.drawable.hinh9));
            mangHinh.add(24,new Integer(R.drawable.hinh10));
            mangHinh.add(25,new Integer(R.drawable.hinh11));
            mangHinh.add(26,new Integer(R.drawable.hinh12));
            mangHinh.add(27,new Integer(R.drawable.hinh13));
            mangHinh.add(28,new Integer(R.drawable.hinh14));
            mangHinh.add(29,new Integer(R.drawable.hinh15));
            mangHinh.add(30,new Integer(R.drawable.hinh16));
            mangHinh.add(31,new Integer(R.drawable.hinh17));
            mangHinh.add(32,new Integer(R.drawable.hinh18));
            mangHinh.add(33,new Integer(R.drawable.hinh19));
            mangHinh.add(34,new Integer(R.drawable.hinh20));
            mangHinh.add(35,new Integer(R.drawable.hinh21));
            mangHinh.add(36,new Integer(R.drawable.hinh22));


            for(int i=0;i<=36;i++)
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
