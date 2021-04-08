package FF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    private int option;
//aaaa
    public Menu() {
        super();
    }

    public int menuPral() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {

            System.out.println(" \nMENU PRINCIPAL \n");

            System.out.println("1. Afegir dades");
            System.out.println("2. Consulta dades. ");
            System.out.println("3. Elimina dades. ");
            System.out.println("4. Actualitza dades. ");

            System.out.println("0. Sortir. ");

            System.out.println("Esculli opció: ");
            try {
                option = Integer.parseInt(br.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("valor no vàlid");
                e.printStackTrace();
            }
        } while (option != 0 && option != 1 && option != 2);

        return option;
    }


    public int menuConsulta(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {

            System.out.println(" \nMENU PRINCIPAL \n");

            System.out.println("1. Consulta cartes. ");
            System.out.println("2. Consulta personatge. ");
            System.out.println("3. Consulta  mazo");

            System.out.println("Esculli opció: ");
            try {
                option = Integer.parseInt(br.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("valor no vàlid");
                e.printStackTrace();
            }
        } while (option != 0 && option != 1 && option != 2);


        return option;
    }

    public int menuAdd(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {

            System.out.println(" \nMENU PRINCIPAL \n");

            System.out.println("1. Afegeix una carta. ");
            System.out.println("2. Afegeix un personatge. ");

            System.out.println("Esculli opció: ");
            try {
                option = Integer.parseInt(br.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("valor no vàlid");
                e.printStackTrace();
            }
        } while (option != 0 && option != 1 && option != 2);


        return option;
    }



}
