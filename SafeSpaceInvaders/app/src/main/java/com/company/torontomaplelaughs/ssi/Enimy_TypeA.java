package com.company.torontomaplelaughs.ssi;

import com.company.torontomaplelaughs.ssi.Projectile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 12/1/2017.
 */

public class Enimy_TypeA {

    public int posX,posY, SpeedX, SpeedY;
    public float shotTimer, w_Time;
    public List<Projectile> e_ProjectileList;
    public boolean isShooting=false;

    public Enimy_TypeA(int x, int y, float shotIntervle,float worldTime, int speedx,int speedy)
    {
        this.posX=x;
        this.posY=y;
        this.shotTimer=shotIntervle;
        this.SpeedX=speedx;
        this.SpeedY=speedy;
        this.w_Time=worldTime;
        e_ProjectileList=new ArrayList<>();


    }

    void fire()
    {
        e_ProjectileList.add(new Projectile(this.posX,this.posY));
    }
}



