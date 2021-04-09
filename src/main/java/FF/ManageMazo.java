package FF;

import Entities.Mazo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ManageMazo {
    private static SessionFactory factory;

    public static void main(String[] args) throws IOException {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        ManageMazo MM = new ManageMazo();
        Mazo mazo = new Mazo();
        System.out.println("Mazos llegits de la base de dades");
        MM.addMazo(mazo);
        MM.listMazos();
        MM.deleteMazo(mazo.getId_mazo());
        MM.updateMazo(mazo.getId_mazo());
        System.out
                .println("Mazos llegits de la base de dades després de des actualitzacions");
        MM.listMazos();

    }

    /* Method to CREATE a Mazo */
    public void addMazo(Mazo mazo) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer id_mazo = null;
        try {
            tx = session.beginTransaction();
            id_mazo = (Integer) session.save(mazo);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to READ all Mazos */
    public void listMazos() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List mazos = session.createQuery("FROM Mazo").list();

            for (Iterator iterator = mazos.iterator(); iterator.hasNext();) {
                Mazo mazo = (Mazo) iterator.next();
                System.out.println(mazo.toString());
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

    /* Method to UPDATE a Mazo */
    public void updateMazo(Integer id_mazo) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Mazo mazo = (Mazo) session.get(Mazo.class, id_mazo);
            session.update(mazo);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE a Mazo */
    public void deleteMazo(Integer id_mazo) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Mazo mazo = (Mazo) session.get(Mazo.class, id_mazo);
            session.delete(mazo);
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