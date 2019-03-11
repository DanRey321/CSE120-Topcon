package com.example.danielreyes.topconp1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class HomePage extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);

        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);



    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.button1:
                Intent intent = new Intent(HomePage.this, bluetooth.class);
                startActivity(intent);
                break;

            //case R.id.button2:
            //    Intent intent2 = new Intent(HomePage.this, Viewer.class);
            //    startActivity(intent2);
            //    break;

        }



    }



}
