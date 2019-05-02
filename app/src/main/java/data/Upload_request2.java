package data;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.widget.Toast;

import com.irfansyed.umeedenau.validation.Global;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import utils.MyPreferences;
import utils.PostRequestData;
import utils.QuestionModel;

import static data.LocalDataManager.database;

/**
 * Created by Umeed-e-Nau on 12/28/2016.
 */
public class Upload_request2 extends AsyncTask {

    Context mContext;
    public static ProgressDialog dialog;
    HashMap<String, String> param;
    String[] interviewLogData;
    String mUserMsg;

    public Upload_request2(Context context) {

        //stop interview
        // if(InterviewUploadingStatus.status<2)
        //   this.cancel(false);

        mContext = context;
        dialog = new ProgressDialog(context);
        param = new HashMap<>();

    }

    @Override
    protected void onPreExecute() {

      //  dialog.setMessage("Uploading interview Please wait ....");
       // dialog.setCancelable(false);
      //  dialog.show();


        HashMap<String, List<String>> map = QuestionModel.quest.get("a");


        //region Query

        String query ="select "+

                "A1	,"
                +"A2	,"
                +"B1	,"
                +"B2	,"
                +"B3	,"
                +"B4	,"
                +"B5	,"
                +"B5_d	,"
                +"B6	,"
                +"B7	,"
                +"C1	,"
                +"C2	,"
                +"C3	,"
                +"C4	,"
                +"C5	,"
                +"D1	,"
                +"D2	,"
                +"D2_d	,"
                +"D3	,"
                +"D4	,"
                +"D5	,"
                +"D6	,"
                +"E1	,"
                +"E2	,"
                +"E3	,"
                +"E4	,"
                +"E4_1	,"
                +"E4_2	,"
                +"E4_3	,"
                +"E4_4	,"
                +"E4_5	,"
                +"E4_6	,"
                +"E4_7	,"
                +"E4_8	,"
                +"E4_9	,"
                +"E4_10	,"
                +"E4_11	,"
                +"E4_12	,"
                +"E4_13	,"
                +"E5	,"
                +"E6	,"
                +"E7	,"
                +"E8	,"
                +"E9	,"
                +"E10	,"
                +"E11	,"
                +"F1	,"
                +"F2	,"
                +"F3	,"
                +"F4	,"
                +"F5	,"
                +"F6	,"
                +"F7a	,"
                +"F7b	,"
                +"F8	,"
                +"F9	,"
                +"act_gps_lat	,"
                +"act_gps_long	,"
                +"V_H_B1	,"
                +"V_V_B1	,"
                +"V_R_B1	,"
                +"V_H_B2	,"
                +"V_V_B2	,"
                +"V_R_B2	,"
                +"V_H_B3	,"
                +"V_V_B3	,"
                +"V_R_B3	,"
                +"V_H_B4	,"
                +"V_V_B4	,"
                +"V_R_B4	,"
                +"V_H_B5	,"
                +"V_V_B5	,"
                +"V_R_B5	,"
                +"V_H_B6	,"
                +"V_V_B6	,"
                +"V_R_B6	,"
                +"V_H_B7	,"
                +"V_V_B7	,"
                +"V_R_B7	,"
                +"V_H_C1	,"
                +"V_V_C1	,"
                +"V_R_C1	,"
                +"V_H_C2	,"
                +"V_V_C2	,"
                +"V_R_C2	,"
                +"V_H_C3	,"
                +"V_V_C3	,"
                +"V_R_C3	,"
                +"V_H_C4	,"
                +"V_V_C4	,"
                +"V_R_C4	,"
                +"V_H_C5	,"
                +"V_V_C5	,"
                +"V_R_C5	,"
                +"V_H_D1	,"
                +"V_V_D1	,"
                +"V_R_D1	,"
                +"V_H_D2	,"
                +"V_V_D2	,"
                +"V_R_D2	,"
                +"V_H_D3	,"
                +"V_V_D3	,"
                +"V_R_D3	,"
                +"V_H_D4	,"
                +"V_V_D4	,"
                +"V_R_D4	,"
                +"V_H_D5	,"
                +"V_V_D5	,"
                +"V_R_D5	,"
                +"V_H_D6	,"
                +"V_V_D6	,"
                +"V_R_D6	,"
                +"V_H_E1	,"
                +"V_V_E1	,"
                +"V_R_E1	,"
                +"V_H_E2	,"
                +"V_V_E2	,"
                +"V_R_E2	,"
                +"V_H_E3	,"
                +"V_V_E3	,"
                +"V_R_E3	,"
                +"V_H_E4	,"
                +"V_V_E4	,"
                +"V_R_E4	,"
                +"V_H_E4_1	,"
                +"V_V_E4_1	,"
                +"V_R_E4_1	,"
                +"V_H_E4_2	,"
                +"V_V_E4_2	,"
                +"V_R_E4_2	,"
                +"V_H_E4_3	,"
                +"V_V_E4_3	,"
                +"V_R_E4_3	,"
                +"V_H_E4_4	,"
                +"V_V_E4_4	,"
                +"V_R_E4_4	,"
                +"V_H_E4_5	,"
                +"V_V_E4_5	,"
                +"V_R_E4_5	,"
                +"V_H_E4_6	,"
                +"V_V_E4_6	,"
                +"V_R_E4_6	,"
                +"V_H_E4_7	,"
                +"V_V_E4_7	,"
                +"V_R_E4_7	,"
                +"V_H_E4_8	,"
                +"V_V_E4_8	,"
                +"V_R_E4_8	,"
                +"V_H_E4_9	,"
                +"V_V_E4_9	,"
                +"V_R_E4_9	,"
                +"V_H_E4_10	,"
                +"V_V_E4_10	,"
                +"V_R_E4_10	,"
                +"V_H_E4_11	,"
                +"V_V_E4_11	,"
                +"V_R_E4_11	,"
                +"V_H_E4_12	,"
                +"V_V_E4_12	,"
                +"V_R_E4_12	,"
                +"V_H_E4_13	,"
                +"V_V_E4_13	,"
                +"V_R_E4_13	,"
                +"V_H_E5	,"
                +"V_V_E5	,"
                +"V_R_E5	,"
                +"V_H_E6	,"
                +"V_V_E6	,"
                +"V_R_E6	,"
                +"V_H_E7	,"
                +"V_V_E7	,"
                +"V_R_E7	,"
                +"V_H_E8	,"
                +"V_V_E8	,"
                +"V_R_E8	,"
                +"V_H_E9	,"
                +"V_V_E9	,"
                +"V_R_E9	,"
                +"V_H_E10	,"
                +"V_V_E10	,"
                +"V_R_E10	,"
                +"V_H_E11	,"
                +"V_V_E11	,"
                +"V_R_E11	,"
                +"V_H_F1 	,"
                +"V_V_F1 	,"
                +"V_R_F1 	,"
                +"V_H_F2 	,"
                +"V_V_F2 	,"
                +"V_R_F2 	,"
                +"V_H_F3 	,"
                +"V_V_F3 	,"
                +"V_R_F3 	,"
                +"V_H_F4 	,"
                +"V_V_F4 	,"
                +"V_R_F4 	,"
                +"V_H_F5 	,"
                +"V_V_F5 	,"
                +"V_R_F5 	,"
                +"V_H_F6 	,"
                +"V_V_F6 	,"
                +"V_R_F6 	,"
                +"V_H_F7a 	,"
                +"V_V_F7a 	,"
                +"V_R_F7a 	,"
                +"V_H_F7b 	,"
                +"V_V_F7b 	,"
                +"V_R_F7b 	,"
                +"V_H_F8 	,"
                +"V_V_F8 	,"
                +"V_R_F8 	,"
                +"V_H_F9 	,"
                +"V_V_F9 	,"
                +"V_R_F9" +

       " from activity1 where pk_pk = '%s' order by id  desc LIMIT 1";

        query = String.format(query, Global.global_id);

        LocalDataManager Lm = new LocalDataManager(mContext);
        Cursor c = Lm.database.rawQuery(query, null);


        if (c != null) {
            if (c.moveToFirst()) {


                param.put("A1", c.getString(	c.getColumnIndex("A1")));
                param.put("A2", c.getString(	c.getColumnIndex("A2")));
                param.put("B1", c.getString(	c.getColumnIndex("B1")));
                param.put("B2", c.getString(	c.getColumnIndex("B2")));
                param.put("B3", c.getString(	c.getColumnIndex("B3")));
                param.put("B4", c.getString(	c.getColumnIndex("B4")));
                param.put("B5", c.getString(	c.getColumnIndex("B5")));
                param.put("B5_d", c.getString(	c.getColumnIndex("B5_d")));
                param.put("B6", c.getString(	c.getColumnIndex("B6")));
                param.put("B7", c.getString(	c.getColumnIndex("B7")));
                param.put("C1", c.getString(	c.getColumnIndex("C1")));
                param.put("C2", c.getString(	c.getColumnIndex("C2")));
                param.put("C3", c.getString(	c.getColumnIndex("C3")));
                param.put("C4", c.getString(	c.getColumnIndex("C4")));
                param.put("C5", c.getString(	c.getColumnIndex("C5")));
                param.put("D1", c.getString(	c.getColumnIndex("D1")));
                param.put("D2", c.getString(	c.getColumnIndex("D2")));
                param.put("D2_d", c.getString(	c.getColumnIndex("D2_d")));
                param.put("D3", c.getString(	c.getColumnIndex("D3")));
                param.put("D4", c.getString(	c.getColumnIndex("D4")));
                param.put("D5", c.getString(	c.getColumnIndex("D5")));
                param.put("D6", c.getString(	c.getColumnIndex("D6")));
                param.put("E1", c.getString(	c.getColumnIndex("E1")));
                param.put("E2", c.getString(	c.getColumnIndex("E2")));
                param.put("E3", c.getString(	c.getColumnIndex("E3")));
                param.put("E4", c.getString(	c.getColumnIndex("E4")));
                param.put("E4_1", c.getString(	c.getColumnIndex("E4_1")));
                param.put("E4_2", c.getString(	c.getColumnIndex("E4_2")));
                param.put("E4_3", c.getString(	c.getColumnIndex("E4_3")));
                param.put("E4_4", c.getString(	c.getColumnIndex("E4_4")));
                param.put("E4_5", c.getString(	c.getColumnIndex("E4_5")));
                param.put("E4_6", c.getString(	c.getColumnIndex("E4_6")));
                param.put("E4_7", c.getString(	c.getColumnIndex("E4_7")));
                param.put("E4_8", c.getString(	c.getColumnIndex("E4_8")));
                param.put("E4_9", c.getString(	c.getColumnIndex("E4_9")));
                param.put("E4_10", c.getString(	c.getColumnIndex("E4_10")));
                param.put("E4_11", c.getString(	c.getColumnIndex("E4_11")));
                param.put("E4_12", c.getString(	c.getColumnIndex("E4_12")));
                param.put("E4_13", c.getString(	c.getColumnIndex("E4_13")));
                param.put("E5", c.getString(	c.getColumnIndex("E5")));
                param.put("E6", c.getString(	c.getColumnIndex("E6")));
                param.put("E7", c.getString(	c.getColumnIndex("E7")));
                param.put("E8", c.getString(	c.getColumnIndex("E8")));
                param.put("E9", c.getString(	c.getColumnIndex("E9")));
                param.put("E10", c.getString(	c.getColumnIndex("E10")));
                param.put("E11", c.getString(	c.getColumnIndex("E11")));
                param.put("F1", c.getString(	c.getColumnIndex("F1")));
                param.put("F2", c.getString(	c.getColumnIndex("F2")));
                param.put("F3", c.getString(	c.getColumnIndex("F3")));
                param.put("F4", c.getString(	c.getColumnIndex("F4")));
                param.put("F5", c.getString(	c.getColumnIndex("F5")));
                param.put("F6", c.getString(	c.getColumnIndex("F6")));
                param.put("F7_a", c.getString(	c.getColumnIndex("F7a")));
                param.put("F7_b", c.getString(	c.getColumnIndex("F7b")));
                param.put("F8", c.getString(	c.getColumnIndex("F8")));
                param.put("F9", c.getString(	c.getColumnIndex("F9")));
                param.put("act_gps_lat", c.getString(	c.getColumnIndex("act_gps_lat")));
                param.put("act_gps_long", c.getString(	c.getColumnIndex("act_gps_long")));
                param.put("V_H_B1", c.getString(	c.getColumnIndex("V_H_B1")));
                param.put("V_V_B1", c.getString(	c.getColumnIndex("V_V_B1")));
                param.put("V_R_B1", c.getString(	c.getColumnIndex("V_R_B1")));
                param.put("V_H_B2", c.getString(	c.getColumnIndex("V_H_B2")));
                param.put("V_V_B2", c.getString(	c.getColumnIndex("V_V_B2")));
                param.put("V_R_B2", c.getString(	c.getColumnIndex("V_R_B2")));
                param.put("V_H_B3", c.getString(	c.getColumnIndex("V_H_B3")));
                param.put("V_V_B3", c.getString(	c.getColumnIndex("V_V_B3")));
                param.put("V_R_B3", c.getString(	c.getColumnIndex("V_R_B3")));
                param.put("V_H_B4", c.getString(	c.getColumnIndex("V_H_B4")));
                param.put("V_V_B4", c.getString(	c.getColumnIndex("V_V_B4")));
                param.put("V_R_B4", c.getString(	c.getColumnIndex("V_R_B4")));
                param.put("V_H_B5", c.getString(	c.getColumnIndex("V_H_B5")));
                param.put("V_V_B5", c.getString(	c.getColumnIndex("V_V_B5")));
                param.put("V_R_B5", c.getString(	c.getColumnIndex("V_R_B5")));
                param.put("V_H_B6", c.getString(	c.getColumnIndex("V_H_B6")));
                param.put("V_V_B6", c.getString(	c.getColumnIndex("V_V_B6")));
                param.put("V_R_B6", c.getString(	c.getColumnIndex("V_R_B6")));
                param.put("V_H_B7", c.getString(	c.getColumnIndex("V_H_B7")));
                param.put("V_V_B7", c.getString(	c.getColumnIndex("V_V_B7")));
                param.put("V_R_B7", c.getString(	c.getColumnIndex("V_R_B7")));
                param.put("V_H_C1", c.getString(	c.getColumnIndex("V_H_C1")));
                param.put("V_V_C1", c.getString(	c.getColumnIndex("V_V_C1")));
                param.put("V_R_C1", c.getString(	c.getColumnIndex("V_R_C1")));
                param.put("V_H_C2", c.getString(	c.getColumnIndex("V_H_C2")));
                param.put("V_V_C2", c.getString(	c.getColumnIndex("V_V_C2")));
                param.put("V_R_C2", c.getString(	c.getColumnIndex("V_R_C2")));
                param.put("V_H_C3", c.getString(	c.getColumnIndex("V_H_C3")));
                param.put("V_V_C3", c.getString(	c.getColumnIndex("V_V_C3")));
                param.put("V_R_C3", c.getString(	c.getColumnIndex("V_R_C3")));
                param.put("V_H_C4", c.getString(	c.getColumnIndex("V_H_C4")));
                param.put("V_V_C4", c.getString(	c.getColumnIndex("V_V_C4")));
                param.put("V_R_C4", c.getString(	c.getColumnIndex("V_R_C4")));
                param.put("V_H_C5", c.getString(	c.getColumnIndex("V_H_C5")));
                param.put("V_V_C5", c.getString(	c.getColumnIndex("V_V_C5")));
                param.put("V_R_C5", c.getString(	c.getColumnIndex("V_R_C5")));
                param.put("V_H_D1", c.getString(	c.getColumnIndex("V_H_D1")));
                param.put("V_V_D1", c.getString(	c.getColumnIndex("V_V_D1")));
                param.put("V_R_D1", c.getString(	c.getColumnIndex("V_R_D1")));
                param.put("V_H_D2", c.getString(	c.getColumnIndex("V_H_D2")));
                param.put("V_V_D2", c.getString(	c.getColumnIndex("V_V_D2")));
                param.put("V_R_D2", c.getString(	c.getColumnIndex("V_R_D2")));
                param.put("V_H_D3", c.getString(	c.getColumnIndex("V_H_D3")));
                param.put("V_V_D3", c.getString(	c.getColumnIndex("V_V_D3")));
                param.put("V_R_D3", c.getString(	c.getColumnIndex("V_R_D3")));
                param.put("V_H_D4", c.getString(	c.getColumnIndex("V_H_D4")));
                param.put("V_V_D4", c.getString(	c.getColumnIndex("V_V_D4")));
                param.put("V_R_D4", c.getString(	c.getColumnIndex("V_R_D4")));
                param.put("V_H_D5", c.getString(	c.getColumnIndex("V_H_D5")));
                param.put("V_V_D5", c.getString(	c.getColumnIndex("V_V_D5")));
                param.put("V_R_D5", c.getString(	c.getColumnIndex("V_R_D5")));
                param.put("V_H_D6", c.getString(	c.getColumnIndex("V_H_D6")));
                param.put("V_V_D6", c.getString(	c.getColumnIndex("V_V_D6")));
                param.put("V_R_D6", c.getString(	c.getColumnIndex("V_R_D6")));
                param.put("V_H_E1", c.getString(	c.getColumnIndex("V_H_E1")));
                param.put("V_V_E1", c.getString(	c.getColumnIndex("V_V_E1")));
                param.put("V_R_E1", c.getString(	c.getColumnIndex("V_R_E1")));
                param.put("V_H_E2", c.getString(	c.getColumnIndex("V_H_E2")));
                param.put("V_V_E2", c.getString(	c.getColumnIndex("V_V_E2")));
                param.put("V_R_E2", c.getString(	c.getColumnIndex("V_R_E2")));
                param.put("V_H_E3", c.getString(	c.getColumnIndex("V_H_E3")));
                param.put("V_V_E3", c.getString(	c.getColumnIndex("V_V_E3")));
                param.put("V_R_E3", c.getString(	c.getColumnIndex("V_R_E3")));
                param.put("V_H_E4", c.getString(	c.getColumnIndex("V_H_E4")));
                param.put("V_V_E4", c.getString(	c.getColumnIndex("V_V_E4")));
                param.put("V_R_E4", c.getString(	c.getColumnIndex("V_R_E4")));
                param.put("V_H_E4_1", c.getString(	c.getColumnIndex("V_H_E4_1")));
                param.put("V_V_E4_1", c.getString(	c.getColumnIndex("V_V_E4_1")));
                param.put("V_R_E4_1", c.getString(	c.getColumnIndex("V_R_E4_1")));
                param.put("V_H_E4_2", c.getString(	c.getColumnIndex("V_H_E4_2")));
                param.put("V_V_E4_2", c.getString(	c.getColumnIndex("V_V_E4_2")));
                param.put("V_R_E4_2", c.getString(	c.getColumnIndex("V_R_E4_2")));
                param.put("V_H_E4_3", c.getString(	c.getColumnIndex("V_H_E4_3")));
                param.put("V_V_E4_3", c.getString(	c.getColumnIndex("V_V_E4_3")));
                param.put("V_R_E4_3", c.getString(	c.getColumnIndex("V_R_E4_3")));
                param.put("V_H_E4_4", c.getString(	c.getColumnIndex("V_H_E4_4")));
                param.put("V_V_E4_4", c.getString(	c.getColumnIndex("V_V_E4_4")));
                param.put("V_R_E4_4", c.getString(	c.getColumnIndex("V_R_E4_4")));
                param.put("V_H_E4_5", c.getString(	c.getColumnIndex("V_H_E4_5")));
                param.put("V_V_E4_5", c.getString(	c.getColumnIndex("V_V_E4_5")));
                param.put("V_R_E4_5", c.getString(	c.getColumnIndex("V_R_E4_5")));
                param.put("V_H_E4_6", c.getString(	c.getColumnIndex("V_H_E4_6")));
                param.put("V_V_E4_6", c.getString(	c.getColumnIndex("V_V_E4_6")));
                param.put("V_R_E4_6", c.getString(	c.getColumnIndex("V_R_E4_6")));
                param.put("V_H_E4_7", c.getString(	c.getColumnIndex("V_H_E4_7")));
                param.put("V_V_E4_7", c.getString(	c.getColumnIndex("V_V_E4_7")));
                param.put("V_R_E4_7", c.getString(	c.getColumnIndex("V_R_E4_7")));
                param.put("V_H_E4_8", c.getString(	c.getColumnIndex("V_H_E4_8")));
                param.put("V_V_E4_8", c.getString(	c.getColumnIndex("V_V_E4_8")));
                param.put("V_R_E4_8", c.getString(	c.getColumnIndex("V_R_E4_8")));
                param.put("V_H_E4_9", c.getString(	c.getColumnIndex("V_H_E4_9")));
                param.put("V_V_E4_9", c.getString(	c.getColumnIndex("V_V_E4_9")));
                param.put("V_R_E4_9", c.getString(	c.getColumnIndex("V_R_E4_9")));
                param.put("V_H_E4_10", c.getString(	c.getColumnIndex("V_H_E4_10")));
                param.put("V_V_E4_10", c.getString(	c.getColumnIndex("V_V_E4_10")));
                param.put("V_R_E4_10", c.getString(	c.getColumnIndex("V_R_E4_10")));
                param.put("V_H_E4_11", c.getString(	c.getColumnIndex("V_H_E4_11")));
                param.put("V_V_E4_11", c.getString(	c.getColumnIndex("V_V_E4_11")));
                param.put("V_R_E4_11", c.getString(	c.getColumnIndex("V_R_E4_11")));
                param.put("V_H_E4_12", c.getString(	c.getColumnIndex("V_H_E4_12")));
                param.put("V_V_E4_12", c.getString(	c.getColumnIndex("V_V_E4_12")));
                param.put("V_R_E4_12", c.getString(	c.getColumnIndex("V_R_E4_12")));
                param.put("V_H_E4_13", c.getString(	c.getColumnIndex("V_H_E4_13")));
                param.put("V_V_E4_13", c.getString(	c.getColumnIndex("V_V_E4_13")));
                param.put("V_R_E4_13", c.getString(	c.getColumnIndex("V_R_E4_13")));
                param.put("V_H_E5", c.getString(	c.getColumnIndex("V_H_E5")));
                param.put("V_V_E5", c.getString(	c.getColumnIndex("V_V_E5")));
                param.put("V_R_E5", c.getString(	c.getColumnIndex("V_R_E5")));
                param.put("V_H_E6", c.getString(	c.getColumnIndex("V_H_E6")));
                param.put("V_V_E6", c.getString(	c.getColumnIndex("V_V_E6")));
                param.put("V_R_E6", c.getString(	c.getColumnIndex("V_R_E6")));
                param.put("V_H_E7", c.getString(	c.getColumnIndex("V_H_E7")));
                param.put("V_V_E7", c.getString(	c.getColumnIndex("V_V_E7")));
                param.put("V_R_E7", c.getString(	c.getColumnIndex("V_R_E7")));
                param.put("V_H_E8", c.getString(	c.getColumnIndex("V_H_E8")));
                param.put("V_V_E8", c.getString(	c.getColumnIndex("V_V_E8")));
                param.put("V_R_E8", c.getString(	c.getColumnIndex("V_R_E8")));
                param.put("V_H_E9", c.getString(	c.getColumnIndex("V_H_E9")));
                param.put("V_V_E9", c.getString(	c.getColumnIndex("V_V_E9")));
                param.put("V_R_E9", c.getString(	c.getColumnIndex("V_R_E9")));
                param.put("V_H_E10", c.getString(	c.getColumnIndex("V_H_E10")));
                param.put("V_V_E10", c.getString(	c.getColumnIndex("V_V_E10")));
                param.put("V_R_E10", c.getString(	c.getColumnIndex("V_R_E10")));
                param.put("V_H_E11", c.getString(	c.getColumnIndex("V_H_E11")));
                param.put("V_V_E11", c.getString(	c.getColumnIndex("V_V_E11")));
                param.put("V_R_E11", c.getString(	c.getColumnIndex("V_R_E11")));
                param.put("V_H_F1", c.getString(	c.getColumnIndex("V_H_F1")));
                param.put("V_V_F1", c.getString(	c.getColumnIndex("V_V_F1")));
                param.put("V_R_F1", c.getString(	c.getColumnIndex("V_R_F1")));
                param.put("V_H_F2", c.getString(	c.getColumnIndex("V_H_F2")));
                param.put("V_V_F2", c.getString(	c.getColumnIndex("V_V_F2")));
                param.put("V_R_F2", c.getString(	c.getColumnIndex("V_R_F2")));
                param.put("V_H_F3", c.getString(	c.getColumnIndex("V_H_F3")));
                param.put("V_V_F3", c.getString(	c.getColumnIndex("V_V_F3")));
                param.put("V_R_F3", c.getString(	c.getColumnIndex("V_R_F3")));
                param.put("V_H_F4", c.getString(	c.getColumnIndex("V_H_F4")));
                param.put("V_V_F4", c.getString(	c.getColumnIndex("V_V_F4")));
                param.put("V_R_F4", c.getString(	c.getColumnIndex("V_R_F4")));
                param.put("V_H_F5", c.getString(	c.getColumnIndex("V_H_F5")));
                param.put("V_V_F5", c.getString(	c.getColumnIndex("V_V_F5")));
                param.put("V_R_F5", c.getString(	c.getColumnIndex("V_R_F5")));
                param.put("V_H_F6", c.getString(	c.getColumnIndex("V_H_F6")));
                param.put("V_V_F6", c.getString(	c.getColumnIndex("V_V_F6")));
                param.put("V_R_F6", c.getString(	c.getColumnIndex("V_R_F6")));
                param.put("V_H_F7_a", c.getString(	c.getColumnIndex("V_H_F7a")));
                param.put("V_V_F7_a", c.getString(	c.getColumnIndex("V_V_F7a")));
                param.put("V_R_F7_a", c.getString(	c.getColumnIndex("V_R_F7a")));
                param.put("V_H_F7_b", c.getString(	c.getColumnIndex("V_H_F7b")));
                param.put("V_V_F7_b", c.getString(	c.getColumnIndex("V_V_F7b")));
                param.put("V_R_F7_b", c.getString(	c.getColumnIndex("V_R_F7b")));
                param.put("V_H_F8", c.getString(	c.getColumnIndex("V_H_F8")));
                param.put("V_V_F8", c.getString(	c.getColumnIndex("V_V_F8")));
                param.put("V_R_F8", c.getString(	c.getColumnIndex("V_R_F8")));
                param.put("V_H_F9", c.getString(	c.getColumnIndex("V_H_F9")));
                param.put("V_V_F9", c.getString(	c.getColumnIndex("V_V_F9")));
                param.put("V_R_F9", c.getString(	c.getColumnIndex("V_R_F9")));

                param.put("pk_pk", Global.server_id);

            }

        }
        //endregion


        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        String urlString = new MyPreferences(mContext).getReq2();

        URL url;
        HttpURLConnection connection;

        try {
            url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            // connection.setRequestMethod("GET");
            connection.setConnectTimeout(1000);

            OutputStream os = connection.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

            bw.write(PostRequestData.getData(param));
            bw.flush();


            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String st ="", line;
                while ((line = br.readLine()) != null) {
                    st = st + line;
                }
                return st;
            } else {
                mUserMsg ="Server Couldn't process the request";
            }
        } catch (MalformedURLException e) {
            Toast.makeText(mContext, e.toString(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {


            mUserMsg ="Please make sure that Internet connection is available," +
                   " and server IP is inserted in settings";
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Object o) {


        try {
           // dialog.dismiss();

            if (mUserMsg != null)
                throw new IOException();


            //int houseId = Integer.parseInt(((String) o).replace("\"",""));

            String result = (((String) o).replace("\"",""));


            Toast.makeText(mContext,"Request 2  Has ben Uploaded", Toast.LENGTH_SHORT).show();



            Update_Status_Tabl1();

        } catch (IOException e) {
            //if connection was available via connecting but
            //we can't get data from server..
            if (mUserMsg == null)
                mUserMsg ="Please check connection";
            dialog.dismiss();
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
            mUserMsg = e.getMessage();
            dialog.dismiss();
        } catch (Exception e) {
            Toast.makeText(mContext,"Uploading failed at request 2", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
            return;
        } finally {
            if (mUserMsg != null)
                Toast.makeText(mContext, mUserMsg, Toast.LENGTH_SHORT).show();
        }


        super.onPostExecute(o);
    }



    void Update_Status_Tabl1() {

        String query ="update  tabl1  set Interview_status='2' where id="+Global.global_id;


        query = String.format(query);

        LocalDataManager validationactivity = new LocalDataManager(mContext);

        database.execSQL(query);

        thread.start();

    }

    // wait for Toast then kill app
    Thread thread = new Thread() {
        @Override
        public void run() {
            try {
                Thread.sleep(800); // As I am using LENGTH_LONG in Toast
                // Your_Activity.this.finish();


                int pid = android.os.Process.myPid();
                android.os.Process.killProcess(pid);
                // getActivity().finish();


                System.exit(0);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
}


