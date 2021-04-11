package frantronicsdevelopment.frank.com.elpisapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.KeyEvent;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.webkit.WebView;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        WebView webView = findViewById(R.id.webview);
        webView.setWebViewClient(new MyWebViewClient());

        DrawerLayout drawer = findViewById( R.id.drawer_layout );
        NavigationView navigationView = findViewById( R.id.nav_view );

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener( toggle );
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener( this );

        //Get a reference to your WebView//
       // webView = findViewById(R.id.webview);

        //Specify the URL you want to display//
        webView.loadUrl("https://elpischristianministries.co.uk/");

        //Obtain the WebSettings object//
       // WebSettings webSettings = webView.getSettings();

        //Call setJavaScriptEnabled(true)//
       // webSettings.setJavaScriptEnabled(true);

        //myWebView.setWebViewClient(MyWebViewClient);

       BottomNavigationView navView = findViewById( R.id.bottom_nav_view);
        navView.setOnNavigationItemSelectedListener( mOnNavigationItemSelectedListener );


        AppCenter.start(getApplication(), "aaeb4042-35ab-4472-a5d0-1b645a313592",
                Analytics.class, Crashes.class);
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.sermon:
                    // mTextMessage.setText( R.string.title_podcasts);
                    Intent intent = new Intent(MainActivity.this, SermonsActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.events:
                  //  mTextMessage.setText( R.string.title_events );
                    WebView webView = findViewById(R.id.webview);
                    //Specify the URL you want to display//
                    webView.loadUrl("https://elpischristianministries.co.uk/event/");
                    return true;
                case R.id.live_streaming:
                  //  mTextMessage.setText( R.string.title_live_streaming );
                    Intent intent2 = new Intent(MainActivity.this, ShowVideo.class);
                    startActivity(intent2);
                    return true;
            }
            return false;
        }
    };

        //Check whether there’s any WebView history that the user can navigate back to//

    @Override

    public boolean onKeyDown(final int keyCode, final KeyEvent event) {
        WebView myWebView = null;
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
        //If there is history, then the canGoBack method will return ‘true’//
            return true;
        }

        //If the button that’s been pressed wasn’t the ‘Back’ button, or there’s currently no
        //WebView history, then the system should resort to its default behavior and return
        //the user to the previous Activity//
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById( R.id.drawer_layout );
        if (drawer.isDrawerOpen( GravityCompat.START )) {
            drawer.closeDrawer( GravityCompat.START );
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.main, menu );
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

        return super.onOptionsItemSelected( item );
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            WebView webView = findViewById(R.id.webview);
            //Specify the URL you want to display//
            webView.loadUrl("https://elpischristianministries.co.uk/");

        } else if (id == R.id.nav_media) {
            WebView webView = findViewById(R.id.webview);
            //Specify the URL you want to display//
            webView.loadUrl("http://elpischristianministries.co.uk/sermons/");

        }  else if (id == R.id.nav_history) {
            WebView webView = findViewById(R.id.webview);
            //Specify the URL you want to display//
            webView.loadUrl("https://elpischristianministries.co.uk/history/");

        } else if (id == R.id.nav_who_we_are) {
            WebView webView = findViewById(R.id.webview);
            //Specify the URL you want to display//
            webView.loadUrl("https://elpischristianministries.co.uk/who-we-are/");

        } else if (id == R.id.nav_mission_and_vision) {
            WebView webView = findViewById(R.id.webview);
            //Specify the URL you want to display//
            webView.loadUrl("https://elpischristianministries.co.uk/mission-and-vision/");

        } else if (id == R.id.nav_pledge_of_excellence) {
            WebView webView = findViewById(R.id.webview);
            //Specify the URL you want to display//
            webView.loadUrl("https://elpischristianministries.co.uk/pledge-of-excellence/");

        } else if (id == R.id.nav_events) {
            WebView webView = findViewById(R.id.webview);
            //Specify the URL you want to display//
            webView.loadUrl("https://elpischristianministries.co.uk/event/");
        }

        DrawerLayout drawer = findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
        return true;
    }

}
