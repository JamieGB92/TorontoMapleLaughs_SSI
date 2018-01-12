package com.company.torontomaplelaughs.safespaceinvaders;

/**
 * Created by J on 10/7/2017.
 */

import com.company.torontomaplelaughs.androidgames.framework.Game;
import com.company.torontomaplelaughs.androidgames.framework.Graphics;
import com.company.torontomaplelaughs.androidgames.framework.Input.TouchEvent;
import com.company.torontomaplelaughs.androidgames.framework.Pixmap;
import com.company.torontomaplelaughs.androidgames.framework.Screen;

import java.util.List;

public class PauseScreen extends Screen {
    private static Pixmap background;
    private static Pixmap title;
    private static Pixmap ResumeButton;

    private int titleXpos;
    private int titleYpos;

    private int ResumeButtonXpos;
    private int ResumeButtonYpos=1000;

    public PauseScreen(Game game)
    {
        super(game);
        Graphics g= game.getGraphics();
        title=g.newPixmap("pause.png",Graphics.PixmapFormat.RGB565);
        ResumeButton=g.newPixmap("start_but.png",Graphics.PixmapFormat.ARGB4444);

        ResumeButtonXpos =  g.getWidth() / 2 - ResumeButton.getWidth() / 2;
    }
    public void update(float deltaTime)
    {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();

        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if(inBounds(event,ResumeButtonXpos,ResumeButtonYpos,ResumeButton.getWidth(),ResumeButton.getHeight()))
                {
                    game.setScreen(new GameScreen(game, GameScreen.GameState.Running));
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
        g.drawPixmap(title,g.getWidth()/2-title.getWidth()/2,0);
        g.drawPixmap(ResumeButton,ResumeButtonXpos,ResumeButtonYpos);

    }
}
