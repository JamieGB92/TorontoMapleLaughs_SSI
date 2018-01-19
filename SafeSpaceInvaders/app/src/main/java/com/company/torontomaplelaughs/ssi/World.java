package com.company.torontomaplelaughs.ssi;
import com.company.torontomaplelaughs.ssi.Enimy_TypeA;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by J on 10/12/2017.
 */

import java.util.ArrayList;
import java.util.Random;

public class World {
    static final int WORLD_WIDTH=10;
    static final int WORLD_HEIGHT=15;
    static final int ScoreINC_A=10;
    static final int ScorInc_B=20;
    static final float TICK_INTIAL=0.01f;
    static final float TICK_DECREMENT=0.5F;
    public final int startPosX=500;
    public final int startPosY=1000;

    public com.company.torontomaplelaughs.ssi.Player m_player;
    public List<com.company.torontomaplelaughs.ssi.BackGround> m_BgList;
    public List<com.company.torontomaplelaughs.ssi.BackGround> m_BgList2;

    public List<Enimy_TypeA> m_EnimyList;
    public List<com.company.torontomaplelaughs.ssi.Enimy_TypeB> m_EnimyList2;
    public List<com.company.torontomaplelaughs.ssi.Enimy_TypeC> m_EnimyList3;
    public List<com.company.torontomaplelaughs.ssi.PickUp> m_pickUpList;


    public boolean gameOver=false;
    public int score =0;

    boolean feilds[][]=new boolean[WORLD_WIDTH][WORLD_HEIGHT];
    Random random = new Random();
    float tickTime=0;
    static float tick=TICK_INTIAL;

    public World()
    {

        m_player=new com.company.torontomaplelaughs.ssi.Player(startPosX,startPosY);
        m_BgList=new ArrayList<>();
        m_BgList2=new ArrayList<>();

        m_player=new com.company.torontomaplelaughs.ssi.Player(500,500);
        m_EnimyList=new ArrayList<>();
        m_EnimyList2=new ArrayList<>();
        m_EnimyList3=new ArrayList<>();
        m_pickUpList=new ArrayList<>();

    }

    public void update(float deltaTime)
    {


        tickTime+=deltaTime;

        while(tickTime>tickTime)
        {
            tickTime-=tick;


        }

    }
    public void pause(float deltaTime)
    {
        
        while(tickTime>tickTime)
        {

        }
    }

}
