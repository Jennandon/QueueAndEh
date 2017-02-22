package com.example.jennandon.queueandeh.dummy;

import android.util.Xml;

import com.example.jennandon.queueandeh.Decision.Decision;

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
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        addItem(new DummyItem("1", "Item 1"));
        addItem(new DummyItem("2", "Item 2"));
        addItem(new DummyItem("3", "Item 3"));
        loadData();
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String content;

        public DummyItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }

    private static void loadData() {

        try {
            InputStream raw = new FileInputStream(new File("/Users/Shannon/Dropbox/School/PersProjs/IDC/QueueAndEh/app/src/main/res/raw/example1.xml"));
            try{
                parseDecisionsXML(raw);
            }catch(Exception e) {
                System.out.println("delete me later DEAR GOD DELETE ME LATER");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static final String ns = null;

    public static List parseDecisionsXML(InputStream in) throws XmlPullParserException, IOException {
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

    private static List readFeed(XmlPullParser parser) throws XmlPullParserException, IOException {
        List decisions = new ArrayList();

        parser.require(XmlPullParser.START_TAG, ns, "decisions");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the decision tag
            if (name.equals("decision")) {
                decisions.add(readDecision(parser));

            } else {
                skip(parser);
            }
        }
        return decisions;
    }

    // Parses the contents of a decision. If it encounters a title, summary, or link tag, hands them off
// to their respective "read" methods for processing. Otherwise, skips the tag.
    private static Decision readDecision(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "decision");

        Decision decision = new Decision();

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();

            String stringID = parser.getAttributeValue(null, "id");
            decision.setId(Integer.parseInt(stringID));
            System.out.println(decision.getId());
            parser.nextTag();


            String stringRoot = parser.getAttributeValue(null, "root");
            decision.setRootId(Integer.parseInt(stringRoot));
            System.out.println(decision.getRootId());
            parser.nextTag();

            String stringParent = parser.getAttributeValue(null, "parent");
            decision.setParentId(Integer.parseInt(stringParent));
            System.out.println(decision.getParentId());
            parser.nextTag();

            if (name.equals("text")) {
                decision.setText(readText(parser));
                System.out.println(decision.getText());

            } else if (name.equals("picture")) {
                decision.setImagePath(readPicture(parser));
                System.out.println(decision.getImagePath());

            } else if (name.equals("sound")) {
                decision.setSoundPath(readSound(parser));
                System.out.println(decision.getSoundPath());

            } else if (name.equals("resources")) {
                // deal with resources
                // sout decision.getResources()

            } else if (name.equals("subdecision")) {
                String stringSubID = parser.getAttributeValue(null, "id");
                Integer subDecisionID = Integer.parseInt(stringSubID);
                parser.nextTag();

                String subDecisionText = readSubdecisionText(parser);

                decision.getSubDecisions().put(subDecisionID, subDecisionText);

                System.out.println(decision.getSubDecisions());

            } else {
                skip(parser);
            }
        }
        return decision;
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

    // Processes text tags in the feed.
    private static String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "text");
        String text = readTextField(parser);
        parser.require(XmlPullParser.END_TAG, ns, "text");
        return text;
    }

    // Processes picture tags in the feed.
    private static String readPicture(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "picture");
        String picture = readTextField(parser);
        parser.require(XmlPullParser.END_TAG, ns, "picture");
        return picture;
    }

    // Processes sound tags in the feed.
    private static String readSound(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "sound");
        String sound = readTextField(parser);
        parser.require(XmlPullParser.END_TAG, ns, "sound");
        return sound;
    }

    // Processes text tags in the feed.
    private static String readSubdecisionText(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "subdecision");
        String subDecisionText = readTextField(parser);
        parser.require(XmlPullParser.END_TAG, ns, "subdecision");
        return subDecisionText;
    }












//    // Processes resources tags in the feed.
//    private List<Resource> readResources(XmlPullParser parser) throws IOException, XmlPullParserException {
//        parser.require(XmlPullParser.START_TAG, ns, "sound");
//         sound = readTextField(parser);
//        parser.require(XmlPullParser.END_TAG, ns, "sound");
//        return sound;
//    }

    // For the tags title and summary, extracts their text values.
    private static String readTextField(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

    private static void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
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