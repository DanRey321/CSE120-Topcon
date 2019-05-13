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

    private Button goto_viewer;
    private Button goto_FAQ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        goto_viewer = (Button) findViewById(R.id.spanish);
        goto_viewer.setOnClickListener(new View.OnClickListener() {
                                           // @Override
                                           public void onClick(View v) {
                                               sendSpanishViewer();
                                           }
                                       }
        );

        goto_FAQ = (Button) findViewById(R.id.faqs);
        goto_FAQ.setOnClickListener(new View.OnClickListener() {
                                           // @Override
                                           public void onClick(View v) {
                                               sendFAQs();
                                           }
                                       }
        );


    }

    public void sendSpanishViewer()
    {
        Intent Spanish = new Intent(this, SpanishViewer.class);
        startActivity(Spanish);
    }

    public void sendFAQs()
    {
        Intent Spanish = new Intent(this, FAQ.class);
        startActivity(Spanish);
    }

}


