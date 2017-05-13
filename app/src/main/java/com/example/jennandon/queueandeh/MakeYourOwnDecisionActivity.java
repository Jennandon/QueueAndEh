package com.example.jennandon.queueandeh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by jennmacfarlane on 2017-04-24.
 **/


    public class MakeYourOwnDecisionActivity extends AbstractDecisionActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.yourowndecisionlayout);

            setStartOverBtn();
        }
    }

