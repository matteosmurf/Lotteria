/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author matteosmurf
 * 
 */
public class Lotteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CREAZIONE MATRICE/ESTRAZIONE
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il numero di colonne e righe");
        int columns = scanner.nextInt();
        int rows = scanner.nextInt();
        //NUMERO DEI NUMERI
       /*  int N = scanner.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            N = Integer.parseInt(br.readLine());
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } */


        Estrazione e = new Estrazione(columns, rows);
        //STAMPA MATRICE
        e.start();
        Giocatore g0 = new Giocatore(0, "matteo", e);
        Giocatore g1 = new Giocatore(1, "francesco", e);
        Giocatore g2 = new Giocatore(2, "mattia", e);
        Giocatore g3 = new Giocatore(3, "andrea", e);
        g0.start();
        g1.start();
        g2.start();
        g3.start();
        try {
            g0.join();
            g1.join();
            g2.join();
            g3.join();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            System.err.println("errore join");
        }
        
        // Scelta del numero dei numeri da estrarre

        // Istanza ed avvio del thread Estrazione

        // Istanza di alcuni thread Giocatore

        // Avvio dei thread Giocatori

        // Comunicazione fine gioco
        e.stampaVincitori();
    }
}
