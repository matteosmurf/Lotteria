/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.Random;

/*
 *
 * @author monica ciuchetti
 */
public class Giocatore extends Thread {
   // attributi
   private int idGiocatore;
   private String nomeGiocatore;
   private Estrazione estrazione;

   /**
    * 
    * Metodo costruttore
    * 
    * @param idGiocatore codice del giocatore
    * @param estrazione  riferimento dell'oggetto Estrazione
    */
   public Giocatore(int idGiocatore, String nomeGiocatore, Estrazione estrazione) {
      // inizializzazione attributi
      this.idGiocatore = idGiocatore;
      this.nomeGiocatore = nomeGiocatore;
      this.estrazione = estrazione;
   }

   /**
    * 
    * Metodo per eseguire il thread
    */
   public void run() {
      Random random = new Random();
      System.out.println("nome giocatore: " + nomeGiocatore);
      // scelta del numero da giocare
      int nScelto = random.nextInt(10);
      // verifica del risultato
      for(int i = 3; i>0; i--){
         System.out.println(i);
         try {
            sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
            System.err.println("errore sleep");
         }
      }
      estrazione.verifica(nScelto, idGiocatore);
   }
}