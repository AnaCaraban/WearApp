package edu.cs4730.wearapp;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.widget.Toast.makeText;

/*
  * simple app that shows random number.
  *
  * Note there is a round, notround, and layout directory.  in support.wear it will now select the
  * "correct" one.  It square uses notround, round uses round and layout appears unused in the wear.
  *
  * bluetooth debugging: https://developer.android.com/training/wearables/apps/debugging.html
  *
  * remember these gpt bluetooth:
  * adb forward tcp:4444 localabstract:/adb-hub
    adb connect 127.0.0.1:4444
 */

public class MainActivity extends WearableActivity {

    private TextView stepgoal;
    ImageButton ibless, ibmore;
    Button ibsubmit;

    int stepsSet = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        stepgoal = (TextView) findViewById(R.id.dailyNumber);
        ibless = (ImageButton) findViewById(R.id.dailyMinus);
        ibmore = (ImageButton) findViewById(R.id.dailyMore);
        ibsubmit = (Button) findViewById(R.id.submit);


        ibless.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                stepsSet-=1000;
                stepgoal.setText(Integer.toString(stepsSet));
            }
        });

        ibmore.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                stepsSet+=1000;
                stepgoal.setText(Integer.toString(stepsSet));
            }
        });

        ibsubmit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Goal updated", Toast.LENGTH_SHORT).show();
            }
        });

        // Enables Always-on
        setAmbientEnabled();
    }
}