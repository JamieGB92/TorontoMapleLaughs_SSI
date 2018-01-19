package com.company.torontomaplelaughs.ssi;

/**
 * Created by J on 10/7/2017.
 */

import com.company.torontomaplelaughs.androidgames.framework.Game;
import com.company.torontomaplelaughs.androidgames.framework.Graphics;
import com.company.torontomaplelaughs.androidgames.framework.Input.TouchEvent;
import com.company.torontomaplelaughs.androidgames.framework.Pixmap;
import com.company.torontomaplelaughs.androidgames.framework.Screen;


import java.util.List;



public class HighScore extends Screen {

    private static Pixmap background;
    private static Pixmap title;
    private static Pixmap mainMenuButton;
    private static Pixmap Leaderboard;
    private static Pixmap Achievements;

    private int LeaderXpos;
    private int LeaderYpos=1000;

    private int AchieveXpos;
    private int AchieveYpos=900;

    private int mainMenuXpos=300;
    private int mainMenuYpos=1200;

    String lines[] = new String[5];

    public HighScore(Game game)
    {
        super(game);

        for (int i = 0; i < 5; i++) {
            lines[i] = "" + (i+1) + ". " + Settings.highscores[i];
        }
        Graphics g=game.getGraphics();

        background=g.newPixmap("bg.png",Graphics.PixmapFormat.RGB565);
        mainMenuButton=g.newPixmap("mainmenu.png",Graphics.PixmapFormat.ARGB4444);
        Achievements=g.newPixmap("Achievements.png", Graphics.PixmapFormat.RGB565);
        Leaderboard=g.newPixmap("Leaderboard.png", Graphics.PixmapFormat.RGB565);
        title=g.newPixmap("hs_but.png",Graphics.PixmapFormat.RGB565);

    }


    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();

        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if (inBounds(event, mainMenuXpos, mainMenuYpos, mainMenuButton.getWidth(), mainMenuButton.getHeight())) {
                    game.setScreen(new MaineMenuSceen(game));
                }
                if (inBounds(event, LeaderXpos, LeaderYpos, Leaderboard.getWidth(), Leaderboard.getHeight())) {
                    game.showLeaderboard();
                    return;
                }
                if (inBounds(event, AchieveXpos, AchieveYpos, Achievements.getWidth(), Achievements.getHeight())) {
                    game.showAchievements();
                    return;

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
        g.drawPixmap(title,g.getWidth()/2-title.getWidth()/2,50);
        g.drawPixmap(mainMenuButton,mainMenuXpos,mainMenuYpos);
        g.drawPixmap(Achievements,g.getWidth()/2-Achievements.getWidth()/2,AchieveYpos);
        g.drawPixmap(Leaderboard,g.getWidth()/2-Leaderboard.getWidth()/2,LeaderYpos);

        int y= 100;
        for (int i= 0; i<5 ;i++) {
            drawText(g, lines[i], 170, y);
            y+=30;
        }
    }

    public void drawText(Graphics g, String line, int x, int y) {
        int len = line.length();
        for (int i = 0;i<len; i++) {
            char character = line.charAt(i);

            if (character == ' '){
                x+= 20;
                continue;
            }

            int srcX=0;
            int srcWidth = 0;
            if(character == '.') {
                srcX = 200;
                srcWidth = 10;
            } else {
                srcX = (character - '0') * 20;
                srcWidth = 20;
            }

            g.drawPixmap(Assets.numbers, x, y, srcX, 0, srcWidth, 32);
            x+= srcWidth;
        }
    }
}
