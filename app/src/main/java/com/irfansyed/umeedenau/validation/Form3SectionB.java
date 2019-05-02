package com.irfansyed.umeedenau.validation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.irfansyed.umeedenau.validation.databinding.Form1sectioncBinding;
import com.irfansyed.umeedenau.validation.databinding.Form3sectionbBinding;


public  class Form3SectionB extends AppCompatActivity implements View.OnClickListener {


    //region Initialization
    Form3sectionbBinding bin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bin= DataBindingUtil.setContentView(this, R.layout.form3sectionb);





    }






    @Override
    public void onClick(View view)
    {

    }





}
