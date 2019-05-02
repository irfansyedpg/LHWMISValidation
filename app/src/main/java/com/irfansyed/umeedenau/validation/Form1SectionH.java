package com.irfansyed.umeedenau.validation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.irfansyed.umeedenau.validation.databinding.Form1sectionhBinding;
import com.irfansyed.umeedenau.validation.databinding.LhwdashbordBinding;


public  class Form1SectionH extends AppCompatActivity implements View.OnClickListener {


    //region Initialization
    Form1sectionhBinding bin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bin= DataBindingUtil.setContentView(this, R.layout.form1sectionh);



    }






    @Override
    public void onClick(View view)
    {

    }





}
