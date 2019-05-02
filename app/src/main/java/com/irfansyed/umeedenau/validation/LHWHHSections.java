package com.irfansyed.umeedenau.validation;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.irfansyed.umeedenau.validation.databinding.LhwdashbordBinding;
import com.irfansyed.umeedenau.validation.databinding.LhwhhsectionBinding;


public  class LHWHHSections extends AppCompatActivity implements View.OnClickListener {


    //region Initialization
    LhwhhsectionBinding bin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bin= DataBindingUtil.setContentView(this, R.layout.lhwhhsection);



        bin.btnSectionC.setOnClickListener(this);
        bin.btnSectionD.setOnClickListener(this);
        bin.btnSectionE.setOnClickListener(this);
        bin.btnSectionF.setOnClickListener(this);
        bin.btnSectionG.setOnClickListener(this);
        bin.btnSectionH.setOnClickListener(this);


             }






    @Override
    public void onClick(View view)
    {
        show_alert(view);


    }

    private  void show_alert(final View click_view)
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogLayout = inflater.inflate(R.layout.form1sectionb, null);
        builder.setView(dialogLayout);
        builder.setCancelable(false);




        final TextView lhwf1b1,lhwf1b2,lhwf1b3;

        lhwf1b1= dialogLayout.findViewById(R.id.lhwf1b1);
        lhwf1b2= dialogLayout.findViewById(R.id.lhwf1b2);
        lhwf1b3= dialogLayout.findViewById(R.id.lhwf1b3);

        final  Button btn_cancel,btn_ok;
        btn_cancel=dialogLayout.findViewById(R.id.btn_cancel);
        btn_ok=dialogLayout.findViewById(R.id.btn_ok);
        final AlertDialog dialog = builder.create();


        dialog.show();
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intt;

                if(click_view.getId()==R.id.btnSectionC)
                {
                    intt=new Intent(getBaseContext(),Form1SectionC.class);
                }
                else if(click_view.getId()==R.id.btnSectionD)
                {
                    intt=new Intent(getBaseContext(),Form1SectionD.class);
                }
                else if(click_view.getId()==R.id.btnSectionE)
                {
                    intt=new Intent(getBaseContext(),Form1SectionE.class);
                }
                else if(click_view.getId()==R.id.btnSectionF)
                {
                    intt=new Intent(getBaseContext(),Form1SectionF.class);
                }
                else if(click_view.getId()==R.id.btnSectionG)
                {
                    intt=new Intent(getBaseContext(),Form1SectionG.class);
                }
                else
                {
                    intt=new Intent(getBaseContext(),Form1SectionH.class);
                }

                startActivity(intt);

            }
        });

    }



 

}
