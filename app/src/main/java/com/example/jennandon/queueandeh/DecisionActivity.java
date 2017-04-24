package com.example.jennandon.queueandeh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jennandon.queueandeh.Decision.Decision;
import com.example.jennandon.queueandeh.Utils.DecisionTree;

/**
 * Created by andrewbates11 on 2017-02-21.
 */

public class DecisionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testlayout3node);
        this.getResources().openRawResource(R.raw.decisiontreexml);

        // TODO: refactor this
        setStartOverBtn();
        setDecisionText();
    }


    protected void setDecisionText() {
        TextView decisionTextView = (TextView) findViewById(R.id.decisionText);
        Decision decisionOne = DecisionTree.getInstance().getFirstDecision();

        decisionTextView.setText(decisionOne.getText());
    }



    // sets the button for going back to the start
    protected void setStartOverBtn() {
        final Button startOverBtn = (Button) findViewById(R.id.start_over);
        startOverBtn.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //yesBtn.setBackgroundColor(Color.RED);
                        Intent i = new Intent(DecisionActivity.this, StartActivity.class);
                        //i.putExtra(getString(R.string.stop_name_key), stop.getNumber());
                        startActivity(i);
                    }
                }
        );
    }


}
