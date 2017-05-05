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
 * Created by andrewbates11 on 2017-02-21.
 */

public class DecisionActivity extends Activity {
    private Decision currentDecision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testlayout3node);
        this.getResources().openRawResource(R.raw.decisiontreexml);

        // TODO: refactor this
        setStartOverBtn();
        setDecisionFields();
    }

    //sets decision fields for the current decision
    protected void setDecisionFields() {
        currentDecision = DecisionManager.getInstance().getFirstDecision();

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
                        Intent i = new Intent(DecisionActivity.this, StartActivity.class);
                        startActivity(i);
                    }
                }
        );
    }

    // when yes button is pressed, go to the corresponding decisionactivity or decision leaf
    protected void chooseYesButton() {
        final Button chsYesBtn = (Button) findViewById(R.id.YES);
        chsYesBtn.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(DecisionActivity.this, DecisionActivity.class);
                        startActivity(i);
                    }
                }
        );
    }

    // when no button is pressed, go to the corresponding next decisionactivity or decision leaf
    protected void chooseNoButton() {
        final Button chsNoBtn = (Button) findViewById(R.id.NO);
        chsNoBtn.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(DecisionActivity.this, DecisionActivity.class);
                        startActivity(i);

                    }
                }
        );

    }


}
