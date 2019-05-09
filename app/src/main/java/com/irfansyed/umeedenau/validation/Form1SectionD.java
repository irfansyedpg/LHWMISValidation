package com.irfansyed.umeedenau.validation;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.irfansyed.umeedenau.validation.databinding.Form1sectiondBinding;

import java.util.HashMap;

import utils.GeneratorClass;
import utils.ValidatorClass;


public  class Form1SectionD extends AppCompatActivity implements View.OnClickListener {


    //region Initialization
    Form1sectiondBinding bin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bin= DataBindingUtil.setContentView(this, R.layout.form1sectiond);

        bin.btnNext.setOnClickListener(this);




    }






    @Override
    public void onClick(View view)
    {

        if (!formValidation()) {
            return;
        }

        insert_data();
        int count= GeneratorClass.hh_section_count("TableF1SectionD",this);

        Toast.makeText(this,"Data Inserted",Toast.LENGTH_SHORT).show();


        Intent returnIntent = new Intent();
        returnIntent.putExtra("count",count+"");
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }


    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bin.Dsection);
    }

    void insert_data()
    {
        HashMap<String, String> Has_Map = new HashMap<>();


        Has_Map.put("FK_id",Global.LhwHH_id+"");
        Has_Map.put("LhwSectionPKId",Global.LhwSection_id+"");
        Has_Map.put("Status","0");

        GeneratorClass.Has_Map.clear();
        GeneratorClass.Insert_table(bin.Dsection,true);
        GeneratorClass.inert_db("TableF1SectionD",this,Has_Map);




    }


}
