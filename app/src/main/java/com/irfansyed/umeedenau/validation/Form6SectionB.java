package com.irfansyed.umeedenau.validation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.irfansyed.umeedenau.validation.databinding.Form5sectionbBinding;
import com.irfansyed.umeedenau.validation.databinding.Form6sectionbBinding;


public  class Form6SectionB extends AppCompatActivity implements View.OnClickListener {


    //region Initialization
    Form6sectionbBinding bin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bin= DataBindingUtil.setContentView(this, R.layout.form6sectionb);





    }






    @Override
    public void onClick(View view)
    {

    }





}
