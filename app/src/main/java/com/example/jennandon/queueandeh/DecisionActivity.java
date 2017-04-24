package com.example.jennandon.queueandeh;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

/**
 * Created by andrewbates11 on 2017-02-21.
 */

public class DecisionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testlayout3node);
        this.getResources().openRawResource(R.raw.decisiontreexml);

    }


}
