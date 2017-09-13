package com.myanmar.mmtexttool;

import android.content.ClipboardManager;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class ClonerFuck extends AppCompatActivity implements View.OnClickListener {
    EditText edText;
    Button btnCopy, btnSend;
    String Text;
    AdRequest adRequest;
    AdView B;
    InterstitialAd IAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloner_fuck);

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

        edText = (EditText) findViewById(R.id.edText);
        btnCopy = (Button) findViewById(R.id.btnCopy);
        btnSend = (Button) findViewById(R.id.btnSend);

        btnCopy.setOnClickListener(this);
        btnSend.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        Text = bundle.getString("key");
        edText.setText(Text);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View v) {
        if (IAd.isLoaded()){
            IAd.show();
        }else{
            IAd.loadAd(adRequest);
        }
        switch (v.getId()){
            case R.id.btnCopy:
                ClipboardManager Copy = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                Copy.setText(Text);
                if (Copy.hasText()){
                    Toast.makeText(ClonerFuck.this,"All Text Copied!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnSend:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,Text);
                startActivity(new Intent(Intent.createChooser(intent,getResources().getString(R.string.app_name))));
                break;
        }
    }
}
