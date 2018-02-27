
package com.example.abdenour.engarde;

import android.util.Log;

import java.util.*;
import java.util.Random;

/**
 * Created by seddi on 05/02/2018.
 */

public class Joueur {
    private List<Integer> mainCarte;
    private int score;
    private int caseActuelle;
    private int caseAdversaire;
    private  HashMap<Integer, Integer> paquet;



    private boolean APerdu;
    private int caseDeDepart;
    public boolean isAPerdu() {
        return APerdu;
    }

    public void setAPerdu(boolean APerdu) {
        this.APerdu = APerdu;
    }

    public int getCaseDeDepart() {
        return caseDeDepart;
    }

    public void setCaseDeDepart(int caseDeDepart) {
        this.caseDeDepart = caseDeDepart;
    }

    public Joueur(int score, int caseActuelle, int posAdversaire, int maCaseDeDepart) {
        this.caseDeDepart = maCaseDeDepart;

        APerdu = false;
        paquet = new HashMap<Integer, Integer>();
        mainCarte = new ArrayList<Integer>();


        this.score = score;
        this.caseActuelle = caseActuelle;

        this.caseAdversaire=posAdversaire;
        this.intpaquet();
        for(int i=0;i<5;i++){
            this.piocher();
        }

    }

    public HashMap<Integer, Integer> getPaquet() {
        return paquet;
    }

    public void setPaquet(HashMap<Integer, Integer> paquet) {
        this.paquet = paquet;
    }
    public void setMain(ArrayList<Integer> main) {
        this.mainCarte = main;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCaseActuelle(int caseActuelle) {
        this.caseActuelle = caseActuelle;
    }

    public List<Integer> getMain() {

        return mainCarte;
    }

    public int getScore() {
        return score;
    }

    public int getCaseActuelle() {
        return caseActuelle;
    }

    public void Mouvement(int carte){
        if(!ADepasser()){

            this.caseActuelle+=carte;

            if( caseActuelle >25 || caseActuelle<0 ){
                APerdu=true;
            }

        }else{
            Log.e("depassement","les joueurs ");
        }
    }
    public boolean ADepasser(){
        if(caseDeDepart==1) {

            return (this.caseAdversaire - this.caseActuelle <= 0);

        } else {
            return (this.caseAdversaire - this.caseActuelle >= 0);
        }
    }
    public int AttaquerDirect(int carte,int force){
        if(this.distanceJoueurs() == carte){
            switch (force){
                case 1:

                    break;
                case 2:

                    break;
                default:Log.e("attaque non valide","nombre de cartes different de (1 ou 2)");
            }
        }else {
            Log.e("attaque non valide","la carte ne correspond pas a la distance");
        }

        return 0;
    }
    public int AttaquerIndirect(int mouvement,int carte){
        return 0;
    }
    public  int distanceJoueurs(){
        return Math.abs(this.caseAdversaire-this.caseActuelle);
    }

    public void Defendre(int carte){

    }
    public void intpaquet(){

        paquet.put(1,5);
        paquet.put(2,5);
        paquet.put(3,5);
        paquet.put(4,5);
        paquet.put(5,5);
        //paquet.add(1,5);paquet.add(2,5);paquet.add(3,5);paquet.add(4,5);paquet.add(5,5);
    }


    public void piocher(){
        if( paquet.size() == 0){
            //distance mediane par raport au joueur
        }else {
            Random r=new Random();
            int indice = 1 + (int)(Math.random() * ((4)));
            while(paquet.get(indice) == 0){
                indice= 1 + (int)(Math.random() * ((4)));
            }

            int var = paquet.get(indice) - 1;
            paquet.put(indice, var);

            mainCarte.add(indice);

        }

    }


}