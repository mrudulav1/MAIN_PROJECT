package com.example.digital_indenting;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class custom_damagereport extends BaseAdapter {
    String [] facname,date,time,eq_name,eq_type,eq_code,damage,status;
    private Context context;


    public custom_damagereport(Context appcontext, String []facname, String []date, String []time, String [] eq_name, String[] eq_type,String[] eq_code, String[] damage,String[] status){
        this.context = appcontext;
        this.facname = facname;
        this.date = date;
        this.time = time;
        this.eq_name = eq_name;
        this.eq_type = eq_type;
        this.eq_code = eq_code;
        this.damage = damage;
        this.status=status;

    }

    @Override
    public int getCount() {
        return facname.length;
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
            gridView = inflator.inflate(R.layout.custom_damagereport, null);

        }
        else {
                gridView =(View) view;
        }

        TextView facl = (TextView)gridView.findViewById(R.id.textView26);
        TextView ddate = (TextView)gridView.findViewById(R.id.textView16);
        TextView dtime = (TextView)gridView.findViewById(R.id.textView18);
        TextView eqname = (TextView)gridView.findViewById(R.id.textView3);
        TextView eqtyp = (TextView)gridView.findViewById(R.id.textView10);
        TextView eqcode = (TextView)gridView.findViewById(R.id.textView12);
        TextView eqdamage = (TextView)gridView.findViewById(R.id.textView14);
        TextView fstatus = (TextView) gridView.findViewById(R.id.textView74);


        facl.setTextColor(Color.BLACK);
        ddate.setTextColor(Color.BLACK);
        dtime.setTextColor(Color.BLACK);
        eqname.setTextColor(Color.BLACK);
        eqtyp.setTextColor(Color.BLACK);
        eqcode.setTextColor(Color.BLACK);
        eqdamage.setTextColor(Color.BLACK);
        fstatus.setTextColor(Color.BLACK);

        facl.setText(facname[i]);
        ddate.setText(date[i]);
        dtime.setText(time[i]);
        eqname.setText(eq_name[i]);
        eqtyp.setText(eq_type[i]);
        eqcode.setText(eq_code[i]);
        eqdamage.setText(damage[i]);
        fstatus.setText(status[i]);


        return gridView;
    }
}
