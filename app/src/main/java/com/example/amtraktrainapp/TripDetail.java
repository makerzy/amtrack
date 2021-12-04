package com.example.amtraktrainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class TripDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_detail);
        TextView arrivalTime = (TextView) findViewById(R.id.txtArrivalTime);
        ImageView img = (ImageView) findViewById(R.id.imgTrip);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int intHours = sharedPref.getInt("key1", 0);
        int intMinutes = sharedPref.getInt("key2", 0);
        float decTripLength = sharedPref.getFloat("key3", 0);
        float decArrivalTime;

        decArrivalTime =(( intHours * 60)+ intMinutes + decTripLength);
        float convertedArrivalTime = decArrivalTime/60;
        String hour = String.valueOf(convertedArrivalTime).split("\\.")[0];
        String minutes = String.valueOf(convertedArrivalTime).split("\\.")[1];
        String cMinutes = String.valueOf(Math.round(Integer.parseInt(minutes)*60));

        arrivalTime.setText("Your Arrival time is "+ hour+ ":"+cMinutes.substring(0,2));

        if(convertedArrivalTime> 24)
            img.setImageResource(R.drawable.red_eye);
        else
            img.setImageResource(R.drawable.amtrak);


    }
}