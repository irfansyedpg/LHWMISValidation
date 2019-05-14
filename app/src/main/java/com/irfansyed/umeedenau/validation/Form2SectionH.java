package com.irfansyed.umeedenau.validation;

import android.content.Intent;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.irfansyed.umeedenau.validation.databinding.Form1sectionhBinding;
import com.irfansyed.umeedenau.validation.databinding.Form2sectionhBinding;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;

import data.LocalDataManager;
import utils.ClearAllcontrol;
import utils.GeneratorClass;
import utils.GetGpsHideForm;
import utils.ValidatorClass;

import static data.LocalDataManager.database;


public  class Form2SectionH extends AppCompatActivity implements View.OnClickListener,RadioButton.OnCheckedChangeListener {


    //region Initialization
    Form2sectionhBinding bin;

    String FK_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bin= DataBindingUtil.setContentView(this, R.layout.form2sectionh);


        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        if(b!=null)
        {
            FK_id =(String) b.get("pk_id");


            this.ininfo();

        }




        bin.lhwf2h61.setOnCheckedChangeListener(this);
        bin.lhwf2h62.setOnCheckedChangeListener(this);


        bin.btnNext.setOnClickListener(this);

    }






    @Override
    public void onClick(View view)
    {   if (!formValidation()) {
        return;
    }

        insert_data();


        Toast.makeText(this,"Data Inserted",Toast.LENGTH_SHORT).show();
        Intent intt = new Intent(getBaseContext(), PendingInterviewsHH.class);
        startActivity(intt);

        finish();

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(buttonView.getId()==R.id.lhwf2h6_1 || buttonView.getId()==R.id.lhwf2h6_2 )
        {

            ClearAllcontrol.ClearAll(bin.LvLhwf2h7);

        }
    }


    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bin.SectionH);
    }



    void insert_data()
    {
        HashMap<String, String> Has_Map = new HashMap<>();
        GeneratorClass.Has_Map.clear();


        Has_Map.put("FK_id",FK_id+"");
        Has_Map.put("LhwSectionPKId",Global.LhwSection_id+"");

        String start_time = DateFormat.getDateTimeInstance().format(new Date());
        String gps_=GetGpsHideForm.get_gps(this);
        String[] gps=gps_.split("/");
        String Lat=gps[0];
        String Long=gps[1];
        Has_Map.put(Global.GPSLat,Lat);
        Has_Map.put(Global.GPSLong,Long);
        Has_Map.put(Global.InterviewTime,start_time);


        GeneratorClass.Insert_table(bin.SectionH,true);
        GeneratorClass.inert_db("TableF2SectionH",this,Has_Map);
        GeneratorClass.HH_update_Form1("TableF1SectionH",FK_id,this);
        GeneratorClass.LHWSectionUpdateCOunt("LHWCommunityHHCount",Global.LhwSection_id,this);



    }


    public    void ininfo()
    {

        String query2 = "select lhwf1h3,lhwf1h4  from TableF1SectionH  where id="+FK_id;

        LocalDataManager Lm = new LocalDataManager(this);
        Cursor c = database.rawQuery(query2, null);


        if (c != null) {
            if (c.moveToFirst()) {
                do {

                    bin.lhwf2h3.setText(c.getString(0));
                    bin.lhwf2h4.setText(c.getString(1));


                } while (c.moveToNext());
            }

        }





    }
}
