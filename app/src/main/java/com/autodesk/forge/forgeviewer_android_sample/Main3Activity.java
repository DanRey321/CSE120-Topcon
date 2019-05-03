package com.autodesk.forge.forgeviewer_android_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ProgressDialog;
import android.os.Environment;
import android.app.Dialog;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.pm.*;
import android.support.v4.content.*;
import android.support.v4.app.ActivityCompat;
import android.content.Intent;
import android.net.Uri;


import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FilenameFilter;

public class Main3Activity extends AppCompatActivity {

    private Button goto_changer;
    private Button btn_get_token;
    private Button btn_create_bucket;
    private Button btn_browser_model;
    private Button btn_upload_model;
    private Button btn_post_job;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn_get_token = (Button)findViewById(R.id.btnGetToken);
        btn_get_token.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {

                    ProgressDialog progress = new ProgressDialog(Main3Activity.this);
                    AsyncGetToken task_gettoken =  new AsyncGetToken(progress, Main3Activity.this);
                    task_gettoken.execute();
                }
                catch(Exception ex){

                    Toast.makeText(
                            getApplicationContext(),
                            ex.toString(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_create_bucket = (Button)findViewById(R.id.btnCreateBucket);
        btn_create_bucket.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    ProgressDialog progress = new ProgressDialog(Main3Activity.this);
                    AsyncGetToken task_gettoken =  new AsyncGetToken(progress, Main3Activity.this);
                    task_gettoken.execute();
                    /*
                    ProgressDialog progress2 = new ProgressDialog(ViewerActivity.this);
                    AsyncCreateBucket task_createtoken =  new AsyncCreateBucket(progress2, ViewerActivity.this);
                    task_createtoken.execute();
                    */
                }
                catch(Exception ex){

                    Toast.makeText(
                            getApplicationContext(),
                            ex.toString(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_browser_model = (Button)findViewById(R.id.btnBrowserModel);
        btn_browser_model.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                loadFileList();
                myFileDialog(DIALOG_LOAD_FILE).show();
            }
        });

        btn_upload_model = (Button)findViewById(R.id.btnUploadModel);
        btn_upload_model.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (mChosenFile==null || mChosenFile=="")
                    return;

                ProgressDialog progress = new ProgressDialog(Main3Activity.this);
                AsyncUpload task_upload =  new AsyncUpload(progress, Main3Activity.this);
                task_upload.execute();
                /*
                ProgressDialog progress2 = new ProgressDialog(ViewerActivity.this);
                AsyncPostJob task_post_job =  new AsyncPostJob(progress2, ViewerActivity.this);
                task_post_job.execute();
                */

            }
        });

        btn_post_job = (Button)findViewById(R.id.btnPostJob);
        btn_post_job.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                ProgressDialog progress = new ProgressDialog(Main3Activity.this);
                AsyncConverter task_post_job =  new AsyncConverter(progress, Main3Activity.this);
                task_post_job.execute();

            }
        });


        //goto_changer = (Button)findViewById(R.id.Find);
        //goto_changer.setOnClickListener(new View.OnClickListener()
        //{
            // @Override
         //   public void onClick(View v)
          //  {
           //     sendChanger();
           // }
        //});

    }

   // public void sendChanger() {

   // }

    private void loadFileList() {


        //String xx = Environment.getExternalStorageDirectory() + "/";
        File mPath = new File(Environment.getExternalStorageDirectory() + "/DCIM/" );//+
        //getApplicationContext().getString(R.string.app_name));

        try {
            mPath.mkdirs();
        } catch (SecurityException e) {
            //Log.e(TAG, "unable to write on the sd card " + e.toString());
        }
        if (mPath.exists()) {
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String filename) {
                    //add your filter if needed
                    File sel = new File(dir, filename);
                    return true;
                }
            };
            mFileList = mPath.list(filter);
        } else {
            mFileList= new String[0];
        }
    }

    protected Dialog myFileDialog(int id) {
        Dialog dialog = null;
        AlertDialog.Builder builder = new Builder(this);

        switch (id) {
            case DIALOG_LOAD_FILE:
                builder.setTitle("Choose your file");
                if (mFileList == null) {
                    dialog = builder.create();
                    return dialog;
                }
                builder.setItems(mFileList, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        mChosenFile = mFileList[which];
                        TextView modelName = (TextView)findViewById(R.id.textViewModelName);
                        modelName.setText(mChosenFile);
                    }
                });

                break;
        }
        dialog = builder.show();
        return dialog;
    }

    private String[] mFileList;
    private String mChosenFile;
    private static final int DIALOG_LOAD_FILE = 1000;


}


