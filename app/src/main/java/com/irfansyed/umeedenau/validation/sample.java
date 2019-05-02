package com.irfansyed.umeedenau.validation;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.irfansyed.umeedenau.validation.databinding.LhwdashbordBinding;


public  class sample extends AppCompatActivity implements View.OnClickListener {


    //region Initialization
    LhwdashbordBinding bin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bin= DataBindingUtil.setContentView(this, R.layout.lhwdashbord);





    }






    @Override
    public void onClick(View view)
    {

    }





}
