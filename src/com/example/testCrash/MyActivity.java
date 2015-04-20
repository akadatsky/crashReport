package com.example.testCrash;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MyActivity extends Activity {

    private int zero = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        CrashReporter crashReporter = new CrashReporter(this, "Error: " + getPackageName() + " (" + Feedback.getPackageVersion(getApplicationContext()) + ")");
        Thread.setDefaultUncaughtExceptionHandler(crashReporter);

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Test", "test: " + 5 / zero);
            }
        });

    }
}
