package com.myanmar.mmtexttool;

import android.content.ClipboardManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class FlipText extends AppCompatActivity implements View.OnClickListener {
    EditText flip_edMain,flip_edStyle1,flip_edStyle2,flip_edStyle3,flip_edStyle4;
    ImageButton b1,b2,b3,b4;
    AdView B;
    AdRequest adRequest;
    InterstitialAd IAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip_text);
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

        flip_edMain = (EditText) findViewById(R.id.flip_edMain);
        flip_edStyle1 = (EditText) findViewById(R.id.flip_edStyle1);
        flip_edStyle2 = (EditText) findViewById(R.id.flip_edStyle2);
        flip_edStyle3 = (EditText) findViewById(R.id.flip_edStyle3);
        flip_edStyle4 = (EditText) findViewById(R.id.flip_edStyle4);
        b1 = (ImageButton) findViewById(R.id.style1Copy);
        b2 = (ImageButton) findViewById(R.id.style2Copy);
        b3 = (ImageButton) findViewById(R.id.style3Copy);
        b4 = (ImageButton) findViewById(R.id.style4Copy);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

        flip_edMain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                styleOne(s.toString());
                styleTwo(s.toString());
                styleThree(s.toString());
                styleFour(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void styleOne(String Text){
        String normal = "abcdefghijklmnopqrstuvwxyz_,;.?!/\\'";
        String split  = "ɐqɔpǝɟɓɥᴉſʞๅɯuodbɹsʇnʌʍxʎz‾'؛˙¿¡/\\,";

        normal += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        split  += "∀qϽᗡƎℲƃHIſʞ˥WNOԀὉᴚS⊥∩ΛMXʎZ";

        normal += "0123456789";
        split  += "0ƖᄅƐㄣϛ9ㄥ86";

        String newstr = "";
        char letter;
        for (int i=0; i< Text.length(); i++) {
            letter = Text.charAt(i);

            int a = normal.indexOf(letter);
            newstr += (a != -1) ? split.charAt(a) : letter;
        }
        String res = new StringBuilder(newstr).reverse().toString();

        flip_edStyle1.setText(res);
    }

    public void styleTwo(String Text){
        String reverse = new StringBuffer(Text).reverse().toString();
        flip_edStyle2.setText(reverse);
    }

    public void styleThree(String Text){
        Text = Text.replace("a","ɐ");
        Text = Text.replace("b","q");
        Text = Text.replace("c","ɔ");
        Text = Text.replace("d","p");
        Text = Text.replace("e","ǝ");
        Text = Text.replace("f","ɟ");
        Text = Text.replace("g","ɓ");
        Text = Text.replace("h","ɥ");
        Text = Text.replace("i","ᴉ");
        Text = Text.replace("j","ſ");
        Text = Text.replace("k","ʞ");
        Text = Text.replace("l","ๅ");
        Text = Text.replace("m","ɯ");
        Text = Text.replace("n","u");
        Text = Text.replace("o","o");
        Text = Text.replace("p","d");
        Text = Text.replace("q","b");
        Text = Text.replace("r","ɹ");
        Text = Text.replace("s","s");
        Text = Text.replace("t","ʇ");
        Text = Text.replace("u","n");
        Text = Text.replace("v","ʌ");
        Text = Text.replace("w","ʍ");
        Text = Text.replace("x","x");
        Text = Text.replace("y","ʎ");
        Text = Text.replace("z","z");
        String reverse = new StringBuffer(Text).reverse().toString();
        flip_edStyle3.setText(reverse);
    }

    public void styleFour(String Text){
        String normal = "abcdefghijklmnopqrstuvwxyz_,;.?!/\\'";
        String split  = "ɐqɔpǝɟɓɥᴉſʞๅɯuodbɹsʇnʌʍxʎz‾'؛˙¿¡/\\,";

        normal += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        split  += "∀qϽᗡƎℲƃHIſʞ˥WNOԀὉᴚS⊥∩ΛMXʎZ";

        normal += "0123456789";
        split  += "0ƖᄅƐㄣϛ9ㄥ86";

        String newstr = "";
        char letter;
        for (int i=0; i< Text.length(); i++) {
            letter = Text.charAt(i);

            int a = normal.indexOf(letter);
            newstr += (a != -1) ? split.charAt(a) : letter;
        }

        flip_edStyle4.setText(newstr);
    }

    @Override
    public void onClick(View v) {
        if(IAd.isLoaded()){
            IAd.show();
        }else{
            IAd.loadAd(adRequest);
        }
        ClipboardManager copy = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        switch (v.getId()){
            case R.id.style1Copy:
                copy.setText(flip_edStyle1.getText());
                if(copy.hasText()){
                    Toast.makeText(FlipText.this, "Copied!", Toast.LENGTH_SHORT).show();
                }

            case R.id.style2Copy:
                copy.setText(flip_edStyle2.getText());
                if(copy.hasText()){
                    Toast.makeText(FlipText.this, "Copied!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.style3Copy:
                copy.setText(flip_edStyle3.getText());
                if(copy.hasText()){
                    Toast.makeText(FlipText.this, "Copied!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.style4Copy:copy.setText(flip_edStyle4.getText());
                if(copy.hasText()){
                    Toast.makeText(FlipText.this, "Copied!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
