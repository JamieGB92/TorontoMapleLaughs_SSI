package com.company.torontomaplelaughs.safespaceinvaders;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import com.company.torontomaplelaughs.androidgames.framework.Game;
import com.company.torontomaplelaughs.androidgames.framework.Graphics;
import com.company.torontomaplelaughs.androidgames.framework.Input.TouchEvent;
import com.company.torontomaplelaughs.androidgames.framework.Pixmap;
import com.company.torontomaplelaughs.androidgames.framework.Screen;

import java.util.List;

/**
 * Created by Zachary on 12/4/2017.
 */

public class GameOverScreen extends Screen {
    private static Pixmap GameOver_BG;
    private static Pixmap GameOver_Text;
    private static Pixmap mainMenuButton;

    int mainMenuButtonXpos;
    int mainMenuButtonYpos = 1000;

    int GameOver_TextXpos;
    int GameOver_TextYpos = 500;





    public GameOverScreen(Game game) {
        super(game);
        Graphics g = game.getGraphics();
        GameOver_BG = g.newPixmap("GameOver.png", Graphics.PixmapFormat.RGB565);
        GameOver_Text = g.newPixmap("GameOverText.png", Graphics.PixmapFormat.RGB565);
        mainMenuButton=Assets.mainMenulogo;

        mainMenuButtonXpos =  g.getWidth() / 2 - mainMenuButton.getWidth() / 2;
        GameOver_TextXpos = g.getWidth() / 2 - GameOver_Text.getWidth() / 2;

    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();

        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if (inBounds(event, mainMenuButtonXpos, mainMenuButtonYpos, mainMenuButton.getWidth(), mainMenuButton.getHeight())) {
                    game.setScreen(new MaineMenuSceen(game));
                    return;
                }
            }

        }

    }





    @Override
    public void present(float deltaTime)
    {
        Graphics g=game.getGraphics();
        g.drawPixmap(GameOver_BG,0,0);
        g.drawPixmap(mainMenuButton,mainMenuButtonXpos,mainMenuButtonYpos);
        g.drawPixmap(GameOver_Text,GameOver_TextXpos,GameOver_TextYpos);

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