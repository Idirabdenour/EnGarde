package com.example.abdenour.engarde;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    //

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5, action;

    TextView tChoix1;
    TextView tChoix2;
    TextView tChoix3;
    TextView tChoix4;
    TextView tChoix5;

    int nbrCarte = 0;

    HashMap<Integer, Integer> valueCarte = new HashMap<Integer, Integer>();


    //instancce class joueur
    Joueur j;
    //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        j=new Joueur(0,1,23,1);



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

        tChoix1 = (TextView)findViewById(R.id.choix1);
        tChoix2 = (TextView)findViewById(R.id.choix2);
        tChoix3 = (TextView)findViewById(R.id.choix3);
        tChoix4 = (TextView)findViewById(R.id.choix4);
        tChoix5 = (TextView)findViewById(R.id.choix5);

        btn1 = (Button) findViewById(R.id.Carte1);
        btn2 = (Button) findViewById(R.id.Carte2);
        btn3 = (Button) findViewById(R.id.Carte3);
        btn4 = (Button) findViewById(R.id.Carte4);
        btn5 = (Button) findViewById(R.id.Carte5);
        action = (Button) findViewById(R.id.action);
        action.setVisibility(View.INVISIBLE);

        t1.setText("X");
        t1.setTextColor(Color.WHITE);

        valueCarte.put(1,0);
        valueCarte.put(2,0);
        valueCarte.put(3,0);
        valueCarte.put(4,0);
        valueCarte.put(5,0);




        TextView tScore = (TextView)findViewById(R.id.Score);
        tScore.setText(j.getPaquet().toString());
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

            Carte.setText("t"+j.getMain().get(i));
            int img = getResources().getIdentifier("carte" + j.getMain().get(i), "drawable", getPackageName());
            Carte.setBackgroundResource(img);

    }
}

    public  void clickCarte1(View V){

        if(nbrCarte == 1 && valueCarte.get(1) != 0){
            tChoix1.setText("");
            valueCarte.put(1, 0);
            nbrCarte--;
            action.setVisibility(View.INVISIBLE);
        }

        else if(nbrCarte < 2){
        tChoix1.setText("X");
        valueCarte.put(1, j.getMain().get(0));
        nbrCarte++;
            action.setVisibility(View.VISIBLE);
        if(nbrCarte == 2){
            for (int i = 1; i <= 5; i++){
                if(valueCarte.get(i) == 0){
                    String btn = "Carte" + i;
                    int res = getResources().getIdentifier(btn, "id", getPackageName());
                    Button Carte = (Button) findViewById(res);
                    Carte.setVisibility(View.INVISIBLE);
                }
            }
        }
    }else{
        tChoix1.setText("");
        valueCarte.put(1, 0);
        nbrCarte--;
        for (int i = 1; i <= 5; i++){
            if(valueCarte.get(i) == 0){
                String btn = "Carte" + i;
                int res = getResources().getIdentifier(btn, "id", getPackageName());
                Button Carte = (Button) findViewById(res);
                Carte.setVisibility(View.VISIBLE);
            }
        }

    }



    }

    public  void clickCarte2(View V){
        if(nbrCarte == 1 && valueCarte.get(2) != 0){
            tChoix2.setText("");
            valueCarte.put(2, 0);
            nbrCarte--;
            action.setVisibility(View.INVISIBLE);
        }

        else if(nbrCarte < 2){
            tChoix2.setText("X");
            valueCarte.put(2, j.getMain().get(0));
            nbrCarte++;
            action.setVisibility(View.VISIBLE);
            if(nbrCarte == 2){
                for (int i = 1; i <= 5; i++){
                    if(valueCarte.get(i) == 0){
                        String btn = "Carte" + i;
                        int res = getResources().getIdentifier(btn, "id", getPackageName());
                        Button Carte = (Button) findViewById(res);
                        Carte.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }else {
            tChoix2.setText("");
            valueCarte.put(2, 0);
            nbrCarte--;
            for (int i = 1; i <= 5; i++) {
                if (valueCarte.get(i) == 0) {
                    String btn = "Carte" + i;
                    int res = getResources().getIdentifier(btn, "id", getPackageName());
                    Button Carte = (Button) findViewById(res);
                    Carte.setVisibility(View.VISIBLE);
                }
            }
        }

    }

    public  void clickCarte3(View V){
        if(nbrCarte == 1 && valueCarte.get(3) != 0){
            tChoix3.setText("");
            valueCarte.put(3, 0);
            nbrCarte--;
            action.setVisibility(View.INVISIBLE);
        }

        else if(nbrCarte < 2){
            tChoix3.setText("X");
            valueCarte.put(3, j.getMain().get(0));
            nbrCarte++;
            action.setVisibility(View.VISIBLE);
            if(nbrCarte == 2){
                for (int i = 1; i <= 5; i++){
                    if(valueCarte.get(i) == 0){
                        String btn = "Carte" + i;
                        int res = getResources().getIdentifier(btn, "id", getPackageName());
                        Button Carte = (Button) findViewById(res);
                        Carte.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }else {
            tChoix3.setText("");
            valueCarte.put(3, 0);
            nbrCarte--;

            for (int i = 1; i <= 5; i++) {
                if (valueCarte.get(i) == 0) {
                    String btn = "Carte" + i;
                    int res = getResources().getIdentifier(btn, "id", getPackageName());
                    Button Carte = (Button) findViewById(res);
                    Carte.setVisibility(View.VISIBLE);
                }
            }
        }


    }

    public  void clickCarte4(View V){
        if(nbrCarte == 1 && valueCarte.get(4) != 0){
            tChoix4.setText("");
            valueCarte.put(4, 0);
            nbrCarte--;
            action.setVisibility(View.INVISIBLE);
        }

        else if(nbrCarte < 2){
            tChoix4.setText("X");
            valueCarte.put(4, j.getMain().get(0));
            nbrCarte++;
            action.setVisibility(View.VISIBLE);
            if(nbrCarte == 2){
                for (int i = 1; i <= 5; i++){
                    if(valueCarte.get(i) == 0){
                        String btn = "Carte" + i;
                        int res = getResources().getIdentifier(btn, "id", getPackageName());
                        Button Carte = (Button) findViewById(res);
                        Carte.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }else {
            tChoix4.setText("");
            valueCarte.put(4, 0);
            nbrCarte--;
            for (int i = 1; i <= 5; i++) {
                if (valueCarte.get(i) == 0) {
                    String btn = "Carte" + i;
                    int res = getResources().getIdentifier(btn, "id", getPackageName());
                    Button Carte = (Button) findViewById(res);
                    Carte.setVisibility(View.VISIBLE);
                }
            }
        }


    }
    public  void clickCarte5(View V){
        if(nbrCarte == 1 && valueCarte.get(5) != 0){
            tChoix5.setText("");
            valueCarte.put(5, 0);
            nbrCarte--;
            action.setVisibility(View.INVISIBLE);
        }

        else if(nbrCarte < 2){
            tChoix5.setText("X");
            valueCarte.put(5, j.getMain().get(0));
            nbrCarte++;
            action.setVisibility(View.VISIBLE);
            if(nbrCarte == 2){
                for (int i = 1; i <= 5; i++){
                    if(valueCarte.get(i) == 0){
                        String btn = "Carte" + i;
                        int res = getResources().getIdentifier(btn, "id", getPackageName());
                        Button Carte = (Button) findViewById(res);
                        Carte.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }else {
            tChoix5.setText("");
            valueCarte.put(5, 0);
            nbrCarte--;
            for (int i = 1; i <= 5; i++) {
                if (valueCarte.get(i) == 0) {
                    String btn = "Carte" + i;
                    int res = getResources().getIdentifier(btn, "id", getPackageName());
                    Button Carte = (Button) findViewById(res);
                    Carte.setVisibility(View.VISIBLE);
                }
            }
        }
    }



}
