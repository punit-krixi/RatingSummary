package com.krixi.summary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.krixi.ratingsummary.RatingSummary;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            JSONObject starValues = new JSONObject("{\"1\": 0, \"2\": 0, \"3\": 3, \"4\": 11, \"5\": 2}");
            RatingSummary summary = (RatingSummary) findViewById(R.id.summaryContainer);
            summary.setStarValues(starValues);
            summary.drawRatingSummary();
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
