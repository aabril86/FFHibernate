package FF;

import FF.Entities.Mano;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ManageMano {
    private static SessionFactory factory;
    private Mano mano;

    public static void main(String[] args) throws IOException {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        ManageMano MM = new ManageMano();
        Mano mano = new Mano();
        System.out.println("Manos llegits de la base de dades");
        MM.addMano(mano);
        MM.listManos();
        MM.deleteMano(mano.getId_mano());
        MM.updateMano(mano.getId_mano());
        System.out.println("Manos llegits de la base de dades després de des actualitzacions");
        MM.listManos();

    }

    /* Method to CREATE a Mano */
    public void addMano(Mano mano) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer id_mano = null;
        try {
            tx = session.beginTransaction();
            id_mano = (Integer) session.save(mano);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to READ all Manos */
    public void listManos() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List manos = session.createQuery("FROM mano").list();

            for (Iterator iterator = manos.iterator(); iterator.hasNext();) {
                Mano mano = (Mano) iterator.next();
                System.out.println(mano.toString());
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

    /* Method to UPDATE a Mano */
    public void updateMano(Integer id_mano) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Mano mano = (Mano) session.get(Mano.class, id_mano);
            session.update(mano);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE a Mano */
    public void deleteMano(Integer id_mano) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Mano mano = (Mano) session.get(Mano.class, id_mano);
            session.delete(mano);
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
