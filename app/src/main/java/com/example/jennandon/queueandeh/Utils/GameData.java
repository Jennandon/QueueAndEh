package com.example.jennandon.queueandeh.Utils;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;

import com.example.jennandon.queueandeh.Decision.Decision;
import com.example.jennandon.queueandeh.R;

import java.util.Map;

/**
 * GameData singleton to contain static information of interest to our activities
 * Created by Shannon on 2017-02-22.
 */
public class GameData {

    private static GameData ourInstance;
    private Map<Integer, Decision> decisionMap;

    /* Private Constructor, prevents any other
     * class from instantiating.
     */
    private GameData() {
    }

    public static void loadInstance(final Resources resources){
        if(ourInstance == null){
            synchronized (GameData.class){
                //Double-check lock to make sure we have control of ourInstance
                if(ourInstance == null){
                    ourInstance = new GameData();
                    Parser parser = new Parser();
                    ourInstance.setGlobalMap(parser.loadData(resources));
                }
            }
        }
    }
    public static GameData getInstance() {
        return ourInstance;
    }

    public Map<Integer, Decision> getGlobalMap() {
        return decisionMap;
    }

    public void setGlobalMap(final Map<Integer, Decision> decisionMap){
        this.decisionMap = decisionMap;
    }

}
