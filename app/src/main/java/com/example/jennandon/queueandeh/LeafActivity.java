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
 * Created by shanben7 on 2017-05-05.
 **/



public class LeafActivity extends AbstractDecisionActivity {
    private Decision currentDecision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.leaflayout);

        Integer extra = getIntent().getIntExtra("decision", 1);
        currentDecision = DecisionManager.getInstance().getDecisionMap().get(extra);

        setStartOverBtn();
        setMoreInfoButton(currentDecision);
        setDecisionFields(currentDecision);
        setGoBackBtn(currentDecision);
    }

}

