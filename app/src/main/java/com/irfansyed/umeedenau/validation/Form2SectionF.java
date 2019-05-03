package com.irfansyed.umeedenau.validation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.irfansyed.umeedenau.validation.databinding.Form1sectionfBinding;
import com.irfansyed.umeedenau.validation.databinding.Form2sectionfBinding;


public  class Form2SectionF extends AppCompatActivity implements View.OnClickListener {


    //region Initialization
    Form2sectionfBinding bin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bin= DataBindingUtil.setContentView(this, R.layout.form2sectionf);





    }






    @Override
    public void onClick(View view)
    {

    }





}
