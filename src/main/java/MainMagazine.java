import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Entities.*;


public class MainMagazine {

    public static void main(String[] args)  {
        ArrayList<Revista> revistes = new ArrayList();
        FileAccessor fa;

        Menu menu = new Menu();
        int opcio = -1;
        
        while(opcio != 0) {
        opcio = menu.menuPral();
        
            switch (opcio) {

                case 1:

                    System.out.println("1!!");
                    fa = new FileAccessor();
                    try {
                        fa.readAutorsFile("src/main/java/docs/autors.txt");
                        fa.printAutors();
                        fa.readMagazinesFile("src/main/java/docs/revistes.txt");
                        fa.printRevistes();
                        revistes = fa.readArticlesFile("src/main/java/docs/articles.txt");
                        mostraRevistes(revistes);
                    } catch (NumberFormatException | IOException e) {

                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Llistat de revistes");
                    System.out.println("___________________");

                    try {
                        System.out.println(seleccionaArticle(seleccionaRevista(revistes)).getAutor().toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Adeu!!");
                    System.exit(1);
                    break;

            }
        }

    }
    public static void mostraRevistes(ArrayList<Revista> revistes){
        for (int i = 0; i < revistes.size(); i++) {

            System.out.println(revistes.get(i).toString());
            for (int j = 0; j < revistes.get(i).getArticles().size(); j++) {
                System.out.println("\t"+ revistes.get(i).getArticle(j).toString());
                System.out.println("\t\t"+revistes.get(i).getArticle(j).getAutor().toString());
            }

        }
    }

    public static Revista seleccionaRevista(ArrayList<Revista> revistes){
        //TODO
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID de la revista: ");
        int id = scanner.nextInt();

        for (Revista re: revistes) {
            if(re.getId_revista() == id) return re;
        }

        return null;

    }
    public static Article seleccionaArticle(Revista revista){
        //TODO
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: article: ");

        int id = scanner.nextInt();

        for (Article a: revista.getArticles()) {
            if(a.getId_article() == id) return a;
        }
        return null;

    }



}
