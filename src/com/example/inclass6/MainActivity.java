package com.example.inclass6;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {
ProgressDialog pd;
Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new GetAsyncTaskApps(this).execute("http://itunes.apple.com/us/rss/topgrossingapplications/limit=25/json");

    }
}
