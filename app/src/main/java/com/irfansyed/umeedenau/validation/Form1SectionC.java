package com.irfansyed.umeedenau.validation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.irfansyed.umeedenau.validation.databinding.Form1sectioncBinding;

import java.util.HashMap;

import data.LocalDataManager;
import utils.GeneratorClass;
import utils.ValidatorClass;

import utils.ClearAllcontrol;


public  class Form1SectionC extends AppCompatActivity implements View.OnClickListener,RadioButton.OnCheckedChangeListener {


    //region Initialization
    Form1sectioncBinding bin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bin= DataBindingUtil.setContentView(this, R.layout.form1sectionc);

        bin.btnNext.setOnClickListener(this);


        bin.lhwf1c61.setOnCheckedChangeListener(this);
        bin.lhwf1c62.setOnCheckedChangeListener(this);
        bin.lhwf1c63.setOnCheckedChangeListener(this);


    }






    @Override
    public void onClick(View view)
    {
        if (!formValidation()) {
            // return;
        }

        insert_data();

   //     this.finish();

    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bin.pp);
    }



    void insert_data()
    {
        HashMap<String, String> Has_Map = new HashMap<>();

        Has_Map=  GeneratorClass.Insert_table(bin.pp,true);
        GeneratorClass.inert_db("TableF1SectionC",this);




    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


        if(buttonView.getId()==R.id.lhwf1c6_1 || buttonView.getId()==R.id.lhwf1c6_2 || buttonView.getId()==R.id.lhwf1c6_3)
        {

            if(buttonView.getId()==R.id.lhwf1c6_1)
            {
                if(bin.lhwf1c61.isChecked())
                {
                    bin.LvLhwf1c7.setVisibility(View.GONE);
                    ClearAllcontrol.ClearAll(bin.LvLhwf1c7);

                }
                else
                {
                    bin.LvLhwf1c7.setVisibility(View.VISIBLE);
                }
            }

        }

    }
}
