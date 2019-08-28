package com.irfansyed.umeedenau.validation;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.irfansyed.umeedenau.validation.databinding.Form1sectioneBinding;

import java.util.HashMap;

import utils.GeneratorClass;
import utils.ValidatorClass;


public  class Form1SectionE extends AppCompatActivity implements View.OnClickListener {


    //region Initialization
    Form1sectioneBinding bin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bin= DataBindingUtil.setContentView(this, R.layout.form1sectione);


        bin.btnNext.setOnClickListener(this);



        if(GeneratorClass.LHWsectionStatus("TableF1SectionE")==false)
        {

            bin.lhwf1e1.setText("000");
            bin.lhwf1e1.setVisibility(View.GONE);
        }





    }






    @Override
    public void onClick(View view)
    {
        if (!formValidation()) {
            return;
        }


        if(!GeneratorClass.checktextbox(bin.lhwf1e1,bin.lhwf1e2))
        {
            return;
        }

        insert_data();
        int count= GeneratorClass.hh_section_count("TableF1SectionE",this);

        Toast.makeText(this,"Data Inserted",Toast.LENGTH_SHORT).show();


        Intent returnIntent = new Intent();
        returnIntent.putExtra("count",count+"");
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bin.SectionE);
    }

    void insert_data()
    {
        HashMap<String, String> Has_Map = new HashMap<>();
        GeneratorClass.Has_Map.clear();


        Has_Map.put("FK_id",Global.LhwHH_id+"");
        Has_Map.put("LhwSectionPKId",Global.LhwSection_id+"");
        Has_Map.put("Status","0");

        GeneratorClass.Insert_table(bin.SectionE,true);
        GeneratorClass.inert_db("TableF1SectionE",this,Has_Map);
        GeneratorClass.LHWSectionUpdateCOunt("LHWOfficeHHCount",Global.LhwSection_id,this);




    }





}
