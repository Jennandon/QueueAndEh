package com.example.jennandon.queueandeh.Decision;

/**
 * Created by andrewbates11 on 2017-02-21.
 */

import android.graphics.drawable.Drawable;
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
    private Integer yesSubdecision;
    private Integer noSubdecision;
    private String soundPath;
    private Drawable imagePath;
    private List<String> resources;

    public Decision(){
        this.text = null;
        this.id = null;
        this.rootId = null;
        this.parentId = null;
        this.yesSubdecision = null;
        this.noSubdecision = null;
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

    public Integer getYesSubdecision() {return yesSubdecision;}

    public void setYesSubdecision(Integer yesSubdecision) {this.yesSubdecision = yesSubdecision;}

    public Integer getNoSubdecision() {return noSubdecision;}

    public void setNoSubdecision(Integer noSubdecision) {this.noSubdecision = noSubdecision;}

    public String getSoundPath() {
        return soundPath;
    }

    public void setSoundPath(String soundPath) {
        this.soundPath = soundPath;
    }

    public Drawable getImagePath() {
        return imagePath;
    }

    public void setImagePath(Drawable imagePath) {
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

    /*
    returns true if this decision has no subDecisions and is leaf of decisionTree
     */
    public boolean isLeaf() {
        return (this.yesSubdecision == null && this.noSubdecision == null);
    }

}
