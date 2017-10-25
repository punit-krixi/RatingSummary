package com.krixi.ratingsummary;


import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * Created by punit on 24/10/17.
 */

public class RatingSummary extends LinearLayout {

    private ProgressBar star1;
    private ProgressBar star2;
    private ProgressBar star3;
    private ProgressBar star4;
    private ProgressBar star5;
    private TextView star1SummaryCount;
    private TextView star2SummaryCount;
    private TextView star3SummaryCount;
    private TextView star4SummaryCount;
    private TextView star5SummaryCount;
    private LinearLayout ratingSummaryContainer;
    private int maxSizeOfBar;
    private JSONObject starValues;

    private int starsSummaryCountDefaultColor;
    private int star5SummaryCountColor;
    private int star4SummaryCountColor;
    private int star3SummaryCountColor;
    private int star2SummaryCountColor;
    private int star1SummaryCountColor;
    private int starsSummaryCountZeroValueDefaultColor;
    private int star5SummaryCountZeroValueColor;
    private int star4SummaryCountZeroValueColor;
    private int star3SummaryCountZeroValueColor;
    private int star2SummaryCountZeroValueColor;
    private int star1SummaryCountZeroValueColor;

    public RatingSummary(Context context) {
        super(context);
        View view =  LayoutInflater.from(context).inflate(R.layout.rating_summary, null);
        starValues = null;
        maxSizeOfBar = -1;
        initializeView(context,view, null);
        this.addView(view);
    }

    public RatingSummary(Context context, AttributeSet attrs){
        super(context,attrs);
        View view =  LayoutInflater.from(context).inflate(R.layout.rating_summary, null);
        starValues = null;
        maxSizeOfBar = -1;
        initializeView(context,view,attrs);
        this.addView(view);
    }

    private void initializeView(Context context, View view, AttributeSet attrs) {
        int starsSummaryColor = context.getResources().getColor(android.R.color.darker_gray);
        int star5SummaryColor = context.getResources().getColor(android.R.color.darker_gray);
        int star4SummaryColor = context.getResources().getColor(android.R.color.darker_gray);
        int star3SummaryColor = context.getResources().getColor(android.R.color.darker_gray);
        int star2SummaryColor = context.getResources().getColor(android.R.color.darker_gray);
        int star1SummaryColor = context.getResources().getColor(android.R.color.darker_gray);

        starsSummaryCountDefaultColor = context.getResources().getColor(android.R.color.white);
        star5SummaryCountColor = context.getResources().getColor(android.R.color.white);
        star4SummaryCountColor = context.getResources().getColor(android.R.color.white);
        star3SummaryCountColor = context.getResources().getColor(android.R.color.white);
        star2SummaryCountColor = context.getResources().getColor(android.R.color.white);
        star1SummaryCountColor = context.getResources().getColor(android.R.color.white);

        starsSummaryCountZeroValueDefaultColor = context.getResources().getColor(android.R.color.black);
        star5SummaryCountZeroValueColor = context.getResources().getColor(android.R.color.black);
        star4SummaryCountZeroValueColor = context.getResources().getColor(android.R.color.black);
        star3SummaryCountZeroValueColor = context.getResources().getColor(android.R.color.black);
        star2SummaryCountZeroValueColor = context.getResources().getColor(android.R.color.black);
        star1SummaryCountZeroValueColor = context.getResources().getColor(android.R.color.black);



        if(attrs != null){
            TypedArray typedArray = context.obtainStyledAttributes(attrs,
                    R.styleable.RatingSummary, 0, 0);

            starsSummaryColor = typedArray.getColor(R.styleable.RatingSummary_starsDefaultSummaryColor, context.getResources().getColor(android.R.color.darker_gray));
            star5SummaryColor = typedArray.getColor(R.styleable.RatingSummary_star5SummaryColor, starsSummaryColor);
            star4SummaryColor = typedArray.getColor(R.styleable.RatingSummary_star4SummaryColor, starsSummaryColor);
            star3SummaryColor = typedArray.getColor(R.styleable.RatingSummary_star3SummaryColor, starsSummaryColor);
            star2SummaryColor = typedArray.getColor(R.styleable.RatingSummary_star2SummaryColor, starsSummaryColor);
            star1SummaryColor = typedArray.getColor(R.styleable.RatingSummary_star1SummaryColor, starsSummaryColor);


            starsSummaryCountDefaultColor = typedArray.getColor(R.styleable.RatingSummary_starsSummaryCountDefaultColor, context.getResources().getColor(android.R.color.black));
            star5SummaryCountColor = typedArray.getColor(R.styleable.RatingSummary_star5SummaryCountColor, starsSummaryCountDefaultColor);
            star4SummaryCountColor = typedArray.getColor(R.styleable.RatingSummary_star4SummaryCountColor, starsSummaryCountDefaultColor);
            star3SummaryCountColor = typedArray.getColor(R.styleable.RatingSummary_star3SummaryCountColor, starsSummaryCountDefaultColor);
            star2SummaryCountColor = typedArray.getColor(R.styleable.RatingSummary_star2SummaryCountColor, starsSummaryCountDefaultColor);
            star1SummaryCountColor = typedArray.getColor(R.styleable.RatingSummary_star1SummaryCountColor, starsSummaryCountDefaultColor);

            starsSummaryCountZeroValueDefaultColor = typedArray.getColor(R.styleable.RatingSummary_starsSummaryCountZeroValueDefaultColor, context.getResources().getColor(android.R.color.black));
            star5SummaryCountZeroValueColor = typedArray.getColor(R.styleable.RatingSummary_star5SummaryCountZeroValueColor, starsSummaryCountZeroValueDefaultColor);
            star4SummaryCountZeroValueColor = typedArray.getColor(R.styleable.RatingSummary_star4SummaryCountZeroValueColor, starsSummaryCountZeroValueDefaultColor);
            star3SummaryCountZeroValueColor = typedArray.getColor(R.styleable.RatingSummary_star3SummaryCountZeroValueColor, starsSummaryCountZeroValueDefaultColor);
            star2SummaryCountZeroValueColor = typedArray.getColor(R.styleable.RatingSummary_star2SummaryCountZeroValueColor, starsSummaryCountZeroValueDefaultColor);
            star1SummaryCountZeroValueColor = typedArray.getColor(R.styleable.RatingSummary_star1SummaryCountZeroValueColor, starsSummaryCountZeroValueDefaultColor);


        }

        star1 = (ProgressBar) view.findViewById(R.id.star1);
        star2 = (ProgressBar) view.findViewById(R.id.star2);
        star3 = (ProgressBar) view.findViewById(R.id.star3);
        star4 = (ProgressBar) view.findViewById(R.id.star4);
        star5 = (ProgressBar) view.findViewById(R.id.star5);

        star1SummaryCount = (TextView) view.findViewById(R.id.star1SummaryCount);
        star2SummaryCount = (TextView) view.findViewById(R.id.star2SummaryCount);
        star3SummaryCount = (TextView) view.findViewById(R.id.star3SummaryCount);
        star4SummaryCount = (TextView) view.findViewById(R.id.star4SummaryCount);
        star5SummaryCount = (TextView) view.findViewById(R.id.star5SummaryCount);

        star5.getProgressDrawable().setColorFilter(star5SummaryColor, android.graphics.PorterDuff.Mode.SRC_IN);
        star4.getProgressDrawable().setColorFilter(star4SummaryColor, android.graphics.PorterDuff.Mode.SRC_IN);
        star3.getProgressDrawable().setColorFilter(star3SummaryColor, android.graphics.PorterDuff.Mode.SRC_IN);
        star2.getProgressDrawable().setColorFilter(star2SummaryColor, android.graphics.PorterDuff.Mode.SRC_IN);
        star1.getProgressDrawable().setColorFilter(star1SummaryColor, android.graphics.PorterDuff.Mode.SRC_IN);

        ratingSummaryContainer = (LinearLayout) view.findViewById(R.id.ratingSummaryContainer);
        ratingSummaryContainer.post(new Runnable() {

            @Override
            public void run() {
                maxSizeOfBar = ratingSummaryContainer.getWidth() - 100;
                if(starValues != null){
                    renderRatingOnUi();
                }
            }
        });
    }

