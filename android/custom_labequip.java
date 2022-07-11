package com.example.digital_indenting;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class custom_labequip extends BaseAdapter {
    String [] eq_img, eq_code,eq_name,eq_type,fac_name;
    private Context context;


    public custom_labequip(Context appcontext, String[] eq_img, String[] eq_code, String[] eq_name, String[] eq_type, String[] fac_name){
        this.context=appcontext;
        this.eq_img=eq_img;
        this.eq_code=eq_code;
        this.eq_name=eq_name;
        this.eq_type=eq_type;
        this.fac_name=fac_name;
//        this.fac_pos=fac_pos;

    }

    @Override
    public int getCount() {
        return eq_code.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        if (view==null){
            gridView = new View(context);
            gridView = inflator.inflate(R.layout.custom_labequip, null);

        }
        else{
            gridView =(View) view;

        }
        ImageView eimg = (ImageView) gridView.findViewById(R.id.imageView);
        TextView code = (TextView) gridView.findViewById(R.id.textView30);

        TextView name = (TextView) gridView.findViewById(R.id.textView34);
        TextView type = (TextView) gridView.findViewById(R.id.textView35);
        TextView faculty = (TextView) gridView.findViewById(R.id.textView37);
//        TextView facpos = (TextView) gridView.findViewById(R.id.textView39);



        code.setTextColor(Color.BLACK);
        name.setTextColor(Color.BLACK);
        type.setTextColor(Color.BLACK);
        faculty.setTextColor(Color.BLACK);
//        facpos.setTextColor(Color.BLACK);

        code.setText(eq_code[i]);
        name.setText(eq_name[i]);
        type.setText(eq_type[i]);
        faculty.setText(fac_name[i]);
//        facpos.setText(fac_pos[i]);

        SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(context);
        String hu = sh.getString("ip", "");
//
//        String url = "http://" + ip + ":5000" + eq_img[i];

        String url = "http://" + hu + ":5000/" +eq_img[i];

//
//
        Picasso.with(context).load(url).into(eimg);


        return gridView;
    }
}
