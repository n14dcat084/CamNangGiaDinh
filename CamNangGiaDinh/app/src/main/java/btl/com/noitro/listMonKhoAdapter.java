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

public class listMonKhoAdapter extends ArrayAdapter<danhsach> {
    public listMonKhoAdapter(Context context, int resource, ArrayList<danhsach> objects) {
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

            ArrayList<Integer> mangHinh = new ArrayList<Integer>(35);

            mangHinh.add(0,new Integer(R.drawable.canuckhjo));
            mangHinh.add(1,new Integer(R.drawable.bachikhoxuhao));
            mangHinh.add(2,new Integer(R.drawable.cahukhorieng));
            mangHinh.add(3,new Integer(R.drawable.thitkhotieuxanh));
            mangHinh.add(4,new Integer(R.drawable.thitdongmua));
            mangHinh.add(5,new Integer(R.drawable.bapcoumxa));
            mangHinh.add(6,new Integer(R.drawable.nemthit));
            mangHinh.add(7,new Integer(R.drawable.baroikhonamdongco));
            mangHinh.add(8,new Integer(R.drawable.thitbaroikhoxxxx));
            mangHinh.add(9,new Integer(R.drawable.asfsdadfsf));
            mangHinh.add(10,new Integer(R.drawable.suonnonkhotraiduatuoi));
            mangHinh.add(11,new Integer(R.drawable.cusenkhotom));
            mangHinh.add(12,new Integer(R.drawable.cattramkhocai));
            mangHinh.add(13,new Integer(R.drawable.cacomkhotieu));
            mangHinh.add(14,new Integer(R.drawable.tomkhotrungcut));
            mangHinh.add(15,new Integer(R.drawable.bothung));
            mangHinh.add(16,new Integer(R.drawable.baroikhotieuu));
            mangHinh.add(17,new Integer(R.drawable.cakhokgosua));
            mangHinh.add(18,new Integer(R.drawable.cacomkgothit));
            mangHinh.add(19,new Integer(R.drawable.cakhorieng));
            mangHinh.add(20,new Integer(R.drawable.mucduaca));
            mangHinh.add(21,new Integer(R.drawable.muoisamamruoc));
            mangHinh.add(22,new Integer(R.drawable.thitbaroikgomm));
            mangHinh.add(23,new Integer(R.drawable.bokhotieui));
            mangHinh.add(24,new Integer(R.drawable.bonaunho));
            mangHinh.add(25,new Integer(R.drawable.cathusotttt));
            mangHinh.add(26,new Integer(R.drawable.thitheokhothom));
            mangHinh.add(27,new Integer(R.drawable.cahoikhoduacai));
            mangHinh.add(28,new Integer(R.drawable.cacomkgothit));
            mangHinh.add(29,new Integer(R.drawable.thitheokhothom));
            mangHinh.add(30,new Integer(R.drawable.vitkhotau));
            mangHinh.add(31,new Integer(R.drawable.gakgogung));
            mangHinh.add(32,new Integer(R.drawable.cangukgi));
            mangHinh.add(33,new Integer(R.drawable.mithitham));
            mangHinh.add(34,new Integer(R.drawable.bpsps));


            for(int i=0;i<=34;i++)
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
