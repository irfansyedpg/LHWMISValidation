package com.irfansyed.umeedenau.validation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.irfansyed.umeedenau.validation.databinding.Form1sectioncBinding;
import com.irfansyed.umeedenau.validation.databinding.LhwdashbordBinding;
import com.irfansyed.validation.ValidatorClass;


public  class Form1SectionC extends AppCompatActivity implements View.OnClickListener {


    //region Initialization
    Form1sectioncBinding bin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bin= DataBindingUtil.setContentView(this, R.layout.form1sectionc);

        bin.btnNext.setOnClickListener(this);




    }






    @Override
    public void onClick(View view)
    {
        if (!formValidation())
            return;


      /*  if (validateField() == false) {
            Toast.makeText(this, "Please Complete Mendatory Fields", Toast.LENGTH_LONG).show();
            return;
        }
        */

        this.finish();

    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bin.pp);
    }

    boolean validateField()
    {

        if (Gothrough.IamHiden(bin.LvLhwf1c1) == false) {
            return false;
        }
        if (Gothrough.IamHiden(bin.LvLhwf1c2) == false) {
            return false;
        }
        if (Gothrough.IamHiden(bin.LvLhwf1c3) == false) {
            return false;
        }
        if (Gothrough.IamHiden(bin.LvLhwf1c4) == false) {
            return false;
        }
        if (Gothrough.IamHiden(bin.LvLhwf1c5) == false) {
            return false;
        }
        if (Gothrough.IamHiden(bin.LvLhwf1c6) == false) {
            return false;
        }
        if (Gothrough.IamHiden(bin.LvLhwf1c7) == false) {
            return false;
        }
        if (Gothrough.IamHiden(bin.LvLhwf1c8) == false) {
            return false;
        }

        return true;

    }

    void insert_data()
    {

    }





}
