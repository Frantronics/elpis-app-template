package frantronicsdevelopment.frank.com.elpisapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TeachingsActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG = "Sermons";
    ImageView imgView1, imgView2, imgView3, imgView4;
    CardView cardView1, cardView2, cardView3, cardView4;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.podcast_cardview);
        cardView1 = findViewById(R.id.cardview_1);
        cardView1.setOnClickListener(this);
        cardView2 = findViewById(R.id.cardview_2);
        cardView2.setOnClickListener(this);
        cardView3 = findViewById(R.id.cardview_3);
        cardView3.setOnClickListener(this);
        cardView4 = findViewById(R.id.cardview_4);
        cardView4.setOnClickListener(this);


        imgView1 = findViewById(R.id.cardview1__img_1);
        imgView1.setOnClickListener(this);
        imgView2 = findViewById(R.id.cardview2__img_2);
        imgView2.setOnClickListener(this);
        imgView3 = findViewById(R.id.cardview3__img_3);
        imgView3.setOnClickListener(this);
        imgView4 = findViewById(R.id.cardview4__img_4);
        imgView4.setOnClickListener(this);


        //Clickable TextView
        textView = findViewById(R.id.sermon_link);

        //Make ActionBar back button visible
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        textView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeachingsActivity.this, MusicPlatforms.class);
                startActivity(intent);
            }
        } );

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.cardview_1:
            case R.id.cardview1__img_1:
                // Handle profile Activity
                Intent intent1 = new Intent(TeachingsActivity.this, MediaPlayerActivity_1.class);
                startActivity(intent1);
                Toast.makeText(this, "Listen and be blessed", Toast.LENGTH_SHORT).show();
                break;

            case R.id.cardview_2:
            case R.id.cardview2__img_2:
                // Handle edit profile Activity
                //Intent editIntent = new Intent(Home.this, ActivityEditProfile.class);
                //startActivity(editIntent);
                Intent intent2 = new Intent(TeachingsActivity.this, MediaPlayerActivity_2.class);
                startActivity(intent2);
                Toast.makeText(this, "Listen and be blessed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardview_3:
            case R.id.cardview3__img_3:
                Intent intent3 = new Intent(TeachingsActivity.this, MediaPlayerActivity_3.class);
                startActivity(intent3);
                Toast.makeText(this, "Listen and be blessed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardview_4:
            case R.id.cardview4__img_4:
                Intent intent4 = new Intent(TeachingsActivity.this, MediaPlayerActivity_4.class);
                startActivity(intent4);
                Toast.makeText(this, "Listen and be blessed", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    // Respond to ActionBar back button clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //do what you want
                Intent intent = new Intent(TeachingsActivity.this, ActivityElpisWebPage.class);
                startActivity(intent);
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
