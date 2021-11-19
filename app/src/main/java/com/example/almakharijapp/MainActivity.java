package com.example.almakharijapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button , button2 , repo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openActivity2();

            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openActivity3();

            }
        });

        repo = (Button) findViewById(R.id.button3);
        repo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gotoURL("https://github.com/HumaaMustafa/AlMakharij");


            }
        });



    }

    private void gotoURL(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri) );
    }

    public void openActivity2()
    {
        Intent intent = new Intent(this , MainActivity2.class);
        startActivity(intent);

    }
    public void openActivity3()
    {
        Intent intent = new Intent(this , MainActivity3.class);
        startActivity(intent);

    }
}