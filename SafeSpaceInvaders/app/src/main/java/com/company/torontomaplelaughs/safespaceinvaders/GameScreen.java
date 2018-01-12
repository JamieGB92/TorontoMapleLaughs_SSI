package com.company.torontomaplelaughs.safespaceinvaders;

/**
 * Created by J on 10/6/2017.
 */

//jamie: -add explosions to player and enimies
//       -add boss level
//       -add pick up that destorys all enimies
//       -pickups:functionality: sheild, health, shotgun
import android.view.SurfaceHolder;

import com.company.torontomaplelaughs.androidgames.framework.Game;
import com.company.torontomaplelaughs.androidgames.framework.Graphics;
import com.company.torontomaplelaughs.androidgames.framework.Input.TouchEvent;
import com.company.torontomaplelaughs.androidgames.framework.Input;
import com.company.torontomaplelaughs.androidgames.framework.Pixmap;
import com.company.torontomaplelaughs.androidgames.framework.Screen;
import com.google.android.gms.games.Games;

import java.util.Random;

import java.util.ArrayList;
import java.util.List;


public class GameScreen extends Screen {

    enum GameState {
        Ready,
        Running,
        Runningb,
        Runningc,
        Paused,
        GameOver
    }

    GameState state = GameState.Running;


    //region golabal quanities
    int mainMenuButtonXpos = 0;
    int mainMenuButtonYpos = 1250;
    int fireButtonXpos = 675;
    int firButtonYpos = 1100;
    int pauseButtonXpos = 365;
    int pauseButtonYpos = 1250;
    int projectileSpeed, projectilePosx, projectilePosy, BGspeed;
    int ECA_Spawner1_PosX = 200;
    int ECA_Spawner1_PosY = -200;
    int ECA_Spawner2_PosX = 400;
    int ECA_Spawner2_PosY = -200;
    int ECA_Spawner3_PosX = -50;
    int ECA_Spawner3_PosY = 300;
    int ECA_Spawner4_PosX = 750;
    int ECA_Spawner4_PosY = 750;
    int ECA2_Spawner1_PosX = -50;
    int ECA2_Spawner1_PosY = 200;
    int ECA2_Spawner2_PosX = -50;
    int ECA2_Spawner2_PosY = 400;
    int ECA2_Spawner3_PosX = -50;
    int ECA2_Spawner3_PosY = 600;
    int ECA2_Spawner4_PosX = 200;
    int ECA2_Spawner4_PosY = -200;
    int ECA2_Spawner5_PosX = 400;
    int ECA2_Spawner5_PosY = -200;
    int ECA2_Spawner6_PosX = 750;
    int ECA2_Spawner6_PosY = 400;
    int ECA2_Spawner7_PosX = 750;
    int ECA2_Spawner7_PosY = 800;
    int eMoveSpeed = 20;
    int eMoveSpeed2 = 40;
    int spawnChoose = 0;
    int eProjectileSpeedLv1 = 30;
    int eProjectileSpeedLv2 = 60;
    float spawnTime = 2.0f;
    float spawnTime2 = 4.0f;
    float fireRate = 20.0f;
    float fireRate2 = 6.0f;
    int score = 0;
    int numberOfLives = 3;
    float shotGunTimer = 0.0f;
    int old;

    private boolean hasShotgun() {
        if (shotGunTimer > 0) {
            return true;
        } else {
            return false;
        }
    }

    private float sheildTimer = 0.0f;
    private int numSheild = 0;

    private boolean hasSheild() {
        if (sheildTimer > 0 && numSheild > 0) {
            if (sheildTimer <= 0) {
                numSheild = 0;
                return false;
            }
            return true;

        } else {
            return false;
        }
    }

    private float timePassed = 0;
    private float puTime = 5.0f;
    private float pickTimer = 10.0f;
    //endregion

    //region global objects
    World world;
    private static Pixmap mainMenuButton;
    private static Pixmap fireButton;
    private static Pixmap pauseButton;
    private static Pixmap BackGroundPic;
    private static Pixmap BackGroundPic2;
    private static Pixmap BackGroundPic3;
    private static Pixmap playerPixmap;
    private static Pixmap healthPickup_B;
    private static Pixmap ShotGunPickup;
    private static Pixmap bombpickup;
    private static Pixmap SheildPickup;

    private static Pixmap lvl1EnimyPixmap;
    private static Pixmap lvl2EnimyPixmap;
    private static Pixmap lvl3EnimyPixmap;

    private static Pixmap projectilePic;

    Random random;
    //endregion

    public GameScreen(Game game) {
        super(game);
<<<<<<< HEAD
        world=new World();
        mainMenuButton=Assets.mainMenulogo;
        fireButton=Assets.fireButton;
        pauseButton=Assets.pauseLogo;
        playerPixmap=Assets.playerShip;
        BackGroundPic=Assets.Level1_BG;
        BackGroundPic2=Assets.Level2_BG;
        lvl1EnimyPixmap=Assets.Level1_Enemy;
        lvl2EnimyPixmap=Assets.Level2_Enemy;
        projectilePic=Assets.projectile;
        healthPickup_B=Assets.healthPickup_B;
        SheildPickup=Assets.shieldPickup;
        ShotGunPickup=Assets.gunPickup_4;
        world.m_BgList.add(new BackGround(0,0));
        world.m_BgList.add(new BackGround(0,-BackGroundPic.getHeight()));
        world.m_BgList.add(new BackGround(0,-BackGroundPic.getHeight()*2));
        world.m_BgList2.add(new BackGround(0,0));
        world.m_BgList2.add(new BackGround(0,-BackGroundPic2.getHeight()));
        world.m_BgList2.add(new BackGround(0,-BackGroundPic2.getHeight()*2));
        random=new Random();
        state=GameState.Running;
=======
        world = new World();
        mainMenuButton = Assets.mainMenulogo;
        fireButton = Assets.fireButton;
        pauseButton = Assets.pauseLogo;
        playerPixmap = Assets.playerShip;
        BackGroundPic = Assets.Level1_BG;
        BackGroundPic2 = Assets.Level2_BG;
        BackGroundPic3=Assets.Level3_BG;
        lvl1EnimyPixmap = Assets.Level1_Enemy;
        lvl2EnimyPixmap = Assets.Level2_Enemy;
        lvl3EnimyPixmap=Assets.Level3_Enemy;
        projectilePic = Assets.projectile;
        healthPickup_B = Assets.healthPickup_B;
        SheildPickup = Assets.shieldPickup;
        ShotGunPickup = Assets.gunPickup_4;
        bombpickup = Assets.Bomb;
        world.m_BgList.add(new BackGround(0, 0));
        world.m_BgList.add(new BackGround(0, -BackGroundPic.getHeight()));
        world.m_BgList.add(new BackGround(0, -BackGroundPic.getHeight() * 2));
        world.m_BgList2.add(new BackGround(0, 0));
        world.m_BgList2.add(new BackGround(0, -BackGroundPic2.getHeight()));
        world.m_BgList2.add(new BackGround(0, -BackGroundPic2.getHeight() * 2));
        random = new Random();
        state = GameState.Runningc;
>>>>>>> master

    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        float accelXval = game.getInput().getAccelX();
        float accelYval = game.getInput().getAccelY();

        if (state == GameState.Running) {
            updateRunning(touchEvents, accelXval, accelYval, deltaTime);
        }
        if (state == GameState.Runningb) {
            updateRunningb(touchEvents, accelXval, accelYval, deltaTime);
        }
        if (state == GameState.Runningc){
            updateRunningc(touchEvents, accelXval, accelYval, deltaTime);
        }

        if (state == GameState.Paused) {
            updatePaused(touchEvents);
            Settings.save(game.getFileIO());
            Settings.load(game.getFileIO());
        }

        if (state == GameState.GameOver) {
            game.setScreen(new GameOverScreen(game));
            Settings.save(game.getFileIO());
        }

    }

    private void updateRunning(List<TouchEvent> touchEvents, float m_AccelX, float m_AccelY, float deltaTime) {
        //region
        if (numberOfLives <= 0) {
            Settings.addScore(score);
            Settings.save(game.getFileIO());
            state = GameState.GameOver;

            if (Settings.soundEnabled)
                Assets.DeathScreen_music.play();
            game.submitScore(score);
        }

        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);

