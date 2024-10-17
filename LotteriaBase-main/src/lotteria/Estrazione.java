/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author monica ciuchetti
 */
public class Estrazione extends Thread {
    // attributi
    ArrayList<Integer> gVincitori = new ArrayList<>();
    private int matrice[][];
    private int rows;
    private int columns;
    /**
     * 
     * Metodo costruttore
     */   
    public Estrazione(int rows, int columns) {
        this.rows=rows;
        this.columns=columns;
        matrice = new int[rows][columns];

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                Random rand = new Random();
                int random = rand.nextInt(10);
                matrice[i][j] = random;
            }
        }
        // popolamento matrice numeri estratti
        // inizializzazione array vincitori
    }

    /**
    * 
    * Metodo per visualizzare la matrice dei numeri estratti
    */
    public void stampaMatrice() {
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print(matrice[i][j] + "\t");
            }
            System.out.print("\n");
        }

       // stampa matrice dei numeri estratti
    }
    
    /**
    * 
    * Metodo per visualizzare i vincitori dell'estrazione
    */
    public void stampaVincitori() {
            System.out.println("Giocatori vincitori: " + gVincitori);
        }

    /**
    * 
    * Metodo per verificare il numero scelto dal giocatore e determinare i vincitori7
    * @param numero numero scelto dal giocatore
    * @param idgiocatore di del giocatore 
    */
    public void verifica(int numero, int idGiocatore) {
        boolean flag=false;
        //VERIFICA
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
               if(numero==matrice[i][j]){
                flag=true;
                System.out.println("giocatore: "+ idGiocatore + " hai scleto il nuemro: "+ numero + " hai vinto!");
                while (gVincitori.size()<3) {
                    gVincitori.add(idGiocatore);
                    return;
                }
                
               }
            }
        }
        if(!flag){
            System.out.println( idGiocatore + ": hai perso");
        }
    }

    /**
    * 
    * Metodo per eseguire il thread
    */
    public void run() {
        // stampa iniziale
        System.out.println("Inizio lotteria");
        // estrazione dei numeri
        // stampa matrice
        stampaMatrice();
        // stampa finale
    }
}


