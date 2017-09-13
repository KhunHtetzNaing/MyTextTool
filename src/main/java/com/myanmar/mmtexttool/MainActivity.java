package com.myanmar.mmtexttool;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnBold,btnBlank,btnFlip,btnClone,btnStyle,btnAbout;
    AdView B;
    AdRequest adRequest;
    InterstitialAd IAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        btnBold = (ImageButton) findViewById(R.id.btnBoldText);
        btnBlank = (ImageButton) findViewById(R.id.btnBlankText);
        btnFlip = (ImageButton) findViewById(R.id.btnFipText);
        btnClone = (ImageButton) findViewById(R.id.btnClone);
        btnStyle = (ImageButton) findViewById(R.id.btnStyle);
        btnAbout = (ImageButton) findViewById(R.id.btnAbout);

        btnBold.setOnClickListener(this);
        btnBlank.setOnClickListener(this);
        btnFlip.setOnClickListener(this);
        btnClone.setOnClickListener(this);
        btnStyle.setOnClickListener(this);
        btnAbout.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"MM Text Cloner");
                startActivity(new Intent(Intent.createChooser(intent,"Share App Via...")));
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Attention!");
        builder.setMessage("Do you want to Exit ?");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showAd();
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showAd();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {startActivity(new Intent(MainActivity.this,About.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        showAd();
        switch (v.getId()){
            case R.id.btnBoldText:
                startActivity(new Intent(MainActivity.this,BoldText.class));
                break;
            case R.id.btnBlankText:
                ClipboardManager copy = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                copy.setText("᠌᠌᠌");
                if (copy.hasText()){
                    Toast.makeText(MainActivity.this, "Copied! Now you can Paste!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnFipText:
                startActivity(new Intent(MainActivity.this,FlipText.class));
                break;
            case R.id.btnClone:
                startActivity(new Intent(MainActivity.this,TextCloner.class));
                break;
            case R.id.btnStyle:
                startActivity(new Intent(MainActivity.this,StyleText.class));break;
            case R.id.btnAbout:showAd();startActivity(new Intent(MainActivity.this,About.class));break;
        }
    }

    public void showAd(){
        if(IAd.isLoaded()){
            IAd.show();
        }else{
            IAd.loadAd(adRequest);
        }
    }
}
