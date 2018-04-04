/***
 Developed by AKASH SINGH SENGAR ON 5TH APRIL 2018
 */
package com.paranormal.anandshashi.screenlock;

import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

public class FullScreen extends AppCompatActivity {

    private VideoView myVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_full_screen);

        myVideoView =  findViewById(R.id.videoView);
        myVideoView.setVideoURI(Uri.parse(("android.resource://" + getPackageName() + "/" + R.raw.pa)));
        myVideoView.start();
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            public void run() {
                finish();
            }
        }, 2000);
    }
}
