package com.ksu4040e071.uinormal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        //讓JavaScript可以在WebView上面運行
        webView.loadUrl("http://www.google.com.tw");
        //一開始載入的頁面來源


        webView.setWebViewClient(new WebViewClient(){
            //自訂網頁
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request){
                webView.loadUrl("http://www.google.com.tw");
                return true;
            }
        });

        RatingBar ratingBar =(RatingBar) findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser){

                String text = rating +" star(s)";
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        //當按下按鍵時，事件觸發
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()){
            webView.goBack();
            //返回前一個網頁
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}

