package com.example.androidchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar aboutToolBar = findViewById(R.id.about_toolbar);
        setSupportActionBar(aboutToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        WebView aboutWebView = findViewById(R.id.about_web_view);
        aboutWebView.setWebViewClient(new CustomWebViewClient());
        aboutWebView.loadUrl("https://andela.com/about/");
        WebSettings webSettings = aboutWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }

    public class CustomWebViewClient extends WebViewClient{
        //Handles errors that may occur while trying to
        //connect to website
        @Override
        public void onReceivedSslError(WebView view, final SslErrorHandler sslErrorHandler, SslError sslError){
            final AlertDialog.Builder builder = new AlertDialog.Builder(AboutActivity.this);
            builder.setMessage(R.string.error_message);

            //Gives the user option of whether to proceed to website or not
            builder.setPositiveButton("continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.proceed();
                }
            });
            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.cancel();
                }
            });
            final AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}
