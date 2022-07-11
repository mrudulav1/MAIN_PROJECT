package com.example.digital_indenting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class view_damagereport extends AppCompatActivity {
    ListView lv2;
    String [] facname,date,time,eq_name,eq_type,eq_code,damage,status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_damagereport);
        lv2 = (ListView) findViewById(R.id.lv3);

        Toast.makeText(this, "aaaaaa", Toast.LENGTH_SHORT).show();

        SharedPreferences sh= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String hu = sh.getString("ip", "");
        String url = "http://" + hu + ":5000/student_damageview";



        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //  Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();

                        // response
                        try {
                            JSONObject jsonObj = new JSONObject(response);
                            if (jsonObj.getString("status").equalsIgnoreCase("ok")) {
                                JSONArray js= jsonObj.getJSONArray("data");
                                facname=new String[js.length()];
                                date=new String[js.length()];
                                time=new String[js.length()];
                                eq_name=new String[js.length()];
                                eq_type=new String[js.length()];
                                eq_code=new String[js.length()];

                                damage=new String[js.length()];
                                status= new String[js.length()];



                                for(int i=0;i<js.length();i++)
                                {
                                    JSONObject u=js.getJSONObject(i);

                                    facname[i]=u.getString("staff_name");
                                    date[i]=u.getString("ddate");
//
                                    time[i]=u.getString("time");
                                    eq_name[i]=u.getString("eqp_name");
                                    eq_type[i]=u.getString("type");
                                    eq_code[i]=u.getString("eq_code");
                                    damage[i]=u.getString("damege");
                                    status[i]=u.getString("fstatus");


                                }

                                // ArrayAdapter<String> adpt=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,name);
                                lv2.setAdapter(new custom_damagereport(getApplicationContext(),facname,date,time,eq_name,eq_type,eq_code,damage,status));
                                // l1.setAdapter(new Custom(getApplicationContext(),gamecode,name,type,description,image,amount,status));
                            }
                            else if (jsonObj.getString("status").equalsIgnoreCase("None")) {
                                JSONArray js= jsonObj.getJSONArray("data");
                                facname=new String[js.length()];
                                date=new String[js.length()];
                                time=new String[js.length()];
                                eq_name=new String[js.length()];
                                eq_type=new String[js.length()];
                                eq_code=new String[js.length()];
                                damage=new String[js.length()];
                                status=new String[js.length()];

//                                damage[i]=u.getString("damege");
//                                status[i]=u.getString("fstatus");



                                for(int i=0;i<js.length();i++)
                                {
                                    JSONObject u=js.getJSONObject(i);

                                    facname[i]=u.getString("staff_name");
                                    date[i]=u.getString("ddate");
//
                                    time[i]=u.getString("time");
                                    eq_name[i]=u.getString("eqp_name");
                                    eq_type[i]=u.getString("type");
                                    eq_code[i]=u.getString("eq_code");
                                    damage[i]=u.getString("damege");
                                    status[i]=u.getString("fstatus");


                                }
                                // ArrayAdapter<String> adpt=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,name);
                                lv2.setAdapter(new custom_damagereport(getApplicationContext(),facname,date,time,eq_name,eq_type,eq_code,damage,status));
                                // l1.setAdapter(new Custom(getApplicationContext(),gamecode,name,type,description,image,amount,status));
                            }
                            // }
                            else {
                                Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
                            }

                        }    catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Error" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Toast.makeText(getApplicationContext(), "eeeee" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                Map<String, String> params = new HashMap<String, String>();

                String id=sh.getString("lid","");
                params.put("lid",id);
//                params.put("mac",maclis);

                return params;
            }
        };

        int MY_SOCKET_TIMEOUT_MS=100000;

        postRequest.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(postRequest);
    }
}