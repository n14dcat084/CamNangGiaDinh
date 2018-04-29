package btl.com.noitro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danh on 10/04/2018.
 */

public class listMonCanhAdapter extends ArrayAdapter<danhsach> {
    public listMonCanhAdapter(Context context, int resource, List<danhsach> items) {
        super(context, resource, items);
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

            ArrayList<Integer> mangHinh = new ArrayList<Integer>(49);

            mangHinh.add(0,new Integer(R.drawable.canhchuadualeo));
            mangHinh.add(1,new Integer(R.drawable.mongtoinaumuop));
            mangHinh.add(2,new Integer(R.drawable.docmungnaumoc));
            mangHinh.add(3,new Integer(R.drawable.canhbaunaungao));
            mangHinh.add(4,new Integer(R.drawable.thitbamnau));
            mangHinh.add(5,new Integer(R.drawable.canhchuacacom));
            mangHinh.add(6,new Integer(R.drawable.calocnaungot));
            mangHinh.add(7,new Integer(R.drawable.canhca));
            mangHinh.add(8,new Integer(R.drawable.canhtom));
            mangHinh.add(9,new Integer(R.drawable.bidaocuontomthit));
            mangHinh.add(10,new Integer(R.drawable.suoncuu));
            mangHinh.add(11,new Integer(R.drawable.canhtom));
            mangHinh.add(12,new Integer(R.drawable.canhcaibacccp));
            mangHinh.add(13,new Integer(R.drawable.canhchuacabop));
            mangHinh.add(14,new Integer(R.drawable.calocnauhoathiend));
            mangHinh.add(15,new Integer(R.drawable.rieucaloc));
            mangHinh.add(16,new Integer(R.drawable.camhrhuaj));
            mangHinh.add(17,new Integer(R.drawable.canhsuonheokhoquas));
            mangHinh.add(18,new Integer(R.drawable.suptomtiatoss));
            mangHinh.add(19,new Integer(R.drawable.tomchienduac));
            mangHinh.add(20,new Integer(R.drawable.ganausa));
            mangHinh.add(21,new Integer(R.drawable.canhcuaraunhut));
            mangHinh.add(22,new Integer(R.drawable.canhcuacuanaumang));
            mangHinh.add(23,new Integer(R.drawable.canhca));
            mangHinh.add(24,new Integer(R.drawable.canhtom));
            mangHinh.add(25,new Integer(R.drawable.canhtiomchuasodua));
            mangHinh.add(26,new Integer(R.drawable.canhdudusaiap));
            mangHinh.add(27,new Integer(R.drawable.canhgaadad));
            mangHinh.add(28,new Integer(R.drawable.canhmitnonnaulala));
            mangHinh.add(29,new Integer(R.drawable.canhbinaua));
            mangHinh.add(30,new Integer(R.drawable.cathunauduac));
            mangHinh.add(31,new Integer(R.drawable.canhbinaua));
            mangHinh.add(32,new Integer(R.drawable.camhbuntaudauhu));
            mangHinh.add(33,new Integer(R.drawable.canhcanahch));
            mangHinh.add(34,new Integer(R.drawable.canhcuaraunhut));
            mangHinh.add(35,new Integer(R.drawable.canhcuachacuag));
            mangHinh.add(36,new Integer(R.drawable.canhkhoquaca));
            mangHinh.add(37,new Integer(R.drawable.xanhcnahd));
            mangHinh.add(38,new Integer(R.drawable.canhmocnamhuong));
            mangHinh.add(39,new Integer(R.drawable.canhtauhuday));
            mangHinh.add(40,new Integer(R.drawable.canhrongbientauhu));
            mangHinh.add(41,new Integer(R.drawable.canhsuonshay));
            mangHinh.add(42,new Integer(R.drawable.camhsuonkhoaitay));
            mangHinh.add(43,new Integer(R.drawable.canhsytad));
            mangHinh.add(44,new Integer(R.drawable.canhchuaraumuongtom));
            mangHinh.add(45,new Integer(R.drawable.canhchuacabop));
            mangHinh.add(46,new Integer(R.drawable.bonghecuontom));
            mangHinh.add(47,new Integer(R.drawable.kimchambongbi));
            mangHinh.add(48,new Integer(R.drawable.canhcanahch));

            for(int i=0;i<=48;i++)
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
