package com.autodesk.forge.forgeviewer_android_sample;

/**
 * Created by xiaodongliang on 1/18/18.
 */

import android.os.AsyncTask;
import android.app.ProgressDialog;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;


import com.autodesk.client.ApiException;
import com.autodesk.client.auth.OAuth2TwoLegged;


public class AsyncGetToken extends AsyncTask<List<String>, String, Void>  {



    private ViewerActivity activity;
    private Main3Activity activity2;

    //indicate whether the task completed
    private  String responseStr = "";
    //initialize progress dialog
    private ProgressDialog progress;
    private ProgressDialog progress2;

    //text view of token
    private TextView tokenView = null;

    //text view of status
    private TextView statusView = null;



    public AsyncGetToken(ProgressDialog p, ViewerActivity a) {
        this.progress = p;
        this.activity = a;

        statusView = (TextView)activity.findViewById(R.id.textViewStatus);
        tokenView = (TextView)activity.findViewById(R.id.textViewToken);
    }
    //For Model Derivative Changer
    public AsyncGetToken(ProgressDialog p, Main3Activity a) {
        this.progress2 = p;
        this.activity2 = a;

        statusView = (TextView)activity.findViewById(R.id.textViewStatus);
        tokenView = (TextView)activity.findViewById(R.id.textViewToken);
    }

    public void onPreExecute() {
        progress.show();
        statusView.setText("working for get token.....");

    }



    // task completed
    public void onPostExecute(Void unused) {

        progress.dismiss();

//        Toast.makeText(
//                activity.getApplicationContext(),
//                responseStr,
//                Toast.LENGTH_LONG).show();
    }


    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        if (values != null && values.length > 0) {

            statusView.setText(values[0]);
            String tokenStr = values[1];
            //String tokenStrReturn = values[1];

            //if(tokenStr.length() > 10){
            //    tokenStr = tokenStr.substring(0,10);
              //  tokenStr += ".........";
           // }

            tokenView.setText(tokenStr);


        }
    }

    @Override
    protected Void doInBackground(List<String>... params) {

        String CLIENT_ID = Global.CLIENT_ID;
        String CLIENT_SECRET = Global.CLIENT_SECRET;
        List<String> scopes = new ArrayList<String>();

        scopes.add("data:read");
        scopes.add("data:write");
        scopes.add("bucket:create");
        scopes.add("bucket:read");

        try {

            //remove last token if any
            Global.token="";

            Global.oauth2TwoLegged = new OAuth2TwoLegged(CLIENT_ID, CLIENT_SECRET, scopes, true);

            Global.twoLeggedCredentials = Global.oauth2TwoLegged .authenticate();
            String token = Global.twoLeggedCredentials.getAccessToken();

            //update with the new token
            Global.token = token;
            responseStr = "get token Succeeded!";
        }
        catch(ApiException ae){
            responseStr ="Failed to get token" + ae.toString();
        }
        catch(Exception ex){
            responseStr ="Failed to get token" + ex.toString();
        }
        finally{
            String[] values = new String[2];
            values[0]= responseStr;
            values[1]= Global.token;
            publishProgress(values);
        }
        return null;
    }

}