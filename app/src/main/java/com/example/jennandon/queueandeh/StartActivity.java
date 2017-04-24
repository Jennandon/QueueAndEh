package com.example.jennandon.queueandeh;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jennandon.queueandeh.Utils.GameData;
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
        GameData.loadInstance(this.getResources());
        GameData gameData = GameData.getInstance();

        setYesButton();
        setNoButton();
    }

    // when yes button is pressed, go to main decision view
    protected void setYesButton() {
        final Button yesBtn = (Button) findViewById(R.id.YES);
        yesBtn.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //yesBtn.setBackgroundColor(Color.RED);
                        Intent i = new Intent(StartActivity.this, DecisionActivity.class);
                        //i.putExtra(getString(R.string.stop_name_key), stop.getNumber());
                        startActivity(i);
                        //overridePendingTransition(R.anim.slide_in_from_right, android.R.anim.fade_out);
                    }
                }
        );
    }

    // when no button is pressed, end and tell user to make their own decision
    protected void setNoButton() {
        final Button noBtn = (Button) findViewById(R.id.NO);
        noBtn.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(StartActivity.this, MakeYourOwnDecisionActivity.class);
                        startActivity(i);

                    }
                }
        );

    }
}
