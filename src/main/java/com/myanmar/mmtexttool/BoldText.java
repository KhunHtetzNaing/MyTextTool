package com.myanmar.mmtexttool;

import android.content.ClipboardManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class BoldText extends AppCompatActivity {
    EditText editText;
    ClipboardManager copy;
    AdView B;
    AdRequest adRequest;
    InterstitialAd IAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bold_text);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adRequest = new AdRequest.Builder().build();
        B = (AdView) findViewById(R.id.adView);
        B.loadAd(adRequest);

        IAd = new InterstitialAd(this);
        IAd.setAdUnitId("ca-app-pub-4173348573252986/8544692053");
        IAd.loadAd(adRequest);

        IAd.setAdListener(new AdListener() {
            @Override
            public void onAdOpened() {
                IAd.loadAd(adRequest);
            }

            @Override
            public void onAdLeftApplication() {
                IAd.loadAd(adRequest);
            }

            @Override
            public void onAdFailedToLoad(int i) {
                IAd.loadAd(adRequest);
            }

            @Override
            public void onAdClosed() {
                IAd.loadAd(adRequest);
            }
        });

        editText = (EditText) findViewById(R.id.edText);
        copy = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(IAd.isLoaded()){
                    IAd.show();
                }else{
                    IAd.loadAd(adRequest);
                }
                String text = editText.getText().toString();
                if (!text.isEmpty()){
                    copy.setText("@@[0:[128571804449068:1:"+text+"]]@[128571804449068:]");
                    if (copy.hasText()){
                        Toast.makeText(BoldText.this, "Text Copied! Now you can paste :)", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(BoldText.this, "Text Empty!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
