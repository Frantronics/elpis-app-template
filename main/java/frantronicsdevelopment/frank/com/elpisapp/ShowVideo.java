package frantronicsdevelopment.frank.com.elpisapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class ShowVideo extends YouTubeBaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

// TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_streaming);

        //VideoView vidView = findViewById(R.id.youtubePlayerView);

        final YouTubePlayerView youtubePlayerView = findViewById(R.id.youtubePlayerView);

        Button buttonPlay = findViewById(R.id.buttonPlay);

        ImageButton youTubeBackBtn = findViewById(R.id.youTubeBckBtn);
        //String vidAddress = "https://www.youtube.com/channel/UCysovpxmE_3iz_KAKO7wfBw/live";
        /**
         String vidAddress = "https://www.youtube.com/channel/UCysovpxmE_3iz_KAKO7wfBw/live";
         Uri vidUri = Uri.parse(vidAddress);
         vidView.setVideoURI(vidUri);
         MediaController vidControl = new MediaController(this);
         vidControl.setAnchorView(vidView);
         vidView.setMediaController(vidControl);
         vidView.start();
         */
        //Make ActionBar back button visible
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       //getSupportActionBar().setDisplayShowHomeEnabled(true);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String videoId = "https://www.youtube.com/channel/UCysovpxmE_3iz_KAKO7wfBw/live";
                playVideo(videoId, youtubePlayerView);
            }
        });

        youTubeBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowVideo.this, ActivityElpisWebPage.class);
                startActivity(intent);
            }
        });
    }

    public void playVideo ( final String videoId, YouTubePlayerView youTubePlayerView){
        //initialize youtube player view
        youTubePlayerView.initialize("AIzaSyCKbZGN3lsaYyCkhsUAjvNI4aBQK1dBYS8",
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean b) {
                        youTubePlayer.cueVideo(videoId);
                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {

                    }
                });
    }

}
