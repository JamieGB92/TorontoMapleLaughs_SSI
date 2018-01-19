package com.company.torontomaplelaughs.ssi;

/**
 * Created by J on 1/12/2018.
 */


import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 12/15/2017.
 */

public class Enimy_TypeC {
    public int posX,posY, SpeedX, SpeedY;
    public float shotTimer, w_Time;
    public List<com.company.torontomaplelaughs.ssi.Projectile> e_ProjectileList;
    public List<com.company.torontomaplelaughs.ssi.Projectile> e_ProjectileList2;
    public boolean isShooting=false;

    public Enimy_TypeC(int x, int y, float shotIntervle,float worldTime, int speedx,int speedy)
    {
        this.posX=x;
        this.posY=y;
        this.shotTimer=shotIntervle;
        this.SpeedX=speedx;
        this.SpeedY=speedy;
        this.w_Time=worldTime;
        e_ProjectileList=new ArrayList<>();
        e_ProjectileList2=new ArrayList<>();


    }

    void fire()
    {
        e_ProjectileList.add(new com.company.torontomaplelaughs.ssi.Projectile(this.posX,this.posY));
        e_ProjectileList2.add(new com.company.torontomaplelaughs.ssi.Projectile(this.posX,this.posY));
    }
}
