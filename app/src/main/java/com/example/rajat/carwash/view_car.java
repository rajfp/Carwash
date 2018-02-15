package com.example.rajat.carwash;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class view_car extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
Spinner spinner;
    ToggleButton toggleButton;
    TableLayout tableLayout;
    Toolbar toolbar;
    Button back;
    Dialog dialog;
    TextView t1,t2,t3,t4,t5,t6,t7,t8;
    private static final String TAG=MainActivity.class.getSimpleName();
    public static final String SITE_KEY="6LdUpUAUAAAAAD5Ynoa_EX3ta5lAkekt67PyLtJ0";
    public static final String SITE_SECRET_KEY="6LdUpUAUAAAAAB_Gb7rWTOqNX3I2hSJj68AKervQ";
    String userResponseToken;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_car);
        spinner= (Spinner) findViewById(R.id.spinn);
        toolbar= (Toolbar) findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        t1= (TextView) findViewById(R.id.tv);
        t2= (TextView) findViewById(R.id.note);
        t3= (TextView) findViewById(R.id.tt);
        t4= (TextView) findViewById(R.id.must);
        t1.setVisibility(View.INVISIBLE);
        back= (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(view_car.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
        t2.setVisibility(View.INVISIBLE);
        t3.setVisibility(View.INVISIBLE);
        t4.setVisibility(View.INVISIBLE);
        tableLayout= (TableLayout) findViewById(R.id.tl);
        tableLayout.setVisibility(View.INVISIBLE);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view_car.this,R.array.bg,R.layout.support_simple_spinner_dropdown_item);
        ;
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        toggleButton= (ToggleButton) findViewById(R.id.tb);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()) {
                    dialog = new Dialog(view_car.this, R.style.cust_dialog);
                    dialog.setContentView(R.layout.dialogb);
                    dialog.setTitle("Digital Signature");
                    dialog.getWindow().setTitleColor(Color.parseColor("#ffffff"));

                    Button db2 = (Button) dialog.findViewById(R.id.db2);
                    db2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
            }
        });


    }
    public void recaptcha(View v) {



            SafetyNet.getClient(this).verifyWithRecaptcha(SITE_KEY)
                    .addOnSuccessListener(this, new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
                        @Override
                        public void onSuccess(SafetyNetApi.RecaptchaTokenResponse response) {
                            userResponseToken = response.getTokenResult();
                            if (!userResponseToken.isEmpty()) {
                                sendRequest();
                            }
                        }
                    })
                    .addOnFailureListener(this, new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            if (e instanceof ApiException) {
                                ApiException apiException = (ApiException) e;
                                Log.d(TAG, "Error message: " +
                                        CommonStatusCodes.getStatusCodeString(apiException.getStatusCode()));

                            } else {
                                Log.d(TAG, "Unknown type of error: " + e.getMessage());
                            }
                        }
                    });

            dialog.dismiss();


    }
    public void sendRequest()  {

        String url = "https://www.google.com/recaptcha/api/siteverify";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);

                            if (obj.getString("success").equals("true")){
                                Toast.makeText(view_car.this,"Submitted Successfully",Toast.LENGTH_LONG).show();
                                t5= (TextView) findViewById(R.id.ab);
                                t6= (TextView) findViewById(R.id.hyu);
                                t7= (TextView) findViewById(R.id.i20);
                                t8= (TextView) findViewById(R.id.ss);
                                t5.setTextColor(Color.parseColor("#228B22"));
                                t6.setTextColor(Color.parseColor("#228B22"));
                                t7.setTextColor(Color.parseColor("#228B22"));
                                t8.setText("Yes");
                                t8.setTextColor(Color.parseColor("#228B22"));
                                toggleButton.setEnabled(false);
                            }

                        }

                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(view_car.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("secret", SITE_SECRET_KEY);
                params.put("response", userResponseToken);
                return params;
            }
        };
        AppController.getInstance(this).addToRequestQueue(stringRequest);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        if(item.equals("cs")) {
            tableLayout.setVisibility(View.VISIBLE);
            t1.setVisibility(View.VISIBLE);
            t2.setVisibility(View.VISIBLE);
            t3.setVisibility(View.VISIBLE);
            t4.setVisibility(View.VISIBLE);
        }
        else {
            tableLayout.setVisibility(View.INVISIBLE);
            t1.setVisibility(View.INVISIBLE);
            t2.setVisibility(View.INVISIBLE);
            t3.setVisibility(View.INVISIBLE);
            t4.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
