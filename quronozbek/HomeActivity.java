package com.asadulloh.quronozbek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4000;
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView logo, slogan, subSlogan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        // Animations
        Context context;
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //Hooks
        image = findViewById(R.id.imgWelcome);
        logo = findViewById(R.id.txtTitleWelcome);
        slogan = findViewById(R.id.txtSubtitleWelcome);
        subSlogan = findViewById(R.id.txtSubtitleWelcome2);

        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);
        subSlogan.setAnimation(bottomAnim);

        new Handler().postDelayed(() -> {
            Intent homeIntent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(homeIntent);
            finish();
        }, SPLASH_TIME_OUT);
    }
}
