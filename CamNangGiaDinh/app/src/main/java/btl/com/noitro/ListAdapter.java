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
 * Created by Quang Hai on 6/9/2016.
 */
public class ListAdapter extends ArrayAdapter<danhsach> {


    public ListAdapter(Context context, int resource, List<danhsach> items) {
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

            ArrayList<Integer> mangHinh = new ArrayList<Integer>(40);

                mangHinh.add(0,new Integer(R.drawable.com));
                mangHinh.add(1,new Integer(R.drawable.cua));
                mangHinh.add(2,new Integer(R.drawable.bep1));
                mangHinh.add(3,new Integer(R.drawable.rau));
                mangHinh.add(4,new Integer(R.drawable.thuocsau));
                mangHinh.add(5,new Integer(R.drawable.mangcut));
                mangHinh.add(6,new Integer(R.drawable.cua1));
                mangHinh.add(7,new Integer(R.drawable.luon));
                mangHinh.add(8,new Integer(R.drawable.xoong));
                mangHinh.add(9,new Integer(R.drawable.muoi));
                mangHinh.add(10,new Integer(R.drawable.thitbo));
                mangHinh.add(11,new Integer(R.drawable.tu1));
                mangHinh.add(12,new Integer(R.drawable.oc));
                mangHinh.add(13,new Integer(R.drawable.tom));
                mangHinh.add(14,new Integer(R.drawable.ruoi));
                mangHinh.add(15,new Integer(R.drawable.chao));
                mangHinh.add(16,new Integer(R.drawable.traidau));
                mangHinh.add(17,new Integer(R.drawable.rau1));
                mangHinh.add(18,new Integer(R.drawable.thitheo));
                mangHinh.add(19,new Integer(R.drawable.thitga));
                mangHinh.add(20,new Integer(R.drawable.thomnhavesinh));
                mangHinh.add(21,new Integer(R.drawable.trangda));
                mangHinh.add(22,new Integer(R.drawable.fillet));
                mangHinh.add(23,new Integer(R.drawable.kdtet));
                mangHinh.add(24,new Integer(R.drawable.kdtet));
                mangHinh.add(25,new Integer(R.drawable.cathit));
                mangHinh.add(26,new Integer(R.drawable.acb));
                mangHinh.add(27,new Integer(R.drawable.raumuong));
                mangHinh.add(28,new Integer(R.drawable.traidau));
                mangHinh.add(29,new Integer(R.drawable.ruangao));
                mangHinh.add(30,new Integer(R.drawable.traidau));
                mangHinh.add(31,new Integer(R.drawable.khoca));
                mangHinh.add(32,new Integer(R.drawable.luocga2));
                mangHinh.add(33,new Integer(R.drawable.comraumuong));
                mangHinh.add(34,new Integer(R.drawable.trungchien));
                mangHinh.add(35,new Integer(R.drawable.sinhto));
                mangHinh.add(36,new Integer(R.drawable.comnhao));
                mangHinh.add(37,new Integer(R.drawable.canhca));
                mangHinh.add(38,new Integer(R.drawable.vesinhbepgas));
                mangHinh.add(39,new Integer(R.drawable.luocthit));

                for(int i=0;i<=39;i++)
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
