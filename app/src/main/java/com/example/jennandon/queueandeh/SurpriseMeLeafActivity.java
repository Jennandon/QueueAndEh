package com.example.jennandon.queueandeh;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jennandon.queueandeh.Decision.Decision;
import com.example.jennandon.queueandeh.Utils.DecisionManager;

/**
 * Created by jennmacfarlane on 2017-05-08.
 */



public class SurpriseMeLeafActivity extends AbstractDecisionActivity {
    private Decision currentDecision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surprisemeleaflayout);

        Integer extra = getIntent().getIntExtra("decision", 1);
        currentDecision = DecisionManager.getInstance().getDecisionMap().get(extra);

        setStartOverBtn();
        setDecisionFields(currentDecision);
        setMoreInfoButton(currentDecision);
        setMapsButton();
    }

    public void setMapsButton() {
        final Button mapsButton = (Button) findViewById(R.id.maps);
        mapsButton.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String uri = "http://maps.google.co.in/maps?q=" + currentDecision.getLocation();
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                        mapIntent.setPackage("com.google.android.apps.maps");
                        if (mapIntent.resolveActivity(getPackageManager()) != null) {
                            startActivity(mapIntent);
                        }
                    }
                });
    }


}