package com.example.trang.news.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.trang.news.R;
import com.example.trang.news.fragment.VnexpressFragment;

public class VnexpressActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vnexpress);
        initView();
    }

    private void initView() {
        webView = (WebView) findViewById(R.id.wv_data_vnexpress);
        String link = getIntent().getStringExtra(VnexpressFragment.LINK);
        webView.loadUrl(link);

    }
}
