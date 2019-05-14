package com.irfansyed.umeedenau.validation;

import android.content.Intent;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.irfansyed.umeedenau.validation.databinding.Form1sectiongBinding;
import com.irfansyed.umeedenau.validation.databinding.Form2sectiongBinding;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;

import data.LocalDataManager;
import utils.GeneratorClass;
import utils.GetGpsHideForm;
import utils.ValidatorClass;

import static data.LocalDataManager.database;


public  class Form2SectionG extends AppCompatActivity implements View.OnClickListener {


    //region Initialization
    Form2sectiongBinding bin;
    String FK_id;
    String Lat,Long;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bin= DataBindingUtil.setContentView(this, R.layout.form2sectiong);


        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        if(b!=null)
        {
            FK_id =(String) b.get("pk_id");


            this.ininfo();

        }






        bin.btnNext.setOnClickListener(this);

        String gps_=GetGpsHideForm.get_gps(this);
        String[] gps=gps_.split("/");
         Lat=gps[0];
         Long=gps[1];

    }






    @Override
    public void onClick(View view)
    {      if (!formValidation()) {
        return;
    }

        insert_data();


        Toast.makeText(this,"Data Inserted",Toast.LENGTH_SHORT).show();
        Intent intt = new Intent(getBaseContext(), PendingInterviewsHH.class);
        startActivity(intt);

        finish();

    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bin.SectionG);
    }



    void insert_data()
    {
        HashMap<String, String> Has_Map = new HashMap<>();
        GeneratorClass.Has_Map.clear();


        Has_Map.put("FK_id",FK_id+"");
        Has_Map.put("LhwSectionPKId",Global.LhwSection_id+"");

        String start_time = DateFormat.getDateTimeInstance().format(new Date());

        Has_Map.put(Global.GPSLat,Lat);
        Has_Map.put(Global.GPSLong,Long);
        Has_Map.put(Global.InterviewTime,start_time);


        GeneratorClass.Insert_table(bin.SectionG,true);
        GeneratorClass.inert_db("TableF2SectionG",this,Has_Map);
        GeneratorClass.HH_update_Form1("TableF1SectionG",FK_id,this);
        GeneratorClass.LHWSectionUpdateCOunt("LHWCommunityHHCount",Global.LhwSection_id,this);



    }


    public    void ininfo()
    {

        String query2 = "select lhwf1g4  from TableF1SectionG  where id="+FK_id;

        LocalDataManager Lm = new LocalDataManager(this);
        Cursor c = database.rawQuery(query2, null);


        if (c != null) {
            if (c.moveToFirst()) {
                do {


                    bin.lhwf2g4.setText(c.getString(0));


                } while (c.moveToNext());
            }

        }





    }



}
