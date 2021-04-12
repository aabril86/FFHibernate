package FF;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    private static SessionFactory factory;

    public static void main(String[] args) {

        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        ManagePersonaje managePersonaje = new ManagePersonaje();
        ManageCarta manageCarta = new ManageCarta();
        ManageMazo manageMazo = new ManageMazo();



        Menu menu = new Menu();
        int opcio = -1;

        while (opcio != 0) {
            opcio = menu.menuPral();

            switch (opcio) {

                case 1:
                    opcio = menu.menuAdd();
                    switch(opcio) {

                        case 1:
                            // AÑADIR CARTA
                            break;

                        case 2:
                            // AÑADIR PERSONAJE
                            break;

                        case 3:
                            // AÑADIR MAZO
                            break;

                        case 4:
                            break;

                    }

                    break;

                case 2:
                    opcio = menu.menuConsulta();
                    switch(opcio) {

                        case 1:
                            // CONSULTAR CARTA
                            break;

                        case 2:
                            // CONSULTAR PERSONAJE
                            break;

                        case 3:
                            // CONSULTAR MAZO
                            break;
                    }

                    break;

                case 3:
                    opcio = menu.menuRemove();
                    switch(opcio) {

                        case 1:
                            // ELIMINAR CARTA
                            break;

                        case 2:
                            // ELIMINAR PERSONAJE
                            break;

                        case 3:
                            // ELIMINAR MAZO
                            break;
                    }

                    break;

                case 4:
                    opcio = menu.menuUpdate();
                    switch(opcio) {

                        case 1:
                            // ACTUALIZAR CARTA
                            break;

                        case 2:
                            // ACTUALIZAR PERSONAJE
                            break;

                        case 3:
                            // ACTUALIZAR MAZO
                            break;

                    }
                    break;
            }
        }
    }
}