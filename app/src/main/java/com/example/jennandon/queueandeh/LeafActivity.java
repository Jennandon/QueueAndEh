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
 * Created by shanben7 on 2017-05-05.
 **/



public class LeafActivity extends Activity {
    private Decision currentDecision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.leaflayout);

        Integer extra = getIntent().getIntExtra("decision", 2);
        currentDecision = DecisionManager.getInstance().getDecisionMap().get(extra);

        // TODO: refactor this
        setStartOverBtn();
        setDecisionFields();
        setGoBackBtn();
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


    // sets the button for going back to the start
    protected void setStartOverBtn() {
        final Button startOverBtn = (Button) findViewById(R.id.start_over);
        startOverBtn.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(LeafActivity.this, StartActivity.class);
                        startActivity(i);
                    }
                }
        );
    }

    //sets the button for going back to the parent decision
    protected void setGoBackBtn() {
        final Button goBackBtn = (Button) findViewById(R.id.back);
        goBackBtn.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (currentDecision.getId() != 2) {
                            Intent i = new Intent(LeafActivity.this, DecisionActivity.class);
                            i.putExtra("decision", currentDecision.getParentId());
                            startActivity(i);
                        } else {
                            Intent i = new Intent(LeafActivity.this, StartActivity.class);
                            startActivity(i);
                        }
                    }
                }
        );
    }
}