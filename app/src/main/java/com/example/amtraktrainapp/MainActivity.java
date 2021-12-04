package com.example.amtraktrainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int intHours;
    int intMinutes;
    float decTripLength;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText hours = (EditText) findViewById(R.id.txtHours);
        final EditText minutes = (EditText) findViewById(R.id.txtMinutes);
        final EditText tripLength = (EditText) findViewById(R.id.txtTripLength);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intHours = Integer.parseInt(hours.getText().toString());
                intMinutes = Integer.parseInt(minutes.getText().toString());
                decTripLength = Float.parseFloat(tripLength.getText().toString());
                if(intHours> 24) return;  // simple check for correct hours input
                if(intMinutes> 60) return; // simple check for correct minutes input
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("key1", intHours);
                editor.putInt("key2", intMinutes);
                editor.putFloat("key3", decTripLength);
                editor.commit();
                startActivity(new Intent(MainActivity.this, TripDetail.class));
            }
        });
    }
}