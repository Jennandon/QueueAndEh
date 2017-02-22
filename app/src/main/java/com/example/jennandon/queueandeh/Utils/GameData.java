package com.example.jennandon.queueandeh.Utils;

import com.example.jennandon.queueandeh.Decision.Decision;

import java.util.Map;

/**
 * Created by Shannon on 2017-02-22.
 */
public class GameData extends Parser {

    private static GameData ourInstance = new GameData();
    private static Map<Integer, Decision> globalMap;

    /* Private Constructor, prevents any other
     * class from instantiating.
     */
    private GameData() {
       // this.globalMap = loadData(   );
    }

    public static GameData getInstance() {
        return ourInstance;
    }

    public static Map<Integer, Decision> getGlobalMap() {
        return globalMap;
    }

}
