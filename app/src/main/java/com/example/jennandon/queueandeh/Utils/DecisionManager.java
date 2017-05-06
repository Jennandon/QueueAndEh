package com.example.jennandon.queueandeh.Utils;

import android.content.res.Resources;

import com.example.jennandon.queueandeh.Decision.Decision;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
                    ourInstance.setDecisionMap(parser.loadData(resources));
                }
            }
        }
    }
    public static DecisionManager getInstance() {
        return ourInstance;
    }

    public Map<Integer, Decision> getDecisionMap() {
        return decisionMap;
    }

    public void setDecisionMap(final Map<Integer, Decision> decisionMap){
        this.decisionMap = decisionMap;
    }

    public Integer getRandomLeafId() {

        List<Integer> leafIds = new ArrayList<>();

        // if decision is a leaf, add it to list for random selection
        for (Decision decision : decisionMap.values()) {
            if (decision.isLeaf()) {
                leafIds.add(decision.getId());
            }
        }

        // randomly select a leaf ID from the list
        Random r = new Random();
        return leafIds.get(r.nextInt(leafIds.size()));
    }

}
