package com.company.torontomaplelaughs.safespaceinvaders;

import java.io.BufferedReader;
 import java.io.BufferedWriter;
 import java.io.File;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.io.OutputStreamWriter;

 import com.company.torontomaplelaughs.androidgames.framework.FileIO;

 /**
 * Created by Z on 11/30/2017.
 */

public class Settings {
    public static boolean soundEnabled = true;
    public static int[] highscores = new int[] {5,4,3,2,1};

    public static void load(FileIO files)
    {
        BufferedReader in = null;
        try{
            in = new BufferedReader(new InputStreamReader(files.readFile("safespaceinvaders.settings")));
            soundEnabled = Boolean.parseBoolean(in.readLine());
            for (int i = 0; i < 5; i++)
            {
                highscores[i] = Integer.parseInt(in.readLine());
            }
        } catch (IOException e) {

        }catch (NumberFormatException e) {

        }finally {
            try {
                if (in != null)
                    in.close();
            }catch (IOException e ){

            }
        }
    }

    public static void save(FileIO files) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    files.writeFile(".safespaceinvaders")));
            out.write(Boolean.toString(soundEnabled));
            out.write("\n");
            for (int i = 0; i <highscores.length; i++) {
                out.write(Integer.toString(highscores[i]));
                out.write("\n");
            }
        } catch (IOException e) {
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
            }
        }
    }

    public static void addScore(int score) {
        for (int i = 0; i < highscores.length; i++) {
            if (highscores[i] == score)
                return;
        }

        for (int i = 0; i <highscores.length; i++) {
            if (highscores[i] < score) {
                for (int j = highscores.length -1; j>i;j--)
                    highscores[j] = highscores[j-1];
                highscores[i] = score;
                break;
            }
        }
    }
}