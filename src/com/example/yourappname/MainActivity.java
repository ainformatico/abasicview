package com.example.yourappname;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity
{
  //Called when the activity is first created
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    final Activity MyActivity = this;

    //request the progress bar
    getWindow().requestFeature(Window.FEATURE_PROGRESS);

    //set the content view
    setContentView(R.layout.webview);

    //show the progress bar
    getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);

    //get the webview
    WebView myWebView = (WebView) findViewById(R.id.webview);

    //enable javascript
    myWebView.getSettings().setJavaScriptEnabled(true);

    //load the url
    myWebView.loadUrl("http://www.alejandroelinformatico.com/");

    //prevent browser from open new urls
    myWebView.setWebViewClient(new WebViewClient());

    //handle the client
    myWebView.setWebChromeClient(new WebChromeClient()
    {
      //progress
      public void onProgressChanged(WebView view, int progress)
      {
        //set the text
        MyActivity.setTitle(R.string.loading);
        //set the progress and hide the bar after tat
        MyActivity.setProgress(progress * 100);

        //set the app name again
        if(progress == 100)
        {
          MyActivity.setTitle(R.string.app_name);
        }
      }
    });
  }
}
