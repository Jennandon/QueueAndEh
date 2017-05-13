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
 * Created by Shannon on 2017-05-13.
 */

public abstract class AbstractDecisionActivity extends Activity {

    // sets the button for going back to the start
    protected void setStartOverBtn() {
        final Button startOverBtn = (Button) findViewById(R.id.start_over);
        startOverBtn.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(AbstractDecisionActivity.this, StartActivity.class);
                        startActivity(i);

                        overridePendingTransition(R.anim.abc_fade_in, android.R.anim.fade_out);
                    }
                });
    }

    //sets the button for going back to the parent decision
    protected void setGoBackBtn(final Decision decision){
        final Button goBackBtn = (Button) findViewById(R.id.back);
        goBackBtn.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (decision.getId() != 1) {
                            Intent i = new Intent(AbstractDecisionActivity.this, DecisionActivity.class);
                            i.putExtra("decision", decision.getParentId());
                            startActivity(i);

                            overridePendingTransition(R.anim.abc_fade_in, android.R.anim.fade_out);
                        } else {
                            Intent i = new Intent(AbstractDecisionActivity.this, StartActivity.class);
                            startActivity(i);

                            overridePendingTransition(R.anim.abc_fade_in, android.R.anim.fade_out);
                        }
                    }
                });
    }

    // sets the button for surprise, brings user to random leaf
    protected void setSurpriseMeButton() {
        final Button surpriseMeBtn = (Button) findViewById(R.id.surprise_me);
        surpriseMeBtn.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(AbstractDecisionActivity.this, SurpriseMeLeafActivity.class);
                        i.putExtra("decision", DecisionManager.getInstance().getRandomLeafId());
                        startActivity(i);
                        overridePendingTransition(R.anim.abc_fade_in, android.R.anim.fade_out);
                    }
                });
    }

    // sets the button for opening the leaf's info link in browser
    protected void setMoreInfoButton(final Decision decision) {
        final Button moreInfoBtn = (Button) findViewById(R.id.info);
        moreInfoBtn.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(decision.getInfoURL()));
                        startActivity(i);
                    }
                });
    }

    //sets decision fields for the current decision
    protected void setDecisionFields(final Decision decision) {

        // display the current decision's text
        TextView decisionTextView = (TextView) findViewById(R.id.decisionText);
        decisionTextView.setText(decision.getText());

        // display the current decision's image
        ImageView decisionImageView = (ImageView) findViewById(R.id.decision_image);
        String variableValue = decision.getImageName();
        decisionImageView.setImageResource(getResources().getIdentifier(variableValue, "drawable", getPackageName()));
    }

}

