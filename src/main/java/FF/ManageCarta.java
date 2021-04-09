package FF;

import FF.Entities.Cartas.Carta;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ManageCarta {
    private static SessionFactory factory;

    public static void main(String[] args) throws IOException {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        Carta carta = new Carta();
        ManageCarta MC = new ManageCarta();
        System.out.println("Mazos llegits de la base de dades");
        MC.addCarta(carta);
        MC.listCartas();
        MC.deleteCarta(carta.getId_carta());
        MC.updateCarta(carta.getId_carta());
        System.out
                .println("Mazos llegits de la base de dades després de des actualitzacions");
        MC.listCartas();

    }

    /* Method to CREATE a Carta */
    public void addCarta(Carta carta) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer id_carta = null;
        try {
            tx = session.beginTransaction();
            id_carta = (Integer) session.save(carta);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to READ all Cartas */
    public void listCartas() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List cartas = session.createQuery("FROM Carta").list();

            for (Iterator iterator = cartas.iterator(); iterator.hasNext();) {
                Carta carta = (Carta) iterator.next();
                System.out.println(carta.toString());
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

    /* Method to UPDATE a Carta */
    public void updateCarta(Integer id_carta) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Carta carta = (Carta) session.get(Carta.class, id_carta);
            session.update(carta);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE a Carta */
    public void deleteCarta(Integer id_carta) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Carta carta = (Carta) session.get(Carta.class, id_carta);
            session.delete(carta);
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
