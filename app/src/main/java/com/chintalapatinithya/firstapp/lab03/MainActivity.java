package com.chintalapatinithya.firstapp.lab03;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView displayText1;
    TextView displayText2;
    TextView displayText3;
    TextView displayText4;
    SeekBar sBar;
    SharedPreferences mPreferences;
    int a;
    int b;
    int c;
    int d;
    SharedPreferences.Editor Edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayText1=findViewById(R.id.displayText1);
        displayText2=findViewById(R.id.displayText2);
        displayText3=findViewById(R.id.displayText3);
        displayText4=findViewById(R.id.displayText4);
        sBar = (SeekBar)findViewById(R.id.seekBar1);

        Listener x = new Listener();
        displayText1.setOnClickListener(x);
        displayText2.setOnClickListener(x);
        displayText3.setOnClickListener(x);
        displayText4.setOnClickListener(x);
        mPreferences = getSharedPreferences("com.nithyacl.sharedprefs",MODE_PRIVATE);
        a = mPreferences.getInt("displayText1", 0);
        b = mPreferences.getInt("displayText2", 0);
        c = mPreferences.getInt("displayText3", 0);
        d = mPreferences.getInt("displayText4", 0);
        Edit = mPreferences.edit();
        displayText1.setTextSize(sBar.getProgress());
        displayText2.setTextSize(sBar.getProgress());
        displayText3.setTextSize(sBar.getProgress());
        displayText4.setTextSize(sBar.getProgress());
        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pval = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pval = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                displayText1.setTextSize(pval);
                displayText2.setTextSize(pval);
                displayText3.setTextSize(pval);
                displayText4.setTextSize(pval);

            }
        });

    }


    private class Listener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            TextView text = (TextView)view;

            if(displayText1.isPressed()) {
                a++;
                Toast toast = Toast.makeText(getApplicationContext(), "Option 1 Clicked: " + a, Toast.LENGTH_SHORT);
                toast.setMargin(50, 50);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
                Edit.putInt("displayText1", a );
                Edit.apply();


            }

            if(displayText2.isPressed()) {
                b++;
                Toast toast = Toast.makeText(getApplicationContext(), "Option 2 Clicked: " + b, Toast.LENGTH_SHORT);
                toast.setMargin(50, 50);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
                Edit.putInt("displayText2", b );
                Edit.apply();
            }

            if(displayText3.isPressed()) {
                c++;
                Toast toast = Toast.makeText(getApplicationContext(), "Option 3 Clicked: " + c, Toast.LENGTH_SHORT);
                toast.setMargin(50, 50);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
                Edit.putInt("displayText3", c );
                Edit.apply();
            }

            if(displayText4.isPressed()) {
                d++;
                Toast toast = Toast.makeText(getApplicationContext(), "Option 4 Clicked: "+ d, Toast.LENGTH_SHORT);
                toast.setMargin(50, 50);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
                Edit.putInt("displayText1", d );
                Edit.apply();
            }

        }
    }
}
