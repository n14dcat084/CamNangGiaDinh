package btl.com.noitro;

import android.annotation.SuppressLint;
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

public class listMonChienAdapter extends ArrayAdapter<danhsach> {
    public listMonChienAdapter(Context context, int resource, ArrayList<danhsach> objects) {
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

            ArrayList<Integer> mangHinh = new ArrayList<Integer>(30);

            mangHinh.add(0,new Integer(R.drawable.tomchienduac));
            mangHinh.add(1,new Integer(R.drawable.thitlonchienn));
            mangHinh.add(2,new Integer(R.drawable.catimkep));
            mangHinh.add(3,new Integer(R.drawable.banhchung));
            mangHinh.add(4,new Integer(R.drawable.thitga));
            mangHinh.add(5,new Integer(R.drawable.com));
            mangHinh.add(6,new Integer(R.drawable.banhdaychienxusit));
            mangHinh.add(7,new Integer(R.drawable.sodiepchienxu));
            mangHinh.add(8,new Integer(R.drawable.chachiahalung));
            mangHinh.add(9,new Integer(R.drawable.trungchienxuxu));
            mangHinh.add(10,new Integer(R.drawable.ganheonguvihuong));
            mangHinh.add(11,new Integer(R.drawable.banhcrepesotcam));
            mangHinh.add(12,new Integer(R.drawable.trungchientommuc));
            mangHinh.add(13,new Integer(R.drawable.cutchienxaot));
            mangHinh.add(14,new Integer(R.drawable.gioluathitheoxi));
            mangHinh.add(15,new Integer(R.drawable.vitgiangmuoi));
            mangHinh.add(16,new Integer(R.drawable.ucgaphomai));
            mangHinh.add(17,new Integer(R.drawable.comchienhoathienly));
            mangHinh.add(18,new Integer(R.drawable.canhgajava));
            mangHinh.add(19,new Integer(R.drawable.chagionghei));
            mangHinh.add(20,new Integer(R.drawable.chamucthila));
            mangHinh.add(21,new Integer(R.drawable.cuuvietnamnuong));
            mangHinh.add(22,new Integer(R.drawable.vukhucreung));
            mangHinh.add(23,new Integer(R.drawable.sanwichkeprong));
            mangHinh.add(24,new Integer(R.drawable.baroirutsuon));
            mangHinh.add(25,new Integer(R.drawable.mucchiensuvoisit));
            mangHinh.add(26,new Integer(R.drawable.cathaclacchien));
            mangHinh.add(27,new Integer(R.drawable.gachiena));
            mangHinh.add(28,new Integer(R.drawable.gachienccc));
            mangHinh.add(29,new Integer(R.drawable.suonchienxaot));


            for(int i=0;i<=29;i++)
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
