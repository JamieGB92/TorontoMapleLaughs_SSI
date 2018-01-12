package com.company.torontomaplelaughs.androidgames.framework;

public interface Game 
{
    public Input getInput();
    public FileIO getFileIO();
    public Graphics getGraphics();
    public Audio getAudio();
    public void setScreen(Screen screen);
    public Screen getCurrentScreen();
    public Screen getStartScreen();

    public boolean isSignedIn();
    public void signIn();
    public void submitScore (int score);
    public void showLeaderboard();
    public void showAchievements();
    public void showBanner();
    public void hideBanner();
    public void showInterstitialAd();





}

