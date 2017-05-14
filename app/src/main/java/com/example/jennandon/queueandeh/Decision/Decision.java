package com.example.jennandon.queueandeh.Decision;

/**
 * Created by andrewbates11 on 2017-02-21.
 */

import java.util.List;

/**
 * A class to model the decisions parsed from the XML
 */
public class Decision {
    private String text;
    private Integer id;
    private Integer parentId;
    private Integer yesSubdecision;
    private Integer noSubdecision;
    private String location;
    private String infoURL;
    private String imageName;

    // private String soundName;

    public Decision(){
        this.text = null;
        this.id = null;
        this.parentId = null;
        this.yesSubdecision = null;
        this.noSubdecision = null;
        this.infoURL = null;
        this.imageName = null;
        this.location = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getInfoURL() {
        return infoURL;
    }

    public void setInfoURL(String infoURL) {
        this.infoURL = infoURL;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /*
    returns true if this decision has no subDecisions and is leaf of decisionTree
     */
    public boolean isLeaf() {
        return (this.yesSubdecision == null && this.noSubdecision == null);
    }

}
