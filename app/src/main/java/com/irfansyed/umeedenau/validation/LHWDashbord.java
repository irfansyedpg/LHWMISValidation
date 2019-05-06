package com.irfansyed.umeedenau.validation;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.irfansyed.umeedenau.validation.databinding.LhwdashbordBinding;

import java.util.ArrayList;

import data.LocalDataManager;
import utils.MyPreferences;

import static data.LocalDataManager.database;


public class LHWDashbord extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {


    //region Initialization
    LhwdashbordBinding bin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bin = DataBindingUtil.setContentView(this, R.layout.lhwdashbord);


        bin.btnCommunity.setOnClickListener(this);
        bin.btnSourceRegister.setOnClickListener(this);


        select_tehsil();
        bin.lhwf1a1.setOnItemSelectedListener(this);
        bin.lhwf1a2.setOnItemSelectedListener(this);
        bin.lhwf1a3.setOnItemSelectedListener(this);


    }


    @Override
    public void onClick(View view) {
        boolean boolSourceRegister = false;

        if (view.getId() == R.id.btnSourceRegister) {
            boolSourceRegister = true;
        }


        if (logic_error() == true) {
            showLhwSelection(boolSourceRegister);

            if (boolSourceRegister == true) {



                String status = get_status_interview(bin.lhwf1a1.getSelectedItem().toString(), bin.lhwf1a2.getSelectedItem().toString(),

                        bin.lhwf1a3.getSelectedItem().toString(), bin.lhwf1a4.getText().toString()
                );

                if (status.equals("1")) {
                    insert_db(bin.lhwf1a1.getSelectedItem().toString(), bin.lhwf1a2.getSelectedItem().toString(),

                            bin.lhwf1a3.getSelectedItem().toString(), bin.lhwf1a4.getText().toString()
                    );


                    get_status_interview(bin.lhwf1a1.getSelectedItem().toString(), bin.lhwf1a2.getSelectedItem().toString(),

                            bin.lhwf1a3.getSelectedItem().toString(), bin.lhwf1a4.getText().toString()
                    );
                }
            }
        }
    }


    // Alert lhw selection

    void showLhwSelection(final boolean boolSourceRegister) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        builder.setTitle("LHW Selection");
        final View dialogLayout = inflater.inflate(R.layout.lhwselection, null);
        builder.setView(dialogLayout);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setCancelable(false);
        builder.show();

        final Button btnHH = dialogLayout.findViewById(R.id.btn_HH);
        final Button btnVHC = dialogLayout.findViewById(R.id.btn_vhc);
        final Button btnWSG = dialogLayout.findViewById(R.id.btn_WSG);



        if(boolSourceRegister==true)
        {
            btnHH.setText("Validate HH("+hh_count+")");
            btnVHC.setText("Validate VHC("+vhc_count+")");
            btnWSG.setText("Validate WSG("+wsg_count+")");

        }
        else
        {
            btnHH.setText("Validate HH");
            btnVHC.setText("Validate VHC");
            btnWSG.setText("Validate WSG");

        }

        // button HH

        btnHH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (boolSourceRegister == true) {
                    Intent intt = new Intent(getBaseContext(), LHWHHSections.class);
                    startActivity(intt);

                } else {
                    Intent intt = new Intent(getBaseContext(), PendingInterviewsHH.class);
                    startActivity(intt);

                }

            }
        });


        // button VHC

        btnVHC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (boolSourceRegister == true) {
                    Intent intt = new Intent(getBaseContext(), Form3SectionB.class);
                    startActivity(intt);

                } else {
                    Intent intt = new Intent(getBaseContext(), PendingInterviewsVHC.class);
                    startActivity(intt);
                }
            }
        });

        // button WSG

        btnWSG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (boolSourceRegister == true) {
                    Intent intt = new Intent(getBaseContext(), Form5SectionB.class);
                    startActivity(intt);

                } else {
                    Intent intt = new Intent(getBaseContext(), PendingInterviewsWSG.class);
                    startActivity(intt);
                }
            }
        });
    }


    void select_tehsil() {

        ArrayList<String> lst_tehsil = new ArrayList<>();
        String query = "select distinct Tehsil from TableLoginData ";


        query = String.format(query);

        LocalDataManager Lm = new LocalDataManager(this);
        Cursor c = database.rawQuery(query, null);


        lst_tehsil.add("Select Tehsil");
        if (c != null) {
            if (c.moveToFirst()) {
                do {

                    lst_tehsil.add(c.getString(0));

                } while (c.moveToNext());
            }
        }


        ArrayAdapter<String> dataAdapterD = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lst_tehsil);

        dataAdapterD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bin.lhwf1a1.setAdapter(dataAdapterD);


        bin.lhwf1a1.setSelection(0);
    }


    void select_HF() {

        String Tehisl = bin.lhwf1a1.getSelectedItem().toString();

        bin.lhwf1a2.setAdapter(null);

        ArrayList<String> lst_tehsil = new ArrayList<>();
        String query = "select distinct Reporting_HF from TableLoginData where Tehsil='" + Tehisl + "'";


        query = String.format(query);

        LocalDataManager Lm = new LocalDataManager(this);
        Cursor c = database.rawQuery(query, null);


        lst_tehsil.add("Select Health Facility");
        if (c != null) {
            if (c.moveToFirst()) {
                do {

                    lst_tehsil.add(c.getString(0));

                } while (c.moveToNext());
            }
        }


        ArrayAdapter<String> dataAdapterD = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lst_tehsil);

        dataAdapterD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bin.lhwf1a2.setAdapter(dataAdapterD);


        bin.lhwf1a2.setSelection(0);


    }


    void select_LHW() {

        String HF = bin.lhwf1a2.getSelectedItem().toString();
        String Tehisl = bin.lhwf1a1.getSelectedItem().toString();

        bin.lhwf1a3.setAdapter(null);

        ArrayList<String> lst_tehsil = new ArrayList<>();
        String query = "select distinct LHW_Ids from TableLoginData where Tehsil='" + Tehisl + "' and Reporting_HF='" + HF + "'";


        query = String.format(query);

        LocalDataManager Lm = new LocalDataManager(this);
        Cursor c = database.rawQuery(query, null);


        lst_tehsil.add("Select LHW ID");

        if (c != null) {
            if (c.moveToFirst()) {
                do {

                    lst_tehsil.add(c.getString(0));

                } while (c.moveToNext());
            }
        }


        ArrayAdapter<String> dataAdapterD = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lst_tehsil);

        dataAdapterD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bin.lhwf1a3.setAdapter(dataAdapterD);


        bin.lhwf1a3.setSelection(0);


    }

    void select_Name() {


        String Tehisl = bin.lhwf1a3.getSelectedItem().toString();


        String query = "select distinct LHW_Name from TableLoginData where LHW_Ids='" + Tehisl + "'";


        query = String.format(query);

        LocalDataManager Lm = new LocalDataManager(this);
        Cursor c = database.rawQuery(query, null);


        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    bin.lhwf1a4.setText(c.getString(0));

                } while (c.moveToNext());
            }
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (parent.getId() == R.id.lhwf1a1) {

            bin.lhwf1a2.setAdapter(null);
            bin.lhwf1a3.setAdapter(null);
            bin.lhwf1a4.setText("");
            this.select_HF();
        }
        if (parent.getId() == R.id.lhwf1a2) {

            bin.lhwf1a3.setAdapter(null);
            bin.lhwf1a4.setText("");
            this.select_LHW();
        }
        if (parent.getId() == R.id.lhwf1a3) {


            bin.lhwf1a4.setText("");
            this.select_Name();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    boolean logic_error() {
        if (bin.lhwf1a1.getSelectedItem().toString().equals("Select Tehsil")) {
            Toast.makeText(this, "Please Select Tehsil", Toast.LENGTH_LONG).show();
            return false;
        }

        if (bin.lhwf1a2.getSelectedItem().toString().equals("Select Health Facility")) {
            Toast.makeText(this, "Select Health Facility", Toast.LENGTH_LONG).show();
            return false;
        }


        if (bin.lhwf1a3.getSelectedItem().toString().equals("Select LHW ID")) {
            Toast.makeText(this, "Please Select LHW ID", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;

    }


    void insert_db(String a1, String a2, String a3, String a4) {
        String query = "insert into  TableLHWSection (lhwf1a1,lhwf1a2,lhwf1a3,lhwf1a4,status,HH_count,VHC_count,WSG_count) values('" +

                a1 + "','" + a2 + "','" + a3 + "','" + a4 + "','0','0','0','0')";

        query = String.format(query);

        LocalDataManager validationactivity = new LocalDataManager(this);

        validationactivity.database.execSQL(query);
    }

    int hh_count=0;
    int vhc_count=0;
    int wsg_count=0;
    int LHWsection_Pk_Id=0;
    String get_status_interview(String a1, String a2, String a3, String a4) {

        String status = "1";

        String query = "select status,HH_count,VHC_count,WSG_count,id from  TableLHWSection where lhwf1a1='" + a1 + "'" +

                " and lhwf1a2='" + a2 + "'" +
                " and lhwf1a3='" + a3 + "'";


        query = String.format(query);

        LocalDataManager Lm = new LocalDataManager(this);
        Cursor c = database.rawQuery(query, null);


        if (c != null) {
            if (c.moveToFirst()) {
                do {

                    status = c.getString(0);
                    hh_count= c.getInt(1);
                    vhc_count= c.getInt(2);
                    wsg_count= c.getInt(3);
                    LHWsection_Pk_Id= c.getInt(4);


                } while (c.moveToNext());
            }
        }


        Global.LhwSection_id=LHWsection_Pk_Id;
        Global.HH_count=hh_count;
        Global.WSG_cout=wsg_count;
        Global.VHC_count=vhc_count;

        return status;

    }
}
