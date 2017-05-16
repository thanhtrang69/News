package com.example.trang.news.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.trang.news.R;
import com.example.trang.news.fragment.DanTriFragment;

public class DanTriActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dantri);
        initView();
    }

    private void initView() {
        webView = (WebView) findViewById(R.id.wv_data_sport);
        String link = getIntent().getStringExtra(DanTriFragment.LINKDANTRI);
        webView.loadUrl(link);

    }
}
