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

public class view_labequipments extends AppCompatActivity {
    ListView lv;
    String [] eq_img, eq_code,eq_name,eq_type,fac_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_labequipments);
        lv = (ListView) findViewById(R.id.lv3);
        Toast.makeText(this, "aaaaaa", Toast.LENGTH_SHORT).show();

        SharedPreferences sh= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String hu = sh.getString("ip", "");
        String url = "http://" + hu + ":5000/and_view_lab";


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

                                eq_img=new String[js.length()];
                                eq_code=new String[js.length()];
                                eq_name=new String[js.length()];
                                eq_type=new String[js.length()];
                                fac_name=new String[js.length()];
//                                fac_pos=new String[js.length()];

//                                damage=new String[js.length()];



                                for(int i=0;i<js.length();i++)
                                {
                                    JSONObject u=js.getJSONObject(i);

//

                                    eq_img[i]=u.getString("photo");
                                    eq_code[i]=u.getString("eqip_nid");
//
                                    eq_name[i]=u.getString("eqp_name");
//                                    eq_name[i]=u.getString("eqp_name");
                                    eq_type[i]=u.getString("type");
                                    fac_name[i]=u.getString("staff_name");
//                                    fac_pos[i]=u.getString("position");


                                }

                                // ArrayAdapter<String> adpt=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,name);
//
                                lv.setAdapter(new custom_labequip(getApplicationContext(),eq_img,eq_code,eq_name,eq_type,fac_name));
//                                lv.setAdapter(new custom_labequip(getApplicationContext(),eq_img,eq_code,eq_name,eq_name,eq_type,fac_name,fac_pos));
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