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
import java.util.Map;
import java.util.stream.Collectors;

import utils.MyPreferences;
import utils.PostRequestData;

/**
 * Created by Umeed-e-Nau on 12/28/2016.
 */
public class UploadF1F2SectionB extends AsyncTask {

    Context mContext;
    public static ProgressDialog dialog;
    HashMap<String, String> param;
    String[] interviewLogData;
    String mUserMsg;

    public UploadF1F2SectionB(Context context) {



        mContext = context;
        dialog = new ProgressDialog(context);
        param = new HashMap<>();

    }


    @Override
    protected void onPreExecute() {

        dialog.setMessage("Uploading interview Please wait ....");
        dialog.setCancelable(false);
        dialog.show();


        int ccc=0;



        String Fk_id="";

        //region Query

        String query = "select * from TableF1SectionC as F1 join TableHHSection as H on F1.Fk_id=H.id  where F1.LhwSectionPKId='"+Global.global_id+"'";




        LocalDataManager Lm = new LocalDataManager(mContext);
        Cursor c = Lm.database.rawQuery(query, null);



        if (c != null) {
            if (c.moveToFirst()) {


                Global.loop_count=c.getCount();
                do {


                if(ccc==Global.loop_Increment) {

    param.put("lhwf1c1", c.getString(c.getColumnIndex("lhwf1c1")));
    param.put("lhwf1c2", c.getString(c.getColumnIndex("lhwf1c2")));
    param.put("lhwf1c3", c.getString(c.getColumnIndex("lhwf1c3")));
    param.put("lhwf1c4", c.getString(c.getColumnIndex("lhwf1c4")));
    param.put("lhwf1c5", c.getString(c.getColumnIndex("lhwf1c5")));
    param.put("lhwf1c6", c.getString(c.getColumnIndex("lhwf1c6")));
    param.put("lhwf1c7", c.getString(c.getColumnIndex("lhwf1c7")));
    param.put("lhwf1c8", c.getString(c.getColumnIndex("lhwf1c8")));

    param.put("lhwf1b1", c.getString(c.getColumnIndex("lhwf1b1")));
    param.put("lhwf1b2", c.getString(c.getColumnIndex("lhwf1b2")));
    param.put("lhwf1b3", c.getString(c.getColumnIndex("lhwf1b3")));

    Fk_id = c.getString(0);
               }
                    ccc++;


                } while (c.moveToNext());
            }

        }
        else
        {
            param.put("lhwf1c1", "00");
            param.put("lhwf1c2", "00");
            param.put("lhwf1c3", "00");
            param.put("lhwf1c4", "00");
            param.put("lhwf1c5", "00");
            param.put("lhwf1c6", "00");
            param.put("lhwf1c7", "00");
            param.put("lhwf1c8", "00");
            param.put("lhwf1b1", "00");
            param.put("lhwf1b2", "00");
            param.put("lhwf1b3", "00");


        }






        String query2 = "select * from TableF2SectionC where LhwSectionPKId='"+Global.global_id+"' and Fk_id='"+Fk_id+"'";




        LocalDataManager Lm2 = new LocalDataManager(mContext);
        Cursor c2 = Lm2.database.rawQuery(query2, null);


        int a= c2.getCount();
        if (c2 != null && c2.getCount()!=0) {
            if (c2.moveToFirst()) {

                param.put("lhwf2c2", c2.getString(	c2.getColumnIndex("lhwf2c2")));
                param.put("lhwf2c3", c2.getString(	c2.getColumnIndex("lhwf2c3")));
                param.put("lhwf2c4", c2.getString(	c2.getColumnIndex("lhwf2c4")));
                param.put("lhwf2c5", c2.getString(	c2.getColumnIndex("lhwf2c5")));
                param.put("lhwf2c6", c2.getString(	c2.getColumnIndex("lhwf2c6")));
                param.put("lhwf2c7", c2.getString(	c2.getColumnIndex("lhwf2c7")));
                param.put("lhwf2c8", c2.getString(	c2.getColumnIndex("lhwf2c8")));
                param.put("lhwf2c9", c2.getString(	c2.getColumnIndex("lhwf2c9")));
                param.put("lhwf2c10", c2.getString(	c2.getColumnIndex("lhwf2c10")));
                param.put("lhwf2c11", c2.getString(	c2.getColumnIndex("lhwf2c11")));
                param.put("LhwSectionPKId",Global.server_id );


            }

        }
        else
        {

            param.put("lhwf2c2", "00");
            param.put("lhwf2c3", "00");
            param.put("lhwf2c4", "00");
            param.put("lhwf2c5", "00");
            param.put("lhwf2c6", "00");
            param.put("lhwf2c7", "00");
            param.put("lhwf2c8", "00");
            param.put("lhwf2c9", "00");
            param.put("lhwf2c10","00");
            param.put("lhwf2c11","00");
            param.put("LhwSectionPKId",Global.server_id );


        }



        if(param.containsValue(null))
        {

            for(Map.Entry<String, String > entry : param.entrySet()){
                if (entry.getValue() == null) {
                    param.put(entry.getKey(),"00");
                }
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            }
        }


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

        //    String result = (((String) o).replace("\"", ""));


          ///  Toast.makeText(mContext, "Interivew Has ben Uploaded", Toast.LENGTH_SHORT).show();
            // new LocalDataManager(mContext).uploadInterview();

      //      Global.server_id=result;



            Global.loop_Increment++;

            if(Global.loop_count!=Global.loop_Increment) {



                new UploadF1F2SectionB(mContext).execute();
            }
            else
            {
                Global.loop_Increment=0;
                Global.loop_count=0;

            }


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
        }


      /*  catch (Exception e) {
            Toast.makeText(mContext, "Uploading failed at request 2", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
            return;
        }

        */
        finally {
            if (mUserMsg != null)
                Toast.makeText(mContext, mUserMsg, Toast.LENGTH_SHORT).show();
        }


        super.onPostExecute(o);
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


