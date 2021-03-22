import java.io.IOException;
import java.util.List;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entities.Autor;
//import Entities.Employee;

public class ManageAutor {

    private static SessionFactory factory;

    public static void main(String[] args) throws IOException {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        ManageAutor MA = new ManageAutor();
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
        MA.deleteAutor(1);
        MA.updateEmployee(2, false);
        System.out
                .println("Autors llegits de la base de dades després de des actualitzacions");
        MA.listAutors();

    }

    /* Method to CREATE an Autor in the database */
    public void addAutor(Autor autor) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer AutorID = null;
        try {
            tx = session.beginTransaction();

            AutorID = (Integer) session.save(autor);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    /* Method to READ all Autors */
    public void listAutors() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List autors = session.createQuery("FROM Autor").list();

            for (Iterator iterator = autors.iterator(); iterator.hasNext();) {
                Autor autor = (Autor) iterator.next();
                System.out.println(autor.toString());
            }

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to UPDATE activity for an autor */
    public void updateEmployee(Integer AutorID, boolean actiu) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Autor autor = (Autor) session.get(Autor.class, AutorID);
            autor.setActiu(actiu);
            session.update(autor);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an employee from the records */
    public void deleteAutor(Integer AutorID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Autor autor = (Autor) session.get(Autor.class, AutorID);
            session.delete(autor);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
