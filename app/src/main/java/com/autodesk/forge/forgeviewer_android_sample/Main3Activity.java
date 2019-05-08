package com.autodesk.forge.forgeviewer_android_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;


public class Main3Activity extends AppCompatActivity {

    private Button goto_spanish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        goto_spanish = (Button) findViewById(R.id.button16);
        goto_spanish.setOnClickListener(new View.OnClickListener() {
                                            // @Override
                                            public void onClick(View v) {
                                                sendViewer();
                                            }
                                        }
        );


    }

    public void sendViewer()
    {
        Intent startViewerS = new Intent(this, ViewerSpanish.class);
        startActivity(startViewerS);
    }



}


