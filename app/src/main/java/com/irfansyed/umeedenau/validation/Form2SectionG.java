package com.irfansyed.umeedenau.validation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.irfansyed.umeedenau.validation.databinding.Form1sectiongBinding;
import com.irfansyed.umeedenau.validation.databinding.Form2sectiongBinding;


public  class Form2SectionG extends AppCompatActivity implements View.OnClickListener {


    //region Initialization
    Form2sectiongBinding bin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bin= DataBindingUtil.setContentView(this, R.layout.form2sectiong);





    }






    @Override
    public void onClick(View view)
    {

    }





}
