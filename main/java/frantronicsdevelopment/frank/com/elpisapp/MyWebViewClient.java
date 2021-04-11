package frantronicsdevelopment.frank.com.elpisapp;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {

    @Override
        //Implement shouldOverrideUrlLoading//
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        //Check whether the URL contains a whitelisted domain. In this example, we’re checking
        //whether the URL contains the “example.com” string//
        if(Uri.parse(url).getHost().endsWith("https://elpischristianministries.co.uk/")) {

        //If the URL does contain the “example.com” string, then the shouldOverrideUrlLoading method
        //will return ‘false” and the URL will be loaded inside your WebView//
            return false;
        }
        else if(Uri.parse(url).getHost().endsWith("http://elpischristianministries.co.uk/sermons/")) {

            //If the URL does contain the “example.com” string, then the shouldOverrideUrlLoading method
            //will return ‘false” and the URL will be loaded inside your WebView//
            return false;
        }
        else if(Uri.parse(url).getHost().endsWith("https://elpischristianministries.co.uk/history/")) {

            //If the URL does contain the “example.com” string, then the shouldOverrideUrlLoading method
            //will return ‘false” and the URL will be loaded inside your WebView//
            return false;
        }
        else if(Uri.parse(url).getHost().endsWith("https://elpischristianministries.co.uk/who-we-are/")) {

            //If the URL does contain the “example.com” string, then the shouldOverrideUrlLoading method
            //will return ‘false” and the URL will be loaded inside your WebView//
            return false;
        }
        else if(Uri.parse(url).getHost().endsWith("https://elpischristianministries.co.uk/mission-and-vision/")) {

            //If the URL does contain the “example.com” string, then the shouldOverrideUrlLoading method
            //will return ‘false” and the URL will be loaded inside your WebView//
            return false;

        }
        else if(Uri.parse(url).getHost().endsWith("https://elpischristianministries.co.uk/pledge-of-excellence/")) {

            //If the URL does contain the “example.com” string, then the shouldOverrideUrlLoading method
            //will return ‘false” and the URL will be loaded inside your WebView//
            return false;

        }
        else if(Uri.parse(url).getHost().endsWith("https://elpischristianministries.co.uk/event/")) {

            //If the URL does contain the “example.com” string, then the shouldOverrideUrlLoading method
            //will return ‘false” and the URL will be loaded inside your WebView//
            return false;

        }

        //If the URL doesn’t contain this string, then it’ll return “true.” At this point, we’ll
        //launch the user’s preferred browser, by firing off an Intent//
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }
}

