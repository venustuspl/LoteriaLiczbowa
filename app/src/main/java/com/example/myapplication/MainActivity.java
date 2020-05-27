package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button przycisk;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        przycisk = findViewById(R.id.button);

        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.lotto.pl/lotto/wyniki-i-wygrane/ostatnie-wyniki");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }



    public void onClick(View view) {
        List<Integer> lista = new ArrayList<>();
        Random r = new Random();
        while (lista.size() < 6) {
            Integer nowe = 1 + r.nextInt(49);
            boolean czyjest = false;
            for (int i : lista) {
                if (i == nowe) {
                    czyjest = true;
                }
            }
            if (czyjest == false) lista.add(nowe);
        }
        String napis = "Wylosowano 6 liczb: ";
        for (int i : lista) napis += i + " ";
        przycisk.setText(napis);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
