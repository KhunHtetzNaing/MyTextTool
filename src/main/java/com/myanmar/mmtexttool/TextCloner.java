package com.myanmar.mmtexttool;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class TextCloner extends AppCompatActivity {

    AdRequest adRequest;
    AdView B;
    EditText edText,edCount;
    Button btnClone;
    String Result="";
    InterstitialAd IAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_cloner);

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
        edCount = (EditText) findViewById(R.id.edCount);
        btnClone = (Button) findViewById(R.id.btnClone);

        btnClone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (IAd.isLoaded()){
                    IAd.show();
                }else{
                    IAd.loadAd(adRequest);
                }
                String Text = edText.getText().toString();
                String Check = edCount.getText().toString();
                if (Text.equals("")){
                    Toast.makeText(TextCloner.this, "Text Empty!", Toast.LENGTH_SHORT).show();
                }else{
                    if (Check.equals("")){
                        Toast.makeText(TextCloner.this, "Count Empty!", Toast.LENGTH_SHORT).show();
                    }else{
                        Result = "";
                        int Count = Integer.parseInt(edCount.getText().toString());
                        for (int i=0;i<Count;i++){
                            Result+=Text+"\n";
                        }
                        Intent intent = new Intent(TextCloner.this,ClonerFuck.class);
                        Bundle bdl = new Bundle();
                        bdl.putString("key",Result);
                        intent.putExtras(bdl);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
