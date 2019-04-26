package com.autodesk.forge.forgeviewer_android_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Button goto_viewer;
//    private Button goto_bluetooth;
//    private Button goto_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        goto_viewer = (Button)findViewById(R.id.button6);
        goto_viewer.setOnClickListener(new View.OnClickListener()
                                       {
                                         // @Override
                                         public void onClick(View v)
                                         {
                                             sendViewer();
                                         }
                                       }
        );

        // yet to be implemented:

//        goto_bluetooth = (Button)findViewById(R.id.button5);
//        goto_bluetooth.setOnClickListener(new View.OnClickListener()
//                                          {
//                                              // @Override
//                                              public void onClick(View v)
//                                              {
//                                                  sendBluetooth();
//                                              }
//                                          }
//        );
//
//        goto_settings = (Button)findViewById(R.id.button7);
//        goto_settings.setOnClickListener(new View.OnClickListener()
//                                       {
//                                           // @Override
//                                           public void onClick(View v)
//                                           {
//                                               sendSettings();
//                                           }
//                                       }
//        );
    }


    public void sendViewer()
    {
        Intent startViewer = new Intent(this, ViewerActivity.class); // 'ViewerActivity' should be updated...
        startActivity(startViewer);
    }

    // 'BluetoothActivity' not yet created...
    public void sendBluetooth()
    {
        // Intent startBluetooth = new Intent(this, BluetoothActivity.class);
        // startIntent(startBluetooth);
    }

    // 'SettingsActivity' not yet created...
    public void sendSettings()
    {
        // Intent startSettings = new Intent(this, SettingsActivity.class);
        // startIntent(startSettings);
    }
}
