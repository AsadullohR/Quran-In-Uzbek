package com.asadulloh.quronozbek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ViewPager mViewPager;
    Adapter mAdapter;
    List<Model> mModels;
    Integer[] colors = null;
    ArgbEvaluator mArgbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //==========================================================Card View

        mModels = new ArrayList<>();
        mModels.add(new Model(R.drawable.quranlogosd, "Qur'on",
                "Qur'on tafsiri o'zbek tilida\n" +
                        "Afzal Rafiqo'v tomonidan ovozli uslubda o'qib berildi\n\n"));
        mModels.add(new Model(R.drawable.tezkunda, "TEZ KUNDA", "\n\n\n"));
//        mModels.add(new Model(R.drawable.poster, "Poster", "Poster is any piece of printed paper"));
//        mModels.add(new Model(R.drawable.namecard, "Namecard", "Business cards are cards bearing"));

        mAdapter = new Adapter(mModels, this);

        mViewPager = findViewById(R.id.viewPager);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color2),
//                getResources().getColor(R.color.color3),
//                getResources().getColor(R.color.color4)
        };

        colors = colors_temp;
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (mAdapter.getCount() - 1) && position < (colors.length - 1)) {
                    mViewPager.setBackgroundColor(
                            (Integer) mArgbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                } else {
                    mViewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }


            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });
        mViewPager.setOnClickListener(this);

        //============================================================================AD

        MobileAds.initialize(this, getString(R.string.quron_app_id));
        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        adView.setVisibility(View.GONE);
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }
        });
        //============================================================================Button

        Button btnKirish = findViewById(R.id.btnKirish);
        btnKirish.setOnClickListener(this);

        //============================================================================Update

        AppUpdateChecker appUpdateChecker = new AppUpdateChecker(this);  //pass the activity in constructor
        appUpdateChecker.checkForUpdate(false); //mannual check false here

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SuraList.class);

        if (intent != null) {
//            Animation animation = AnimationUtils.loadAnimation(this, R.anim.mixed_anim);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Hali tayyor emas", Toast.LENGTH_LONG).show();
        }
    }
}
