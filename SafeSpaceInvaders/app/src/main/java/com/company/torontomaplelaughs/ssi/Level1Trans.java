package com.company.torontomaplelaughs.ssi;

import com.company.torontomaplelaughs.androidgames.framework.Game;
import com.company.torontomaplelaughs.androidgames.framework.Graphics;
import com.company.torontomaplelaughs.androidgames.framework.Input;
import com.company.torontomaplelaughs.androidgames.framework.Pixmap;
import com.company.torontomaplelaughs.androidgames.framework.Screen;

import java.util.List;

/**
 * Created by Zachary on 1/10/2018.
 */

public class Level1Trans extends Screen {
    private static Pixmap background;
    private static Pixmap Text;
    private static Pixmap Continue;

    private int TextXpos;
    private int TextYpos;

    private int ContinueXpos;
    private int ContinueYpos=1000;

    public Level1Trans(Game game)
    {
        super(game);
        Graphics g= game.getGraphics();
        background=g.newPixmap("GameOver.png", Graphics.PixmapFormat.RGB565);
        Text=g.newPixmap("Level1Text.png",Graphics.PixmapFormat.RGB565);
        Continue=g.newPixmap("Continue.png",Graphics.PixmapFormat.ARGB4444);

        ContinueXpos =  g.getWidth() / 2 - Continue.getWidth() / 2;
    }
    public void update(float deltaTime)
    {
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();

        for (int i = 0; i < len; i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event.type == Input.TouchEvent.TOUCH_UP) {
                if(inBounds(event,ContinueXpos,ContinueYpos,Continue.getWidth(),Continue.getHeight()))
                {
                    game.setScreen(new GameScreen(game, GameScreen.GameState.Runningb));
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
        g.drawPixmap(Text,g.getWidth()/2-Text.getWidth()/2,450);
        g.drawPixmap(Continue,ContinueXpos,ContinueYpos);

    }
}

