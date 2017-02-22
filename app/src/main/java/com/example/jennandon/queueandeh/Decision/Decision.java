package com.example.jennandon.queueandeh.Decision;

/**
 * Created by andrewbates11 on 2017-02-21.
 */

import android.media.MediaPlayer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class to model the decisions parsed from the XML
 */
public class Decision {
    private String text;
    private Integer id;
    private Integer rootId;
    private Integer parentId;
    private Map<Integer, String> subDecisions;
    private String soundPath;
    private String imagePath;
    private List<String> resources;

    public Decision(){
        this.text = null;
        this.id = null;
        this.rootId = null;
        this.parentId = null;
        this.subDecisions = new HashMap<>();
        this.soundPath = null;
        this.imagePath = null;
        this.resources = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRootId() {
        return rootId;
    }

    public void setRootId(Integer rootId) {
        this.rootId = rootId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Map<Integer, String> getSubDecisions() {return subDecisions;
    }

    public void setSubDecisions(Map<Integer, String> subDecisions) {
        this.subDecisions = subDecisions;
    }

    public String getSoundPath() {
        return soundPath;
    }

    public void setSoundPath(String soundPath) {
        this.soundPath = soundPath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<String> getResources() {
        return resources;
    }

    public void setResources(List<String> resources) {
        this.resources = resources;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
