package com.autodesk.forge.forgeviewer_android_sample;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.TextView;

import com.autodesk.client.ApiException;
import com.autodesk.client.ApiResponse;
import com.autodesk.client.model.Job;
import com.autodesk.client.model.JobPayload;
import com.autodesk.client.model.JobPayloadInput;
import com.autodesk.client.model.JobPayloadItem;
import com.autodesk.client.model.JobPayloadOutput;
import com.autodesk.client.model.Manifest;

import org.apache.commons.codec.binary.Base64;

import java.util.Arrays;
import java.util.List;


public class AsyncConverter extends AsyncTask<List<String>, String, Void> {


    private Main3Activity activity2;

    //indicate whether the task completed
    private  String responseStr = "";
    //initialize progress dialog

    private ProgressDialog progress2;

    //text view of job progress
    private TextView jobProgressView = null;
    //text view of status
    private TextView statusView = null;


    public AsyncConverter(ProgressDialog p, Main3Activity a) {

        this.progress2 = p;
        this.activity2 = a;
        statusView = (TextView)activity2.findViewById(R.id.textViewStatus1);
        jobProgressView = (TextView)activity2.findViewById(R.id.textviewpostjob1);

    }

    public void onPreExecute() {

        progress2.show();

        statusView.setText("working for post job.....");

    }

    // task completed
    public void onPostExecute(Void unused) {

        progress2.dismiss();

//        Toast.makeText(
//                _activity.getApplicationContext(),
//                _responseStr,
//                Toast.LENGTH_LONG).show();
    }

    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        if (values != null && values.length > 0) {

            statusView.setText(values[0]);

            if(values.length>1)
                jobProgressView.setText(values[1]);
        }
    }

    @Override
    protected Void doInBackground(List<String>... params) {


        try {



            JobPayload job = new JobPayload();

            byte[] urnBase64 = Base64.encodeBase64(Global.URN.getBytes());
            String base64Str = new String(urnBase64);
            Global.base64URN = base64Str;

            JobPayloadInput input = new JobPayloadInput();
            input.setUrn(base64Str);


            JobPayloadOutput output = new JobPayloadOutput();
            JobPayloadItem formats = new JobPayloadItem();
            formats.setType(JobPayloadItem.TypeEnum.SVF);
            formats.setViews(Arrays.asList(JobPayloadItem.ViewsEnum._3D));
            output.setFormats(Arrays.asList(formats));

            job.setInput(input);
            job.setOutput(output);

            ApiResponse<Job> response = Global.derivativesApi.translate(job, true,
                    Global.oauth2TwoLegged, Global.twoLeggedCredentials);


            String[] values = new String[2];
            values[0]= "Post Job Succeeded!";
            values[1]= "Started to translate...";
            publishProgress(values);

            boolean isComplete = false;
            ApiResponse<Manifest> response_status = null;

            long startTime = System.currentTimeMillis();

            while(!isComplete){
                response_status = Global.derivativesApi.getManifest(base64Str,null,
                        Global.oauth2TwoLegged,Global.twoLeggedCredentials);
                Manifest manifest = response_status.getData();
                if(response_status.getData().getProgress().equals("complete")){
                    isComplete = true;
                    responseStr ="translation completed!";

                    values[0]= "Started to translate...";
                    values[1]= "Progress:" + response_status.getData().getProgress();
                    publishProgress(values);
                }
                else{
                    Thread.sleep(2000);

                    values[0]= "Started to translate...";
                    values[1]= "Progress:" + response_status.getData().getProgress();
                    publishProgress(values);

                    long currentTime = System.currentTimeMillis();
                    if(currentTime - startTime > 3000000){

                        //wait for 5 minutes
                        responseStr ="time out!";
                        break;
                    }

                }
            }

        }
        catch(ApiException ae){
            responseStr ="Failed to post job " + ae.toString();
        }
        catch(Exception ex){
            responseStr ="Failed to post job " + ex.toString();
        }
        finally{

            publishProgress(responseStr);
        }
        return null;
    }
}
