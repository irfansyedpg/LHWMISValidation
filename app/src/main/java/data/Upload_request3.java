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
public class Upload_request3 extends AsyncTask {

    Context mContext;
    public static ProgressDialog dialog;
    HashMap<String, String> param;
    String[] interviewLogData;
    String mUserMsg;

    public Upload_request3(Context context) {

        //stop interview
        // if(InterviewUploadingStatus.status<2)
        //   this.cancel(false);

        mContext = context;
        dialog = new ProgressDialog(context);
        param = new HashMap<>();

    }

    @Override
    protected void onPreExecute() {

        dialog.setMessage("Uploading interview Please wait ....");
        dialog.setCancelable(false);
        dialog.show();


        HashMap<String, List<String>> map = QuestionModel.quest.get("a");


        //region Query

        String query = "select "+

                 "G1_1	,"
                +"G2_1	,"
                +"G3_1	,"
                +"G3_2_1	,"
                +"G4_1	,"
                +"G5_1	,"
                +"G6_1	,"
                +"G6_1_1	,"
                +"G7_1	,"
                +"G8_1	,"
                +"G9_1	,"
                +"H1_1	,"
                +"H1_2_1	,"
                +"H2_1	,"
                +"H3_1	,"
                +"H4_1	,"
                +"H4_1_1	,"
                +"H4_2_1	,"
                +"H5_1	,"
                +"H6_1	,"
                +"H7_1	,"
                +"H8_1	,"
                +"H8_2_1	,"
                +"I1_1	,"
                +"I2_1	,"
                +"I3_1	,"
                +"I4_1	,"
                +"J1_1	,"
                +"J2_1	,"
                +"J3_1	,"
                +"J4_1	,"
                +"J5_1	,"
                +"J6_1	,"
                +"J7_1	,"
                +"K1_1	,"
                +"K2_1	,"
                +"K3_1	,"
                +"K4_1	,"
                +"K5_1	,"
                +"K6_1	,"
                +"K7_1	,"

                +"G1_2	,"
                +"G2_2	,"
                +"G3_2	,"
                +"G3_2_2	,"
                +"G4_2	,"
                +"G5_2	,"
                +"G6_2	,"
                +"G6_1_2	,"
                +"G7_2	,"
                +"G8_2	,"
                +"G9_2	,"
                +"H1_2	,"
                +"H1_2_2	,"
                +"H2_2	,"
                +"H3_2	,"
                +"H4_2	,"
                +"H4_1_2	,"
                +"H4_2_2	,"
                +"H5_2	,"
                +"H6_2	,"
                +"H7_2	,"
                +"H8_2	,"
                +"H8_2_2	,"
                +"I1_2	,"
                +"I2_2	,"
                +"I3_2	,"
                +"I4_2	,"
                +"J1_2	,"
                +"J2_2	,"
                +"J3_2	,"
                +"J4_2	,"
                +"J5_2	,"
                +"J6_2	,"
                +"J7_2	,"
                +"K1_2	,"
                +"K2_2	,"
                +"K3_2	,"
                +"K4_2	,"
                +"K5_2	,"
                +"K6_2	,"
                +"K7_2	,"

                +"G1_3	,"
                +"G2_3	,"
                +"G3_3	,"
                +"G3_2_3	,"
                +"G4_3	,"
                +"G5_3	,"
                +"G6_3	,"
                +"G6_1_3	,"
                +"G7_3	,"
                +"G8_3	,"
                +"G9_3	,"
                +"H1_3	,"
                +"H1_2_3	,"
                +"H2_3	,"
                +"H3_3	,"
                +"H4_3	,"
                +"H4_1_3	,"
                +"H4_2_3	,"
                +"H5_3	,"
                +"H6_3	,"
                +"H7_3	,"
                +"H8_3	,"
                +"H8_2_3	,"
                +"I1_3	,"
                +"I2_3	,"
                +"I3_3	,"
                +"I4_3	,"
                +"J1_3	,"
                +"J2_3	,"
                +"J3_3	,"
                +"J4_3	,"
                +"J5_3	,"
                +"J6_3	,"
                +"J7_3	,"
                +"K1_3	,"
                +"K2_3	,"
                +"K3_3	,"
                +"K4_3	,"
                +"K5_3	,"
                +"K6_3	,"
                +"K7_3  ,"



                +"G1_rem	,"
                +"G2_rem	,"
                +"G3_rem	,"
                +"G3_2_rem	,"
                +"G4_rem	,"
                +"G5_rem	,"
                +"G6_rem	,"
                +"G6_1_rem	,"
                +"G7_rem	,"
                +"G8_rem	,"
                +"G9_rem	,"
                +"H1_rem	,"
                +"H1_2_rem	,"
                +"H2_rem	,"
                +"H3_rem	,"
                +"H4_rem	,"
                +"H4_1_rem	,"
                +"H4_2_rem	,"
                +"H5_rem	,"
                +"H6_rem	,"
                +"H7_rem	,"
                +"H8_rem	,"
                +"H8_2_rem	,"
                +"I1_rem	,"
                +"I2_rem	,"
                +"I3_rem	,"
                +"I4_rem	,"
                +"J1_rem	,"
                +"J2_rem	,"
                +"J3_rem	,"
                +"J4_rem	,"
                +"J5_rem	,"
                +"J6_rem	,"
                +"J7_rem	,"
                +"K1_rem	,"
                +"K2_rem	,"
                +"K3_rem	,"
                +"K4_rem	,"
                +"K5_rem	,"
                +"K6_rem	,"
                +"K7_rem  "+


        " from activity3 where pk_pk = '%s' order by id  desc LIMIT 1";

        query = String.format(query, Global.global_id);

        LocalDataManager Lm = new LocalDataManager(mContext);
        Cursor c = database.rawQuery(query, null);


        if (c != null) {
            if (c.moveToFirst()) {

                param.put("G1_1", c.getString(	c.getColumnIndex("G1_1")));
                param.put("G2_1", c.getString(	c.getColumnIndex("G2_1")));
                param.put("G3_1", c.getString(	c.getColumnIndex("G3_1")));
                param.put("G3_2_1", c.getString(	c.getColumnIndex("G3_2_1")));
                param.put("G4_1", c.getString(	c.getColumnIndex("G4_1")));
                param.put("G5_1", c.getString(	c.getColumnIndex("G5_1")));
                param.put("G6_1", c.getString(	c.getColumnIndex("G6_1")));
                param.put("G6_1_1", c.getString(	c.getColumnIndex("G6_1_1")));
                param.put("G7_1", c.getString(	c.getColumnIndex("G7_1")));
                param.put("G8_1", c.getString(	c.getColumnIndex("G8_1")));
                param.put("G9_1", c.getString(	c.getColumnIndex("G9_1")));
                param.put("H1_1", c.getString(	c.getColumnIndex("H1_1")));
                param.put("H1_2_1", c.getString(	c.getColumnIndex("H1_2_1")));
                param.put("H2_1", c.getString(	c.getColumnIndex("H2_1")));
                param.put("H3_1", c.getString(	c.getColumnIndex("H3_1")));
                param.put("H4_1", c.getString(	c.getColumnIndex("H4_1")));
                param.put("H4_1_1", c.getString(	c.getColumnIndex("H4_1_1")));
                param.put("H4_2_1", c.getString(	c.getColumnIndex("H4_2_1")));
                param.put("H5_1", c.getString(	c.getColumnIndex("H5_1")));
                param.put("H6_1", c.getString(	c.getColumnIndex("H6_1")));
                param.put("H7_1", c.getString(	c.getColumnIndex("H7_1")));
                param.put("H8_1", c.getString(	c.getColumnIndex("H8_1")));
                param.put("H8_2_1", c.getString(	c.getColumnIndex("H8_2_1")));
                param.put("I1_1", c.getString(	c.getColumnIndex("I1_1")));
                param.put("I2_1", c.getString(	c.getColumnIndex("I2_1")));
                param.put("I3_1", c.getString(	c.getColumnIndex("I3_1")));
                param.put("I4_1", c.getString(	c.getColumnIndex("I4_1")));
                param.put("J1_1", c.getString(	c.getColumnIndex("J1_1")));
                param.put("J2_1", c.getString(	c.getColumnIndex("J2_1")));
                param.put("J3_1", c.getString(	c.getColumnIndex("J3_1")));
                param.put("J4_1", c.getString(	c.getColumnIndex("J4_1")));
                param.put("J5_1", c.getString(	c.getColumnIndex("J5_1")));
                param.put("J6_1", c.getString(	c.getColumnIndex("J6_1")));
                param.put("J7_1", c.getString(	c.getColumnIndex("J7_1")));
                param.put("K1_1", c.getString(	c.getColumnIndex("K1_1")));
                param.put("K2_1", c.getString(	c.getColumnIndex("K2_1")));
                param.put("K3_1", c.getString(	c.getColumnIndex("K3_1")));
                param.put("K4_1", c.getString(	c.getColumnIndex("K4_1")));
                param.put("K5_1", c.getString(	c.getColumnIndex("K5_1")));
                param.put("K6_1", c.getString(	c.getColumnIndex("K6_1")));
                param.put("K7_1", c.getString(	c.getColumnIndex("K7_1")));
                param.put("G1_2", c.getString(	c.getColumnIndex("G1_2")));
                param.put("G2_2", c.getString(	c.getColumnIndex("G2_2")));
                param.put("G3_2", c.getString(	c.getColumnIndex("G3_2")));
                param.put("G3_2_2", c.getString(	c.getColumnIndex("G3_2_2")));
                param.put("G4_2", c.getString(	c.getColumnIndex("G4_2")));
                param.put("G5_2", c.getString(	c.getColumnIndex("G5_2")));
                param.put("G6_2", c.getString(	c.getColumnIndex("G6_2")));
                param.put("G6_1_2", c.getString(	c.getColumnIndex("G6_1_2")));
                param.put("G7_2", c.getString(	c.getColumnIndex("G7_2")));
                param.put("G8_2", c.getString(	c.getColumnIndex("G8_2")));
                param.put("G9_2", c.getString(	c.getColumnIndex("G9_2")));
                param.put("H1_2", c.getString(	c.getColumnIndex("H1_2")));
                param.put("H1_2_2", c.getString(	c.getColumnIndex("H1_2_2")));
                param.put("H2_2", c.getString(	c.getColumnIndex("H2_2")));
                param.put("H3_2", c.getString(	c.getColumnIndex("H3_2")));
                param.put("H4_2", c.getString(	c.getColumnIndex("H4_2")));
                param.put("H4_1_2", c.getString(	c.getColumnIndex("H4_1_2")));
                param.put("H4_2_2", c.getString(	c.getColumnIndex("H4_2_2")));
                param.put("H5_2", c.getString(	c.getColumnIndex("H5_2")));
                param.put("H6_2", c.getString(	c.getColumnIndex("H6_2")));
                param.put("H7_2", c.getString(	c.getColumnIndex("H7_2")));
                param.put("H8_2", c.getString(	c.getColumnIndex("H8_2")));
                param.put("H8_2_2", c.getString(	c.getColumnIndex("H8_2_2")));
                param.put("I1_2", c.getString(	c.getColumnIndex("I1_2")));
                param.put("I2_2", c.getString(	c.getColumnIndex("I2_2")));
                param.put("I3_2", c.getString(	c.getColumnIndex("I3_2")));
                param.put("I4_2", c.getString(	c.getColumnIndex("I4_2")));
                param.put("J1_2", c.getString(	c.getColumnIndex("J1_2")));
                param.put("J2_2", c.getString(	c.getColumnIndex("J2_2")));
                param.put("J3_2", c.getString(	c.getColumnIndex("J3_2")));
                param.put("J4_2", c.getString(	c.getColumnIndex("J4_2")));
                param.put("J5_2", c.getString(	c.getColumnIndex("J5_2")));
                param.put("J6_2", c.getString(	c.getColumnIndex("J6_2")));
                param.put("J7_2", c.getString(	c.getColumnIndex("J7_2")));
                param.put("K1_2", c.getString(	c.getColumnIndex("K1_2")));
                param.put("K2_2", c.getString(	c.getColumnIndex("K2_2")));
                param.put("K3_2", c.getString(	c.getColumnIndex("K3_2")));
                param.put("K4_2", c.getString(	c.getColumnIndex("K4_2")));
                param.put("K5_2", c.getString(	c.getColumnIndex("K5_2")));
                param.put("K6_2", c.getString(	c.getColumnIndex("K6_2")));
                param.put("K7_2", c.getString(	c.getColumnIndex("K7_2")));
                param.put("G1_3", c.getString(	c.getColumnIndex("G1_3")));
                param.put("G2_3", c.getString(	c.getColumnIndex("G2_3")));
                param.put("G3_3", c.getString(	c.getColumnIndex("G3_3")));
                param.put("G3_2_3", c.getString(	c.getColumnIndex("G3_2_3")));
                param.put("G4_3", c.getString(	c.getColumnIndex("G4_3")));
                param.put("G5_3", c.getString(	c.getColumnIndex("G5_3")));
                param.put("G6_3", c.getString(	c.getColumnIndex("G6_3")));
                param.put("G6_1_3", c.getString(	c.getColumnIndex("G6_1_3")));
                param.put("G7_3", c.getString(	c.getColumnIndex("G7_3")));
                param.put("G8_3", c.getString(	c.getColumnIndex("G8_3")));
                param.put("G9_3", c.getString(	c.getColumnIndex("G9_3")));
                param.put("H1_3", c.getString(	c.getColumnIndex("H1_3")));
                param.put("H1_2_3", c.getString(	c.getColumnIndex("H1_2_3")));
                param.put("H2_3", c.getString(	c.getColumnIndex("H2_3")));
                param.put("H3_3", c.getString(	c.getColumnIndex("H3_3")));
                param.put("H4_3", c.getString(	c.getColumnIndex("H4_3")));
                param.put("H4_1_3", c.getString(	c.getColumnIndex("H4_1_3")));
                param.put("H4_2_3", c.getString(	c.getColumnIndex("H4_2_3")));
                param.put("H5_3", c.getString(	c.getColumnIndex("H5_3")));
                param.put("H6_3", c.getString(	c.getColumnIndex("H6_3")));
                param.put("H7_3", c.getString(	c.getColumnIndex("H7_3")));
                param.put("H8_3", c.getString(	c.getColumnIndex("H8_3")));
                param.put("H8_2_3", c.getString(	c.getColumnIndex("H8_2_3")));
                param.put("I1_3", c.getString(	c.getColumnIndex("I1_3")));
                param.put("I2_3", c.getString(	c.getColumnIndex("I2_3")));
                param.put("I3_3", c.getString(	c.getColumnIndex("I3_3")));
                param.put("I4_3", c.getString(	c.getColumnIndex("I4_3")));
                param.put("J1_3", c.getString(	c.getColumnIndex("J1_3")));
                param.put("J2_3", c.getString(	c.getColumnIndex("J2_3")));
                param.put("J3_3", c.getString(	c.getColumnIndex("J3_3")));
                param.put("J4_3", c.getString(	c.getColumnIndex("J4_3")));
                param.put("J5_3", c.getString(	c.getColumnIndex("J5_3")));
                param.put("J6_3", c.getString(	c.getColumnIndex("J6_3")));
                param.put("J7_3", c.getString(	c.getColumnIndex("J7_3")));
                param.put("K1_3", c.getString(	c.getColumnIndex("K1_3")));
                param.put("K2_3", c.getString(	c.getColumnIndex("K2_3")));
                param.put("K3_3", c.getString(	c.getColumnIndex("K3_3")));
                param.put("K4_3", c.getString(	c.getColumnIndex("K4_3")));
                param.put("K5_3", c.getString(	c.getColumnIndex("K5_3")));
                param.put("K6_3", c.getString(	c.getColumnIndex("K6_3")));
                param.put("K7_3", c.getString(	c.getColumnIndex("K7_3")));


                param.put("G1_rem", c.getString(	c.getColumnIndex("G1_rem")));
                param.put("G2_rem", c.getString(	c.getColumnIndex("G2_rem")));
                param.put("G3_rem", c.getString(	c.getColumnIndex("G3_rem")));
                param.put("G3_2_rem", c.getString(	c.getColumnIndex("G3_2_rem")));
                param.put("G4_rem", c.getString(	c.getColumnIndex("G4_rem")));
                param.put("G5_rem", c.getString(	c.getColumnIndex("G5_rem")));
                param.put("G6_rem", c.getString(	c.getColumnIndex("G6_rem")));
                param.put("G6_1_rem", c.getString(	c.getColumnIndex("G6_1_rem")));
                param.put("G7_rem", c.getString(	c.getColumnIndex("G7_rem")));
                param.put("G8_rem", c.getString(	c.getColumnIndex("G8_rem")));
                param.put("G9_rem", c.getString(	c.getColumnIndex("G9_rem")));
                param.put("H1_rem", c.getString(	c.getColumnIndex("H1_rem")));
                param.put("H1_2_rem", c.getString(	c.getColumnIndex("H1_2_rem")));
                param.put("H2_rem", c.getString(	c.getColumnIndex("H2_rem")));
                param.put("H3_rem", c.getString(	c.getColumnIndex("H3_rem")));
                param.put("H4_rem", c.getString(	c.getColumnIndex("H4_rem")));
                param.put("H4_1_rem", c.getString(	c.getColumnIndex("H4_1_rem")));
                param.put("H4_2_rem", c.getString(	c.getColumnIndex("H4_2_rem")));
                param.put("H5_rem", c.getString(	c.getColumnIndex("H5_rem")));
                param.put("H6_rem", c.getString(	c.getColumnIndex("H6_rem")));
                param.put("H7_rem", c.getString(	c.getColumnIndex("H7_rem")));
                param.put("H8_rem", c.getString(	c.getColumnIndex("H8_rem")));
                param.put("H8_2_rem", c.getString(	c.getColumnIndex("H8_2_rem")));
                param.put("I1_rem", c.getString(	c.getColumnIndex("I1_rem")));
                param.put("I2_rem", c.getString(	c.getColumnIndex("I2_rem")));
                param.put("I3_rem", c.getString(	c.getColumnIndex("I3_rem")));
                param.put("I4_rem", c.getString(	c.getColumnIndex("I4_rem")));
                param.put("J1_rem", c.getString(	c.getColumnIndex("J1_rem")));
                param.put("J2_rem", c.getString(	c.getColumnIndex("J2_rem")));
                param.put("J3_rem", c.getString(	c.getColumnIndex("J3_rem")));
                param.put("J4_rem", c.getString(	c.getColumnIndex("J4_rem")));
                param.put("J5_rem", c.getString(	c.getColumnIndex("J5_rem")));
                param.put("J6_rem", c.getString(	c.getColumnIndex("J6_rem")));
                param.put("J7_rem", c.getString(	c.getColumnIndex("J7_rem")));
                param.put("K1_rem", c.getString(	c.getColumnIndex("K1_rem")));
                param.put("K2_rem", c.getString(	c.getColumnIndex("K2_rem")));
                param.put("K3_rem", c.getString(	c.getColumnIndex("K3_rem")));
                param.put("K4_rem", c.getString(	c.getColumnIndex("K4_rem")));
                param.put("K5_rem", c.getString(	c.getColumnIndex("K5_rem")));
                param.put("K6_rem", c.getString(	c.getColumnIndex("K6_rem")));
                param.put("K7_rem", c.getString(	c.getColumnIndex("K7_rem")));
                param.put("pk_pk", Global.server_id);

            }

        }
        //endregion


        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        String urlString = new MyPreferences(mContext).getReq3();

        URL url;
        HttpURLConnection connection;

        try {
            url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            // connection.setRequestMethod("GET");
            connection.setConnectTimeout(1000);

            OutputStream os = connection.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

            bw.write(PostRequestData.getData(param));
            bw.flush();


            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String st = "", line;
                while ((line = br.readLine()) != null) {
                    st = st + line;
                }
                return st;
            } else {
                mUserMsg = "Server Couldn't process the request";
            }
        } catch (MalformedURLException e) {
            Toast.makeText(mContext, e.toString(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {


            mUserMsg = "Please make sure that Internet connection is available," +
                    " and server IP is inserted in settings";
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Object o) {


        try {
            dialog.dismiss();

            if (mUserMsg != null)
                throw new IOException();


            //int houseId = Integer.parseInt(((String) o).replace("\"",""));

            String result = (((String) o).replace("\"", ""));


            Toast.makeText(mContext, "Request 3  Has ben Uploaded", Toast.LENGTH_SHORT).show();

            Update_Status_Tabl1();



        } catch (IOException e) {
            //if connection was available via connecting but
            //we can't get data from server..
            if (mUserMsg == null)
                mUserMsg = "Please check connection";
            dialog.dismiss();
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
            mUserMsg = e.getMessage();
            dialog.dismiss();
        } catch (Exception e) {
            Toast.makeText(mContext, "Uploading failed at request 1", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
            return;
        } finally {
            if (mUserMsg != null)
                Toast.makeText(mContext, mUserMsg, Toast.LENGTH_SHORT).show();
        }


        super.onPostExecute(o);
    }





    void Update_Status_Tabl1() {

        String query = "update  tabl1  set Interview_status='2' where id="+Global.global_id;


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


