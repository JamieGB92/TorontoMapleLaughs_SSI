package com.company.torontomaplelaughs.ssi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zachary on 12/4/2017.
 */

public class Health {

    public int Posx, Posy;
    List<Health> m_Health;

    public Health(int x,int y)
    {
        this.Posx=x;
        this.Posy=y;
        m_Health=new ArrayList<>();
    }
}
