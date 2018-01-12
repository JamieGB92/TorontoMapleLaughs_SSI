package com.company.torontomaplelaughs.safespaceinvaders;

/**
 * Created by J on 10/7/2017.
 */

import android.graphics.Path;

import com.company.torontomaplelaughs.androidgames.framework.Game;
import com.company.torontomaplelaughs.androidgames.framework.Graphics;
import com.company.torontomaplelaughs.androidgames.framework.Input.TouchEvent;
import com.company.torontomaplelaughs.androidgames.framework.Pixmap;
import com.company.torontomaplelaughs.androidgames.framework.Screen;

import java.util.List;


public class Options extends Screen {



    private static Pixmap background;
    private static Pixmap title;
    private static Pixmap mainMenuButton;
    private static Pixmap soundEnabled;
    private static Pixmap Checkoff;
    private static Pixmap Checkon;

    private int CheckonXpos;
    private int CheckonYpos;

    private int CheckoffXpos;
    private int CheckoffYpos=550;

    private int soundEXpos;
    private int soundEYPos=400;

    private int titleXpos;
    private int titleYpos;

    private int mainMenuXpos=50;
    private int mainMenuYpos=1200;

    public Options(Game game)
    {
        super(game);
        Graphics g=game.getGraphics();
        background=g.newPixmap("bg.png",Graphics.PixmapFormat.RGB565);
        title=g.newPixmap("op_but.png",Graphics.PixmapFormat.RGB565);
        mainMenuButton=g.newPixmap("mainmenu.png",Graphics.PixmapFormat.ARGB4444);
        soundEnabled=g.newPixmap("SoundEn.png", Graphics.PixmapFormat.RGB565);

        Checkoff=g.newPixmap("CheckOn.png", Graphics.PixmapFormat.RGB565);
        //Checkon=g.newPixmap("CheckOn.png", Graphics.PixmapFormat.RGB565);


    }
    public void update(float deltaTime)
    {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();

        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if(inBounds(event,mainMenuXpos,mainMenuYpos,mainMenuButton.getWidth(),mainMenuButton.getHeight()))
                {
                    game.setScreen(new MaineMenuSceen(game));
                }

                if (event.type == TouchEvent.TOUCH_UP) {
                    if (inBounds(event, soundEXpos, soundEYPos, soundEnabled.getWidth(), soundEnabled.getHeight()))
                    {
                       if (Settings.soundEnabled = true)
                        {
                            Settings.soundEnabled = false;
                            return;

                        }else
                        {
                            Settings.soundEnabled = true;
                            return;
                        }
                    } Settings.save(game.getFileIO());

                }

            }
        }


    }
    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
    @Override
    public void present(float deltaTime)
    {
        Graphics g=game.getGraphics();
        g.drawPixmap(background,0,0);
        g.drawPixmap(title,g.getWidth()/2-title.getWidth()/2,0);
        g.drawPixmap(mainMenuButton,mainMenuXpos,mainMenuYpos);
        g.drawPixmap(soundEnabled,g.getWidth()/2-soundEnabled.getWidth()/2, soundEYPos);
        g.drawPixmap(Checkoff, g.getWidth()/2-Checkoff.getWidth()/2, CheckoffYpos);

    }
}
