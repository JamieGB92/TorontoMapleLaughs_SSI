package com.company.torontomaplelaughs.safespaceinvaders;

/**
 * Created by J on 10/6/2017.
 */
import android.app.ListActivity;

import com.company.torontomaplelaughs.androidgames.framework.Game;
import com.company.torontomaplelaughs.androidgames.framework.Graphics;
import com.company.torontomaplelaughs.androidgames.framework.Input.TouchEvent;
import com.company.torontomaplelaughs.androidgames.framework.Pixmap;
import com.company.torontomaplelaughs.androidgames.framework.Screen;

import java.util.List;

public class MaineMenuSceen extends Screen {
    private static Pixmap background;
    private static Pixmap title;
    private static Pixmap highScoreButton;
    private static Pixmap howtoplay;
    private static Pixmap playButton;



    private int playXPos;
    private int playYPos;

    private int highScoreXPos;
    private int highScoreYPos;

    private int howtoplayXPos;
    private int howtoplayYPos;

    public MaineMenuSceen(Game game) {
        super(game);
        Graphics g = game.getGraphics();
        background = g.newPixmap("bg.png", Graphics.PixmapFormat.RGB565);
        title=g.newPixmap("mainlogo.png",Graphics.PixmapFormat.RGB565);
        playButton = g.newPixmap("start_but.png", Graphics.PixmapFormat.ARGB4444);
        highScoreButton=g.newPixmap("hs_but.png",Graphics.PixmapFormat.ARGB4444);
        howtoplay=g.newPixmap("HowToPlay.png",Graphics.PixmapFormat.ARGB4444);

        playXPos = g.getWidth() / 2 - playButton.getWidth() / 2;
        playYPos = g.getHeight() / 2 - playButton.getHeight() / 2;

        highScoreXPos=playXPos;
        highScoreYPos=playYPos+highScoreButton.getHeight()*2;

        howtoplayXPos=playXPos;
        howtoplayYPos=highScoreYPos+howtoplay.getHeight()*2;




    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();



        int len = touchEvents.size();

        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if (inBounds(event, playXPos, playYPos, playButton.getWidth(), playButton.getHeight()))
                {
                    game.setScreen(new GameScreen(game));
                    game.hideBanner();
                    return;
                }

                if (inBounds(event, highScoreXPos, highScoreYPos, highScoreButton.getWidth(), highScoreButton.getHeight()))
                {
                    game.setScreen(new HighScore(game));
                    game.showInterstitialAd();
                    game.hideBanner();
                    return;
                }
                if (inBounds(event, howtoplayXPos, howtoplayYPos, howtoplay.getWidth(), howtoplay.getHeight()))
                {
                    game.setScreen(new HowToPlay(game));
                    game.hideBanner();
                    return;
                }
            }
        }

        Settings.load(game.getFileIO());
    }
    @Override
    public void present(float deltaTime)
    {
        Graphics g=game.getGraphics();
        g.drawPixmap(background,0,0);
        g.drawPixmap(title,g.getWidth()/2-title.getWidth()/2,0);
        g.drawPixmap(playButton,playXPos,playYPos);
        g.drawPixmap(highScoreButton,highScoreXPos,highScoreYPos);
        g.drawPixmap(howtoplay,g.getWidth()/2-howtoplay.getWidth()/2,howtoplayYPos);

    }
    @Override
    public void pause() { Settings.save(game.getFileIO());
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
    }
}

