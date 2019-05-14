package utils;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import data.LocalDataManager;

/**
 * Created by prabeesh on 7/14/2015.
 */
public class BackgroundTask2 extends AsyncTask<String, Void, String> {

    AlertDialog alertDialog;
    Context     ctx;
    View view;

    Button btn;
    double current_version;

    public BackgroundTask2(Context ctx, Button update_btn, double appVersion) {
        this.ctx = ctx;
        btn = update_btn;
        current_version = appVersion;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... params) {

        String login_url = "http://43.245.131.159:8080/uendashboard/sm/index.php/Welcome/collect_Response2";
        //final String login_url = "http://192.168.1.141/sm/Welcome/collect_Response2";
        String method = params[0];

        if (method.equals("check_app_update")) {

            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("current_version", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(current_version), "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "";
                String line = "";
                if ((line = bufferedReader.readLine()) != null) {

                    response += line;

                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {

        if (result != null && !result.isEmpty()) {

            btn.setEnabled(true);
            btn.setBackgroundColor(0xFFFF0000);
            //Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();

        } else {

            btn.setEnabled(false);
            //Toast.makeText(ctx, "Nahi Hai Value", Toast.LENGTH_LONG).show();
        }
    }
}
