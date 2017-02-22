package com.example.jennandon.queueandeh;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;

import com.example.jennandon.queueandeh.Utils.Parser;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by andrewbates11 on 2017-02-21.
 */

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testlayoutxml);
        Parser parser = new Parser();
        try {
            parser.loadData(this.getResources());
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.getResources();

    }
}
