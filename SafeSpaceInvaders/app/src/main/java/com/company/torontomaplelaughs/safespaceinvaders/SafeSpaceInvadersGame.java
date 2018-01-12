package com.company.torontomaplelaughs.safespaceinvaders;

/**
 * Created by J on 10/6/2017.
 */

import com.company.torontomaplelaughs.androidgames.framework.Screen;
import com.company.torontomaplelaughs.androidgames.framework.impl.AndroidGame;



public class SafeSpaceInvadersGame extends AndroidGame {
    @Override
    public Screen getStartScreen() {
        return new LoadingScreen(this);//put the loading screen here
    }


    @Override
    public void onSignInFailed() {
    }
    @Override
    public void onSignInSucceeded(){

    }



}