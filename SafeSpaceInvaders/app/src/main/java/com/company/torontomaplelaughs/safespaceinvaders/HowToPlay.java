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


public class HowToPlay extends Screen {



    private static Pixmap background;
    private static Pixmap title;
    private static Pixmap mainMenuButton;
    private static Pixmap htpinst;

    private int htpinstXpos;
    private int htpinstYpos=500;



    private int titleXpos;
    private int titleYpos;

    private int mainMenuXpos;
    private int mainMenuYpos=1100;

    public HowToPlay (Game game)
    {
        super(game);
        Graphics g=game.getGraphics();
        background=g.newPixmap("bg.png",Graphics.PixmapFormat.RGB565);
        title=g.newPixmap("HowToPlay.png",Graphics.PixmapFormat.RGB565);
        mainMenuButton=g.newPixmap("mainmenu.png",Graphics.PixmapFormat.ARGB4444);
        htpinst=g.newPixmap("Instructions.png", Graphics.PixmapFormat.RGB565);




    }
    public void update(float deltaTime)
    {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();

        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_DOWN) {
                if(inBounds(event,mainMenuXpos,mainMenuYpos,mainMenuButton.getWidth()*2,mainMenuButton.getHeight()*2))
                {
                    game.setScreen(new MaineMenuSceen(game));
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
        g.drawPixmap(mainMenuButton,g.getWidth()/2-mainMenuButton.getWidth()/2,mainMenuYpos);
        g.drawPixmap(htpinst,g.getWidth()/2-htpinst.getWidth()/2,htpinstYpos);


    }
}
