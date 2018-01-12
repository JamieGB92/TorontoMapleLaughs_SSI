package com.company.torontomaplelaughs.androidgames.framework;

import com.company.torontomaplelaughs.androidgames.framework.Graphics.PixmapFormat;

public interface Pixmap 
{
    public int getWidth();
    public int getHeight();
    public PixmapFormat getFormat();
    public void dispose();
}

