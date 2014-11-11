package edu.pace.pclc.homework1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class SecondActivity extends Activity {

    class MyTimerTask extends TimerTask {
        public void run() {

            act.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //Your code to run in GUI thread here
                    counterView.setText(""+i); ///////////////////

                }
            });

            i++; ////////////////////

        }
    }

    private MyTimerTask timerTask;
    private TextView counterView;
    private Switch mySwitch;
    private Activity act;
    private int i = 0; /////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        counterView = (TextView)findViewById(R.id.counterView);
        mySwitch = (Switch)findViewById(R.id.switch1);
        act = this;

        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (isChecked) {
                    counterView.setText("ON");
                    timerTask = new MyTimerTask();
                    Timer timer = new Timer();
                    timer.schedule(timerTask, 0, 250); //////////////////

                } else {
                    counterView.setText("OFF");
                    timerTask.cancel();
                }

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
