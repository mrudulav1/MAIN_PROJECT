package com.example.digital_indenting;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class custom_attendence extends BaseAdapter {
    String[] tdate,ttime,tstatus;
    private Context context;



    public custom_attendence(Context appcontext, String[] tdate,String[] ttime, String[] tstatus){
        this.context=appcontext;
        this.tdate=tdate;
        this.ttime=ttime;
        this.tstatus=tstatus;
    }


    @Override
    public int getCount() {
        return tdate.length;
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
        gridView = inflator.inflate(R.layout.custom_attendence, null);

    }
        else {
        gridView =(View) view;
    }

    TextView date = (TextView)gridView.findViewById(R.id.textView19);
    TextView time = (TextView)gridView.findViewById(R.id.textView21);
    TextView status = (TextView)gridView.findViewById(R.id.textView23);
//    TextView eqname = (TextView)gridView.findViewById(R.id.textView3);
//    TextView eqtyp = (TextView)gridView.findViewById(R.id.textView10);
//    TextView eqcode = (TextView)gridView.findViewById(R.id.textView12);
//    TextView eqdamage = (TextView)gridView.findViewById(R.id.textView14);

        date.setTextColor(Color.BLACK);
        time.setTextColor(Color.BLACK);
        status.setTextColor(Color.BLACK);
//        eqname.setTextColor(Color.BLACK);
//        eqtyp.setTextColor(Color.BLACK);
//        eqcode.setTextColor(Color.BLACK);
//        eqdamage.setTextColor(Color.BLACK);

        date.setText(tdate[i]);
        time.setText(ttime[i]);
        status.setText(tstatus[i]);
//        eqname.setText(eq_name[i]);
//        eqtyp.setText(eq_type[i]);
//        eqcode.setText(eq_code[i]);
//        eqdamage.setText(damage[i]);


        return gridView;
}
}
