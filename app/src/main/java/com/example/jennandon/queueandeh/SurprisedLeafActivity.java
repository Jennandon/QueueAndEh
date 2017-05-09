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
 * Created by jennmacfarlane on 2017-05-08.
 */



public class SurprisedLeafActivity extends Activity {
    private Decision currentDecision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.surprisedleaflayout);

        Integer extra = getIntent().getIntExtra("decision", 1);
        currentDecision = DecisionManager.getInstance().getDecisionMap().get(extra);

        // TODO: refactor this
        setStartOverBtn();
        setDecisionFields();
        //setGoBackBtn();
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
                        Intent i = new Intent(SurprisedLeafActivity.this, StartActivity.class);
                        startActivity(i);
                        overridePendingTransition(R.anim.abc_fade_in, android.R.anim.fade_out);
                    }
                }
        );
    }

//    //sets the button for going back to the parent decision
//    protected void setGoBackBtn() {
//        final Button goBackBtn = (Button) findViewById(R.id.back);
//        goBackBtn.setOnClickListener(
//                new Button.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (currentDecision.getId() != 1) {
//                            Intent i = new Intent(SurprisedLeafActivity.this, DecisionActivity.class);
//                            i.putExtra("decision", currentDecision.getParentId());
//                            startActivity(i);
//                            overridePendingTransition(R.anim.abc_fade_in, android.R.anim.fade_out);
//                        } else {
//                            Intent i = new Intent(SurprisedLeafActivity.this, StartActivity.class);
//                            startActivity(i);
//                            overridePendingTransition(R.anim.abc_fade_in, android.R.anim.fade_out);
//                        }
//                    }
//                }
//        );
//    }
}