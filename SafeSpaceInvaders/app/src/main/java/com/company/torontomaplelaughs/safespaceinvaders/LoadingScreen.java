package com.company.torontomaplelaughs.safespaceinvaders;

/**
 * Created by J on 10/11/2017.
 */
import com.company.torontomaplelaughs.androidgames.framework.Game;
import com.company.torontomaplelaughs.androidgames.framework.Graphics;
import com.company.torontomaplelaughs.androidgames.framework.Graphics.PixmapFormat;
import com.company.torontomaplelaughs.androidgames.framework.Pixmap;
import com.company.torontomaplelaughs.androidgames.framework.Screen;


public class LoadingScreen extends Screen {
    public LoadingScreen(Game game){super(game);}

    @Override
    public void update(float deltaTime)
    {
        Graphics g=game.getGraphics();
        Assets.mainMenu_BG=g.newPixmap("bg.png",Graphics.PixmapFormat.RGB565);

        Assets.titleLogo=g.newPixmap("mainlogo.png", Graphics.PixmapFormat.RGB565);
        Assets.HowToPlay=g.newPixmap("HowToPlay.png", Graphics.PixmapFormat.RGB565);
        Assets.HTPInst=g.newPixmap("Instructions.png", Graphics.PixmapFormat.RGB565);
        Assets.playerShip=g.newPixmap("Standard.png",  Graphics.PixmapFormat.RGB565);
        Assets.projectile=g.newPixmap("projectile1.png",  Graphics.PixmapFormat.RGB565);
        Assets.damageBoost=g.newPixmap("projectile.gif",  Graphics.PixmapFormat.RGB565);
        Assets.gunPickup_1=g.newPixmap("weapon1.jpg",  Graphics.PixmapFormat.RGB565);
        Assets.gunPickup_2=g.newPixmap("weapon2.jpg",  Graphics.PixmapFormat.RGB565);
        Assets.gunPickup_3=g.newPixmap("weapon3.jpg",  Graphics.PixmapFormat.RGB565);
        Assets.gunPickup_4=g.newPixmap("Weapon1a.png",  Graphics.PixmapFormat.RGB565);
        Assets.healthBar=g.newPixmap("HealthBar.png", Graphics.PixmapFormat.RGB565 );
        Assets.healthPickup=g.newPixmap("healthPU.png",  Graphics.PixmapFormat.RGB565);
        Assets.healthPickup_B=g.newPixmap("healthPU_B.png",  Graphics.PixmapFormat.RGB565);
        Assets.shieldPickup=g.newPixmap("shieldPU.png",  Graphics.PixmapFormat.RGB565);
        Assets.mainMenulogo=g.newPixmap("mainmenu.png", Graphics.PixmapFormat.RGB565);
        Assets.soundEnabled=g.newPixmap("SoundEn.png", Graphics.PixmapFormat.RGB565);
        Assets.Checkoff=g.newPixmap("CheckOn.png", Graphics.PixmapFormat.RGB565);
        Assets.Checkon=g.newPixmap("CheckOn.png", Graphics.PixmapFormat.RGB565);
        Assets.Bomb=g.newPixmap("Bomb.png", Graphics.PixmapFormat.RGB565);
        //Assets.shieldPickup_B=g.newPixmap("shieldPU_B.png", Graphics.PixmapFormat.RGB565);
       // Assets.asteroid=g.newPixmap("Asteroid.png", Graphics.PixmapFormat.RGB565);
       // Assets.asteroid2=g.newPixmap("Asteroid2.jpg", Graphics.PixmapFormat.RGB565);
        //Assets.asteroid3=g.newPixmap("Asteroid3.png", Graphics.PixmapFormat.RGB565);
        Assets.storyScreen_BG=g.newPixmap("Space.png",Graphics.PixmapFormat.RGB565);
        Assets.Level1_BG=g.newPixmap("SpaceBlue.png",Graphics.PixmapFormat.RGB565);
        Assets.Level1_Enemy=g.newPixmap("snowflakeship.png",Graphics.PixmapFormat.RGB565);
        Assets.Level2_BG=g.newPixmap("SpaceRed.jpg",Graphics.PixmapFormat.RGB565);
        Assets.Level2_Enemy=g.newPixmap("isisship.png",Graphics.PixmapFormat.RGB565);
        Assets.Level3_BG=g.newPixmap("SpaceWhite.jpg",Graphics.PixmapFormat.RGB565);
        Assets.Level3_Enemy=g.newPixmap("mexicanship.png",Graphics.PixmapFormat.RGB565);
        Assets.GameOver_BG=g.newPixmap("GameOver.png",Graphics.PixmapFormat.RGB565);
        Assets.GameOver_Text=g.newPixmap("GameOverText.png",Graphics.PixmapFormat.RGB565);
        Assets.Level1Text=g.newPixmap("Level1Text.png", PixmapFormat.RGB565);
        Assets.Level2Text=g.newPixmap("Level2Text.png", PixmapFormat.RGB565);
        Assets.Level3Text=g.newPixmap("Level3Text.png", PixmapFormat.RGB565);
        Assets.BossWin=g.newPixmap("BossText.png", PixmapFormat.RGB565);
        Assets.Continue=g.newPixmap("Continue.png", PixmapFormat.RGB565);
        Assets.explosionA_Placeholder=g.newPixmap("explosion1.png",Graphics.PixmapFormat.RGB565);
        Assets.explosionB_Placeholder=g.newPixmap("explosion2.png",Graphics.PixmapFormat.RGB565);
        Assets.explosionC_Placeholder=g.newPixmap("explosion3.png",Graphics.PixmapFormat.RGB565);
        Assets.highScoreLogo=g.newPixmap("hs_but.png", PixmapFormat.RGB565);
        Assets.scoreLogo=g.newPixmap("scoreLogo.png", PixmapFormat.RGB565);
        Assets.startLogo=g.newPixmap("start_but.png", PixmapFormat.RGB565);
        Assets.pauseLogo=g.newPixmap("pause.png", PixmapFormat.RGB565);
        Assets.highScoreLogo=g.newPixmap("hs_but.png", PixmapFormat.RGB565);
        Assets.Achievements=g.newPixmap("Achievements.png", PixmapFormat.RGB565);
        Assets.Leaderboard=g.newPixmap("Leaderboard.png", PixmapFormat.RGB565);
        Assets.fireButton=g.newPixmap("fireButton.png",PixmapFormat.RGB565);
        Assets.numbers=g.newPixmap("numbers.png",PixmapFormat.RGB565);
       Assets.gunShot_sound = game.getAudio().newSound("Projectile.mp3");
        //Assets.playerDeath_sound = game.getAudio().newSound("");
       Assets.explosion_sound = game.getAudio().newSound("EnemyDeath.mp3");
       // Assets.healthPickup_sound = game.getAudio().newSound("");
      //  Assets.shieldPickup_sound = game.getAudio().newSound("");
       // Assets.gunPickup_sound = game.getAudio().newSound("");
       // Assets.mainMenu_music = game.getAudio().newMusic("");
      //  Assets.Level1_music = game.getAudio().newMusic("");
       // Assets.Level2_music = game.getAudio().newMusic("");
       // Assets.Level3_music =game. getAudio().newMusic("");
      Assets.DeathScreen_music = game.getAudio().newMusic("GameOverScreen.wav");

        game.setScreen(new MaineMenuSceen(game));
        game.showBanner();

        Settings.load(game.getFileIO());


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
    public void present(float deltaTime) {

    }
}
