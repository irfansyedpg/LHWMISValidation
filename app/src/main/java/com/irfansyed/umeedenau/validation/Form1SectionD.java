package com.irfansyed.umeedenau.validation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.irfansyed.umeedenau.validation.databinding.Form1sectioncBinding;
import com.irfansyed.umeedenau.validation.databinding.Form1sectiondBinding;
import com.irfansyed.umeedenau.validation.databinding.LhwdashbordBinding;


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

        this.finish();
    }





}
