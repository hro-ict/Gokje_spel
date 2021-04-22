
//Auteur: Yasar Unlu

package com.company;
import javax.swing.*;
import java.util.Random;
import java.util.concurrent.CancellationException;

public class Gokje {
    public static void main(String[] args){

        // Willekeurige getal genereren tussen 1 en 20
        Random willekeurig = new Random();
        int low=1;
        int high=20;

        int willekeurige_getal= willekeurig.nextInt(high-low)+low;


        //de gebruiker heeft 5  beurten
        int raad_beurt= 5;


        //Welkom message en uitleg over het spel
        JOptionPane.showMessageDialog(null,  "Welkom het Gokje spel\n" +
                "Het spel ziet er zo uit:\n" +
                "Je moet een getal raden tussen 1 en 20.\n" +
                "Daarom gebruik allen een getal tussen 1 en 20 \n" +
                "dus niet meer of niet minder\n" +
                "Gebruik ook gen letters\n" +
                "Je hebt 5 kansen\n" +
                "Success ermee\n" +
                "Klik OK om verder te gaan");

 while (true){

//  Exception gebruiken om te voorkomen dat de gebruiker letters invult ipv getallen
     try {
         int geraden_getal = leesgetal();



         if (geraden_getal>20 || geraden_getal<1){
             show_message("Het getal moet tussen 1 en 20 zijn");
         }

        else if (geraden_getal != willekeurige_getal) {
             raad_beurt -= 1;

             if (willekeurige_getal<geraden_getal) {
                 if (raad_beurt!=0)
                 show_message("Helaas dat is niet juist\n\n" +
                         "TIP: Het getal kleiner dan " + geraden_getal+  "\nJe hebt nog " + raad_beurt + " kans(en)");
             }
             else{
                 if (raad_beurt!=0)

                 show_message ("Helaas dat is niet juist\n\n" +
                         "TIP: Het getal groter dan " + geraden_getal+  "\nJe hebt nog " + raad_beurt + " kans(en)");

             }

             if (raad_beurt==0 ){

                 int response_code= probeer_nog_een_keer("Helaas dat is niet juist\n" +
                         "Je hebt geen kans meer\nHet getal was: "+
                         willekeurige_getal+"\nWil je nog een keer proberen?");
                 if (response_code==0){
                     //response_code 0 is Ja 1 is Nee

                     //gebruiker krijgt opnieuw 5 kansen
                     raad_beurt=5;
                     // Nieuwe Willekeurige getal genereren tussen 1 en 20
                     willekeurige_getal= willekeurig.nextInt(high-low)+low;
                 }
                 else{
                     break;
                 }


             }


         }

// if gebruiker  het getal goed geraden heeft
         else {

             int response_code= probeer_nog_een_keer("Goed ZO!\nDat is juist\nWil je nog een keer proberen?");
             System.out.println(5-raad_beurt);

             // Nieuwe Willekeurige getal genereren tussen 1 en 20
             willekeurige_getal= willekeurig.nextInt(high-low)+low;


             if (response_code==0){
                 //gebruiker krijgt nog 5 kansen
                 raad_beurt=5;

             }
             else {
                 break;
             }

         }
     }

 // if de gebruiker geen getal maar andere karakters invult
     catch(Exception NumberFormatException){
         show_message("    Invalid input\nVul a.u.b. een getal tussen 1 en 20 in");
     }

 }

    }


    public static void show_message (String text){

        JOptionPane.showMessageDialog(null, text);

    }


    //Methode om gebruikersinvoer te lezen
    public static int leesgetal(){

        String tekst= JOptionPane.showInputDialog(null, "Vul een getal in tussen 1 en 20",
                "Gokje", 3);


        // if de gebruiker op cancel button klikt
        if (tekst==null){
            System.exit(0);
        }

        int getal= Integer.parseInt(tekst);

        return getal;
    }


    //Methode om nog een keer te spelen
    public static int probeer_nog_een_keer(String text){

        String[] options = new String[] {"Ja graag", "Nee bedankt"};
        int response = JOptionPane.showOptionDialog(null, text, "Probeer nog een keer",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);

        return response;

    }
}
