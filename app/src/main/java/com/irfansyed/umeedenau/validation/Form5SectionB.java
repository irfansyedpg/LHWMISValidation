package com.irfansyed.umeedenau.validation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.irfansyed.umeedenau.validation.databinding.Form3sectionbBinding;
import com.irfansyed.umeedenau.validation.databinding.Form5sectionbBinding;


public  class Form5SectionB extends AppCompatActivity implements View.OnClickListener {


    //region Initialization
    Form5sectionbBinding bin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bin= DataBindingUtil.setContentView(this, R.layout.form5sectionb);





    }






    @Override
    public void onClick(View view)
    {

    }





}
