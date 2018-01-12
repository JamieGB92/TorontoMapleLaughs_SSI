package com.company.torontomaplelaughs.androidgames.framework.impl;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.company.torontomaplelaughs.androidgames.framework.Audio;
import com.company.torontomaplelaughs.androidgames.framework.FileIO;
import com.company.torontomaplelaughs.androidgames.framework.Game;
import com.company.torontomaplelaughs.androidgames.framework.Graphics;
import com.company.torontomaplelaughs.androidgames.framework.Input;
import com.company.torontomaplelaughs.androidgames.framework.Screen;
import com.company.torontomaplelaughs.safespaceinvaders.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameActivity;

public abstract class AndroidGame extends BaseGameActivity implements Game {
    AndroidFastRenderView renderView;
    Graphics graphics;
    Audio audio;
    Input input;
    FileIO fileIO;
    Screen screen;
    AdView adView;
    InterstitialAd mInterstitialAd;

    static final int REQUEST_LEADERBOARD = 100;
    static final int REQUEST_ACHIEVEMENTS = 200;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);



        boolean isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        int frameBufferWidth = isLandscape ? 1280 : 800;
        int frameBufferHeight = isLandscape ? 800 : 1280;
        Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth, frameBufferHeight, Config.RGB_565);
        
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        
        // determine the scale based on our framebuffer and our display sizes
        float scaleX = (float) frameBufferWidth / size.x;
        float scaleY = (float) frameBufferHeight / size.y;

        renderView = new AndroidFastRenderView(this, frameBuffer);
        graphics = new AndroidGraphics(getAssets(), frameBuffer);
        fileIO = new AndroidFileIO(getAssets());
        audio = new AndroidAudio(this);
        input = new AndroidInput(this, renderView, scaleX, scaleY);
        MobileAds.initialize(this, "ca-app-pub-1631805669376332~2539146087");

        adView=new AdView(this);
        adView.setAdUnitId(getString(R.string.Main_Menu));
        adView.setAdSize(AdSize.SMART_BANNER);

        RelativeLayout mainLayout = new RelativeLayout(this);
        mainLayout.addView(renderView);

        RelativeLayout.LayoutParams adParams = new RelativeLayout.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        adParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        mainLayout.addView(adView, adParams);

        setContentView(mainLayout);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1631805669376332/1694512866");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
        screen = getStartScreen();



    }

    public boolean isSignedIn() {
        return getGameHelper().isSignedIn();
    }
    public void signIn() {
        getGameHelper().beginUserInitiatedSignIn();
    }
    public void submitScore(int score) {
        Games.Leaderboards.submitScore(getGameHelper().getApiClient(),
                getString(R.string.leaderboard_most_badass_killas_around),score);

    }
    public void showLeaderboard() {
        startActivityForResult(Games.Leaderboards.getLeaderboardIntent(getApiClient(),
                getString(R.string.leaderboard_most_badass_killas_around)), REQUEST_LEADERBOARD);
    }

    public void showInterstitialAd() {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
            }
        });
    }

    public void showBanner(){
        this.runOnUiThread(new Runnable(){
            public void run() {

                adView.setVisibility(View.VISIBLE);
                adView.loadAd(new AdRequest.Builder().build());
            }
        });
    }

    public void hideBanner(){
        this.runOnUiThread(new Runnable() {
            public void run() {
                adView.setVisibility(View.GONE);
            }
        });
    }

    public void showAchievements() {
        startActivityForResult(Games.Achievements.getAchievementsIntent(getApiClient()),
                REQUEST_ACHIEVEMENTS);
        //Games.Achievements.unlock(getApiClient(),getString(R.string.achievement_fire_storm));
       // Games.Achievements.increment(getApiClient(),getString(R.string.achievement_fire_storm),1);
       // Games.Achievements.unlock(getApiClient(),getString(R.string.achievement_send_them_back));
        //Games.Achievements.increment(getApiClient(),getString(R.string.achievement_send_them_back),1);
       // Games.Achievements.unlock(getApiClient(),getString(R.string.achievement_kill_50_enemies));
       // Games.Achievements.increment(getApiClient(),getString(R.string.achievement_kill_50_enemies),1);
       // Games.Achievements.unlock(getApiClient(),getString(R.string.achievement_cold_as_icesis));
       // Games.Achievements.increment(getApiClient(),getString(R.string.achievement_cold_as_icesis),1);
       // Games.Achievements.unlock(getApiClient(),getString(R.string.achievement_melting_snowflakes));
        //Games.Achievements.increment(getApiClient(),getString(R.string.achievement_melting_snowflakes),1);
    }

    @Override
    public void onResume() {
        super.onResume();
        screen.resume();
        renderView.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        renderView.pause();
        screen.pause();

        if (isFinishing())
            screen.dispose();
    }



    @Override
    public Input getInput() {
        return input;
    }

    @Override
    public FileIO getFileIO() {
        return fileIO;
    }

    @Override
    public Graphics getGraphics() {
        return graphics;
    }

    @Override
    public Audio getAudio() {
        return audio;
    }

    @Override
    public void setScreen(Screen screen) {
        if (screen == null)
            throw new IllegalArgumentException("Screen is null");

        this.screen.pause();
        this.screen.dispose();
        screen.resume();
        screen.update(0);
        this.screen = screen;
    }
    
    public Screen getCurrentScreen() {
        return screen;
    }
}