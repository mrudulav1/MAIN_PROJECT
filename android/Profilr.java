package com.example.digital_indenting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Profilr extends AppCompatActivity {
    TextView tvname,tv_reg,tv_class,tvplace,tvpin,tvdistrict,tvcontact,tvemail,tv_caution;
    ImageView iv1;

    String lid;

    SharedPreferences sh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilr);


        tvname=(TextView) findViewById(R.id.name);
        tv_reg = (TextView) findViewById(R.id.name2);
        tv_class = (TextView) findViewById(R.id.name3);
        tvplace=(TextView) findViewById(R.id.place1);
        tvpin=(TextView) findViewById(R.id.pin);
        tvcontact=(TextView) findViewById(R.id.phone1);
        tvemail=(TextView) findViewById(R.id.email1);
        tvdistrict=(TextView) findViewById(R.id.district1);
        tv_caution=(TextView) findViewById(R.id.textView45);
        iv1=(ImageView) findViewById(R.id.userphoto2);

        SharedPreferences sh= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String hu = sh.getString("ip", "");
        String url = "http://" + hu + ":5000/and_profile";




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
                                tvname.setText(jsonObj.getString("name"));
                                tv_reg.setText(jsonObj.getString("reg_no"));
                                tv_class.setText(jsonObj.getString("sclass"));
                                tvplace.setText(jsonObj.getString("place"));
                                tvpin.setText(jsonObj.getString("pin"));
                                tvdistrict.setText(jsonObj.getString("city"));
                                 tvemail.setText(jsonObj.getString("email"));
                                tvcontact.setText(jsonObj.getString("phone"));
                                tv_caution.setText(jsonObj.getString("amount"));

                                SharedPreferences sh= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                String ip=sh.getString("ip","");

                                String url="http://" + ip + ":5000"+jsonObj.getString("photo");


                                Picasso.with(getApplicationContext()).load(url).transform(new CircleTransform()). into(iv1);


                            }
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

                String id=sh.getString("uid","");
                params.put("lid",sh.getString("lid",""));


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
