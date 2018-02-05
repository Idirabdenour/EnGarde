package com.example.abdenour.engarde;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }



    public void newgame (View v){
        Intent intenetnewgame = new Intent(  this, MainActivity.class);

        startActivity(intenetnewgame);
    }


    public void AboutGame (View v){
        Intent intenetAboutgame = new Intent(Intent.ACTION_VIEW, Uri.parse("http://videoregles.net/videoregle/en-garde"));
        startActivity(intenetAboutgame);
    }



    public void Exitgame (View v){
        this.finish();

    }


}
