package com.autodesk.forge.forgeviewer_android_sample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FilenameFilter;


public class ViewerActivity extends AppCompatActivity {

    private String[] mFileList1;
    private String[] mFileList2;
    private String[] mFileList3;
    private String mChosenFile1;

    private Button btn_browser_model;


    private static final int DIALOG_LOAD_FILE1 = 1000;
   // private static final int DIALOG_LOAD_FILE2 = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);

        btn_browser_model = (Button) findViewById(R.id.btnBrowserModel);
        btn_browser_model.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


            }
        });


    }




}
