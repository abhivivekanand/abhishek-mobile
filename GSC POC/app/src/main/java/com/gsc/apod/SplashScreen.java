package com.gsc.apod;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gsc.apod.R;

import java.lang.reflect.Method;

public class SplashScreen extends AppCompatActivity {

    private ImageView SplashScreenImage;
    private TextView appName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        SplashScreenImage = findViewById(R.id.SplashScreen);
        appName = findViewById(R.id.appname);
        Splashscreen splashscreen = new Splashscreen();
        splashscreen.start();
    }
    public class Splashscreen extends Thread{
        public void run(){
            try {
                Animation anima = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anima);
                SplashScreenImage.setAnimation(anima);
                appName.setAnimation(anima);
                sleep(1000*2);
                //Below code will test the device is compromised or not.
                if(isDeviceRooted()){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        finishAndRemoveTask();
                    }
                };
            }catch (Exception e){
                e.printStackTrace();
            }
            Intent intent = new Intent(getApplicationContext(),APODFragmentActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            SplashScreen.this.finish();


        }


    }
    //Below code will test the device is compromised or not.
    public boolean isDeviceRooted() {
        boolean isTestKeyFound = false;
        String buildTags = android.os.Build.TAGS;
        isTestKeyFound =  buildTags != null && buildTags.contains("test-keys");
        return isTestKeyFound;
    };
}