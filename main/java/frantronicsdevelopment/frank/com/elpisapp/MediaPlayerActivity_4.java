package frantronicsdevelopment.frank.com.elpisapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MediaPlayerActivity_4 extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    public TextView songName, duration;
    private double timeElapsed = 0, finalTime = 0;
    private int forwardTime = 2000, backwardTime = 2000;
    private Handler durationHandler = new Handler();
    private SeekBar seekbar;

    // Sermon limks
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        //set the layout of the Activity
        setContentView(R.layout.media_player_activity_3);

        //Make ActionBar back button visible
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //initialize views
        initializeViews();

        //Clickable TextView for music platforms
        textView = findViewById(R.id.sermon_link);


        textView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaPlayerActivity_4.this, MusicPlatforms.class);
                startActivity(intent);
            }
        } );

    }

    public void initializeViews(){
        songName = findViewById(R.id.songName);
        //mediaPlayer = MediaPlayer.create(this, R.raw.understanding_tongues);
        finalTime = mediaPlayer.getDuration();
        duration = findViewById(R.id.songDuration);
        seekbar = findViewById(R.id.seekBar);
        songName.setText("Speaking in tongues");

        seekbar.setMax((int) finalTime);
        seekbar.setClickable(false);
    }

    // play mp3 song
    public void play(View view) {
        mediaPlayer.start();
        timeElapsed = mediaPlayer.getCurrentPosition();
        seekbar.setProgress((int) timeElapsed);
        durationHandler.postDelayed(updateSeekBarTime, 100);
    }

    //handler to change seekBarTime
    private Runnable updateSeekBarTime = new Runnable() {
        @SuppressLint("DefaultLocale")
        public void run() {
            //get current position
            timeElapsed = mediaPlayer.getCurrentPosition();

            //set seekbar progress
            seekbar.setProgress((int) timeElapsed);

            //set time remaing
            double timeRemaining = finalTime - timeElapsed;
            duration.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining), TimeUnit.MILLISECONDS.toSeconds((long) timeRemaining) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining))));

            //repeat yourself that again in 100 miliseconds
            durationHandler.postDelayed(this, 100);
        }
    };

    // pause mp3 song
    public void pause(View view) {
        mediaPlayer.pause();
    }

    // go forward at forwardTime seconds
    public void forward(View view) {
        //check if we can go forward at forwardTime seconds before song endes
        if ((timeElapsed + forwardTime) <= finalTime) {
            timeElapsed = timeElapsed + forwardTime;

            //seek to the exact second of the track
            mediaPlayer.seekTo((int) timeElapsed);
        }
    }

    // go backward at backwardTime seconds
    public void rewind(View view) {
        if ((timeElapsed - forwardTime) <= finalTime) {
            timeElapsed = timeElapsed - forwardTime;

            //seek to the exact second of the track
            mediaPlayer.seekTo((int) timeElapsed);
        }

    }

    // Respond to ActionBar back button clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //do what you want
                Intent intent = new Intent( MediaPlayerActivity_4.this, TeachingsActivity.class);
                startActivity(intent);
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
