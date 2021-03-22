import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Autor;

public class AutorJPAManager {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws IOException {
        try {
            emf = Persistence.createEntityManagerFactory("MagazineJPA");
        } catch (Throwable ex) {
            System.err.println("Failed to create EntityManagerFactory object."
                    + ex);
            throw new ExceptionInInitializerError(ex);
        }
        AutorJPAManager MA = new AutorJPAManager();
        FileAccessor fa;
        fa = new FileAccessor();
        fa.readAutorsFile("src/main/java/docs/autors.txt");
        System.out.println("Autors llegits des del fitxer");
        for (int i = 0; i < fa.llistaAutors.size(); i++) {
            System.out.println(fa.llistaAutors.get(i).toString());
            MA.addAutor(fa.llistaAutors.get(i));
        }
        System.out.println("Autors llegits de la base de dades");
        MA.listAutors();
        MA.deleteAutor(5);
        MA.updateAutor(12, false);
        System.out
                .println("Autors llegits de la base de dades després de des actualitzacions");
        MA.listAutors();
    }

    /* Method to CREATE an Autor in the database */
    public void addAutor(Autor autor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
        em.close();
    }

    /* Method to READ all Autors */
    public void listAutors() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Autor> result = em.createQuery("from Autor", Autor.class)
                .getResultList();
        for (Autor autor : result) {
            System.out.println(autor.toString());
        }
        em.getTransaction().commit();
        em.close();

    }

    /* Method to UPDATE activity for an autor */
    public void updateAutor(Integer AutorID, boolean actiu) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Autor autor = (Autor) em.find(Autor.class, AutorID);
        autor.setActiu(actiu);
        em.merge(autor);
        em.getTransaction().commit();
        em.close();
    }

    /* Method to DELETE an employee from the records */
    public void deleteAutor(Integer AutorID) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Autor autor = (Autor) em.find(Autor.class, AutorID);
        em.remove(autor);
        em.getTransaction().commit();
        em.close();
    }
}