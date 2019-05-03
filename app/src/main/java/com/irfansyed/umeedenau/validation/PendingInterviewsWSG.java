package com.irfansyed.umeedenau.validation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import data.LocalDataManager;


public class PendingInterviewsWSG extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pendinginterviewswsg);

          List<String> list = new LocalDataManager(this).getLogList("0");


        if(list == null)
            return;

        Collections.sort(list);

        mRecyclerView = (RecyclerView) findViewById(R.id.list_survey_completed);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mAdapter = new PendingInterviewsWSGCustomAdapter(this, list);
        mRecyclerView.setAdapter(mAdapter);
    }


}


class  PendingInterviewsWSGCustomAdapter extends RecyclerView.Adapter{

    Context mContext;
    List<String> mList;
    public PendingInterviewsWSGCustomAdapter(Context context, List<String> list){
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

        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder b = new AlertDialog.Builder(mContext);
                b.setTitle("Start validation");
                b.setMessage("Do you want to Monitore ");
                b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String memberId = vh.textName.getText().toString();


                        String[] arrr=memberId.split("/");

                       // col_A.data_upload_id=arrr[0];
                        // =arrr[0];

                      //  Intent intent = new Intent(mContext, activity2.class);
                       // intent.putExtra("id",arrr[0]);

                        Global.global_id=arrr[3];
                     //   mContext.startActivity(intent);

                        ((Activity)mContext).finish();

                      //  new Upload_request1(mContext).execute();
                    //    new UploadSectionEAsync(mContext, "3").execute(); // irfan



                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                       // Intent intent = null;

                     //   intent = new Intent(this, PendingInterviewsWSG.class);
                    }
                }).show();
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