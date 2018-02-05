package com.example.abdenour.engarde;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //



    //instancce class joueur

    //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Joueur j=new Joueur(0,1,23,1);



        Button Piocher = (Button)findViewById(R.id.IdPiocher);
        TextView t1 = (TextView)findViewById(R.id.id1);
        TextView t2 = (TextView)findViewById(R.id.id2);
        TextView t3 = (TextView)findViewById(R.id.id3);
        TextView t4 = (TextView)findViewById(R.id.id4);
        TextView t5 = (TextView)findViewById(R.id.id5);
        TextView t6 = (TextView)findViewById(R.id.id6);
        TextView t7 = (TextView)findViewById(R.id.id7);
        TextView t8 = (TextView)findViewById(R.id.id8);
        TextView t9 = (TextView)findViewById(R.id.id9);
        TextView t10 = (TextView)findViewById(R.id.id10);
        TextView t11= (TextView)findViewById(R.id.id11);
        TextView t12 = (TextView)findViewById(R.id.id12);
        TextView t13 = (TextView)findViewById(R.id.id13);
        TextView t14 = (TextView)findViewById(R.id.id14);
        TextView t15 = (TextView)findViewById(R.id.id15);
        TextView t16 = (TextView)findViewById(R.id.id16);
        TextView t17 = (TextView)findViewById(R.id.id17);
        TextView t18 = (TextView)findViewById(R.id.id18);
        TextView t19 = (TextView)findViewById(R.id.id19);
        TextView t20 = (TextView)findViewById(R.id.id20);
        TextView t21 = (TextView)findViewById(R.id.id21);
        TextView t22 = (TextView)findViewById(R.id.id22);

        TextView t23 = (TextView)findViewById(R.id.id23);



        t1.setText("X");
        t1.setTextColor(Color.WHITE);





        TextView tScore = (TextView)findViewById(R.id.Score);


        afficherCarte(j);

    }


    public void GameToHome(View v){
        Intent in = new Intent(this, Home.class);
        startActivity(in);
    }

/*
    public  void Piocher(View V){
        int val = j.piocher();


    }

*/

public void afficherCarte(Joueur j){
    for (int i =0;i<j.getMain().size();i++){
            int b = i+1;
            String btn = "Carte" + b;
            int res = getResources().getIdentifier(btn, "id", getPackageName());
            Button Carte = (Button) findViewById(res);

            int img = getResources().getIdentifier("carte" + j.getMain().get(i), "drawable", getPackageName());
            Carte.setBackgroundResource(img);

    }
}

}
