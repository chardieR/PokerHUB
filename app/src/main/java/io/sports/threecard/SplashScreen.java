package io.sports.threecard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.kaiguanjs.SplashLietener;
import com.kaiguanjs.utils.YQCUtils;

public class SplashScreen extends AppCompatActivity {

    ImageView splashActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        // splash screen full screen
        splashActivity = findViewById(R.id.splashactivity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        YQCUtils.splashAction(this, new SplashLietener() {
            @Override
            public void startMySplash(int version, String downUrl) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(SplashScreen.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },3000);

            }
        });
    }
}