            if (event.type == TouchEvent.TOUCH_UP) {
                if (inBounds(event, mainMenuButtonXpos, mainMenuButtonYpos, mainMenuButton.getWidth(), mainMenuButton.getHeight() + 100)) {
                    game.setScreen(new MaineMenuSceen(game));
                }
                if (inBounds(event, fireButtonXpos, firButtonYpos, fireButton.getWidth(), fireButton.getHeight())) {
                    projectilePosx = world.m_player.posX;
                    projectilePosy = world.m_player.posY;
                    if (Settings.soundEnabled = true)
                        Assets.gunShot_sound.play(1);

                    if (hasShotgun()) {
                        world.m_player.m_projectile.add(new Projectile(world.m_player.posX - 80, world.m_player.posY - 100));
                        world.m_player.m_projectile2.add(new Projectile(world.m_player.posX - 80, world.m_player.posY - 100));
                        world.m_player.m_projectile3.add(new Projectile(world.m_player.posX - 80, world.m_player.posY - 100));
                    } else {
                        world.m_player.m_projectile.add(new Projectile(world.m_player.posX - 80, world.m_player.posY - 100));
                    }
                }

                if (inBounds(event, pauseButtonXpos, pauseButtonYpos, pauseButton.getWidth(), pauseButton.getHeight() + 100)) {
                    game.setScreen(new PauseScreen(game));
                }

            }

        }

        BGspeed = 20;
        for (int k = 0; k < world.m_BgList.size(); k++) {
            world.m_BgList.get(k).posy += BGspeed;
            if (world.m_BgList.get(k).posy > 1500) {
                world.m_BgList.get(k).posy += -BackGroundPic.getHeight() * 3;
            }
        }
        if (m_AccelX > 0.5f) {
            world.m_player.posX -= 4;
            if (m_AccelX > 2.5f) {
                world.m_player.posX -= 8;
            }
            if (world.m_player.posX <= 0) {
                world.m_player.posX = 0;
            }

        }

        if (m_AccelX < -0.5f) {
            world.m_player.posX += 4;
            if (m_AccelX < -2.5f) {
                world.m_player.posX += 8;
            }
            if (world.m_player.posX >= 690) {
                world.m_player.posX = 690;
            }

        }


        if (m_AccelY > 0.5f) {
            world.m_player.posY += 4;
            if (m_AccelX > 2.5f) {
                world.m_player.posY += 8;
            }
            if (world.m_player.posY >= 1000) {
                world.m_player.posY = 1000;
            }

        }

        if (m_AccelY < -0.5f) {
            world.m_player.posY -= 4;
            if (m_AccelX < -2.5f) {
                world.m_player.posY -= 8;
            }
            if (world.m_player.posY <= 0) {
                world.m_player.posY = 0;
            }

        }

        int enimyList = world.m_EnimyList.size();
        int maxEnimycount = 20;
        //region spawn pickups

        if (timePassed >= puTime) {
            int x = 0;
            x = random.nextInt(690);
            int y = 0;
            y = random.nextInt(1000);
            int t;
            t = random.nextInt(3);
            float time = timePassed + pickTimer;

            world.m_pickUpList.add(new PickUp(x, y, t, time));
            puTime += 5;
        }
        //endregion
        //region check pickup collision and type
        int puListSize = world.m_pickUpList.size();
        for (int i = 0; i < puListSize; i++) {
            PickUp curPickup = world.m_pickUpList.get(i);
            int AxMin = world.m_player.posX;
            int AyMin = world.m_player.posY;
            int AxMax = AxMin + (playerPixmap.getWidth() / 2);
            int AyMax = AyMin + (playerPixmap.getHeight() / 2);
            int BxMin = curPickup.xPos;
            int ByMin = curPickup.yPos;
            int BxMax = 0;
            int ByMax = 0;
            int type = curPickup.type;
            switch (type) {
                case 0:
                    if (curPickup.time < timePassed) {
                        world.m_pickUpList.remove(i);
                        puListSize--;
                    } else {
                        BxMax = BxMin + (healthPickup_B.getWidth() / 2);
                        ByMax = ByMin + (healthPickup_B.getHeight() / 2);
                        if ((AxMin >= BxMin && AxMin <= BxMax || AxMax >= BxMin && AxMax <= BxMax)
                                && (AyMin >= ByMin && AyMin <= ByMax || AyMax >= ByMin && AyMax <= ByMax)) {
                            if (numberOfLives < 3) {
                                numberOfLives++;
                            }
                            world.m_pickUpList.remove(i);
                            puListSize--;
                        }
                    }
                    break;
                case 1:
                    if (curPickup.time < timePassed) {
                        world.m_pickUpList.remove(i);
                        puListSize--;
                    } else {
                        BxMax = BxMin + (ShotGunPickup.getWidth() / 2);
                        ByMax = ByMin + (ShotGunPickup.getHeight() / 2);
                        if ((AxMin >= BxMin && AxMin <= BxMax || AxMax >= BxMin && AxMax <= BxMax)
                                && (AyMin >= ByMin && AyMin <= ByMax || AyMax >= ByMin && AyMax <= ByMax)) {
                            if (shotGunTimer <= 0) {
                                shotGunTimer += 20;
                            }
                            world.m_pickUpList.remove(i);
                            puListSize--;

                        }
                    }
                    break;
                case 2:
                    if (curPickup.time < timePassed) {
                        world.m_pickUpList.remove(i);
                        puListSize--;
                    } else {
                        BxMax = BxMin + (SheildPickup.getWidth() / 2);
                        ByMax = ByMin + (SheildPickup.getHeight() / 2);

                        if ((AxMin >= BxMin && AxMin <= BxMax || AxMax >= BxMin && AxMax <= BxMax)
                                && (AyMin >= ByMin && AyMin <= ByMax || AyMax >= ByMin && AyMax <= ByMax)) {
                            if (!hasSheild()) {
                                sheildTimer = timePassed + 10.0f;
                                numSheild += 2;
                            } else {
                                if (numSheild > 2) {
                                    numSheild++;
                                }
                                sheildTimer += 10;
                            }

                            world.m_pickUpList.remove(i);
                            puListSize--;
                        }


                    }
                    break;
                case 3:
                    BxMax = BxMin + bombpickup.getWidth() / 2;
                    ByMax = ByMin + bombpickup.getHeight() / 2;
                    if ((AxMin >= BxMin && AxMin <= BxMax || AxMax >= BxMin && AxMax <= BxMax)
                            && (AyMin >= ByMin && AyMin <= ByMax || AyMax >= ByMin && AyMax <= ByMax)) {
                        world.m_EnimyList2.clear();
                        world.m_pickUpList.remove(i);
                    }
                    break;
            }

        }
        //endregion

        timePassed += deltaTime;
        if (timePassed >= spawnTime) {
            if (enimyList <= maxEnimycount) {

                switch (spawnChoose) {
                    case 0:
                        world.m_EnimyList.add(new Enimy_TypeA(ECA_Spawner1_PosX, ECA_Spawner1_PosY, fireRate, deltaTime, 0, 10));
                        spawnChoose++;
                        break;
                    case 1:
                        world.m_EnimyList.add(new Enimy_TypeA(ECA_Spawner2_PosX, ECA_Spawner2_PosY, fireRate, deltaTime, 0, 10));
                        spawnChoose++;
                        break;
                    case 2:
                        world.m_EnimyList.add(new Enimy_TypeA(ECA_Spawner3_PosX, ECA_Spawner3_PosY, fireRate, deltaTime, 10, 10));
                        spawnChoose++;
                        break;
                    case 3:
                        world.m_EnimyList.add(new Enimy_TypeA(ECA_Spawner4_PosX, ECA_Spawner4_PosY, fireRate, deltaTime, -5, 2));
                        spawnChoose = 0;
                        break;
                }
            }
            spawnTime = spawnTime + 5;
        }


        projectileSpeed = 20;
        int firedBullets = world.m_player.m_projectile.size();
        int firedBulletsA = world.m_player.m_projectile2.size();
        int firedBulletsB = world.m_player.m_projectile3.size();
        for (int j = 0; j < firedBullets; j++) {
            if (j <= world.m_player.m_projectile.size()) {
                world.m_player.m_projectile.get(j).Posy -= projectileSpeed;
            }

        }
        for (int k = 0; k < firedBulletsA; k++) {
            if (k < world.m_player.m_projectile2.size()) {
                world.m_player.m_projectile2.get(k).Posy -= projectileSpeed;
                world.m_player.m_projectile2.get(k).Posx -= projectileSpeed / 2;
            }
        }
        for (int l = 0; l < firedBulletsB; l++) {
            if (l < world.m_player.m_projectile3.size()) {
                world.m_player.m_projectile3.get(l).Posy -= projectileSpeed;
                world.m_player.m_projectile3.get(l).Posx += projectileSpeed / 2;
            }

        }


        for (int g = 0; g < enimyList; g++) {


            Enimy_TypeA curEnimy = world.m_EnimyList.get(g);
            curEnimy.posX += curEnimy.SpeedX;
            curEnimy.posY += curEnimy.SpeedY;

            int AxMin = world.m_player.posX;
            int AyMin = world.m_player.posY;
            int AxMax = AxMin + (playerPixmap.getWidth() / 2);
            int AyMax = AyMin + (playerPixmap.getHeight() / 2);

            int BxMin = curEnimy.posX;
            int ByMin = curEnimy.posY;
            int BxMax = BxMin + (lvl1EnimyPixmap.getWidth() / 2);
            int ByMax = ByMin + (lvl1EnimyPixmap.getHeight() / 2);


            if (timePassed >= curEnimy.shotTimer) {
                curEnimy.fire();
                curEnimy.shotTimer += fireRate;
            }
            //projectile update;
            int projetileList = curEnimy.e_ProjectileList.size();
            for (int h = 0; h < projetileList; h++) {
                Projectile curProjectile = curEnimy.e_ProjectileList.get(h);
                curProjectile.Posy += eProjectileSpeedLv1;
                int CxMin = curProjectile.Posx;
                int CyMin = curProjectile.Posy;
                int CxMax = CxMin + (projectilePic.getWidth() / 2);
                int CyMax = CyMin + (projectilePic.getHeight() / 2);

                if (curProjectile.Posy >= 1200) {
                    curEnimy.e_ProjectileList.remove(h);
                    projetileList--;
                }

                if ((AxMin >= CxMin && AxMin <= CxMax || AxMax >= CxMin && AxMax <= CxMax)
                        && (AyMin >= CyMin && AyMin <= CyMax || AyMax >= CyMin && AyMax <= CyMax)) {

                    if (Settings.soundEnabled)
                        if (hasSheild()) {
                            numSheild--;
                        } else {
                            numberOfLives--;
                            if (numberOfLives <= 0) {
                                Settings.addScore(score);
                                Settings.save(game.getFileIO());
                                state = GameState.GameOver;

                                if (Settings.soundEnabled)
                                    Assets.DeathScreen_music.play();
                                game.submitScore(score);
                            }
                        }
                    curEnimy.e_ProjectileList.remove(h);
                    projetileList--;

                }
            }
            //collision check of enimy hitting player
            if ((AxMin >= BxMin && AxMin <= BxMax || AxMax >= BxMin && AxMax <= BxMax)
                    && (AyMin >= ByMin && AyMin <= ByMax || AyMax >= ByMin && AyMax <= ByMax)) {

                if (Settings.soundEnabled) {
                    Assets.explosion_sound.play(1);
                }
                if (hasSheild()) {
                    numSheild--;
                } else {
                    numberOfLives--;
                    if (numberOfLives <= 0) {
                        Settings.addScore(score);
                        Settings.save(game.getFileIO());
                        state = GameState.GameOver;

                        if (Settings.soundEnabled)
                            Assets.DeathScreen_music.play();
                        game.submitScore(score);
                    }
                }
                world.m_EnimyList.remove(g);
                enimyList--;
            }


            int p_project = world.m_player.m_projectile.size();
            for (int i = 0; i < p_project; i++) {
                Projectile curPprojectile = world.m_player.m_projectile.get(i);
                int p_AxMin = curPprojectile.Posx;
                int p_AyMin = curPprojectile.Posy;
                int p_AxMax = p_AxMin + (projectilePic.getWidth() / 2);
                int p_AyMax = p_AyMin + (projectilePic.getHeight() / 2);

                int p_BxMin = curEnimy.posX;
                int p_ByMin = curEnimy.posY;
                int p_BxMax = BxMin + (lvl1EnimyPixmap.getWidth());
                int p_ByMax = ByMin + (lvl1EnimyPixmap.getHeight());


                //collision check player projectile hitting enimy
                if ((p_AxMin >= p_BxMin && p_AxMin <= p_BxMax || p_AxMax >= p_BxMin && p_AxMax <= p_BxMax)
                        && (p_AyMin >= p_ByMin && p_AyMin <= p_ByMax || p_AyMax >= p_ByMin && p_AyMax <= p_ByMax)) {

                    world.m_player.m_projectile.remove(i);
                    p_project--;
                    world.m_EnimyList.remove(g);
                    //spawn explosion
                    enimyList--;
                    if (Settings.soundEnabled)
                        Assets.explosion_sound.play(1);
                    score += 50;

                }

            }
            for (int i = 0; i < firedBulletsA; i++) {
                Projectile curPprojectile = world.m_player.m_projectile2.get(i);
                int p_AxMin = curPprojectile.Posx;
                int p_AyMin = curPprojectile.Posy;
                int p_AxMax = p_AxMin + (projectilePic.getWidth() / 2);
                int p_AyMax = p_AyMin + (projectilePic.getHeight() / 2);

                int p_BxMin = curEnimy.posX;
                int p_ByMin = curEnimy.posY;
                int p_BxMax = BxMin + (lvl2EnimyPixmap.getWidth());
                int p_ByMax = ByMin + (lvl2EnimyPixmap.getHeight());


                //collision check player projectile hitting enimy
                if ((p_AxMin >= p_BxMin && p_AxMin <= p_BxMax || p_AxMax >= p_BxMin && p_AxMax <= p_BxMax)
                        && (p_AyMin >= p_ByMin && p_AyMin <= p_ByMax || p_AyMax >= p_ByMin && p_AyMax <= p_ByMax)) {

                    world.m_player.m_projectile2.remove(i);
                    firedBulletsA--;
                    world.m_EnimyList.remove(g);
                    enimyList--;
                    if (Settings.soundEnabled)
                        Assets.explosion_sound.play(1);
                    score += 50;

                }
            }
            for (int i = 0; i < firedBulletsB; i++) {
                Projectile curPprojectile = world.m_player.m_projectile3.get(i);
                int p_AxMin = curPprojectile.Posx;
                int p_AyMin = curPprojectile.Posy;
                int p_AxMax = p_AxMin + (projectilePic.getWidth() / 2);
                int p_AyMax = p_AyMin + (projectilePic.getHeight() / 2);

                int p_BxMin = curEnimy.posX;
                int p_ByMin = curEnimy.posY;
                int p_BxMax = BxMin + (lvl2EnimyPixmap.getWidth());
                int p_ByMax = ByMin + (lvl2EnimyPixmap.getHeight());


                //collision check player projectile hitting enimy
                if ((p_AxMin >= p_BxMin && p_AxMin <= p_BxMax || p_AxMax >= p_BxMin && p_AxMax <= p_BxMax)
                        && (p_AyMin >= p_ByMin && p_AyMin <= p_ByMax || p_AyMax >= p_ByMin && p_AyMax <= p_ByMax)) {

                    world.m_player.m_projectile3.remove(i);
                    firedBulletsB--;
                    world.m_EnimyList.remove(g);
                    enimyList--;
                    if (Settings.soundEnabled)
                        Assets.explosion_sound.play(1);
                    score += 50;

                }
            }
            //boundry check
            if (curEnimy.posX > 800 || curEnimy.posX < -100 || curEnimy.posY > 1200) {
                world.m_EnimyList.remove(g);
                //spawn explosion
                enimyList--;
            }
        }


        if (numberOfLives <= 0) {
            Settings.addScore(score);
            Settings.save(game.getFileIO());
            state = GameState.GameOver;

            if (Settings.soundEnabled) {
                Assets.DeathScreen_music.play();
                game.submitScore(score);
            }
        }
        if (score == 500) {
            world.m_EnimyList2.clear();
            world.m_EnimyList.clear();
            world.m_player.m_projectile.clear();
<<<<<<< HEAD
            game.setScreen(new Level1Trans(game));
            state=GameState.Runningb;
=======
            state = GameState.Runningb;
>>>>>>> master

            //Games.Achievements.unlock(getApiClient(), getString(R.string.achievement_cold_as_icesis));

        }
        if (firedBullets == 500) {

            //Games.Achievements.unlock(getApiClient(), getString(R.string.achievement_fire_storm));

        }
        if (sheildTimer < timePassed) {
            sheildTimer = 0;
            numSheild = 0;

        }
        world.update(deltaTime);

    }

    private void updateRunningb(List<TouchEvent> touchEvents, float m_AccelX, float m_AccelY, float deltaTime) {
        int len = touchEvents.size();
        timePassed += deltaTime;

        //region touch UI code
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);

            if (event.type == TouchEvent.TOUCH_UP) {
                if (inBounds(event, mainMenuButtonXpos, mainMenuButtonYpos, mainMenuButton.getWidth(), mainMenuButton.getHeight() + 100)) {
                    game.setScreen(new MaineMenuSceen(game));
                }
                if (inBounds(event, fireButtonXpos, firButtonYpos, fireButton.getWidth(), fireButton.getHeight())) {
                    projectilePosx = world.m_player.posX;
                    projectilePosy = world.m_player.posY;
                    if (Settings.soundEnabled)
                        Assets.gunShot_sound.play(1);


                    if (hasShotgun()) {
                        world.m_player.m_projectile.add(new Projectile(world.m_player.posX - 80, world.m_player.posY - 100));
                        world.m_player.m_projectile2.add(new Projectile(world.m_player.posX - 80, world.m_player.posY - 100));
                        world.m_player.m_projectile3.add(new Projectile(world.m_player.posX - 80, world.m_player.posY - 100));
                    } else {
                        world.m_player.m_projectile.add(new Projectile(world.m_player.posX - 80, world.m_player.posY - 100));
                    }
                }

                if (inBounds(event, pauseButtonXpos, pauseButtonYpos, pauseButton.getWidth(), pauseButton.getHeight() + 100)) {
                    game.setScreen(new PauseScreen(game));
                }

            }

        }
        //endregion
        //region moving background
        BGspeed = 30;
        for (int k = 0; k < world.m_BgList2.size(); k++) {
            world.m_BgList2.get(k).posy += BGspeed;
            if (world.m_BgList2.get(k).posy > 1500) {
                world.m_BgList2.get(k).posy += -BackGroundPic.getHeight() * 3;
            }
        }
        //endregion
        //region player movement
        if (m_AccelX > 0.5f) {
            world.m_player.posX -= 4;
            if (m_AccelX > 2.5f) {
                world.m_player.posX -= 8;
            }
            if (world.m_player.posX <= 0) {
                world.m_player.posX = 0;
            }

        }


        if (m_AccelX < -0.5f) {
            world.m_player.posX += 4;
            if (m_AccelX < -2.5f) {
                world.m_player.posX += 8;
            }
            if (world.m_player.posX >= 690) {
                world.m_player.posX = 690;
            }

        }


        if (m_AccelY > 0.5f) {
            world.m_player.posY += 4;
            if (m_AccelX > 2.5f) {
                world.m_player.posY += 8;
            }
            if (world.m_player.posY >= 1000) {
                world.m_player.posY = 1000;
            }

        }

        if (m_AccelY < -0.5f) {
            world.m_player.posY -= 4;
            if (m_AccelX < -2.5f) {
                world.m_player.posY -= 8;
            }
            if (world.m_player.posY <= 0) {
                world.m_player.posY = 0;
            }

        }
        //endregion
        // region enimy spawning
        int enimyList = world.m_EnimyList2.size();
        int maxEnimycount = 20;

        if (timePassed >= spawnTime2) {
            if (enimyList <= maxEnimycount) {
                switch (spawnChoose) {
                    case 0:
                        world.m_EnimyList2.add(new Enimy_TypeB(ECA2_Spawner1_PosX, ECA2_Spawner1_PosY, fireRate2, deltaTime, 5, 5));
                        spawnChoose++;
                        break;
                    case 1:
                        world.m_EnimyList2.add(new Enimy_TypeB(ECA2_Spawner2_PosX, ECA2_Spawner2_PosY, fireRate2, deltaTime, 10, 0));
                        spawnChoose++;
                        break;
                    case 2:
                        world.m_EnimyList2.add(new Enimy_TypeB(ECA2_Spawner3_PosX, ECA2_Spawner3_PosY, fireRate2, deltaTime, 10, -15));
                        spawnChoose++;
                        break;
                    case 3:
                        world.m_EnimyList2.add(new Enimy_TypeB(ECA2_Spawner4_PosX, ECA2_Spawner4_PosY, fireRate2, deltaTime, 0, 5));
                        spawnChoose++;
                        break;
                    case 4:
                        world.m_EnimyList2.add(new Enimy_TypeB(ECA2_Spawner5_PosX, ECA2_Spawner5_PosY, fireRate2, deltaTime, 0, 7));
                        spawnChoose++;
                        break;
                    case 5:
                        world.m_EnimyList2.add(new Enimy_TypeB(ECA2_Spawner6_PosX, ECA2_Spawner6_PosY, fireRate2, deltaTime, -7, 7));
                        spawnChoose++;
                        break;
                    case 6:
                        world.m_EnimyList2.add(new Enimy_TypeB(ECA2_Spawner7_PosX, ECA2_Spawner7_PosY, fireRate2, deltaTime, -6, -15));
                        spawnChoose++;
                        break;
                    case 7:
                        world.m_EnimyList2.add(new Enimy_TypeB(ECA2_Spawner1_PosX, ECA2_Spawner1_PosY, fireRate2, deltaTime, -3, -10));
                        spawnChoose = 0;
                        break;
                    case 8:


                }
            }
            spawnTime2 += 1;
        }
        //endregion
        //region spawn pickups

        if (timePassed >= puTime) {
            int x = 0;
            x = random.nextInt(690);
            int y = 0;
            y = random.nextInt(1000);
            int t;
            t = random.nextInt(3);
            float time = timePassed + pickTimer;

            world.m_pickUpList.add(new PickUp(x, y, t, time));
            puTime += 5;
        }
        //endregion
        //region update player bullets
        projectileSpeed = 30;

        int firedBullets = world.m_player.m_projectile.size();
        int firedBulletsA = world.m_player.m_projectile2.size();
        int firedBulletsB = world.m_player.m_projectile3.size();
        for (int j = 0; j < firedBullets; j++) {
            if (j <= world.m_player.m_projectile.size()) {
                world.m_player.m_projectile.get(j).Posy -= projectileSpeed;
            }

        }
        for (int k = 0; k < firedBulletsA; k++) {
            if (k < world.m_player.m_projectile2.size()) {
                world.m_player.m_projectile2.get(k).Posy -= projectileSpeed;
                world.m_player.m_projectile2.get(k).Posx -= projectileSpeed / 2;
            }
        }
        for (int l = 0; l < firedBulletsB; l++) {
            if (l < world.m_player.m_projectile3.size()) {
                world.m_player.m_projectile3.get(l).Posy -= projectileSpeed;
                world.m_player.m_projectile3.get(l).Posx += projectileSpeed / 2;
            }

        }
        //endregion
        //region collison checking
        //region check pickup collision and type
        int puListSize = world.m_pickUpList.size();
        for (int i = 0; i < puListSize; i++) {
            PickUp curPickup = world.m_pickUpList.get(i);
            int AxMin = world.m_player.posX;
            int AyMin = world.m_player.posY;
            int AxMax = AxMin + (playerPixmap.getWidth() / 2);
            int AyMax = AyMin + (playerPixmap.getHeight() / 2);
            int BxMin = curPickup.xPos;
            int ByMin = curPickup.yPos;
            int BxMax = 0;
            int ByMax = 0;
            int type = curPickup.type;
            switch (type) {
                case 0:
                    if (curPickup.time < timePassed) {
                        world.m_pickUpList.remove(i);
                        puListSize--;
                    } else {
                        BxMax = BxMin + (healthPickup_B.getWidth() / 2);
                        ByMax = ByMin + (healthPickup_B.getHeight() / 2);
                        if ((AxMin >= BxMin && AxMin <= BxMax || AxMax >= BxMin && AxMax <= BxMax)
                                && (AyMin >= ByMin && AyMin <= ByMax || AyMax >= ByMin && AyMax <= ByMax)) {
                            if (numberOfLives < 3) {
                                numberOfLives++;
                            }
                            world.m_pickUpList.remove(i);
                            puListSize--;
                        }
                    }
                    break;
                case 1:
                    if (curPickup.time < timePassed) {
                        world.m_pickUpList.remove(i);
                        puListSize--;
                    } else {
                        BxMax = BxMin + (ShotGunPickup.getWidth() / 2);
                        ByMax = ByMin + (ShotGunPickup.getHeight() / 2);
                        if ((AxMin >= BxMin && AxMin <= BxMax || AxMax >= BxMin && AxMax <= BxMax)
                                && (AyMin >= ByMin && AyMin <= ByMax || AyMax >= ByMin && AyMax <= ByMax)) {
                            if (shotGunTimer <= 0) {
                                shotGunTimer += 20;
                            }
                            world.m_pickUpList.remove(i);
                            puListSize--;

                        }
                    }
                    break;
                case 2:
                    if (curPickup.time < timePassed) {
                        world.m_pickUpList.remove(i);
                        puListSize--;
                    } else {
                        BxMax = BxMin + (SheildPickup.getWidth() / 2);
                        ByMax = ByMin + (SheildPickup.getHeight() / 2);

                        if ((AxMin >= BxMin && AxMin <= BxMax || AxMax >= BxMin && AxMax <= BxMax)
                                && (AyMin >= ByMin && AyMin <= ByMax || AyMax >= ByMin && AyMax <= ByMax)) {
                            if (!hasSheild()) {
                                sheildTimer = timePassed + 10.0f;
                                numSheild += 2;
                            } else {
                                if (numSheild > 2) {
                                    numSheild++;
                                }
                                sheildTimer += 10;
                            }

                            world.m_pickUpList.remove(i);
                            puListSize--;
                        }


                    }
                    break;
                case 3:
                    BxMax = BxMin + bombpickup.getWidth() / 2;
                    ByMax = ByMin + bombpickup.getHeight() / 2;
                    if ((AxMin >= BxMin && AxMin <= BxMax || AxMax >= BxMin && AxMax <= BxMax)
                            && (AyMin >= ByMin && AyMin <= ByMax || AyMax >= ByMin && AyMax <= ByMax)) {
                        world.m_EnimyList2.clear();
                        world.m_pickUpList.remove(i);
                    }
                    break;
            }

        }
        //endregion
        // region enimy check loop
        for (int g = 0; g < enimyList; g++) {

            Enimy_TypeB curEnimy = world.m_EnimyList2.get(g);
            curEnimy.posX += curEnimy.SpeedX;
            curEnimy.posY += curEnimy.SpeedY;
            //region first gameobject
            int AxMin = world.m_player.posX;
            int AyMin = world.m_player.posY;
            int AxMax = AxMin + (playerPixmap.getWidth() / 2);
            int AyMax = AyMin + (playerPixmap.getHeight() / 2);
            //endregion
            //region second gameobject
            int BxMin = curEnimy.posX;
            int ByMin = curEnimy.posY;
            int BxMax = BxMin + (lvl2EnimyPixmap.getWidth() / 2);
            int ByMax = ByMin + (lvl2EnimyPixmap.getHeight() / 2);
            //endregion
            //region enimy fire
            if (timePassed >= curEnimy.shotTimer) {
                curEnimy.fire();
                curEnimy.shotTimer += fireRate2;
            }
            //endregion
            //region enimy projectile check
            int projetileList = curEnimy.e_ProjectileList.size();
            for (int h = 0; h < projetileList; h++) {
                Projectile curProjectile = curEnimy.e_ProjectileList.get(h);
                curProjectile.Posy += eProjectileSpeedLv2/3;
                int CxMin = curProjectile.Posx;
                int CyMin = curProjectile.Posy;
                int CxMax = CxMin + (projectilePic.getWidth() / 2);
                int CyMax = CyMin + (projectilePic.getHeight() / 2);

                if (curProjectile.Posy >= 1200) {
                    curEnimy.e_ProjectileList.remove(h);
                    //jamie spawn explosion
                    projetileList--;
                }
                // check enimy projectile hit player
                if ((AxMin >= CxMin && AxMin <= CxMax || AxMax >= CxMin && AxMax <= CxMax)
                        && (AyMin >= CyMin && AyMin <= CyMax || AyMax >= CyMin && AyMax <= CyMax)) {
                    curEnimy.e_ProjectileList.remove(h);
                    projetileList--;
                    if (Settings.soundEnabled) {
                        Assets.explosion_sound.play(1);

                    }
                    if (hasSheild()) {
                        numSheild--;
                    } else {
                        numberOfLives--;
                        if (numberOfLives <= 0) {
                            Settings.addScore(score);
                            Settings.save(game.getFileIO());
                            state = GameState.GameOver;

                            if (Settings.soundEnabled)
                                Assets.DeathScreen_music.play();
                            game.submitScore(score);
                        }

                    }
                }
                //endregion
                //region collision check if enimy is hitting player
                if ((AxMin >= BxMin && AxMin <= BxMax || AxMax >= BxMin && AxMax <= BxMax)
                        && (AyMin >= ByMin && AyMin <= ByMax || AyMax >= ByMin && AyMax <= ByMax)) {
                    world.m_EnimyList2.remove(g);
                    if (Settings.soundEnabled) {
                        Assets.explosion_sound.play(1);
                    }
                    if (hasSheild()) {
                        numSheild--;
                    } else {
                        numberOfLives--;
                        if (numberOfLives <= 0) {
                            Settings.addScore(score);
                            Settings.save(game.getFileIO());
                            state = GameState.GameOver;

                            if (Settings.soundEnabled)
                                Assets.DeathScreen_music.play();
                            game.submitScore(score);
                        }
                    }

                    enimyList--;
                }
                //endregion
                //region checking player bullets are hitting enimy
                for (int i = 0; i < firedBullets; i++) {
                    Projectile curPprojectile = world.m_player.m_projectile.get(i);
                    int p_AxMin = curPprojectile.Posx;
                    int p_AyMin = curPprojectile.Posy;
                    int p_AxMax = p_AxMin + (projectilePic.getWidth() / 2);
                    int p_AyMax = p_AyMin + (projectilePic.getHeight() / 2);

                    int p_BxMin = curEnimy.posX;
                    int p_ByMin = curEnimy.posY;
                    int p_BxMax = BxMin + (lvl2EnimyPixmap.getWidth());
                    int p_ByMax = ByMin + (lvl2EnimyPixmap.getHeight());


                    //collision check player projectile hitting enimy
                    if ((p_AxMin >= p_BxMin && p_AxMin <= p_BxMax || p_AxMax >= p_BxMin && p_AxMax <= p_BxMax)
                            && (p_AyMin >= p_ByMin && p_AyMin <= p_ByMax || p_AyMax >= p_ByMin && p_AyMax <= p_ByMax)) {

                        world.m_player.m_projectile.remove(i);
                        firedBullets--;
                        world.m_EnimyList2.remove(g);
                        enimyList--;
                        if (Settings.soundEnabled)
                            Assets.explosion_sound.play(1);
                        score += 50;

                    }
                }
                for (int i = 0; i < firedBulletsA; i++) {
                    Projectile curPprojectile = world.m_player.m_projectile2.get(i);
                    int p_AxMin = curPprojectile.Posx;
                    int p_AyMin = curPprojectile.Posy;
                    int p_AxMax = p_AxMin + (projectilePic.getWidth() / 2);
                    int p_AyMax = p_AyMin + (projectilePic.getHeight() / 2);

                    int p_BxMin = curEnimy.posX;
                    int p_ByMin = curEnimy.posY;
                    int p_BxMax = BxMin + (lvl2EnimyPixmap.getWidth());
                    int p_ByMax = ByMin + (lvl2EnimyPixmap.getHeight());


                    //collision check player projectile hitting enimy
                    if ((p_AxMin >= p_BxMin && p_AxMin <= p_BxMax || p_AxMax >= p_BxMin && p_AxMax <= p_BxMax)
                            && (p_AyMin >= p_ByMin && p_AyMin <= p_ByMax || p_AyMax >= p_ByMin && p_AyMax <= p_ByMax)) {

                        world.m_player.m_projectile2.remove(i);
                        firedBulletsA--;
                        world.m_EnimyList2.remove(g);
                        enimyList--;
                        if (Settings.soundEnabled)
                            Assets.explosion_sound.play(1);
                        score += 50;

                    }
                }
                for (int i = 0; i < firedBulletsB; i++) {
                    Projectile curPprojectile = world.m_player.m_projectile3.get(i);
                    int p_AxMin = curPprojectile.Posx;
                    int p_AyMin = curPprojectile.Posy;
                    int p_AxMax = p_AxMin + (projectilePic.getWidth() / 2);
                    int p_AyMax = p_AyMin + (projectilePic.getHeight() / 2);

                    int p_BxMin = curEnimy.posX;
                    int p_ByMin = curEnimy.posY;
                    int p_BxMax = BxMin + (lvl2EnimyPixmap.getWidth());
                    int p_ByMax = ByMin + (lvl2EnimyPixmap.getHeight());


                    //collision check player projectile hitting enimy
                    if ((p_AxMin >= p_BxMin && p_AxMin <= p_BxMax || p_AxMax >= p_BxMin && p_AxMax <= p_BxMax)
                            && (p_AyMin >= p_ByMin && p_AyMin <= p_ByMax || p_AyMax >= p_ByMin && p_AyMax <= p_ByMax)) {

                        world.m_player.m_projectile3.remove(i);
                        firedBulletsB--;
                        world.m_EnimyList2.remove(g);
                        enimyList--;
                        if (Settings.soundEnabled)
                            Assets.explosion_sound.play(1);
                        score += 50;

                    }
                }
                //endregion
                //region boundry check
                if (curEnimy.posX > 800 || curEnimy.posX < -100 || curEnimy.posY > 1200) {
                    world.m_EnimyList2.remove(g);
                    enimyList--;
                }//endregion

                //update enimy position

            }
        }
        //endregion
        //region player projectil boundry check
        for (int j = 0; j < firedBullets; j++) {

            if (world.m_player.m_projectile.get(j).Posy < -630 ||
                    world.m_player.m_projectile.get(j).Posx > 750 ||
                    world.m_player.m_projectile.get(j).Posx < -200) {
                world.m_player.m_projectile.remove(j);
                firedBullets--;

            }

        }
        for (int j = 0; j < firedBulletsA; j++) {
            if (world.m_player.m_projectile2.get(j).Posy < -630 ||
                    world.m_player.m_projectile2.get(j).Posx > 800 ||
                    world.m_player.m_projectile2.get(j).Posx < -200) {
                world.m_player.m_projectile2.remove(j);
                firedBulletsA--;
            }
        }
        for (int j = 0; j < firedBulletsB; j++) {

            if (world.m_player.m_projectile3.get(j).Posy < -630 ||
                    world.m_player.m_projectile3.get(j).Posx > 800 ||
                    world.m_player.m_projectile3.get(j).Posx < -200) {
                world.m_player.m_projectile3.remove(j);
                firedBulletsB--;

            }

        }
        //endregion
        //endregion
        if (sheildTimer < timePassed) {
            sheildTimer = 0;
            numSheild = 0;

        }
        world.update(deltaTime);//update world clock

    }

    private void updateRunningc(List<TouchEvent> touchEvents, float m_AccelX, float m_AccelY, float deltaTime) {
        int len = touchEvents.size();
        timePassed += deltaTime;

        //region touch UI code
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);

            if (event.type == TouchEvent.TOUCH_UP) {
                if (inBounds(event, mainMenuButtonXpos, mainMenuButtonYpos, mainMenuButton.getWidth(), mainMenuButton.getHeight() + 100)) {
                    game.setScreen(new MaineMenuSceen(game));
                }
                if (inBounds(event, fireButtonXpos, firButtonYpos, fireButton.getWidth(), fireButton.getHeight())) {
                    projectilePosx = world.m_player.posX;
                    projectilePosy = world.m_player.posY;
                    if (Settings.soundEnabled)
                        Assets.gunShot_sound.play(1);


                    if (hasShotgun()) {
                        world.m_player.m_projectile.add(new Projectile(world.m_player.posX - 80, world.m_player.posY - 100));
                        world.m_player.m_projectile2.add(new Projectile(world.m_player.posX - 80, world.m_player.posY - 100));
                        world.m_player.m_projectile3.add(new Projectile(world.m_player.posX - 80, world.m_player.posY - 100));
                    } else {
                        world.m_player.m_projectile.add(new Projectile(world.m_player.posX - 80, world.m_player.posY - 100));
                    }
                }

                if (inBounds(event, pauseButtonXpos, pauseButtonYpos, pauseButton.getWidth(), pauseButton.getHeight() + 100)) {
                    game.setScreen(new PauseScreen(game));
                }

            }

        }
        //endregion
        //region moving background
        BGspeed = 30;
        for (int k = 0; k < world.m_BgList2.size(); k++) {
            world.m_BgList2.get(k).posy += BGspeed;
            if (world.m_BgList2.get(k).posy > 1500) {
                world.m_BgList2.get(k).posy += -BackGroundPic.getHeight() * 3;
            }
        }
        //endregion
        //region player movement
        if (m_AccelX > 0.5f) {
            world.m_player.posX -= 4;
            if (m_AccelX > 2.5f) {
                world.m_player.posX -= 8;
            }
            if (world.m_player.posX <= 0) {
                world.m_player.posX = 0;
            }

        }


        if (m_AccelX < -0.5f) {
            world.m_player.posX += 4;
            if (m_AccelX < -2.5f) {
                world.m_player.posX += 8;
            }
            if (world.m_player.posX >= 690) {
                world.m_player.posX = 690;
            }

        }


        if (m_AccelY > 0.5f) {
            world.m_player.posY += 4;
            if (m_AccelX > 2.5f) {
                world.m_player.posY += 8;
            }
            if (world.m_player.posY >= 1000) {
                world.m_player.posY = 1000;
            }

        }

        if (m_AccelY < -0.5f) {
            world.m_player.posY -= 4;
            if (m_AccelX < -2.5f) {
                world.m_player.posY -= 8;
            }
            if (world.m_player.posY <= 0) {
                world.m_player.posY = 0;
            }

        }
        //endregion
        // region enimy spawning
        int enimyList = world.m_EnimyList3.size();
        int maxEnimycount = 20;

        if (timePassed >= spawnTime2) {
            if (enimyList <= maxEnimycount) {

               int temp=random.nextInt(7);
               if(old!=temp) {
                   spawnChoose = temp;
               }
               else
               {
                   spawnChoose=random.nextInt(11);
               }

                switch (spawnChoose) {
                    case 0:
                        world.m_EnimyList3.add(new Enimy_TypeC(ECA2_Spawner1_PosX, ECA2_Spawner1_PosY, fireRate2, deltaTime, 5, 5));

                        break;
                    case 1:
                        world.m_EnimyList3.add(new Enimy_TypeC(ECA2_Spawner2_PosX, ECA2_Spawner2_PosY, fireRate2, deltaTime, 10, 0));

                        break;
                    case 2:
                        world.m_EnimyList3.add(new Enimy_TypeC(ECA2_Spawner3_PosX, ECA2_Spawner3_PosY, fireRate2, deltaTime, 10, -15));

                        break;
                    case 3:
                        world.m_EnimyList3.add(new Enimy_TypeC(ECA2_Spawner4_PosX, ECA2_Spawner4_PosY, fireRate2, deltaTime, 0, 5));

                        break;
                    case 4:
                        world.m_EnimyList3.add(new Enimy_TypeC(ECA2_Spawner5_PosX, ECA2_Spawner5_PosY, fireRate2, deltaTime, 0, 7));

                        break;
                    case 5:
                        world.m_EnimyList3.add(new Enimy_TypeC(ECA2_Spawner6_PosX, ECA2_Spawner6_PosY, fireRate2, deltaTime, -7, 7));

                        break;
                    case 6:
                        world.m_EnimyList3.add(new Enimy_TypeC(ECA2_Spawner7_PosX, ECA2_Spawner7_PosY, fireRate2, deltaTime, -6, -15));

                        break;
                    case 7:
                        world.m_EnimyList3.add(new Enimy_TypeC(ECA2_Spawner1_PosX, ECA2_Spawner1_PosY, fireRate2, deltaTime, -3, -10));

                        break;
                    case 8:
                        world.m_EnimyList3.add(new Enimy_TypeC(ECA_Spawner1_PosX, ECA_Spawner1_PosY, fireRate2, deltaTime, -6, 7));
                        break;
                    case 9:
                        world.m_EnimyList3.add(new Enimy_TypeC(ECA_Spawner2_PosX, ECA_Spawner2_PosY, fireRate2, deltaTime,0 , 14));
                        break;
                    case 10:
                        world.m_EnimyList3.add(new Enimy_TypeC(ECA_Spawner3_PosX, ECA_Spawner3_PosY, fireRate2, deltaTime,5 , -9));
                        break;



                }
                old=spawnChoose;
            }
            spawnTime2 += 1;
        }
        //endregion
        //region spawn pickups

        if (timePassed >= puTime) {
            int x = 0;
            x = random.nextInt(690);
            int y = 0;
            y = random.nextInt(1000);
            int t;
            t = random.nextInt(4);
            if(t==3)
            {
                int temp=random.nextInt(10);
                if(temp>=5)
                {
                    t=random.nextInt(4);
                }
                else if(temp<=4)
                {
                    t=3;
                }
            }
            float time = timePassed + pickTimer;

            world.m_pickUpList.add(new PickUp(x, y, t, time));
            puTime += 5;
        }
        //endregion
        //region update player bullets
        projectileSpeed = 30;

        int firedBullets = world.m_player.m_projectile.size();
        int firedBulletsA = world.m_player.m_projectile2.size();
        int firedBulletsB = world.m_player.m_projectile3.size();
        for (int j = 0; j < firedBullets; j++) {
            if (j <= world.m_player.m_projectile.size()) {
                world.m_player.m_projectile.get(j).Posy -= projectileSpeed;
            }

        }
        for (int k = 0; k < firedBulletsA; k++) {
            if (k < world.m_player.m_projectile2.size()) {
                world.m_player.m_projectile2.get(k).Posy -= projectileSpeed;
                world.m_player.m_projectile2.get(k).Posx -= projectileSpeed / 2;
            }
        }
        for (int l = 0; l < firedBulletsB; l++) {
            if (l < world.m_player.m_projectile3.size()) {
                world.m_player.m_projectile3.get(l).Posy -= projectileSpeed;
                world.m_player.m_projectile3.get(l).Posx += projectileSpeed / 2;
            }

        }
        //endregion
        //region collison checking
        //region check pickup collision and type
        int puListSize = world.m_pickUpList.size();
        for (int i = 0; i < puListSize; i++) {
            PickUp curPickup = world.m_pickUpList.get(i);
            int AxMin = world.m_player.posX;
            int AyMin = world.m_player.posY;
            int AxMax = AxMin + (playerPixmap.getWidth() / 2);
            int AyMax = AyMin + (playerPixmap.getHeight() / 2);
            int BxMin = curPickup.xPos;
            int ByMin = curPickup.yPos;
            int BxMax = 0;
            int ByMax = 0;
            int type = curPickup.type;
            switch (type) {
                case 0:
                    if (curPickup.time < timePassed) {
                        world.m_pickUpList.remove(i);
                        puListSize--;
                    } else {
                        BxMax = BxMin + (healthPickup_B.getWidth() / 2);
                        ByMax = ByMin + (healthPickup_B.getHeight() / 2);
                        if ((AxMin >= BxMin && AxMin <= BxMax || AxMax >= BxMin && AxMax <= BxMax)
                                && (AyMin >= ByMin && AyMin <= ByMax || AyMax >= ByMin && AyMax <= ByMax)) {
                            if (numberOfLives < 3) {
                                numberOfLives++;
                            }
                            world.m_pickUpList.remove(i);
                            puListSize--;
                        }
                    }
                    break;
                case 1:
                    if (curPickup.time < timePassed) {
                        world.m_pickUpList.remove(i);
                        puListSize--;
                    } else {
                        BxMax = BxMin + (ShotGunPickup.getWidth() / 2);
                        ByMax = ByMin + (ShotGunPickup.getHeight() / 2);
                        if ((AxMin >= BxMin && AxMin <= BxMax || AxMax >= BxMin && AxMax <= BxMax)
                                && (AyMin >= ByMin && AyMin <= ByMax || AyMax >= ByMin && AyMax <= ByMax)) {
                            if (shotGunTimer <= 0) {
                                shotGunTimer += 20;
                            }
                            world.m_pickUpList.remove(i);
                            puListSize--;

                        }
                    }
                    break;
                case 2:
                    if (curPickup.time < timePassed) {
                        world.m_pickUpList.remove(i);
                        puListSize--;
                    } else {
                        BxMax = BxMin + (SheildPickup.getWidth() / 2);
                        ByMax = ByMin + (SheildPickup.getHeight() / 2);

                        if ((AxMin >= BxMin && AxMin <= BxMax || AxMax >= BxMin && AxMax <= BxMax)
                                && (AyMin >= ByMin && AyMin <= ByMax || AyMax >= ByMin && AyMax <= ByMax)) {
                            if (!hasSheild()) {
                                sheildTimer = timePassed + 10.0f;
                                numSheild += 2;
                            } else {
                                if (numSheild > 2) {
                                    numSheild++;
                                }
                                sheildTimer += 10;
                            }

                            world.m_pickUpList.remove(i);
                            puListSize--;
                        }


                    }
                    break;
                case 3:
                    BxMax = BxMin + bombpickup.getWidth() / 2;
                    ByMax = ByMin + bombpickup.getHeight() / 2;
                    if ((AxMin >= BxMin && AxMin <= BxMax || AxMax >= BxMin && AxMax <= BxMax)
                            && (AyMin >= ByMin && AyMin <= ByMax || AyMax >= ByMin && AyMax <= ByMax)) {
                        world.m_EnimyList.clear();
                        world.m_EnimyList2.clear();
                        world.m_EnimyList3.clear();
                        world.m_pickUpList.remove(i);
                    }
                    break;
            }

        }
        //endregion
        // region enimy check loop
        for (int g = 0; g < enimyList; g++) {

            Enimy_TypeC curEnimy = world.m_EnimyList3.get(g);
            curEnimy.posX += curEnimy.SpeedX;
            curEnimy.posY += curEnimy.SpeedY;
            //region first gameobject
            int AxMin = world.m_player.posX;
            int AyMin = world.m_player.posY;
            int AxMax = AxMin + (playerPixmap.getWidth() / 2);
            int AyMax = AyMin + (playerPixmap.getHeight() / 2);
            //endregion
            //region second gameobject
            int BxMin = curEnimy.posX;
            int ByMin = curEnimy.posY;
            int BxMax = BxMin + (lvl3EnimyPixmap.getWidth() / 2);
            int ByMax = ByMin + (lvl3EnimyPixmap.getHeight() / 2);
            //endregion
            //region enimy fire
            if (timePassed > curEnimy.shotTimer) {
                curEnimy.fire();
                curEnimy.shotTimer += fireRate2;
            }
            //endregion
            //region enimy projectile check
            int projetileList = curEnimy.e_ProjectileList.size();
            for (int h = 0; h < projetileList; h++) {
                Projectile curProjectile = curEnimy.e_ProjectileList.get(h);
                curProjectile.Posy += eProjectileSpeedLv2/4;
                curProjectile.Posx += eProjectileSpeedLv2/8;
                int CxMin = curProjectile.Posx;
                int CyMin = curProjectile.Posy;
                int CxMax = CxMin + (projectilePic.getWidth() / 2);
                int CyMax = CyMin + (projectilePic.getHeight() / 2);

                if (curProjectile.Posy >= 1200) {
                    curEnimy.e_ProjectileList.remove(h);
                    //jamie spawn explosion
                    projetileList--;
                }
                // check enimy projectile hit player
                if ((AxMin >= CxMin && AxMin <= CxMax || AxMax >= CxMin && AxMax <= CxMax)
                        && (AyMin >= CyMin && AyMin <= CyMax || AyMax >= CyMin && AyMax <= CyMax)) {
                    curEnimy.e_ProjectileList.remove(h);
                    projetileList--;
                    if (Settings.soundEnabled) {
                        Assets.explosion_sound.play(1);

                    }
                    if (hasSheild()) {
                        numSheild--;
                    } else {
                        numberOfLives--;
                        if (numberOfLives <= 0) {
                            Settings.addScore(score);
                            Settings.save(game.getFileIO());
                            state = GameState.GameOver;

                            if (Settings.soundEnabled)
                                Assets.DeathScreen_music.play();
                            game.submitScore(score);
                        }

                    }
                }
            }
            int projetileList2 = curEnimy.e_ProjectileList2.size();
            for (int h = 0; h < projetileList2; h++) {
                Projectile curProjectile = curEnimy.e_ProjectileList2.get(h);
                curProjectile.Posy += eProjectileSpeedLv2/4;
                curProjectile.Posx += -eProjectileSpeedLv2/8;
                int CxMin = curProjectile.Posx;
                int CyMin = curProjectile.Posy;
                int CxMax = CxMin + (projectilePic.getWidth() / 2);
                int CyMax = CyMin + (projectilePic.getHeight() / 2);

                if (curProjectile.Posy >= 1200) {
                    curEnimy.e_ProjectileList2.remove(h);
                    //jamie spawn explosion
                    projetileList--;
                }
                // check enimy projectile hit player
                if ((AxMin >= CxMin && AxMin <= CxMax || AxMax >= CxMin && AxMax <= CxMax)
                        && (AyMin >= CyMin && AyMin <= CyMax || AyMax >= CyMin && AyMax <= CyMax)) {
                    curEnimy.e_ProjectileList2.remove(h);
                    projetileList2--;
                    if (Settings.soundEnabled) {
                        Assets.explosion_sound.play(1);

                    }
                    if (hasSheild()) {
                        numSheild--;
                    } else {
                        numberOfLives--;
                        if (numberOfLives <= 0) {
                            Settings.addScore(score);
                            Settings.save(game.getFileIO());
                            state = GameState.GameOver;

                            if (Settings.soundEnabled)
                                Assets.DeathScreen_music.play();
                            game.submitScore(score);
                        }

                    }
                }
            }
            //endregion
            //region collision check if enimy is hitting player
            if ((AxMin >= BxMin && AxMin <= BxMax || AxMax >= BxMin && AxMax <= BxMax)
                    && (AyMin >= ByMin && AyMin <= ByMax || AyMax >= ByMin && AyMax <= ByMax)) {
                world.m_EnimyList3.remove(g);
                if (Settings.soundEnabled) {
                    Assets.explosion_sound.play(1);
                }
                if (hasSheild()) {
                    numSheild--;
                } else {
                    numberOfLives--;
                    if (numberOfLives <= 0) {
                        Settings.addScore(score);
                        Settings.save(game.getFileIO());
                        game.submitScore(score);
                        state = GameState.GameOver;

                        if (Settings.soundEnabled)
                            Assets.DeathScreen_music.play();

                    }
                }

                enimyList--;
            }
            //endregion
            //region checking player bullets are hitting enimy
            for (int i = 0; i < firedBullets; i++) {
                Projectile curPprojectile = world.m_player.m_projectile.get(i);
                int p_AxMin = curPprojectile.Posx;
                int p_AyMin = curPprojectile.Posy;
                int p_AxMax = p_AxMin + (projectilePic.getWidth() / 2);
                int p_AyMax = p_AyMin + (projectilePic.getHeight() / 2);

                int p_BxMin = curEnimy.posX;
                int p_ByMin = curEnimy.posY;
                int p_BxMax = BxMin + (lvl2EnimyPixmap.getWidth());
                int p_ByMax = ByMin + (lvl2EnimyPixmap.getHeight());


                //collision check player projectile hitting enimy
                if ((p_AxMin >= p_BxMin && p_AxMin <= p_BxMax || p_AxMax >= p_BxMin && p_AxMax <= p_BxMax)
                        && (p_AyMin >= p_ByMin && p_AyMin <= p_ByMax || p_AyMax >= p_ByMin && p_AyMax <= p_ByMax)) {

                    world.m_player.m_projectile.remove(i);
                    firedBullets--;
                    world.m_EnimyList3.remove(g);
                    enimyList--;
                    if (Settings.soundEnabled)
                        Assets.explosion_sound.play(1);
                    score += 50;

                }
            }
            for (int i = 0; i < firedBulletsA; i++) {
                Projectile curPprojectile = world.m_player.m_projectile2.get(i);
                int p_AxMin = curPprojectile.Posx;
                int p_AyMin = curPprojectile.Posy;
                int p_AxMax = p_AxMin + (projectilePic.getWidth() / 2);
                int p_AyMax = p_AyMin + (projectilePic.getHeight() / 2);

                int p_BxMin = curEnimy.posX;
                int p_ByMin = curEnimy.posY;
                int p_BxMax = BxMin + (lvl2EnimyPixmap.getWidth());
                int p_ByMax = ByMin + (lvl2EnimyPixmap.getHeight());


                //collision check player projectile hitting enimy
                if ((p_AxMin >= p_BxMin && p_AxMin <= p_BxMax || p_AxMax >= p_BxMin && p_AxMax <= p_BxMax)
                        && (p_AyMin >= p_ByMin && p_AyMin <= p_ByMax || p_AyMax >= p_ByMin && p_AyMax <= p_ByMax)) {

                    world.m_player.m_projectile2.remove(i);
                    firedBulletsA--;
                    world.m_EnimyList3.remove(g);
                    enimyList--;
                    if (Settings.soundEnabled)
                        Assets.explosion_sound.play(1);
                    score += 50;

                }
            }
            for (int i = 0; i < firedBulletsB; i++) {
                Projectile curPprojectile = world.m_player.m_projectile3.get(i);
                int p_AxMin = curPprojectile.Posx;
                int p_AyMin = curPprojectile.Posy;
                int p_AxMax = p_AxMin + (projectilePic.getWidth() / 2);
                int p_AyMax = p_AyMin + (projectilePic.getHeight() / 2);

                int p_BxMin = curEnimy.posX;
                int p_ByMin = curEnimy.posY;
                int p_BxMax = BxMin + (lvl2EnimyPixmap.getWidth());
                int p_ByMax = ByMin + (lvl2EnimyPixmap.getHeight());


                //collision check player projectile hitting enimy
                if ((p_AxMin >= p_BxMin && p_AxMin <= p_BxMax || p_AxMax >= p_BxMin && p_AxMax <= p_BxMax)
                        && (p_AyMin >= p_ByMin && p_AyMin <= p_ByMax || p_AyMax >= p_ByMin && p_AyMax <= p_ByMax)) {

                    world.m_player.m_projectile3.remove(i);
                    firedBulletsB--;
                    world.m_EnimyList3.remove(g);
                    enimyList--;
                    if (Settings.soundEnabled)
                        Assets.explosion_sound.play(1);
                    score += 50;

                }
            }
            //endregion
<<<<<<< HEAD

        if(score==2000) {
            world.m_EnimyList2.clear();
            world.m_EnimyList.clear();
            world.m_player.m_projectile.clear();
            game.setScreen(new Level2Trans(game));
            //state=GameState.Runningb;
        }

        if(sheildTimer<timePassed)
        {
            sheildTimer=0;
            numSheild=0;
=======
            //region boundry check
            if (curEnimy.posX > 800 || curEnimy.posX < -100 || curEnimy.posY > 1200) {
                world.m_EnimyList3.remove(g);
                enimyList--;
            }//endregion

            //update enimy position

        }


        //endregion
        //region player projectil boundry check
        for (int j = 0; j < firedBullets; j++) {

            if (world.m_player.m_projectile.get(j).Posy < -630 ||
                    world.m_player.m_projectile.get(j).Posx > 750 ||
                    world.m_player.m_projectile.get(j).Posx < -200) {
                world.m_player.m_projectile.remove(j);
                firedBullets--;

            }
>>>>>>> master

        }
        for (int j = 0; j < firedBulletsA; j++) {
            if (world.m_player.m_projectile2.get(j).Posy < -630 ||
                    world.m_player.m_projectile2.get(j).Posx > 800 ||
                    world.m_player.m_projectile2.get(j).Posx < -200) {
                world.m_player.m_projectile2.remove(j);
                firedBulletsA--;
            }
        }
        for (int j = 0; j < firedBulletsB; j++) {

            if (world.m_player.m_projectile3.get(j).Posy < -630 ||
                    world.m_player.m_projectile3.get(j).Posx > 800 ||
                    world.m_player.m_projectile3.get(j).Posx < -200) {
                world.m_player.m_projectile3.remove(j);
                firedBulletsB--;

            }

        }
        //endregion
        //endregion
        if (sheildTimer < timePassed) {
            sheildTimer = 0;
            numSheild = 0;

        }
        world.update(deltaTime);//update world clock

    }
    private void updatePaused(List<TouchEvent> touchEvents)
    {
        int len=touchEvents.size();
        for(int i=0;i<len;i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_DOWN) {
                if (event.x < 256 && event.x > 416) {
                    //zach this is where we put the pause logic. seacrh pause in this
                    state = GameState.Running;
                    return;
                }
                if(event.x<64&&event.y>416)
                {
                    //game.setScreen(new MaineMenuSceen(game));
                    return;
                }
            }
        }

    }
    @Override
    public void pause() {
        if(state == GameState.Running) {
            Settings.save(game.getFileIO());
            state = GameState.Paused;
        }
    }
    @Override
    public void resume() {
        if(state == GameState.Running);
        Settings.load(game.getFileIO());
    }
    @Override
    public void dispose() {}
    @Override
    public void present(float deltaTime)
    {
        Graphics g = game.getGraphics();
        drawWorld(world);


        drawText(g, score + "", g.getWidth() / 2 - (score + "").length()*20/2, 50);
        // if(state==GameState.Ready)
        //{
        //   drawReadyUI();
        //}
        if(state==GameState.Running)
        {
            drawWorld(world);
            drawText(g, score + "", g.getWidth() / 2 - (score + "").length()*20/2, 50);
            if (numberOfLives == 3){
                g.drawPixmap(Assets.healthPickup_B,675,25);
                g.drawPixmap(Assets.healthPickup_B,675,75);
                g.drawPixmap(Assets.healthPickup_B,675,125);
            }

            if (numberOfLives == 2){
                g.drawPixmap(Assets.healthPickup_B,675,25);
                g.drawPixmap(Assets.healthPickup_B,675,75);

            }

            if (numberOfLives == 1){
                g.drawPixmap(Assets.healthPickup_B,675,25);

            }
            if(numSheild>=2)
            {

                g.drawPixmap(SheildPickup,675,225);

            }
            if(numSheild>=1)
            {
                g.drawPixmap(SheildPickup,675,195);
            }

        }
        if(state==GameState.Runningb)
        {

            drawWorld2(world);
            drawText(g, score + "", g.getWidth() / 2 - (score + "").length()*20/2, 50);
            if (numberOfLives == 3){
                g.drawPixmap(Assets.healthPickup_B,675,25);
                g.drawPixmap(Assets.healthPickup_B,675,75);
                g.drawPixmap(Assets.healthPickup_B,675,125);
            }

            if (numberOfLives == 2){
                g.drawPixmap(Assets.healthPickup_B,675,25);
                g.drawPixmap(Assets.healthPickup_B,675,75);

            }

            if (numberOfLives == 1){
                g.drawPixmap(Assets.healthPickup_B,675,25);

            }
            if(numSheild>=2)
            {

                g.drawPixmap(SheildPickup,675,225);
            }
            if(numSheild>=1)
            {
                g.drawPixmap(SheildPickup,675,195);
            }
        }
        if(state==GameState.Runningc)
        {

            drawWorld3(world);
            drawText(g, score + "", g.getWidth() / 2 - (score + "").length()*20/2, 50);
            if (numberOfLives == 3){
                g.drawPixmap(Assets.healthPickup_B,675,25);
                g.drawPixmap(Assets.healthPickup_B,675,75);
                g.drawPixmap(Assets.healthPickup_B,675,125);
            }

            if (numberOfLives == 2){
                g.drawPixmap(Assets.healthPickup_B,675,25);
                g.drawPixmap(Assets.healthPickup_B,675,75);

            }

            if (numberOfLives == 1){
                g.drawPixmap(Assets.healthPickup_B,675,25);

            }
            if(numSheild>=2)
            {

                g.drawPixmap(SheildPickup,675,225);
            }
            if(numSheild>=1)
            {
                g.drawPixmap(SheildPickup,675,195);
            }
        }
     /*   if(state==GameState.Paused)
       {
            drawPausedUI;
        }*/

        {
            //drawRunningUI();
        }
        //if(state==GameState.Paused)
        //{
        //  drawPausedUI;
        //}



    }
    public void drawText(Graphics g, String line, int x, int y)
    {
        int len = line.length();
        for (int i = 0; i < len; i++){
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
    private void drawWorld(World world)
    {
        Graphics g=game.getGraphics();
        Player player=world.m_player;

        int p_Pos_x;
        p_Pos_x=player.posX;

        int p_Pos_Y;
        p_Pos_x=player.posX;
        p_Pos_Y=player.posY;
        //g.drawPixmap(Assets.Level1_BG,0,0);

        int sven=world.m_BgList.size();
        for(int a=0;a<sven;a++)
        {
            BackGround newBackground=world.m_BgList.get(a);
            g.drawPixmap(BackGroundPic,newBackground.Posx,newBackground.posy);
        }


        int len=world.m_player.m_projectile.size();
        for (int i = 0; i < len; i++) {

            Projectile projectileA = world.m_player.m_projectile.get(i);
            g.drawPixmap(Assets.projectile, projectileA.Posx, projectileA.Posy);
        }int len2=world.m_player.m_projectile2.size();
        for (int i = 0; i < len2; i++) {

            Projectile projectileA = world.m_player.m_projectile2.get(i);
            g.drawPixmap(Assets.projectile, projectileA.Posx, projectileA.Posy);
        }
        int len3=world.m_player.m_projectile3.size();
        for (int i = 0; i < len3; i++) {

            Projectile projectileA = world.m_player.m_projectile3.get(i);
            g.drawPixmap(Assets.projectile, projectileA.Posx, projectileA.Posy);
        }


        g.drawPixmap(playerPixmap,p_Pos_x,world.m_player.posY);
        int ben=world.m_EnimyList.size();
        for(int b=0;b<ben;b++)
        {
            Enimy_TypeA currEnimy=world.m_EnimyList.get(b);
            int ken =currEnimy.e_ProjectileList.size();
            g.drawPixmap(lvl1EnimyPixmap,currEnimy.posX,currEnimy.posY);
            for(int r=0;r<ken;r++)
            {
                Projectile curProjectile=currEnimy.e_ProjectileList.get(r);
                g.drawPixmap(Assets.projectile, curProjectile.Posx, curProjectile.Posy);
            }
        }
        int puList=world.m_pickUpList.size();
        for(int i=0; i<puList; i++)
        {
            PickUp curPickup=world.m_pickUpList.get(i);
            int type=curPickup.type;
            switch(type)
            {
                case(0):
                    g.drawPixmap(healthPickup_B,curPickup.xPos,curPickup.yPos);
                    break;
                case(1):
                    g.drawPixmap(ShotGunPickup,curPickup.xPos,curPickup.yPos);
                    break;
                case(2):
                    g.drawPixmap(SheildPickup,curPickup.xPos,curPickup.yPos);
                    break;

            }

        }

        g.drawPixmap(playerPixmap,p_Pos_x,p_Pos_Y);

        g.drawPixmap(fireButton,fireButtonXpos,firButtonYpos);
        g.drawPixmap(mainMenuButton,mainMenuButtonXpos,mainMenuButtonYpos);
        g.drawPixmap(pauseButton,pauseButtonXpos,pauseButtonYpos);


    }
    private void drawWorld2(World world)
    {
        Graphics g=game.getGraphics();
        Player player=world.m_player;

        int p_Pos_x;
        p_Pos_x=player.posX;

        int p_Pos_Y;
        p_Pos_x=player.posX;
        p_Pos_Y=player.posY;
        //g.drawPixmap(Assets.Level1_BG,0,0);

        int sven=world.m_BgList2.size();
        for(int a=0;a<sven;a++)
        {
            BackGround newBackground=world.m_BgList2.get(a);
            g.drawPixmap(BackGroundPic2,newBackground.Posx,newBackground.posy);
        }


        int len=world.m_player.m_projectile.size();
        for (int i = 0; i < len; i++) {

            Projectile projectileA = world.m_player.m_projectile.get(i);
            g.drawPixmap(Assets.projectile, projectileA.Posx, projectileA.Posy);
        }
        int len2=world.m_player.m_projectile2.size();
        for (int i = 0; i < len2; i++) {

            Projectile projectileA = world.m_player.m_projectile2.get(i);
            g.drawPixmap(Assets.projectile, projectileA.Posx, projectileA.Posy);
        }
        int len3=world.m_player.m_projectile3.size();
        for (int i = 0; i < len3; i++) {

            Projectile projectileA = world.m_player.m_projectile3.get(i);
            g.drawPixmap(Assets.projectile, projectileA.Posx, projectileA.Posy);
        }

        g.drawPixmap(playerPixmap,p_Pos_x,world.m_player.posY);
        int puList=world.m_pickUpList.size();
        for(int i=0; i<puList; i++)
        {
            PickUp curPickup=world.m_pickUpList.get(i);
            int type=curPickup.type;
            switch(type)
            {
                case(0):
                    g.drawPixmap(healthPickup_B,curPickup.xPos,curPickup.yPos);
                    break;
                case(1):
                    g.drawPixmap(ShotGunPickup,curPickup.xPos,curPickup.yPos);
                    break;
                case(2):
                    g.drawPixmap(SheildPickup,curPickup.xPos,curPickup.yPos);
                    break;

            }

        }

        int ben=world.m_EnimyList2.size();
        for(int b=0;b<ben;b++)
        {
            Enimy_TypeB currEnimy=world.m_EnimyList2.get(b);
            int ken =currEnimy.e_ProjectileList.size();
            g.drawPixmap(lvl2EnimyPixmap,currEnimy.posX,currEnimy.posY);
            for(int r=0;r<ken;r++)
            {
                Projectile curProjectile=currEnimy.e_ProjectileList.get(r);
                g.drawPixmap(Assets.projectile, curProjectile.Posx, curProjectile.Posy);
            }
        }


        g.drawPixmap(playerPixmap,p_Pos_x,p_Pos_Y);

        g.drawPixmap(fireButton,fireButtonXpos,firButtonYpos);
        g.drawPixmap(mainMenuButton,mainMenuButtonXpos,mainMenuButtonYpos);
        g.drawPixmap(pauseButton,pauseButtonXpos,pauseButtonYpos);


    }
    private void drawWorld3(World world)
    {
        Graphics g=game.getGraphics();
        Player player=world.m_player;

        int p_Pos_x;
        p_Pos_x=player.posX;

        int p_Pos_Y;
        p_Pos_x=player.posX;
        p_Pos_Y=player.posY;
        //g.drawPixmap(Assets.Level1_BG,0,0);

        int sven=world.m_BgList2.size();
        for(int a=0;a<sven;a++)
        {
            BackGround newBackground=world.m_BgList2.get(a);
            g.drawPixmap(BackGroundPic3,newBackground.Posx,newBackground.posy);
        }


        int len=world.m_player.m_projectile.size();
        for (int i = 0; i < len; i++) {

            Projectile projectileA = world.m_player.m_projectile.get(i);
            g.drawPixmap(Assets.projectile, projectileA.Posx, projectileA.Posy);
        }
        int len2=world.m_player.m_projectile2.size();
        for (int i = 0; i < len2; i++) {

            Projectile projectileA = world.m_player.m_projectile2.get(i);
            g.drawPixmap(Assets.projectile, projectileA.Posx, projectileA.Posy);
        }
        int len3=world.m_player.m_projectile3.size();
        for (int i = 0; i < len3; i++) {

            Projectile projectileA = world.m_player.m_projectile3.get(i);
            g.drawPixmap(Assets.projectile, projectileA.Posx, projectileA.Posy);
        }

        g.drawPixmap(playerPixmap,p_Pos_x,world.m_player.posY);
        int puList=world.m_pickUpList.size();
        for(int i=0; i<puList; i++)
        {
            PickUp curPickup=world.m_pickUpList.get(i);
            int type=curPickup.type;
            switch(type)
            {
                case(0):
                    g.drawPixmap(healthPickup_B,curPickup.xPos,curPickup.yPos);
                    break;
                case(1):
                    g.drawPixmap(ShotGunPickup,curPickup.xPos,curPickup.yPos);
                    break;
                case(2):
                    g.drawPixmap(SheildPickup,curPickup.xPos,curPickup.yPos);
                    break;
                case(3):
                    g.drawPixmap(bombpickup,curPickup.xPos,curPickup.yPos);
                    break;

            }

        }

        int ben=world.m_EnimyList3.size();
        for(int b=0;b<ben;b++)
        {
            Enimy_TypeC currEnimy=world.m_EnimyList3.get(b);
            int ken =currEnimy.e_ProjectileList.size();
            g.drawPixmap(lvl3EnimyPixmap,currEnimy.posX,currEnimy.posY);
            for(int r=0;r<ken;r++)
            {
                Projectile curProjectile=currEnimy.e_ProjectileList.get(r);
                g.drawPixmap(Assets.projectile, curProjectile.Posx, curProjectile.Posy);
            }
            int jen =currEnimy.e_ProjectileList2.size();
            for(int r=0;r<jen;r++)
            {
                Projectile curProjectile=currEnimy.e_ProjectileList2.get(r);
                g.drawPixmap(Assets.projectile, curProjectile.Posx, curProjectile.Posy);
            }

        }


        g.drawPixmap(playerPixmap,p_Pos_x,p_Pos_Y);

        g.drawPixmap(fireButton,fireButtonXpos,firButtonYpos);
        g.drawPixmap(mainMenuButton,mainMenuButtonXpos,mainMenuButtonYpos);
        g.drawPixmap(pauseButton,pauseButtonXpos,pauseButtonYpos);


    }
}