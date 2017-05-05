package com.example.jennandon.queueandeh.Utils;

import android.content.res.Resources;

import com.example.jennandon.queueandeh.Decision.Decision;

import java.util.Map;

/**
 * DecisionManager singleton to contain static information of interest to our activities
 * Created by Shannon on 2017-02-22.
 */
public class DecisionManager {

    private static DecisionManager ourInstance;
    private Map<Integer, Decision> decisionMap;

    /* Private Constructor, prevents any other
     * class from instantiating.
     */
    private DecisionManager() {
    }

    public static void loadInstance(final Resources resources){
        if(ourInstance == null){
            synchronized (DecisionManager.class){
                //Double-check lock to make sure we have control of ourInstance
                if(ourInstance == null){
                    ourInstance = new DecisionManager();
                    Parser parser = new Parser();
                    ourInstance.setGlobalMap(parser.loadData(resources));
                }
            }
        }
    }
    public static DecisionManager getInstance() {
        return ourInstance;
    }

    public Map<Integer, Decision> getGlobalMap() {
        return decisionMap;
    }

    public Decision getFirstDecision() {
        return decisionMap.get(2);
    }

    public void setGlobalMap(final Map<Integer, Decision> decisionMap){
        this.decisionMap = decisionMap;
    }

}
