package com.example.rajat.carwash;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class Work_locations extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    ImageView iv1;
    TextView t1, t2;
    Button bac;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_locations);
        spinner = (Spinner) findViewById(R.id.spin);
        toolbar = (Toolbar) findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        t1 = (TextView) findViewById(R.id.textv);
        t2 = (TextView) findViewById(R.id.textv2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Work_locations.this,R.array.bg,R.layout.support_simple_spinner_dropdown_item);
        t1.setVisibility(View.INVISIBLE);
        t2.setVisibility(View.INVISIBLE);
        iv1 = (ImageView) findViewById(R.id.img1);
        bac= (Button) findViewById(R.id.bac);
        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Work_locations.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
        iv1.setVisibility(View.INVISIBLE);
        ImageView iv1 = (ImageView) findViewById(R.id.img1);
        iv1.setVisibility(View.INVISIBLE);
        ImageView iv2 = (ImageView) findViewById(R.id.img2);
        iv2.setVisibility(View.INVISIBLE);
        ImageView iv3 = (ImageView) findViewById(R.id.img3);
        iv3.setVisibility(View.INVISIBLE);
        ImageView iv4 = (ImageView) findViewById(R.id.img4);
        iv4.setVisibility(View.INVISIBLE);
        ImageView iv5 = (ImageView) findViewById(R.id.img5);
        iv5.setVisibility(View.INVISIBLE);
        ImageView iv6 = (ImageView) findViewById(R.id.img6);
        iv6.setVisibility(View.INVISIBLE);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        final ImageView iv1 = (ImageView) findViewById(R.id.img1);
        final ImageView iv2 = (ImageView) findViewById(R.id.img2);
        ImageView iv3 = (ImageView) findViewById(R.id.img3);
        ImageView iv4 = (ImageView) findViewById(R.id.img4);
        ImageView iv5 = (ImageView) findViewById(R.id.img5);
        ImageView iv6 = (ImageView) findViewById(R.id.img6);

        if (item.equals("cs")) {

            iv1.setVisibility(View.VISIBLE);
            iv1.setImageResource(R.mipmap.ic_launcher);
            iv2.setVisibility(View.VISIBLE);

            iv3.setVisibility(View.VISIBLE);

            iv4.setVisibility(View.VISIBLE);

            iv5.setVisibility(View.VISIBLE);

            iv6.setVisibility(View.VISIBLE);

            t1.setVisibility(View.VISIBLE);
            t2.setVisibility(View.VISIBLE);
            iv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.onclick));
                    v.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            final Dialog dialog = new Dialog(Work_locations.this, R.style.question_dialog_title);
                            dialog.setContentView(R.layout.dialog);
                            Button cancel = (Button) dialog.findViewById(R.id.can);
                            Button submit = (Button) dialog.findViewById(R.id.sub);

                            submit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    RadioGroup radioGroup = (RadioGroup)dialog.findViewById(R.id.rg);
                                    int selectedId = radioGroup.getCheckedRadioButtonId();
                                    RadioButton rbutton= (RadioButton)dialog.findViewById(selectedId);
                                    if (radioGroup.getCheckedRadioButtonId() == -1)
                                    {
                                        dialog.dismiss();
                                    }

                                    else if(rbutton.getText().equals("Cleaned"))
                                    {
                                        iv1.setOnClickListener(null);
                                        Toast.makeText(Work_locations.this,"Submission Successful",Toast.LENGTH_LONG).show();
                                        dialog.dismiss();
                                    }

                                    else
                                    {
                                        dialog.dismiss();
                                    }


                                }
                            });
                            cancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                            dialog.show();


                        }
                    }, 500);


                }
            });

            iv2.setImageResource(R.mipmap.a);
            iv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.onclick));
                    v.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            final Dialog dialog = new Dialog(Work_locations.this, R.style.question_dialog_title);
                            dialog.setContentView(R.layout.dialog);
                            Button cancel = (Button) dialog.findViewById(R.id.can);
                            Button submit = (Button) dialog.findViewById(R.id.sub);

                            submit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    RadioGroup radioGroup = (RadioGroup)dialog.findViewById(R.id.rg);
                                    int selectedId = radioGroup.getCheckedRadioButtonId();
                                    RadioButton rbutton= (RadioButton)dialog.findViewById(selectedId);
                                    if (radioGroup.getCheckedRadioButtonId() == -1)
                                    {
                                        dialog.dismiss();
                                    }
                                   else if(rbutton.getText().equals("Cleaned"))
                                    {
                                        iv2.setOnClickListener(null);
                                        Toast.makeText(Work_locations.this,"Submission Successful",Toast.LENGTH_LONG).show();
                                        dialog.dismiss();

                                    }
                                    else
                                        dialog.dismiss();

                                }
                            });
                            cancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                            dialog.show();


                        }
                    }, 500);


                }
            });
            iv3.setImageResource(R.mipmap.ca);
            iv4.setImageResource(R.mipmap.ca);
            iv5.setImageResource(R.mipmap.a);
            iv6.setImageResource(R.mipmap.ic_launcher);

        } else {
            iv1.setVisibility(View.INVISIBLE);
            iv1.setVisibility(View.INVISIBLE);
            iv2.setVisibility(View.INVISIBLE);
            iv3.setVisibility(View.INVISIBLE);
            iv4.setVisibility(View.INVISIBLE);
            iv5.setVisibility(View.INVISIBLE);
            iv6.setVisibility(View.INVISIBLE);
            t1.setVisibility(View.INVISIBLE);
            t2.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
