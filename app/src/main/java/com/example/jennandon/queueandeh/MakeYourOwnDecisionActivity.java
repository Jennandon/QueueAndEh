package com.example.jennandon.queueandeh;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

/**
 * Created by jennmacfarlane on 2017-04-24.
 **/


    public class MakeYourOwnDecisionActivity extends ActionBarActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.makeyourowndecisionend);
            this.getResources().openRawResource(R.raw.decisiontreexml);

        }

        /** Called when the user clicks the Send button */
        public void sendMessage(View view) {

            // Do something in response to button
        }
    }