    public void setStarValues(JSONObject starValues) {
        this.starValues = starValues;
    }

    public void drawRatingSummary(){
        if(maxSizeOfBar != -1){
            renderRatingOnUi();
        }
    }

    private void renderRatingOnUi() {
        int maxValue = -1;

        try {
            Iterator<?> keys = starValues.keys();

            while (keys.hasNext()) {
                String key = (String) keys.next();
                int value = starValues.getInt(key);
                if (maxValue < value) {
                    maxValue = value;
                }
            }


            if(starValues != null){
                int star5Value = starValues.getInt("5");
                int star4Value = starValues.getInt("4");
                int star3Value = starValues.getInt("3");
                int star2Value = starValues.getInt("2");
                int star1Value = starValues.getInt("1");

                renderRatingBar(star5Value, maxValue, star5, star5SummaryCountColor, star5SummaryCountZeroValueColor, star5SummaryCount);
                renderRatingBar(star4Value, maxValue, star4, star4SummaryCountColor, star4SummaryCountZeroValueColor, star4SummaryCount);
                renderRatingBar(star3Value, maxValue, star3, star3SummaryCountColor, star3SummaryCountZeroValueColor, star3SummaryCount);
                renderRatingBar(star2Value, maxValue, star2, star2SummaryCountColor, star2SummaryCountZeroValueColor, star2SummaryCount);
                renderRatingBar(star1Value, maxValue, star1, star1SummaryCountColor, star1SummaryCountZeroValueColor, star1SummaryCount);
            }


        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    private void renderRatingBar(int barValue, int maxValue, ProgressBar progressBar, int textColor, int zeroValueColor, TextView textView) {
        Double value = ((barValue * 1.0) / maxValue) * maxSizeOfBar;
        if(value.intValue() == 0){
            value = 0.01 * maxSizeOfBar;
            textView.setTextColor(zeroValueColor);
        } else {
            textView.setTextColor(textColor);
        }

        textView.setText(String.valueOf(barValue));
        progressBar.getLayoutParams().width = value.intValue();
        progressBar.invalidate();
    }

}
