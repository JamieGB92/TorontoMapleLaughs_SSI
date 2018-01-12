package com.company.torontomaplelaughs.safespaceinvaders;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by J on 10/12/2017.
 */
import java.util.List;
import java.util.ArrayList;
public class Player {
     public static final int Left=0;
    public static final int Right=9;
    public boolean movingLeft=false;
    public boolean movingRight=false;

    public int posX;
    public int posY;
    public int health;
    public int sheilds;
    public int score;

    public List<Projectile> m_projectile=new ArrayList<Projectile>();
    public List<Projectile> m_projectile2=new ArrayList<Projectile>();
    public List<Projectile> m_projectile3=new ArrayList<Projectile>();



    public Player(int x, int y)
    {

        posX=x;
        posY=y;
        m_projectile.clear();
        m_projectile2.clear();//for shotgun
        m_projectile3.clear();//for shotgun
    }




}
