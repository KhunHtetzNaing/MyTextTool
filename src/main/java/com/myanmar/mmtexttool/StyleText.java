package com.myanmar.mmtexttool;

import android.content.ClipboardManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.concurrent.locks.ReadWriteLock;

public class StyleText extends AppCompatActivity{
    EditText edInput,edOutput;
    CheckBox engCheck,mmCheck;
    AdRequest adRequest;
    AdView B;
    InterstitialAd IAd;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style_text);

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

        edInput = (EditText) findViewById(R.id.edInput);
        edOutput = (EditText) findViewById(R.id.edOutput);
        engCheck = (CheckBox) findViewById(R.id.engCheck);
        mmCheck = (CheckBox) findViewById(R.id.mmCheck);

        edInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                convertText(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void convertText(String Text){
        if (!engCheck.isChecked()){
            if (!mmCheck.isChecked()){
                Text = Text.replace("က","ო");
                Text = Text.replace("ခ","ə");
                Text = Text.replace("ဂ","ი");
                Text = Text.replace("င","c");

                Text = Text.replace("စ","ʚ");
                Text = Text.replace("တ","თ");
                Text = Text.replace("ထ","∞");
                Text = Text.replace("ဒ","ɜ");
                Text = Text.replace("ပ","υ");
                Text = Text.replace("မ","ម");
                Text = Text.replace("ယ","យ");
                Text = Text.replace("လ","ល");
                Text = Text.replace("ဟ","ហ");
                Text = Text.replace("အ","ɜာ");
                Text = Text.replace("ႏ","ຮ");

                String a = "αხcძeբgħijkɭⴅռoρզɤនեυvωxⴁʑ";
                String aa []=a.split("");

                Text = Text.replace("a",aa[1]);
                Text = Text.replace("b",aa[2]);
                Text = Text.replace("c",aa[3]);
                Text = Text.replace("d",aa[4]);
                Text = Text.replace("e",aa[5]);
                Text = Text.replace("f",aa[6]);
                Text = Text.replace("g",aa[7]);
                Text = Text.replace("h",aa[8]);
                Text = Text.replace("i",aa[9]);
                Text = Text.replace("j",aa[10]);
                Text = Text.replace("k",aa[11]);
                Text = Text.replace("l",aa[12]);
                Text = Text.replace("m",aa[13]);
                Text = Text.replace("n",aa[14]);
                Text = Text.replace("o",aa[15]);
                Text = Text.replace("p",aa[16]);
                Text = Text.replace("q",aa[17]);
                Text = Text.replace("r",aa[18]);
                Text = Text.replace("s",aa[19]);
                Text = Text.replace("t",aa[20]);
                Text = Text.replace("u",aa[21]);
                Text = Text.replace("v",aa[22]);
                Text = Text.replace("w",aa[23]);
                Text = Text.replace("x",aa[24]);
                Text = Text.replace("y",aa[25]);
                Text = Text.replace("z",aa[26]);

                edOutput.setText(Text);
            }else{
                Text = Text.replace("က","ო");
                Text = Text.replace("ခ","ə");
                Text = Text.replace("ဂ","ი");
                Text = Text.replace("င","c");

                Text = Text.replace("စ","ʚ");
                Text = Text.replace("တ","თ");
                Text = Text.replace("ထ","∞");
                Text = Text.replace("ဒ","ɜ");
                Text = Text.replace("ပ","υ");
                Text = Text.replace("မ","ម");
                Text = Text.replace("ယ","យ");
                Text = Text.replace("လ","ល");
                Text = Text.replace("ဟ","ហ");
                Text = Text.replace("အ","ɜာ");
                Text = Text.replace("ႏ","ຮ");
                edOutput.setText(Text);
            }
        }else{
            String a = "αხcძeբgħijkɭⴅռoρզɤនեυvωxⴁʑ";
            String aa []=a.split("");

            Text = Text.replace("a",aa[1]);
            Text = Text.replace("b",aa[2]);
            Text = Text.replace("c",aa[3]);
            Text = Text.replace("d",aa[4]);
            Text = Text.replace("e",aa[5]);
            Text = Text.replace("f",aa[6]);
            Text = Text.replace("g",aa[7]);
            Text = Text.replace("h",aa[8]);
            Text = Text.replace("i",aa[9]);
            Text = Text.replace("j",aa[10]);
            Text = Text.replace("k",aa[11]);
            Text = Text.replace("l",aa[12]);
            Text = Text.replace("m",aa[13]);
            Text = Text.replace("n",aa[14]);
            Text = Text.replace("o",aa[15]);
            Text = Text.replace("p",aa[16]);
            Text = Text.replace("q",aa[17]);
            Text = Text.replace("r",aa[18]);
            Text = Text.replace("s",aa[19]);
            Text = Text.replace("t",aa[20]);
            Text = Text.replace("u",aa[21]);
            Text = Text.replace("v",aa[22]);
            Text = Text.replace("w",aa[23]);
            Text = Text.replace("x",aa[24]);
            Text = Text.replace("y",aa[25]);
            Text = Text.replace("z",aa[26]);

            edOutput.setText(Text);
        }
    }

    public void eng(String Text){


    }

    public void StyleText(View view) {
        if(IAd.isLoaded()){
            IAd.show();
        }else{
            IAd.loadAd(adRequest);
        }
        ClipboardManager copy = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        copy.setText(edOutput.getText());
        Toast.makeText(StyleText.this, "Copied!", Toast.LENGTH_SHORT).show();
    }
}
