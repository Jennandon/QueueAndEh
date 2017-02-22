package com.example.jennandon.queueandeh.Utils;

import android.app.Activity;
import android.content.res.Resources;
import android.util.Xml;

import com.example.jennandon.queueandeh.Decision.Decision;
import com.example.jennandon.queueandeh.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shannon on 2017-02-21.
 */

public class Parser{

        public Map<Integer, Decision> loadData(Resources resources){
            try{
                return parseDecisionsXML(resources.openRawResource(R.raw.example1));
            }
            catch(XmlPullParserException e){
                //TODO: Add logging here
                e.printStackTrace();
                return null;
            }
            catch(IOException e){
                //TODO: Add logging here
                e.printStackTrace();
                return null;
            }
        }

        private final String ns = null;

        private Map<Integer, Decision> parseDecisionsXML(InputStream in) throws XmlPullParserException, IOException {
            try {
                XmlPullParser parser = Xml.newPullParser();
                parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                parser.setInput(in, null);
                parser.nextTag();
                return readFeed(parser);
            } finally {
                in.close();
            }
        }

        private Map<Integer, Decision> readFeed(XmlPullParser parser) throws XmlPullParserException, IOException {
            Map<Integer, Decision> decisionMap = new HashMap<>();

            parser.require(XmlPullParser.START_TAG, ns, "decisions");
            while (parser.next() != XmlPullParser.END_TAG) {
                if (parser.getEventType() != XmlPullParser.START_TAG) {
                    continue;
                }
                String name = parser.getName();
                // Starts by looking for the decision tag
                if (name.equals("decision")) {
                    Decision decision = readDecision(parser);
                    decisionMap.put(decision.getId(), decision);
                } else {
                    skip(parser);
                }
            }
            return decisionMap;
        }

        // Parses the contents of a decision. If it encounters a title, summary, or link tag, hands them off
// to their respective "read" methods for processing. Otherwise, skips the tag.
        private Decision readDecision(XmlPullParser parser) throws XmlPullParserException, IOException {
            parser.require(XmlPullParser.START_TAG, ns, "decision");

            Decision decision = new Decision();

            String stringID = parser.getAttributeValue(null, "id");
            decision.setId(Integer.parseInt(stringID));
            String stringRoot = parser.getAttributeValue(null, "root");
            decision.setRootId(Integer.parseInt(stringRoot));
            String stringParent = parser.getAttributeValue(null, "parent");
            decision.setParentId(Integer.parseInt(stringParent));

            while (parser.next() != XmlPullParser.END_TAG) {
                if (parser.getEventType() != XmlPullParser.START_TAG) {
                    continue;
                }
                String name = parser.getName();

                if (name.equals("text")) {
                    decision.setText(readTextField(parser, "text"));
                    System.out.println(decision.getText());

                } else if (name.equals("picture")) {
                    decision.setImagePath(readTextField(parser, "picture"));
                    System.out.println(decision.getImagePath());

                } else if (name.equals("sound")) {
                    decision.setSoundPath(readTextField(parser, "sound"));
                    System.out.println(decision.getSoundPath());

                } else if (name.equals("resources")) {
                    readTextField(parser, "resources");
                }else if (name.equals("subdecisions")) {
                    readSubDecisions(parser, decision);
                }else{
                    skip(parser);
                }
            }
            return decision;
        }
        private void readSubDecisions(XmlPullParser parser, Decision decision)
                throws XmlPullParserException, IOException {
            parser.require(XmlPullParser.START_TAG, ns, "subdecisions");

            while (parser.next() != XmlPullParser.END_TAG) {
                if (parser.getEventType() != XmlPullParser.START_TAG) {
                    continue;
                }
                String name = parser.getName();

                if (name.equals("subdecision")) {
                    String subdecisionID = parser.getAttributeValue(null, "id");
                    String textValue = readTextField(parser, "subdecision");
                    decision.getSubDecisions().put(Integer.parseInt(subdecisionID), textValue);
                }
                else{
                    parser.next();
                }
            }
        }
        //// DOES NOTHING HERE ---- JUST FROM EXAMPLE
        // Processes link tags in the feed. / //// going to be decision tag
        private String readLink(XmlPullParser parser) throws IOException, XmlPullParserException {
            String link = "";
            parser.require(XmlPullParser.START_TAG, ns, "link");


            String tag = parser.getName();
            String relType = parser.getAttributeValue(null, "rel");
            if (tag.equals("link")) {
                if (relType.equals("alternate")) {
                    link = parser.getAttributeValue(null, "href");
                    parser.nextTag();
                }
            }
            parser.require(XmlPullParser.END_TAG, ns, "link");
            return link;
        }

        private String readTextField(XmlPullParser parser, String tag) throws IOException, XmlPullParserException {
            parser.require(XmlPullParser.START_TAG, ns, tag);
            String subDecisionText = readTextField(parser);
            parser.require(XmlPullParser.END_TAG, ns, tag);
            return subDecisionText;
        }

        // For the tags title and summary, extracts their text values.
        private String readTextField(XmlPullParser parser) throws IOException, XmlPullParserException {
            String result = "";
            if (parser.next() == XmlPullParser.TEXT) {
                result = parser.getText();
                parser.nextTag();
            }
            return result;
        }

        private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                throw new IllegalStateException();
            }
            int depth = 1;
            while (depth != 0) {
                switch (parser.next()) {
                    case XmlPullParser.END_TAG:
                        depth--;
                        break;
                    case XmlPullParser.START_TAG:
                        depth++;
                        break;
                }
            }
        }

    }
