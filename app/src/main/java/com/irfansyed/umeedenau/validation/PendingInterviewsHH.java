package com.irfansyed.umeedenau.validation;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import data.LocalDataManager;

import static data.LocalDataManager.database;


public class PendingInterviewsHH extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pendinginterviewshh);

          List<String> list =get_list();


        if(list == null)
            return;

        Collections.sort(list);

        mRecyclerView = (RecyclerView) findViewById(R.id.list_survey_completed);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mAdapter = new PendingInterviewsHHCustomAdapter(this, list);
        mRecyclerView.setAdapter(mAdapter);


    }


    HashMap<String,String> map_add,map_contac;
    public   List<String> get_list()
    {
        map_add=new HashMap<>();
        map_contac=new HashMap<>();

        List<String> lst=new ArrayList<>();
        String query2 = "select id,lhwf1b1,Section,lhwf1b2,lhwf1b3 from  TableHHSection lhw where Fk_id="+Global.LhwSection_id;

        LocalDataManager Lm = new LocalDataManager(this);
        Cursor c = database.rawQuery(query2, null);


        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    String section=c.getString(2);
                    section=section.substring(7);

                    lst.add(c.getString(1)+"/"+section+"/"+c.getString(0));

                    map_add.put(c.getString(0),c.getString(3));
                    map_add.put(c.getString(0),c.getString(4));

                } while (c.moveToNext());
            }
        }

        return lst;


    }

    private  void show_alert(String Addres,String Contact,String Respondent,String Mother)
    {
        final android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogLayout = inflater.inflate(R.layout.dialogpendinghh, null);
        builder.setView(dialogLayout);
        builder.setCancelable(false);




        final EditText addres,contact,respondent,mohter;

        addres=dialogLayout.findViewById(R.id.addres);
        contact=dialogLayout.findViewById(R.id.contact);
        respondent=dialogLayout.findViewById(R.id.respondent);
        mohter=dialogLayout.findViewById(R.id.mohter);
        addres.setText(Addres);
        contact.setText(Contact);
        respondent.setText(Respondent);
        mohter.setText(Mother);


        final Button btn_cancel,btn_ok;
        btn_cancel=dialogLayout.findViewById(R.id.btn_cancel);
        btn_ok=dialogLayout.findViewById(R.id.btn_ok);
        final android.support.v7.app.AlertDialog dialog = builder.create();




        dialog.show();





        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialog.dismiss();



            }
        });



    }

    public  void ininfo(String tblName,String id)
    {
        String RespondentName="";
        String RespndehusbandName="";

        tblName="TableF1"+tblName;

        String query2 = "select *  from "+tblName+"  where Fk_id="+id;

   //     LocalDataManager Lm = new LocalDataManager(this);
        Cursor c = database.rawQuery(query2, null);


        if (c != null) {
            if (c.moveToFirst()) {
                do {


                    RespondentName=c.getString(2);
                    RespndehusbandName=c.getString(3);


                } while (c.moveToNext());
            }
        }

        this.show_alert(map_add.get(id),map_contac.get(id),RespondentName,RespndehusbandName);



    }




}




class  PendingInterviewsHHCustomAdapter extends RecyclerView.Adapter{

    Context mContext;
    List<String> mList;
    public PendingInterviewsHHCustomAdapter(Context context, List<String> list){
        mContext = context;
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_survey_pending, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final ViewHolder vh = (ViewHolder) holder;

        //rejected items..
        if(mList.get(position).contains("--00")) {
          vh.itemView.setBackgroundColor(Color.parseColor("#FFB7BC"));
        }

        vh.textName.setText(mList.get(position).split("--")[0]);
        vh.textId.setText(position+1 +"");

        String memberId = vh.textName.getText().toString();


        String[] arrr=memberId.split("/");




        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                        String memberId = vh.textName.getText().toString();





                        String[] arrr=memberId.split("/");
                         String id=arrr[2];
                         String tbl=arrr[1];

                PendingInterviewsHH pw= new PendingInterviewsHH();

                 pw.ininfo(tbl,id);


                       // col_A.data_upload_id=arrr[0];
                        // =arrr[0];

                      //  Intent intent = new Intent(mContext, activity2.class);
                       // intent.putExtra("id",arrr[0]);

                        Global.global_id=arrr[3];
                     //   mContext.startActivity(intent);

                       // ((Activity)mContext).finish();

                      //  new Upload_request1(mContext).execute();
                    //    new UploadSectionEAsync(mContext, "3").execute(); // irfan




            }
        });
    }




    @Override
    public int getItemCount() {
        return mList.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textName, textId;

        public ViewHolder(View v) {
            super(v);
            textName = (TextView) v.findViewById(R.id.text_item_survey_pending_name);
            textId = (TextView) v.findViewById(R.id.text_item_survey_pending_id);
        }
    }

}