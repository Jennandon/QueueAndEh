package com.example.jennandon.queueandeh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jennandon.queueandeh.Decision.Decision;
import com.example.jennandon.queueandeh.Utils.DecisionManager;

/**
 * Created by shanben7 on 2017-02-21.
 */

public class DecisionActivity extends AbstractDecisionActivity {
    private Decision currentDecision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.decisionlayout);

        Integer extra = getIntent().getIntExtra("decision", 1);
        currentDecision = DecisionManager.getInstance().getDecisionMap().get(extra);

        setStartOverBtn();
        setSurpriseMeButton();

        setDecisionFields();

        setYesButton();
        setNoButton();
        setGoBackBtn(currentDecision);
    }

    //sets decision fields for the current decision
    protected void setDecisionFields() {

        // display the current decision's text
        TextView decisionTextView = (TextView) findViewById(R.id.decisionText);
        decisionTextView.setText(currentDecision.getText());

        // display the current decision's image
        ImageView decisionImageView = (ImageView) findViewById(R.id.decision_image);
        String variableValue = currentDecision.getImageName();
        decisionImageView.setImageResource(getResources().getIdentifier(variableValue, "drawable", getPackageName()));
    }

    // when yes button is pressed, go to this decision's "yes" subDecision
    protected void setYesButton() {
        final Button chsYesBtn = (Button) findViewById(R.id.YES);
        chsYesBtn.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i;

                        if (DecisionManager.getInstance().getDecisionMap().get(currentDecision.getYesSubdecision()).isLeaf()) {
                            i = new Intent(DecisionActivity.this, LeafActivity.class);
                        }

                        else {
                            i = new Intent(DecisionActivity.this, DecisionActivity.class);
                        }

                        i.putExtra("decision", currentDecision.getYesSubdecision());
                        startActivity(i);

                        overridePendingTransition(R.anim.abc_fade_in, android.R.anim.fade_out);
                    }
                }
        );
    }

    // when no button is pressed, go to this decision's "no" subDecision
    protected void setNoButton() {
        final Button chsNoBtn = (Button) findViewById(R.id.NO);
        chsNoBtn.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i;

                        if (DecisionManager.getInstance().getDecisionMap().get(currentDecision.getNoSubdecision()).isLeaf()) {
                            i = new Intent(DecisionActivity.this, LeafActivity.class);
                        }

                        else {
                            i = new Intent(DecisionActivity.this, DecisionActivity.class);
                        }

                        i.putExtra("decision", currentDecision.getNoSubdecision());
                        startActivity(i);

                        overridePendingTransition(R.anim.abc_fade_in, android.R.anim.fade_out);
                    }
                }
        );

    }

}
