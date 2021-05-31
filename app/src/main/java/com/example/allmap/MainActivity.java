package com.example.allmap;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;




public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private String url = "http://m.dyercoffee.cafe24.com/member/login.html";
    private WebSettings mWebSettings; //웹뷰세팅

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        if(intent != null) {//푸시알림을 선택해서 실행한것이 아닌경우 예외처리
            String notificationData = intent.getStringExtra("test");
            if(notificationData != null)
                Log.d("FCM_TEST", notificationData);
        }
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClientClass());

        //세부 세팅 등록

        mWebSettings = webView.getSettings();



        mWebSettings.setSupportMultipleWindows(false); // 새창 띄우기 허용 여부

        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true); // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부

        mWebSettings.setLoadWithOverviewMode(true); // 메타태그 허용 여부

        mWebSettings.setUseWideViewPort(true); // 화면 사이즈 맞추기 허용 여부

        mWebSettings.setSupportZoom(true); // 화면 줌 허용 여부

        mWebSettings.setBuiltInZoomControls(true); // 화면 확대 축소 허용 여부

        mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL); // 콘텐츠 사이즈 맞추기

        mWebSettings.setCacheMode(WebSettings.LOAD_DEFAULT); // 브라우저 캐시 허용 여부

        mWebSettings.setDomStorageEnabled(true); // 로컬 저장소 허용 여부





    }


























    //푸쉬알람
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }






}








