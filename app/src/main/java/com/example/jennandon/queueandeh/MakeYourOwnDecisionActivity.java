package com.example.jennandon.queueandeh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by jennmacfarlane on 2017-04-24.
 **/


    public class MakeYourOwnDecisionActivity extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.makeyourowndecisionend);
            this.getResources().openRawResource(R.raw.decisiontreexml);

            // TODO: refactor so that the code isn't duplicated in decisionActivity
            setStartOverBtn();
        }

    // sets the button for going back to the start
    protected void setStartOverBtn() {
        final Button startOverBtn = (Button) findViewById(R.id.start_over);
        startOverBtn.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //yesBtn.setBackgroundColor(Color.RED);
                        Intent i = new Intent(MakeYourOwnDecisionActivity.this, StartActivity.class);
                        //i.putExtra(getString(R.string.stop_name_key), stop.getNumber());
                        startActivity(i);
                    }
                }
        );
    }
    }

