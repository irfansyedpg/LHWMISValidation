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
import android.widget.RatingBar;

import com.irfansyed.umeedenau.validation.databinding.LhwdashbordBinding;

import utils.MyPreferences;


public  class LHWDashbord extends AppCompatActivity implements View.OnClickListener {


    //region Initialization
    LhwdashbordBinding bin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bin= DataBindingUtil.setContentView(this, R.layout.lhwdashbord);



        bin.btnCommunity.setOnClickListener(this);
        bin.btnSourceRegister.setOnClickListener(this);


    }






    @Override
    public void onClick(View view)
    {
        boolean boolSourceRegister=false;

        if(view.getId()==R.id.btnSourceRegister)
        {
            boolSourceRegister=true;
        }

        showLhwSelection(boolSourceRegister);
    }



    // Alert lhw selection

    void showLhwSelection(final boolean boolSourceRegister)
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        builder.setTitle("LHW Selection");
        final View dialogLayout = inflater.inflate(R.layout.lhwselection, null);
        builder.setView(dialogLayout);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setCancelable(false);
        builder.show();

        final Button btnHH=dialogLayout.findViewById(R.id.btn_HH);
        final Button btnVHC=dialogLayout.findViewById(R.id.btn_vhc);
        final Button btnWSG=dialogLayout.findViewById(R.id.btn_WSG);



        // button HH

        btnHH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(boolSourceRegister==true)
                {
                    Intent intt=new Intent(getBaseContext(),LHWHHSections.class);
                    startActivity(intt);

                }

            }
        });


        // button VHC

        btnVHC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(boolSourceRegister==true)
                {
                    Intent intt=new Intent(getBaseContext(),Form3SectionB.class);
                    startActivity(intt);

                }
            }
        });

        // button WSG

        btnWSG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(boolSourceRegister==true)
                {
                    Intent intt=new Intent(getBaseContext(),Form5SectionB.class);
                    startActivity(intt);

                }
            }
        });
    }


}
