package frantronicsdevelopment.frank.com.elpisapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;


public class ActivityElpisWebPage extends AppCompatActivity {
    private WebView myWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_elpis_web_page);
        BottomNavigationView navView = findViewById( R.id.bottom_nav_nav_view);

        myWebView = findViewById(R.id.elpis_webview);
        WebSettings webSettings = myWebView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://elpischristianministries.co.uk/");

        myWebView.setWebViewClient(new WebViewClient());

        navView.setOnNavigationItemSelectedListener( mOnNavigationItemSelectedListener );

    }

    // Back button to go to previous page
    public void onBackPressed(){
        if (myWebView.canGoBack()){
            myWebView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    myWebView.loadUrl("https://elpischristianministries.co.uk/");
                    return true;

                case R.id.sermon:
                    // mTextMessage.setText( R.string.title_podcasts);
                    Intent intent = new Intent(ActivityElpisWebPage.this, TeachingsActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.events:
                   // mTextMessage.setText( R.string.title_events );
                    myWebView.loadUrl("https://elpischristianministries.co.uk/event/");
                    return true;
                case R.id.live_streaming:
                    //Get a reference to the url
                    //final FirebaseDatabase database = FirebaseDatabase.getInstance();
                    //DatabaseReference ref = database.getReferenceFromUrl("https://elpisapp.firebaseio.com/elpisapp").child("livestreaming");
                  //  mTextMessage.setText( R.string.title_live_streaming );
                   //Intent intent1 = new Intent(ActivityElpisWebPage.this, ShowVideo.class);
                    //startActivity(intent1);
                 myWebView.loadUrl("https://www.youtube.com/channel/UCysovpxmE_3iz_KAKO7wfBw/live");
                    //myWebView.loadUrl("https://www.facebook.com/Elpischristianministries/videos/1087934324728843=" +new Date().getTime());
                    //Intent intent2 = new Intent(ActivityElpisWebPage.this, ShowVideo.class);
                    //startActivity(intent2);
                    return true;

            }
            return false;
        }
    };

}
