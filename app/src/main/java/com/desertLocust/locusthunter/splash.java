package com.desertLocust.locusthunter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.AppLaunchChecker;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class splash extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        lottieAnimationView = findViewById(R.id.animate);
        textView = findViewById(R.id.text);
        lottieAnimationView.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
        textView.animate().translationY(1600).setDuration(1000).setStartDelay(4000);

        AppLauncher appLauncher = new AppLauncher();
        appLauncher.start();



    }
    private  class AppLauncher extends  Thread{
        public void run(){
            try {
                sleep(5000);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Intent intent = new Intent(splash.this, LogIn.class);
            startActivity(intent);
            splash.this.finish();
        }
    }

}