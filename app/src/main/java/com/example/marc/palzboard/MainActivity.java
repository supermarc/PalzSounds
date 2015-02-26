package com.example.marc.palzboard;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    public CheckBox schleif;

    public MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button modohie = (Button) this.findViewById(R.id.button);
        Button dummkopp = (Button) this.findViewById(R.id.button2);
        Button batman = (Button) this.findViewById(R.id.button3);
        Button hermozu = (Button) this.findViewById(R.id.button4);
        Button kacklade = (Button) this.findViewById(R.id.button5);
        Button fuckyou = (Button) this.findViewById(R.id.button6);
        Button motherlode = (Button) this.findViewById(R.id.button7);
        Button lodemantel = (Button) this.findViewById(R.id.button8);
        Button schungeil = (Button) this.findViewById(R.id.button9);
        Button sehrgut = (Button) this.findViewById(R.id.button10);

        schleif = (CheckBox) this.findViewById(R.id.endlosCheck);
        schleif.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mp == null ||  !mp.isPlaying()) {
                    return;
                }

                if(isChecked) {
                    mp.setLooping(true);
                } else {
                    if(mp != null && mp.isPlaying()) {
                        mp.release();
                        mp = null;
                    }
                }
            }
        });

        modohie.setOnClickListener(new myListener(R.raw.modohie));
        dummkopp.setOnClickListener(new myListener(R.raw.dummkopp));
        batman.setOnClickListener(new myListener(R.raw.batman));
        hermozu.setOnClickListener(new myListener(R.raw.hermozu));
        kacklade.setOnClickListener(new myListener(R.raw.kacklade));
        fuckyou.setOnClickListener(new myListener(R.raw.fuckyou));
        motherlode.setOnClickListener(new myListener(R.raw.motherlode));
        lodemantel.setOnClickListener(new myListener(R.raw.lodemandel));
        schungeil.setOnClickListener(new myListener(R.raw.schungeil));
        sehrgut.setOnClickListener(new myListener(R.raw.sehrgut));
    }

    private class myListener implements View.OnClickListener {
        private int sound;
        private String text;

        public myListener(int sound) {
            this.sound = sound;
            this.text = "";
        }

        public myListener(int sound, String text) {
            this.sound = sound;
            this.text = text;
        }

        @Override
        public void onClick(View v) {
            if(mp != null && mp.isPlaying()) {

                mp.release();
                mp = null;
            }

            mp = MediaPlayer.create(getApplicationContext(), this.sound);

            if(schleif.isChecked()) {
                try {
                    mp.setLooping(true);
                    mp.start();
                    //MainActivity.this.mp.prepareAsync();
                }
                catch(IllegalStateException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    mp.start();
                }
                catch(IllegalStateException e) {
                    e.printStackTrace();
                }
            }

            if(!this.text.equals("")){
                Toast.makeText(getApplicationContext(), this.text, Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
